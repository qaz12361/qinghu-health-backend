package cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 循证指南章节 Response VO")
@Data
public class QhChapterRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "章序号", example = "1")
    private Integer num;

    @Schema(description = "章节标题", example = "示例")
    private String title;

    @Schema(description = "封面图序号", example = "1")
    private Integer cover;

    @Schema(description = "章节摘要", example = "示例")
    private String summary;

    @Schema(description = "章节正文", example = "示例")
    private String content;

    @Schema(description = "建议条数", example = "6")
    private Integer itemCount;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
