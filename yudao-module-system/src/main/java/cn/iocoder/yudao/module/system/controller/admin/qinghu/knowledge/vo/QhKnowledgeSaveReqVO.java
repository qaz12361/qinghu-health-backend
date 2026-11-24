package cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledge.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "管理后台 - 健康知识创建/修改 Request VO")
@Data
public class QhKnowledgeSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @NotBlank(message = "标题不能为空")
    @Schema(description = "标题", example = "示例")
    private String title;

    @NotBlank(message = "分类不能为空")
    @Schema(description = "分类", example = "示例")
    private String cat;

    @NotBlank(message = "封面主题键不能为空")
    @Schema(description = "封面主题键", example = "示例")
    private String cover;

    @NotBlank(message = "摘要不能为空")
    @Schema(description = "摘要", example = "示例")
    private String summary;

    @Schema(description = "正文", example = "示例")
    private String content;

}
