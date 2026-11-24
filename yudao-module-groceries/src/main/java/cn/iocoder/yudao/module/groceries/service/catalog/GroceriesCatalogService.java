package cn.iocoder.yudao.module.groceries.service.catalog;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.module.groceries.dal.dataobject.category.GroceriesCategoryDO;
import cn.iocoder.yudao.module.groceries.dal.dataobject.coupon.GroceriesCouponDO;
import cn.iocoder.yudao.module.groceries.dal.dataobject.product.GroceriesProductDO;
import cn.iocoder.yudao.module.groceries.dal.mysql.category.GroceriesCategoryMapper;
import cn.iocoder.yudao.module.groceries.dal.mysql.coupon.GroceriesCouponMapper;
import cn.iocoder.yudao.module.groceries.dal.mysql.product.GroceriesProductMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 生鲜商城 - 商品目录 Service
 *
 * 覆盖分类、商品、优惠券三类只读数据的查询。
 */
@Service
public class GroceriesCatalogService {

    @Resource
    private GroceriesCategoryMapper groceriesCategoryMapper;
    @Resource
    private GroceriesProductMapper groceriesProductMapper;
    @Resource
    private GroceriesCouponMapper groceriesCouponMapper;

    /**
     * 查询全部分类，按预设顺序返回（id 升序即 veg → daily 的录入顺序）
     */
    public List<GroceriesCategoryDO> getCategoryList() {
        return groceriesCategoryMapper.selectList();
    }

    /**
     * 查询商品列表
     *
     * @param catId   分类编号，空表示全部
     * @param keyword 关键字，匹配名称或产地
     */
    public List<GroceriesProductDO> getProductList(String catId, String keyword) {
        return groceriesProductMapper.selectListByCondition(emptyToNull(catId), emptyToNull(keyword));
    }

    /**
     * 获得商品，不存在时抛业务异常
     */
    public GroceriesProductDO getProduct(Integer id) {
        GroceriesProductDO product = id == null ? null : groceriesProductMapper.selectById(id);
        if (product == null) {
            throw new ServiceException(404, "商品不存在");
        }
        return product;
    }

    /**
     * 批量获得商品，返回 id → 商品 的映射，便于组装购物车与订单明细
     */
    public Map<Integer, GroceriesProductDO> getProductMap(Collection<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyMap();
        }
        List<GroceriesProductDO> list = groceriesProductMapper.selectBatchIds(ids);
        return list.stream().collect(Collectors.toMap(GroceriesProductDO::getId, Function.identity()));
    }

    /**
     * 查询全部优惠券
     */
    public List<GroceriesCouponDO> getCouponList() {
        return groceriesCouponMapper.selectList();
    }

    /**
     * 获得优惠券，不存在返回 null
     */
    public GroceriesCouponDO getCoupon(String id) {
        return id == null || id.isBlank() ? null : groceriesCouponMapper.selectById(id);
    }

    /**
     * 扣减库存，库存不足时抛业务异常
     */
    public void reduceStock(Integer productId, int quantity) {
        GroceriesProductDO product = getProduct(productId);
        if (product.getStock() == null || product.getStock() < quantity) {
            throw new ServiceException(400, product.getName() + " 库存不足，仅剩 "
                    + (product.getStock() == null ? 0 : product.getStock()) + product.getUnit());
        }
        GroceriesProductDO updateObj = new GroceriesProductDO();
        updateObj.setId(productId);
        updateObj.setStock(product.getStock() - quantity);
        groceriesProductMapper.updateById(updateObj);
    }

    private static String emptyToNull(String value) {
        return value == null || value.isBlank() ? null : value;
    }

}
