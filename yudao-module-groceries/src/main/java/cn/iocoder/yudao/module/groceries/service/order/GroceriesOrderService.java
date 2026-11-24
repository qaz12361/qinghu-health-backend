package cn.iocoder.yudao.module.groceries.service.order;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.groceries.controller.app.order.vo.GroceriesOrderCreateReqVO;
import cn.iocoder.yudao.module.groceries.controller.app.order.vo.GroceriesOrderItemRespVO;
import cn.iocoder.yudao.module.groceries.controller.app.order.vo.GroceriesOrderRespVO;
import cn.iocoder.yudao.module.groceries.dal.dataobject.coupon.GroceriesCouponDO;
import cn.iocoder.yudao.module.groceries.dal.dataobject.order.GroceriesOrderDO;
import cn.iocoder.yudao.module.groceries.dal.dataobject.order.GroceriesOrderItemDO;
import cn.iocoder.yudao.module.groceries.dal.dataobject.product.GroceriesProductDO;
import cn.iocoder.yudao.module.groceries.dal.mysql.coupon.GroceriesCouponMapper;
import cn.iocoder.yudao.module.groceries.dal.mysql.order.GroceriesOrderItemMapper;
import cn.iocoder.yudao.module.groceries.dal.mysql.order.GroceriesOrderMapper;
import cn.iocoder.yudao.module.groceries.service.cart.GroceriesCartService;
import cn.iocoder.yudao.module.groceries.service.catalog.GroceriesCatalogService;
import cn.iocoder.yudao.module.groceries.service.member.GroceriesMemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 生鲜商城 - 订单 Service
 *
 * 下单核心链路：校验会员 → 校验商品与库存 → 计算金额（含运费、优惠券）→ 落订单与明细
 * → 扣库存 → 核销优惠券 → 清理购物车。
 */
@Service
public class GroceriesOrderService {

    /** 满额免运费门槛 */
    private static final BigDecimal FREE_SHIPPING_THRESHOLD = new BigDecimal("39");
    /** 周边配送运费 */
    private static final BigDecimal DELIVERY_FEE = new BigDecimal("5");

    public static final String SHIP_DELIVERY = "delivery";
    public static final String SHIP_PICKUP = "pickup";

    public static final String STATUS_TO_SHIP = "待发货";
    public static final String STATUS_DELIVERING = "配送中";
    public static final String STATUS_FINISHED = "已完成";
    public static final String STATUS_CANCELED = "已取消";

    private static final Set<String> ALLOWED_STATUS = Set.of(
            STATUS_TO_SHIP, STATUS_DELIVERING, STATUS_FINISHED, STATUS_CANCELED);

    private static final DateTimeFormatter ORDER_NO_DATE = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Resource
    private GroceriesOrderMapper groceriesOrderMapper;
    @Resource
    private GroceriesOrderItemMapper groceriesOrderItemMapper;
    @Resource
    private GroceriesCouponMapper groceriesCouponMapper;
    @Resource
    private GroceriesCatalogService catalogService;
    @Resource
    private GroceriesMemberService memberService;
    @Resource
    private GroceriesCartService cartService;

