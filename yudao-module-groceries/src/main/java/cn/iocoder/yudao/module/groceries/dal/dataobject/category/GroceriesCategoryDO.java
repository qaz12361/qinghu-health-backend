package cn.iocoder.yudao.module.groceries.dal.dataobject.category;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 生鲜商品分类 DO
 *
 * 表 category：类目固定为 8 个（veg / fruit / meat / sea / grain / dairy / snack / daily），
 * 主键为业务字符串，不采用自增。
 */
@TableName("category")
@Data
@EqualsAndHashCode(callSuper = true)
public class GroceriesCategoryDO extends BaseDO {

    /** 分类编号，例如 veg、fruit */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /** 分类名称 */
    private String name;

    /** 分类图标（emoji） */
    private String emoji;

    /** 分类简介 */
    private String description;

    /** 分类图片地址 */
    private String image;

}
