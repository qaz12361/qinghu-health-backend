package cn.iocoder.yudao.module.system.dal.dataobject.fresh.category;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 生鲜分类 DO（只读，用于商品新增时校验/选择分类）
 *
 * @author 芋道 + 本地扩展
 */
@TableName("category")
@Data
@EqualsAndHashCode(callSuper = true)
public class FreshCategoryDO extends BaseDO {

    /**
     * 分类 id（如 veg / fruit / meat）
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 图标
     */
    private String emoji;
    /**
     * 描述
     */
    private String description;
    /**
     * 图片
     */
    private String image;

}
