package cn.iocoder.yudao.module.system.dal.dataobject.fresh.order;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 生鲜订单 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("orders")
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderDO extends BaseDO {

    /**
     * 订单ID
     */
    private Long id;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 会员id
     */
    private Long memberId;
    /**
     * 商品总额
     */
    private BigDecimal totalAmount;
    /**
     * 使用的优惠券id
     */
    private String couponId;
    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;
    /**
     * 实付金额
     */
    private BigDecimal payAmount;
    /**
     * 订单状态（待付款/待发货/待收货/已完成/已取消）
     */
    private String status;

}
