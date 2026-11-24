package cn.iocoder.yudao.module.groceries.controller.app.member.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "用户 App - 会员 Response VO")
@Data
public class GroceriesMemberRespVO {

    @Schema(description = "会员编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer id;

    @Schema(description = "会员姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "王小雨")
    private String name;

    @Schema(description = "手机号", example = "13800000000")
    private String phone;

    @Schema(description = "会员等级", example = "Lv.3")
    private String level;

    @Schema(description = "账户余额", example = "100.00")
    private BigDecimal balance;

}
