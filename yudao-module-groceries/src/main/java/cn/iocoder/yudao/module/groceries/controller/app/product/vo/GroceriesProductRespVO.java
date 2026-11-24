package cn.iocoder.yudao.module.groceries.controller.app.product.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "用户 App - 生鲜商品 Response VO")
@Data
public class GroceriesProductRespVO {

    @Schema(description = "商品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer id;

    @Schema(description = "分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "veg")
    private String catId;

    @Schema(description = "商品图标", example = "🥬")
    private String emoji;

    @Schema(description = "商品名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "有机小油菜")
    private String name;

    @Schema(description = "产地", example = "本地有机农场")
    private String origin;

    @Schema(description = "售价", requiredMode = Schema.RequiredMode.REQUIRED, example = "3.90")
    private BigDecimal price;

    @Schema(description = "原价（划线价）", example = "5.90")
    private BigDecimal oldPrice;

    @Schema(description = "计价单位", example = "500g")
    private String unit;

    @Schema(description = "鲜度标签", example = "当日鲜")
    private String freshLabel;

    @Schema(description = "营销标签", example = "会员价")
    private String tag;

    @Schema(description = "库存", requiredMode = Schema.RequiredMode.REQUIRED, example = "42")
    private Integer stock;

    @Schema(description = "商品图片地址")
    private String image;

}
