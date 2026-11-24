package cn.iocoder.yudao.module.system.controller.admin.fresh.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 生鲜订单 Response VO")
@Data
public class OrderRespVO {

    @Schema(description = "订单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "订单号", example = "FM202610010001")
    private String orderNo;
    @Schema(description = "会员id", example = "1")
    private Long memberId;
    @Schema(description = "商品总额", example = "59.80")
    private BigDecimal totalAmount;
    @Schema(description = "使用的优惠券id", example = "c1")
    private String couponId;
    @Schema(description = "优惠金额", example = "8.00")
    private BigDecimal discountAmount;
    @Schema(description = "实付金额", example = "51.80")
    private BigDecimal payAmount;
    @Schema(description = "订单状态", example = "待付款")
    private String status;
    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
