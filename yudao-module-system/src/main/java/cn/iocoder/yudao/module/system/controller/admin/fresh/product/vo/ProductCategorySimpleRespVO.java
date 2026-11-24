package cn.iocoder.yudao.module.system.controller.admin.fresh.product.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 生鲜分类精简返回（用于新增商品下拉框）
 *
 * @author 芋道 + 本地扩展
 */
@Schema(description = "管理后台 - 生鲜分类精简 Response VO")
@Data
public class ProductCategorySimpleRespVO {

    @Schema(description = "分类 id", example = "veg")
    private String id;

    @Schema(description = "分类名称", example = "时令蔬菜")
    private String name;

    @Schema(description = "图标", example = "🥬")
    private String emoji;

}
