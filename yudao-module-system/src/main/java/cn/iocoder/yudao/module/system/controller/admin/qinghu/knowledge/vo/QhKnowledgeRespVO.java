package cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledge.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 健康知识 Response VO")
@Data
public class QhKnowledgeRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "标题", example = "示例")
    private String title;
    @Schema(description = "分类", example = "示例")
    private String cat;
    @Schema(description = "封面主题键", example = "示例")
    private String cover;
    @Schema(description = "摘要", example = "示例")
    private String summary;
    @Schema(description = "正文", example = "示例")
    private String content;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
