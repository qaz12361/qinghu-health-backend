package cn.iocoder.yudao.module.groceries.controller.app.cart.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 购物车项 Response VO，已把商品信息铺平，前端直接渲染即可。
 */
@Schema(description = "用户 App - 购物车项 Response VO")
@Data
public class GroceriesCartItemRespVO {

    @Schema(description = "购物车项编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer id;

    @Schema(description = "商品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "13")
    private Integer productId;

    @Schema(description = "数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer quantity;

    @Schema(description = "商品名称", example = "鲜牛乳")
    private String name;

    @Schema(description = "商品图标", example = "🥛")
    private String emoji;

    @Schema(description = "分类编号", example = "dairy")
    private String catId;

    @Schema(description = "产地", example = "本地牧场")
    private String origin;

    @Schema(description = "单价", example = "7.90")
    private BigDecimal price;

    @Schema(description = "单位", example = "950ml")
    private String unit;

    @Schema(description = "库存", example = "48")
    private Integer stock;

    @Schema(description = "小计金额", example = "15.80")
    private BigDecimal amount;

}
