package cn.iocoder.yudao.module.groceries.controller.app.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "用户 App - 订单明细 Response VO")
@Data
public class GroceriesOrderItemRespVO {

    @Schema(description = "明细编号", example = "1")
    private Integer id;

    @Schema(description = "订单编号", example = "1")
    private Integer orderId;

    @Schema(description = "商品编号", example = "1")
    private Integer productId;

    @Schema(description = "商品名称快照", example = "有机小油菜")
    private String name;

    @Schema(description = "单价快照", example = "3.90")
    private BigDecimal price;

    @Schema(description = "数量", example = "2")
    private Integer quantity;

    @Schema(description = "单位快照", example = "500g")
    private String unit;

    @Schema(description = "小计金额", example = "7.80")
    private BigDecimal amount;

}
