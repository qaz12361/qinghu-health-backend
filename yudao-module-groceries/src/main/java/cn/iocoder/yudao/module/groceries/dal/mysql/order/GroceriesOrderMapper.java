package cn.iocoder.yudao.module.groceries.dal.mysql.order;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.groceries.dal.dataobject.order.GroceriesOrderDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单 Mapper
 */
@Mapper
public interface GroceriesOrderMapper extends BaseMapperX<GroceriesOrderDO> {

    /**
     * 查询某会员的订单，最新的在前
     */
    default List<GroceriesOrderDO> selectListByMemberId(Integer memberId) {
        return selectList(new LambdaQueryWrapperX<GroceriesOrderDO>()
                .eqIfPresent(GroceriesOrderDO::getMemberId, memberId)
                .orderByDesc(GroceriesOrderDO::getId));
    }

    /**
     * 按订单号查询，用于生成唯一订单号时校验
     */
    default GroceriesOrderDO selectByOrderNo(String orderNo) {
        return selectOne(new LambdaQueryWrapperX<GroceriesOrderDO>()
                .eq(GroceriesOrderDO::getOrderNo, orderNo));
    }

}
