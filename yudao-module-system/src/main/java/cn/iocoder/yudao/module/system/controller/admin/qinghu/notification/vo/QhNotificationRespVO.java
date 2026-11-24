package cn.iocoder.yudao.module.system.controller.admin.qinghu.notification.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 通知中心 Response VO")
@Data
public class QhNotificationRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "接收方", example = "示例")
    private String receiver;
    @Schema(description = "通知类型", example = "示例")
    private String type;
    @Schema(description = "通知标题", example = "示例")
    private String title;
    @Schema(description = "通知内容", example = "示例")
    private String description;
    @Schema(description = "是否已读", example = "示例")
    private Boolean isRead;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "通知时间", example = "示例")
    private LocalDateTime notifyTime;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
