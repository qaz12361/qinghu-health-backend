package cn.iocoder.yudao.module.system.service.fresh.order;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.fresh.order.vo.OrderPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.fresh.order.vo.OrderSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.fresh.order.OrderDO;
import cn.iocoder.yudao.module.system.dal.mysql.fresh.order.OrderMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 生鲜订单 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public Long createOrder(OrderSaveReqVO createReqVO) {
        OrderDO order = BeanUtils.toBean(createReqVO, OrderDO.class);
        orderMapper.insert(order);
        return order.getId();
    }

    @Override
    public void updateOrder(OrderSaveReqVO updateReqVO) {
        validateOrderExists(updateReqVO.getId());
        OrderDO updateObj = BeanUtils.toBean(updateReqVO, OrderDO.class);
        orderMapper.updateById(updateObj);
    }

    @Override
    public void deleteOrder(Long id) {
        validateOrderExists(id);
        orderMapper.deleteById(id);
    }

    @Override
   public OrderDO getOrder(Long id) {
        return orderMapper.selectById(id);
    }

    @Override
    public PageResult<OrderDO> getOrderPage(OrderPageReqVO pageReqVO) {
        return orderMapper.selectPage(pageReqVO);
    }

    private void validateOrderExists(Long id) {
        if (id == null) {
            return;
        }
        if (orderMapper.selectById(id) == null) {
            throw new ServiceException(404, "订单不存在");
        }
    }

}
