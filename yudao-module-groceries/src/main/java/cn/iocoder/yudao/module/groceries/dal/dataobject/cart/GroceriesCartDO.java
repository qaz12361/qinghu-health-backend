package cn.iocoder.yudao.module.groceries.dal.dataobject.cart;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 购物车项 DO
 *
 * 一个会员同一个商品只有一行记录（member_id + product_id 唯一），数量累加。
 */
@TableName("cart")
@Data
@EqualsAndHashCode(callSuper = true)
public class GroceriesCartDO extends BaseDO {

    /** 购物车项编号 */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 会员编号 */
    private Integer memberId;

    /** 商品编号 */
    private Integer productId;

    /** 数量 */
    private Integer quantity;

}
