package cn.iocoder.yudao.module.system.controller.admin.qinghu.notification.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 通知中心创建/修改 Request VO")
@Data
public class QhNotificationSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @Schema(description = "接收方", example = "示例")
    private String receiver;

    @NotBlank(message = "通知类型不能为空")
    @Schema(description = "通知类型", example = "示例")
    private String type;

    @NotBlank(message = "通知标题不能为空")
    @Schema(description = "通知标题", example = "示例")
    private String title;

    @Schema(description = "通知内容", example = "示例")
    private String description;

    @Schema(description = "是否已读", example = "示例")
    private Boolean isRead;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "通知时间", example = "示例")
    private LocalDateTime notifyTime;

}
