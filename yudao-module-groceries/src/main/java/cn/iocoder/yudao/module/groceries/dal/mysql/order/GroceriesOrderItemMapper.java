package cn.iocoder.yudao.module.groceries.dal.mysql.order;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.groceries.dal.dataobject.order.GroceriesOrderItemDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * 订单明细 Mapper
 */
@Mapper
public interface GroceriesOrderItemMapper extends BaseMapperX<GroceriesOrderItemDO> {

    /**
     * 查询多个订单的明细
     */
    default List<GroceriesOrderItemDO> selectListByOrderIds(Collection<Integer> orderIds) {
        return selectList(new LambdaQueryWrapperX<GroceriesOrderItemDO>()
                .in(GroceriesOrderItemDO::getOrderId, orderIds)
                .orderByAsc(GroceriesOrderItemDO::getId));
    }

    /**
     * 查询单个订单的明细
     */
    default List<GroceriesOrderItemDO> selectListByOrderId(Integer orderId) {
        return selectList(new LambdaQueryWrapperX<GroceriesOrderItemDO>()
                .eq(GroceriesOrderItemDO::getOrderId, orderId)
                .orderByAsc(GroceriesOrderItemDO::getId));
    }

}
