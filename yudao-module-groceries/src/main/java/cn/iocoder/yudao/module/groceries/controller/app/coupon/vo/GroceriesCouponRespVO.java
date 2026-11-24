package cn.iocoder.yudao.module.groceries.controller.app.coupon.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "用户 App - 优惠券 Response VO")
@Data
public class GroceriesCouponRespVO {

    @Schema(description = "优惠券编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "c1")
    private String id;

    @Schema(description = "减免金额", requiredMode = Schema.RequiredMode.REQUIRED, example = "8.00")
    private BigDecimal amount;

    @Schema(description = "券名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "满39减8券")
    private String name;

    @Schema(description = "使用门槛", example = "39.00")
    private BigDecimal condition;

    @Schema(description = "是否已使用", example = "false")
    private Boolean used;

}
