package cn.iocoder.yudao.module.system.controller.admin.qinghu.config.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "管理后台 - 平台配置创建/修改 Request VO")
@Data
public class QhConfigSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @NotBlank(message = "配置键不能为空")
    @Schema(description = "配置键", example = "示例")
    private String configKey;

    @NotBlank(message = "配置值不能为空")
    @Schema(description = "配置值", example = "示例")
    private String configValue;

    @Schema(description = "说明", example = "示例")
    private String description;

}
