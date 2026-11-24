package cn.iocoder.yudao.module.groceries.controller.app.cart.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "用户 App - 购物车操作 Request VO")
@Data
public class GroceriesCartItemReqVO {

    @Schema(description = "会员编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "会员编号不能为空")
    private Integer memberId;

    @Schema(description = "商品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "商品编号不能为空")
    private Integer productId;

    @Schema(description = "数量，0 表示移除", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "数量不能为空")
    @Min(value = 0, message = "数量不能小于 0")
    private Integer quantity;

}
