package cn.iocoder.yudao.module.system.controller.admin.qinghu.student.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 学生管理 Response VO")
@Data
public class QhStudentRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "姓名", example = "示例")
    private String name;
    @Schema(description = "学号", example = "示例")
    private String stuNo;
    @Schema(description = "性别", example = "示例")
    private String gender;
    @Schema(description = "年龄", example = "示例")
    private Integer age;
    @Schema(description = "教练绑定状态", example = "示例")
    private String coachStatus;
    @Schema(description = "BMI", example = "示例")
    private BigDecimal bmi;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "最近活跃日期", example = "示例")
    private LocalDate lastActive;
    @Schema(description = "手机号", example = "示例")
    private String phone;
    @Schema(description = "邮箱", example = "示例")
    private String email;
    @Schema(description = "微信号", example = "示例")
    private String wechat;
    @Schema(description = "服务状态", example = "示例")
    private String serviceStatus;
    @Schema(description = "目标方向", example = "示例")
    private String goal;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
