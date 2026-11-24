package cn.iocoder.yudao.module.system.controller.admin.qinghu.reminder.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "管理后台 - 健康提醒创建/修改 Request VO")
@Data
public class QhReminderSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @NotBlank(message = "提醒标题不能为空")
    @Schema(description = "提醒标题", example = "示例")
    private String title;

    @NotBlank(message = "提醒时间 HH:mm不能为空")
    @Schema(description = "提醒时间 HH:mm", example = "示例")
    private String remindTime;

    @NotBlank(message = "提醒类型不能为空")
    @Schema(description = "提醒类型", example = "示例")
    private String type;

    @Schema(description = "是否启用", example = "示例")
    private Boolean enabled;

}
