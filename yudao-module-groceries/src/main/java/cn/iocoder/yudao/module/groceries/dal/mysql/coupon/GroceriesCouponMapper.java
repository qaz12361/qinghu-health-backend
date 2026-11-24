package cn.iocoder.yudao.module.groceries.dal.mysql.coupon;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.groceries.dal.dataobject.coupon.GroceriesCouponDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券 Mapper
 */
@Mapper
public interface GroceriesCouponMapper extends BaseMapperX<GroceriesCouponDO> {
}
