package cn.iocoder.yudao.module.groceries.dal.dataobject.product;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 生鲜商品 DO
 */
@TableName("product")
@Data
@EqualsAndHashCode(callSuper = true)
public class GroceriesProductDO extends BaseDO {

    /** 商品编号 */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 所属分类编号，关联 category.id */
    private String catId;

    /** 商品图标（emoji） */
    private String emoji;

    /** 商品名称 */
    private String name;

    /** 产地 */
    private String origin;

    /** 售价 */
    private BigDecimal price;

    /** 原价（划线价） */
    private BigDecimal oldPrice;

    /** 计价单位，例如 500g、1kg、盒 */
    private String unit;

    /** 鲜度标签，例如 当日鲜、产地直采 */
    private String freshLabel;

    /** 营销标签，例如 会员价、秒杀 */
    private String tag;

    /** 库存 */
    private Integer stock;

    /** 商品图片地址 */
    private String image;

}
