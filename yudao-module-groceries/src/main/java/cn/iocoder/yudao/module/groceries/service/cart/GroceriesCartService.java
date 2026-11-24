package cn.iocoder.yudao.module.groceries.service.cart;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.module.groceries.controller.app.cart.vo.GroceriesCartItemRespVO;
import cn.iocoder.yudao.module.groceries.dal.dataobject.cart.GroceriesCartDO;
import cn.iocoder.yudao.module.groceries.dal.dataobject.product.GroceriesProductDO;
import cn.iocoder.yudao.module.groceries.dal.mysql.cart.GroceriesCartMapper;
import cn.iocoder.yudao.module.groceries.service.catalog.GroceriesCatalogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 生鲜商城 - 购物车 Service
 */
@Service
public class GroceriesCartService {

    @Resource
    private GroceriesCartMapper groceriesCartMapper;
    @Resource
    private GroceriesCatalogService catalogService;

    /**
     * 查询购物车列表，商品信息铺平后返回
     */
    public List<GroceriesCartItemRespVO> getCartList(Integer memberId) {
        List<GroceriesCartDO> carts = groceriesCartMapper.selectListByMemberId(memberId);
        if (carts.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Integer, GroceriesProductDO> productMap = catalogService.getProductMap(
                carts.stream().map(GroceriesCartDO::getProductId).collect(Collectors.toSet()));
        List<GroceriesCartItemRespVO> result = new ArrayList<>(carts.size());
        for (GroceriesCartDO cart : carts) {
            GroceriesProductDO product = productMap.get(cart.getProductId());
            if (product == null) {
                // 商品已被删除，跳过该购物车项，避免前端渲染出脏数据
                continue;
            }
            result.add(buildItem(cart, product));
        }
        return result;
    }

    /**
     * 加入购物车：已存在则累加数量
     *
     * @param quantity 增量，必须大于 0
     */
    @Transactional(rollbackFor = Exception.class)
    public void addToCart(Integer memberId, Integer productId, Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new ServiceException(400, "数量必须大于 0");
        }
        GroceriesProductDO product = catalogService.getProduct(productId);
        if (product == null) {
            throw new ServiceException(404, "商品不存在或已下架");
        }
        // 注意：这里必须连「逻辑删除」的行一起查。购物车表有唯一索引 (member_id, product_id)，
        // 若历史上有被逻辑删除的同商品记录，直接 insert 会撞唯一键，最终被兜底成“系统异常”。
        GroceriesCartDO any = groceriesCartMapper.selectAnyByMemberIdAndProductId(memberId, productId);
        boolean revived = any != null && Boolean.TRUE.equals(any.getDeleted());
        GroceriesCartDO exists = (any == null || Boolean.TRUE.equals(any.getDeleted())) ? null : any;
        int targetQuantity = (exists == null ? 0 : exists.getQuantity()) + quantity;
        validateStock(product, targetQuantity);

        if (revived) {
            // 之前被删过，直接把老记录复活，避免唯一键冲突
            groceriesCartMapper.reviveById(any.getId(), targetQuantity);
        } else if (exists == null) {
            GroceriesCartDO cart = new GroceriesCartDO();
            cart.setMemberId(memberId);
            cart.setProductId(productId);
            cart.setQuantity(targetQuantity);
            groceriesCartMapper.insert(cart);
        } else {
            GroceriesCartDO updateObj = new GroceriesCartDO();
            updateObj.setId(exists.getId());
            updateObj.setQuantity(targetQuantity);
            groceriesCartMapper.updateById(updateObj);
        }
    }

    /**
     * 修改购物车数量，数量为 0 表示移除
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateQuantity(Integer memberId, Integer productId, Integer quantity) {
        GroceriesCartDO exists = groceriesCartMapper.selectByMemberIdAndProductId(memberId, productId);
        if (exists == null) {
            throw new ServiceException(404, "购物车中没有该商品");
        }
        if (quantity == null || quantity <= 0) {
            groceriesCartMapper.physicalDeleteByMemberIdAndProductId(memberId, productId);
            return;
        }
        validateStock(catalogService.getProduct(productId), quantity);
        GroceriesCartDO updateObj = new GroceriesCartDO();
        updateObj.setId(exists.getId());
        updateObj.setQuantity(quantity);
        groceriesCartMapper.updateById(updateObj);
    }

    /**
     * 移除购物车项
     */
    public void removeCartItem(Integer memberId, Integer productId) {
        groceriesCartMapper.physicalDeleteByMemberIdAndProductId(memberId, productId);
    }

    /**
     * 清空购物车
     */
    public void clearCart(Integer memberId) {
        groceriesCartMapper.physicalDeleteByMemberId(memberId);
    }

    /**
     * 下单成功后，移除已下单的商品
     */
    public void removeProducts(Integer memberId, Set<Integer> productIds) {
        for (Integer productId : productIds) {
            groceriesCartMapper.physicalDeleteByMemberIdAndProductId(memberId, productId);
        }
    }

    private void validateStock(GroceriesProductDO product, int quantity) {
        if (product == null) {
            throw new ServiceException(404, "商品不存在或已下架");
        }
        if (product.getStock() == null || product.getStock() < quantity) {
            throw new ServiceException(400, product.getName() + " 库存不足，仅剩 "
                    + (product.getStock() == null ? 0 : product.getStock()) + product.getUnit());
        }
    }

    private GroceriesCartItemRespVO buildItem(GroceriesCartDO cart, GroceriesProductDO product) {
        GroceriesCartItemRespVO item = new GroceriesCartItemRespVO();
        item.setId(cart.getId());
        item.setProductId(cart.getProductId());
        item.setQuantity(cart.getQuantity());
        item.setName(product.getName());
        item.setEmoji(product.getEmoji());
        item.setCatId(product.getCatId());
        item.setOrigin(product.getOrigin());
        item.setPrice(product.getPrice());
        item.setUnit(product.getUnit());
        item.setStock(product.getStock());
        item.setAmount(product.getPrice() == null ? BigDecimal.ZERO
                : product.getPrice().multiply(BigDecimal.valueOf(cart.getQuantity())));
        return item;
    }

}
