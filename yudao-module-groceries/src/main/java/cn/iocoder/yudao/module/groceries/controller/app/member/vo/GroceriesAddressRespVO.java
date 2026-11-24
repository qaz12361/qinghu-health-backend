package cn.iocoder.yudao.module.groceries.controller.app.member.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "用户 App - 收货地址 Response VO")
@Data
public class GroceriesAddressRespVO {

    @Schema(description = "地址编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer id;

    @Schema(description = "会员编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer memberId;

    @Schema(description = "收件人", example = "王小雨")
    private String receiver;

    @Schema(description = "联系电话", example = "13800000000")
    private String phone;

    @Schema(description = "详细地址", example = "阳光社区 3 号楼 2 单元 501")
    private String detail;

    @Schema(description = "是否默认地址", example = "true")
    private Boolean isDefault;

}
