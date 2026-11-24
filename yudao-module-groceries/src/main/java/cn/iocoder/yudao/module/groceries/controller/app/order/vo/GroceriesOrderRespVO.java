package cn.iocoder.yudao.module.groceries.controller.app.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "用户 App - 订单 Response VO")
@Data
public class GroceriesOrderRespVO {

    @Schema(description = "订单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer id;

    @Schema(description = "订单号", requiredMode = Schema.RequiredMode.REQUIRED, example = "FS20261029001")
    private String orderNo;

    @Schema(description = "会员编号", example = "1")
    private Integer memberId;

    @Schema(description = "商品总额", example = "14.60")
    private BigDecimal totalAmount;

    @Schema(description = "优惠券编号", example = "c1")
    private String couponId;

    @Schema(description = "优惠金额", example = "8.00")
    private BigDecimal discountAmount;

    @Schema(description = "实付金额", example = "6.60")
    private BigDecimal payAmount;

    @Schema(description = "订单状态", example = "待发货")
    private String status;

    @Schema(description = "配送方式", example = "delivery")
    private String shipType;

    @Schema(description = "配送费", example = "5.00")
    private BigDecimal shipFee;

    @Schema(description = "收货地址编号", example = "1")
    private Integer addressId;

    @Schema(description = "订单备注")
    private String remark;

    @Schema(description = "下单时间")
    private LocalDateTime createTime;

    @Schema(description = "订单明细")
    private List<GroceriesOrderItemRespVO> items;

}
