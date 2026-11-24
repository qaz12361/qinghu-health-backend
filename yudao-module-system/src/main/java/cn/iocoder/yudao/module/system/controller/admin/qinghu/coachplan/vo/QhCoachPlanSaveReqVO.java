package cn.iocoder.yudao.module.system.controller.admin.qinghu.coachplan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Schema(description = "管理后台 - 教练计划创建/修改 Request VO")
@Data
public class QhCoachPlanSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @NotBlank(message = "关联预约单号不能为空")
    @Schema(description = "关联预约单号", example = "示例")
    private String bookingNo;

    @NotBlank(message = "学生姓名不能为空")
    @Schema(description = "学生姓名", example = "示例")
    private String stuName;

    @NotBlank(message = "教练姓名不能为空")
    @Schema(description = "教练姓名", example = "示例")
    private String coachName;

    @NotBlank(message = "计划标题不能为空")
    @Schema(description = "计划标题", example = "示例")
    private String title;

    @NotBlank(message = "周期不能为空")
    @Schema(description = "周期", example = "示例")
    private String period;

    @Schema(description = "阶段目标", example = "示例")
    private String goal;

    @Schema(description = "计划内容", example = "示例")
    private String content;

    @Schema(description = "负荷等级", example = "示例")
    private String loadLevel;

    @Schema(description = "休息建议", example = "示例")
    private String restAdvice;

    @Schema(description = "检查节点", example = "示例")
    private String checkPoint;

    @NotBlank(message = "状态不能为空")
    @Schema(description = "状态", example = "示例")
    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "制定日期", example = "示例")
    private LocalDate planDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "更新日期", example = "示例")
    private LocalDate planUpdateDate;

    @Schema(description = "教练反馈", example = "示例")
    private String feedback;

}
