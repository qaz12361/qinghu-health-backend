package cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledgepoint.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 知识要点 Response VO")
@Data
public class QhKnowledgePointRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "所属知识编号", example = "示例")
    private Long knowledgeId;
    @Schema(description = "排序号", example = "示例")
    private Integer sortNo;
    @Schema(description = "要点标题", example = "示例")
    private String point;
    @Schema(description = "要点说明", example = "示例")
    private String detail;
    @Schema(description = "重要级别 A/B/C", example = "示例")
    private String level;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
