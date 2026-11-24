package cn.iocoder.yudao.module.system.controller.admin.qinghu.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 平台用户 Response VO")
@Data
public class QhUserRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "姓名", example = "示例")
    private String name;
    @Schema(description = "登录账号", example = "示例")
    private String account;
    @Schema(description = "角色", example = "示例")
    private String role;
    @Schema(description = "状态", example = "示例")
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "注册日期", example = "示例")
    private LocalDate regTime;
    @Schema(description = "入驻审核状态", example = "示例")
    private String applyStatus;
    @Schema(description = "审核通过时间", example = "示例")
    private String approveTime;
    @Schema(description = "专长", example = "示例")
    private String specialty;
    @Schema(description = "资质证书", example = "示例")
    private String cert;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
