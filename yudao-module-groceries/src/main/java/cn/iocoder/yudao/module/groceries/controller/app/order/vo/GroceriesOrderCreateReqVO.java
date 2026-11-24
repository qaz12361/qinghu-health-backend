package cn.iocoder.yudao.module.groceries.controller.app.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "用户 App - 创建订单 Request VO")
@Data
public class GroceriesOrderCreateReqVO {

    @Schema(description = "会员编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "会员编号不能为空")
    private Integer memberId;

    @Schema(description = "配送方式：delivery 周边配送 / pickup 到店自提", example = "delivery")
    private String shipType;

    @Schema(description = "收货地址编号，到店自提时可为空", example = "1")
    private Integer addressId;

    @Schema(description = "优惠券编号，不使用则传空", example = "c1")
    private String couponId;

    @Schema(description = "订单备注", example = "麻烦放门口")
    private String remark;

    @Schema(description = "下单商品明细", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "下单商品不能为空")
    @Valid
    private List<Item> items;

    @Schema(description = "下单商品项")
    @Data
    public static class Item {

        @Schema(description = "商品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "商品编号不能为空")
        private Integer productId;

        @Schema(description = "购买数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
        @NotNull(message = "购买数量不能为空")
        @Min(value = 1, message = "购买数量必须大于 0")
        private Integer quantity;

    }

}
