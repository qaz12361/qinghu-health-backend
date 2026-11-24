package cn.iocoder.yudao.module.system.controller.admin.fresh.member.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 生鲜会员 Response VO")
@Data
public class MemberRespVO {

    @Schema(description = "会员编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "会员姓名", example = "王小雨")
    private String name;
    @Schema(description = "手机号", example = "13800000000")
    private String phone;
    @Schema(description = "会员等级", example = "Lv.3")
    private String level;
    @Schema(description = "账户余额", example = "100.00")
    private BigDecimal balance;
    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
