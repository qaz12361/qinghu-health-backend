package cn.iocoder.yudao.module.system.controller.admin.qinghu.reminder.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 健康提醒 Response VO")
@Data
public class QhReminderRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "提醒标题", example = "示例")
    private String title;
    @Schema(description = "提醒时间 HH:mm", example = "示例")
    private String remindTime;
    @Schema(description = "提醒类型", example = "示例")
    private String type;
    @Schema(description = "是否启用", example = "示例")
    private Boolean enabled;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
