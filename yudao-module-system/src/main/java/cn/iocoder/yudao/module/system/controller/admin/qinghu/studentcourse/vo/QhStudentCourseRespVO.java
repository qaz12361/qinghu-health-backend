package cn.iocoder.yudao.module.system.controller.admin.qinghu.studentcourse.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 已购课程 Response VO")
@Data
public class QhStudentCourseRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "学生编号", example = "示例")
    private Long studentId;
    @Schema(description = "课程编号", example = "示例")
    private Long courseId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "购买日期", example = "示例")
    private LocalDate buyTime;
    @Schema(description = "学习进度 %", example = "示例")
    private Integer progress;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
