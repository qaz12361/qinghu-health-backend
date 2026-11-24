package cn.iocoder.yudao.module.groceries.dal.dataobject.order;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 订单明细 DO
 *
 * 商品名称、单价、单位均做快照，避免商品后续改价影响历史订单。
 */
@TableName("order_item")
@Data
@EqualsAndHashCode(callSuper = true)
public class GroceriesOrderItemDO extends BaseDO {

    /** 明细编号 */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 订单编号 */
    private Integer orderId;

    /** 商品编号 */
    private Integer productId;

    /** 商品名称快照 */
    private String name;

    /** 单价快照 */
    private BigDecimal price;

    /** 数量 */
    private Integer quantity;

    /** 单位快照 */
    private String unit;

}
