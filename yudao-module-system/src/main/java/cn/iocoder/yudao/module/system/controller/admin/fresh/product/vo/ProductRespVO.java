package cn.iocoder.yudao.module.system.controller.admin.fresh.product.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 生鲜商品 Response VO")
@Data
public class ProductRespVO {

    @Schema(description = "商品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "分类id", example = "veg")
    private String catId;
    @Schema(description = "图标", example = "🥬")
    private String emoji;
    @Schema(description = "商品名称", example = "有机青菜")
    private String name;
    @Schema(description = "产地", example = "山东")
    private String origin;
    @Schema(description = "售价", example = "5.80")
    private BigDecimal price;
    @Schema(description = "原价", example = "9.90")
    private BigDecimal oldPrice;
    @Schema(description = "单位", example = "500g")
    private String unit;
    @Schema(description = "鲜度标签", example = "当日鲜")
    private String freshLabel;
    @Schema(description = "营销标签", example = "会员价")
    private String tag;
    @Schema(description = "库存", example = "100")
    private Integer stock;
    @Schema(description = "图片路径", example = "")
    private String image;
    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
