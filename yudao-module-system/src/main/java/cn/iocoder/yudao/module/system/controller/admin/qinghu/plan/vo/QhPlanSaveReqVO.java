package cn.iocoder.yudao.module.system.controller.admin.qinghu.plan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Schema(description = "管理后台 - 运动计划创建/修改 Request VO")
@Data
public class QhPlanSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @NotBlank(message = "学生姓名不能为空")
    @Schema(description = "学生姓名", example = "示例")
    private String stuName;

    @NotBlank(message = "计划标题不能为空")
    @Schema(description = "计划标题", example = "示例")
    private String title;

    @NotBlank(message = "计划内容不能为空")
    @Schema(description = "计划内容", example = "示例")
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "开始日期", example = "示例")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "结束日期", example = "示例")
    private LocalDate endDate;

    @NotBlank(message = "状态不能为空")
    @Schema(description = "状态", example = "示例")
    private String status;

    @Schema(description = "教练反馈", example = "示例")
    private String feedback;

}
