package cn.iocoder.yudao.module.system.dal.dataobject.fresh.product;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 生鲜商品 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("product")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductDO extends BaseDO {

    /**
     * 商品ID
     */
    private Long id;
    /**
     * 分类id
     */
    private String catId;
    /**
     * 图标
     */
    private String emoji;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 产地
     */
    private String origin;
    /**
     * 售价
     */
    private BigDecimal price;
    /**
     * 原价（划线价）
     */
    private BigDecimal oldPrice;
    /**
     * 单位（500g/1kg/盒…）
     */
    private String unit;
    /**
     * 鲜度标签（当日鲜/产地直采…）
     */
    private String freshLabel;
    /**
     * 营销标签（会员价/秒杀）
     */
    private String tag;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 图片路径
     */
    private String image;

}