    /**
     * 创建订单
     *
     * @return 新订单编号
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer createOrder(GroceriesOrderCreateReqVO reqVO) {
        // 1. 校验会员
        memberService.validateMemberExists(reqVO.getMemberId());

        // 2. 校验商品与库存，并计算商品总额
        Map<Integer, GroceriesProductDO> productMap = catalogService.getProductMap(
                reqVO.getItems().stream()
                        .map(GroceriesOrderCreateReqVO.Item::getProductId)
                        .collect(Collectors.toSet()));
        BigDecimal totalAmount = BigDecimal.ZERO;
        List<GroceriesOrderItemDO> orderItems = new ArrayList<>(reqVO.getItems().size());
        for (GroceriesOrderCreateReqVO.Item item : reqVO.getItems()) {
            GroceriesProductDO product = productMap.get(item.getProductId());
            if (product == null) {
                throw new ServiceException(404, "商品不存在：" + item.getProductId());
            }
            if (product.getStock() == null || product.getStock() < item.getQuantity()) {
                throw new ServiceException(400, product.getName() + " 库存不足，仅剩 "
                        + (product.getStock() == null ? 0 : product.getStock()) + product.getUnit());
            }
            BigDecimal price = product.getPrice() == null ? BigDecimal.ZERO : product.getPrice();
            totalAmount = totalAmount.add(price.multiply(BigDecimal.valueOf(item.getQuantity())));

            GroceriesOrderItemDO orderItem = new GroceriesOrderItemDO();
            orderItem.setProductId(product.getId());
            orderItem.setName(product.getName());
            orderItem.setPrice(price);
            orderItem.setQuantity(item.getQuantity());
            orderItem.setUnit(product.getUnit());
            orderItems.add(orderItem);
        }

        // 3. 计算运费：到店自提免运费；周边配送满 39 免运费，否则 5 元
        boolean pickup = SHIP_PICKUP.equalsIgnoreCase(reqVO.getShipType());
        BigDecimal shipFee = BigDecimal.ZERO;
        if (!pickup && totalAmount.compareTo(FREE_SHIPPING_THRESHOLD) < 0) {
            shipFee = DELIVERY_FEE;
        }

        // 4. 校验优惠券
        BigDecimal discountAmount = BigDecimal.ZERO;
        GroceriesCouponDO coupon = catalogService.getCoupon(reqVO.getCouponId());
        if (coupon != null) {
            if (Boolean.TRUE.equals(coupon.getUsed())) {
                throw new ServiceException(400, "优惠券已被使用");
            }
            BigDecimal condition = coupon.getCondition() == null ? BigDecimal.ZERO : coupon.getCondition();
            if (totalAmount.compareTo(condition) < 0) {
                throw new ServiceException(400, "订单金额未达到优惠券使用门槛");
            }
            discountAmount = coupon.getAmount() == null ? BigDecimal.ZERO : coupon.getAmount();
        }

        // 5. 应付金额，最低为 0
        BigDecimal payAmount = totalAmount.add(shipFee).subtract(discountAmount);
        if (payAmount.compareTo(BigDecimal.ZERO) < 0) {
            payAmount = BigDecimal.ZERO;
        }

        // 6. 落订单
        GroceriesOrderDO order = new GroceriesOrderDO();
        order.setOrderNo(generateOrderNo());
        order.setMemberId(reqVO.getMemberId());
        order.setTotalAmount(totalAmount);
        order.setCouponId(coupon == null ? null : coupon.getId());
        order.setDiscountAmount(discountAmount);
        order.setPayAmount(payAmount);
        order.setStatus(STATUS_TO_SHIP);
        order.setShipType(pickup ? SHIP_PICKUP : SHIP_DELIVERY);
        order.setShipFee(shipFee);
        order.setAddressId(reqVO.getAddressId());
        order.setRemark(reqVO.getRemark());
        groceriesOrderMapper.insert(order);

        // 7. 落明细
        orderItems.forEach(item -> item.setOrderId(order.getId()));
        orderItems.forEach(groceriesOrderItemMapper::insert);

        // 8. 扣库存
        reqVO.getItems().forEach(item -> catalogService.reduceStock(item.getProductId(), item.getQuantity()));

        // 9. 核销优惠券
        if (coupon != null) {
            GroceriesCouponDO updateCoupon = new GroceriesCouponDO();
            updateCoupon.setId(coupon.getId());
            updateCoupon.setUsed(true);
            groceriesCouponMapper.updateById(updateCoupon);
        }

        // 10. 清理购物车中已下单的商品
        cartService.removeProducts(reqVO.getMemberId(), productMap.keySet());

        return order.getId();
    }

    /**
     * 查询会员的订单列表（含明细）
     */
    public List<GroceriesOrderRespVO> getOrderList(Integer memberId) {
        List<GroceriesOrderDO> orders = groceriesOrderMapper.selectListByMemberId(memberId);
        return buildRespList(orders);
    }

    /**
     * 获得订单详情（含明细）
     */
    public GroceriesOrderRespVO getOrder(Integer id) {
        GroceriesOrderDO order = groceriesOrderMapper.selectById(id);
        if (order == null) {
            throw new ServiceException(404, "订单不存在");
        }
        return buildRespList(List.of(order)).get(0);
    }

    /**
     * 更新订单状态，供前台「模拟下一步」与后台处理订单使用
     */
    public void updateStatus(Integer id, String status) {
        if (!ALLOWED_STATUS.contains(status)) {
            throw new ServiceException(400, "不支持的订单状态：" + status);
        }
        GroceriesOrderDO order = groceriesOrderMapper.selectById(id);
        if (order == null) {
            throw new ServiceException(404, "订单不存在");
        }
        GroceriesOrderDO updateObj = new GroceriesOrderDO();
        updateObj.setId(id);
        updateObj.setStatus(status);
        groceriesOrderMapper.updateById(updateObj);
    }

    private List<GroceriesOrderRespVO> buildRespList(List<GroceriesOrderDO> orders) {
        if (orders.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Integer, List<GroceriesOrderItemDO>> itemMap = groceriesOrderItemMapper
                .selectListByOrderIds(orders.stream().map(GroceriesOrderDO::getId).collect(Collectors.toList()))
                .stream()
                .collect(Collectors.groupingBy(GroceriesOrderItemDO::getOrderId));

        List<GroceriesOrderRespVO> result = new ArrayList<>(orders.size());
        for (GroceriesOrderDO order : orders) {
            GroceriesOrderRespVO respVO = BeanUtils.toBean(order, GroceriesOrderRespVO.class);
            List<GroceriesOrderItemRespVO> items = BeanUtils.toBean(
                    itemMap.getOrDefault(order.getId(), List.of()), GroceriesOrderItemRespVO.class);
            items.forEach(item -> item.setAmount(item.getPrice() == null ? BigDecimal.ZERO
                    : item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))));
            respVO.setItems(items);
            result.add(respVO);
        }
        return result;
    }

    /**
     * 生成订单号：FS + yyyyMMdd + 3 位当日序号，例如 FS20261029001
     */
    private String generateOrderNo() {
        String prefix = "FS" + LocalDate.now().format(ORDER_NO_DATE);
        long count = groceriesOrderMapper.selectCount(new LambdaQueryWrapperX<GroceriesOrderDO>()
                .likeRight(GroceriesOrderDO::getOrderNo, prefix));
        return prefix + String.format("%03d", count + 1);
    }

}
