package cn.iocoder.yudao.module.system.controller.admin.fresh.member.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - 生鲜会员创建/修改 Request VO")
@Data
public class MemberSaveReqVO {

    @Schema(description = "会员编号", example = "1")
    private Long id;

    @Schema(description = "会员姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "王小雨")
    @NotBlank(message = "会员姓名不能为空")
    private String name;

    @Schema(description = "手机号", example = "13800000000")
    private String phone;

    @Schema(description = "会员等级", example = "Lv.3")
    private String level;

    @Schema(description = "账户余额", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "账户余额不能为空")
    private BigDecimal balance;

}
