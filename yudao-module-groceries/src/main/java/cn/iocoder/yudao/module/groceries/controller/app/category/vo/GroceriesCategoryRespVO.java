package cn.iocoder.yudao.module.groceries.controller.app.category.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "用户 App - 生鲜商品分类 Response VO")
@Data
public class GroceriesCategoryRespVO {

    @Schema(description = "分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "veg")
    private String id;

    @Schema(description = "分类名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "时令蔬菜")
    private String name;

    @Schema(description = "分类图标", example = "🥬")
    private String emoji;

    @Schema(description = "分类简介", example = "当日鲜")
    private String description;

    @Schema(description = "分类图片地址")
    private String image;

}
