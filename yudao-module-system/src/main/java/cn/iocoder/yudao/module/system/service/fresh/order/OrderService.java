package cn.iocoder.yudao.module.system.service.fresh.order;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.fresh.order.vo.OrderPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.fresh.order.vo.OrderSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.fresh.order.OrderDO;

/**
 * 生鲜订单 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface OrderService {

    Long createOrder(OrderSaveReqVO createReqVO);

    void updateOrder(OrderSaveReqVO updateReqVO);

    void deleteOrder(Long id);

    OrderDO getOrder(Long id);

    PageResult<OrderDO> getOrderPage(OrderPageReqVO pageReqVO);

}
