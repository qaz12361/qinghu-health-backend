package cn.iocoder.yudao.module.groceries.dal.dataobject.order;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 订单 DO
 *
 * 状态流转：待发货 → 配送中 → 已完成；异常可置为 已取消。
 */
@TableName("orders")
@Data
@EqualsAndHashCode(callSuper = true)
public class GroceriesOrderDO extends BaseDO {

    /** 订单编号 */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 订单号，形如 FS20261029001 */
    private String orderNo;

    /** 会员编号 */
    private Integer memberId;

    /** 商品总额 */
    private BigDecimal totalAmount;

    /** 使用的优惠券编号 */
    private String couponId;

    /** 优惠金额 */
    private BigDecimal discountAmount;

    /** 实付金额（含运费） */
    private BigDecimal payAmount;

    /** 订单状态 */
    private String status;

    /** 配送方式：delivery 周边配送 / pickup 到店自提 */
    private String shipType;

    /** 配送费 */
    private BigDecimal shipFee;

    /** 收货地址编号 */
    private Integer addressId;

    /** 订单备注 */
    private String remark;

}
