package cn.iocoder.yudao.module.system.controller.admin.qinghu.student.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "管理后台 - 学生管理创建/修改 Request VO")
@Data
public class QhStudentSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @NotBlank(message = "姓名不能为空")
    @Schema(description = "姓名", example = "示例")
    private String name;

    @NotBlank(message = "学号不能为空")
    @Schema(description = "学号", example = "示例")
    private String stuNo;

    @NotBlank(message = "性别不能为空")
    @Schema(description = "性别", example = "示例")
    private String gender;

    @Schema(description = "年龄", example = "示例")
    private Integer age;

    @NotBlank(message = "教练绑定状态不能为空")
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

    @NotBlank(message = "服务状态不能为空")
    @Schema(description = "服务状态", example = "示例")
    private String serviceStatus;

    @NotBlank(message = "目标方向不能为空")
    @Schema(description = "目标方向", example = "示例")
    private String goal;

}
