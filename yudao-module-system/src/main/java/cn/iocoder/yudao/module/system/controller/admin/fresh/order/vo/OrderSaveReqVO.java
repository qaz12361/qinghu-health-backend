package cn.iocoder.yudao.module.system.controller.admin.fresh.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - 生鲜订单创建/修改 Request VO")
@Data
public class OrderSaveReqVO {

    @Schema(description = "订单编号", example = "1")
    private Long id;

    @Schema(description = "订单号", requiredMode = Schema.RequiredMode.REQUIRED, example = "FM202610010001")
    @NotBlank(message = "订单号不能为空")
    private String orderNo;

    @Schema(description = "会员id", example = "1")
    private Long memberId;

    @Schema(description = "商品总额", requiredMode = Schema.RequiredMode.REQUIRED, example = "59.80")
    @NotNull(message = "商品总额不能为空")
    private BigDecimal totalAmount;

    @Schema(description = "使用的优惠券id", example = "c1")
    private String couponId;

    @Schema(description = "优惠金额", example = "8.00")
    private BigDecimal discountAmount;

    @Schema(description = "实付金额", requiredMode = Schema.RequiredMode.REQUIRED, example = "51.80")
    @NotNull(message = "实付金额不能为空")
    private BigDecimal payAmount;

    @Schema(description = "订单状态（待付款/待发货/待收货/已完成/已取消）", example = "待付款")
    private String status;

}
