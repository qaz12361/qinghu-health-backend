package cn.iocoder.yudao.module.system.controller.admin.qinghu.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Schema(description = "管理后台 - 平台用户创建/修改 Request VO")
@Data
public class QhUserSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @NotBlank(message = "姓名不能为空")
    @Schema(description = "姓名", example = "示例")
    private String name;

    @NotBlank(message = "登录账号不能为空")
    @Schema(description = "登录账号", example = "示例")
    private String account;

    @NotBlank(message = "角色不能为空")
    @Schema(description = "角色", example = "示例")
    private String role;

    @NotBlank(message = "状态不能为空")
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

}
