package cn.iocoder.yudao.module.groceries.dal.dataobject.coupon;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 优惠券 DO
 *
 * 注意：condition 是 MySQL 保留字，必须用反引号包裹，否则 SQL 语法错误。
 */
@TableName("coupon")
@Data
@EqualsAndHashCode(callSuper = true)
public class GroceriesCouponDO extends BaseDO {

    /** 优惠券编号，例如 c1、c2 */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /** 减免金额 */
    private BigDecimal amount;

    /** 券名称 */
    private String name;

    /** 使用门槛（订单满多少可用） */
    @TableField("`condition`")
    private BigDecimal condition;

    /** 是否已使用 */
    private Boolean used;

}
