package cn.iocoder.yudao.module.system.controller.admin.qinghu.studentcourse.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Schema(description = "管理后台 - 已购课程创建/修改 Request VO")
@Data
public class QhStudentCourseSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @Schema(description = "学生编号", example = "示例")
    private Long studentId;

    @NotNull(message = "课程编号不能为空")
    @Schema(description = "课程编号", example = "示例")
    private Long courseId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "购买日期", example = "示例")
    private LocalDate buyTime;

    @Schema(description = "学习进度 %", example = "示例")
    private Integer progress;

}
