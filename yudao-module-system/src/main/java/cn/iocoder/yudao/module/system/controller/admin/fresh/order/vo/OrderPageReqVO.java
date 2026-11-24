package cn.iocoder.yudao.module.system.controller.admin.fresh.order.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 生鲜订单分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderPageReqVO extends PageParam {

    @Schema(description = "订单号，模糊匹配", example = "FM2026")
    private String orderNo;

    @Schema(description = "订单状态", example = "待付款")
    private String status;

    @Schema(description = "会员id", example = "1")
    private Long memberId;

}
