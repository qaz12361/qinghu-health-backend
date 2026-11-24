package cn.iocoder.yudao.module.system.controller.admin.fresh.product.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - 生鲜商品创建/修改 Request VO")
@Data
public class ProductSaveReqVO {

    @Schema(description = "商品编号", example = "1")
    private Long id;

    @Schema(description = "分类id（如 veg/fruit/meat）", requiredMode = Schema.RequiredMode.REQUIRED, example = "veg")
    @NotBlank(message = "商品分类不能为空")
    @Size(max = 20, message = "分类 id 不能超过 20 个字符")
    private String catId;

    @Schema(description = "图标", example = "🥬")
    @Size(max = 10, message = "图标不能超过 10 个字符")
    private String emoji;

    @Schema(description = "商品名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "有机青菜")
    @NotBlank(message = "商品名称不能为空")
    @Size(max = 100, message = "商品名称不能超过 100 个字符")
    private String name;

    @Schema(description = "产地", example = "山东")
    @Size(max = 50, message = "产地不能超过 50 个字符")
    private String origin;

    @Schema(description = "售价", requiredMode = Schema.RequiredMode.REQUIRED, example = "5.80")
    @NotNull(message = "售价不能为空")
    private BigDecimal price;

    @Schema(description = "原价（划线价）", example = "9.90")
    private BigDecimal oldPrice;

    @Schema(description = "单位（500g/1kg/盒…）", example = "500g")
    @Size(max = 20, message = "单位不能超过 20 个字符")
    private String unit;

    @Schema(description = "鲜度标签（当日鲜/产地直采…）", example = "当日鲜")
    @Size(max = 20, message = "鲜度标签不能超过 20 个字符")
    private String freshLabel;

    @Schema(description = "营销标签（会员价/秒杀）", example = "会员价")
    @Size(max = 20, message = "营销标签不能超过 20 个字符")
    private String tag;

    @Schema(description = "库存", example = "100")
    private Integer stock;

    @Schema(description = "图片路径", example = "")
    @Size(max = 200, message = "图片路径不能超过 200 个字符")
    private String image;

}
