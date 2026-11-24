package cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledgepoint.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "管理后台 - 知识要点创建/修改 Request VO")
@Data
public class QhKnowledgePointSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @NotNull(message = "所属知识编号不能为空")
    @Schema(description = "所属知识编号", example = "示例")
    private Long knowledgeId;

    @Schema(description = "排序号", example = "示例")
    private Integer sortNo;

    @NotBlank(message = "要点标题不能为空")
    @Schema(description = "要点标题", example = "示例")
    private String point;

    @NotBlank(message = "要点说明不能为空")
    @Schema(description = "要点说明", example = "示例")
    private String detail;

    @NotBlank(message = "重要级别 A/B/C不能为空")
    @Schema(description = "重要级别 A/B/C", example = "示例")
    private String level;

}
