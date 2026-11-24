package cn.iocoder.yudao.module.system.controller.admin.qinghu.config.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 平台配置 Response VO")
@Data
public class QhConfigRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "配置键", example = "示例")
    private String configKey;
    @Schema(description = "配置值", example = "示例")
    private String configValue;
    @Schema(description = "说明", example = "示例")
    private String description;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
