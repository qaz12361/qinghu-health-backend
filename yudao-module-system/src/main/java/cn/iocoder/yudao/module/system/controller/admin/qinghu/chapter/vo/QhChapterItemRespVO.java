package cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 循证指南建议条目 Response VO")
@Data
public class QhChapterItemRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "所属章节ID", example = "1")
    private Long chapterId;

    @Schema(description = "排序号", example = "1")
    private Integer sortNo;

    @Schema(description = "建议标题", example = "示例")
    private String title;

    @Schema(description = "建议说明", example = "示例")
    private String detail;

    @Schema(description = "证据等级 A/B/C", example = "A")
    private String level;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
