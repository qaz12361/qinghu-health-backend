package cn.iocoder.yudao.module.system.controller.admin.qinghu.plan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 运动计划 Response VO")
@Data
public class QhPlanRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "学生姓名", example = "示例")
    private String stuName;
    @Schema(description = "计划标题", example = "示例")
    private String title;
    @Schema(description = "计划内容", example = "示例")
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "开始日期", example = "示例")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "结束日期", example = "示例")
    private LocalDate endDate;
    @Schema(description = "状态", example = "示例")
    private String status;
    @Schema(description = "教练反馈", example = "示例")
    private String feedback;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
