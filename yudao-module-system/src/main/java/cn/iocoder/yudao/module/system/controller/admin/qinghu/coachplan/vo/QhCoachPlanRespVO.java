package cn.iocoder.yudao.module.system.controller.admin.qinghu.coachplan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 教练计划 Response VO")
@Data
public class QhCoachPlanRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "关联预约单号", example = "示例")
    private String bookingNo;
    @Schema(description = "学生姓名", example = "示例")
    private String stuName;
    @Schema(description = "教练姓名", example = "示例")
    private String coachName;
    @Schema(description = "计划标题", example = "示例")
    private String title;
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

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
