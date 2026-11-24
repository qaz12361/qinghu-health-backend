package cn.iocoder.yudao.module.system.controller.admin.qinghu.profile.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 学生档案创建/修改 Request VO")
@Data
public class QhProfileSaveReqVO {

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

    @Schema(description = "学院", example = "示例")
    private String college;

    @Schema(description = "专业", example = "示例")
    private String major;

    @Schema(description = "手机号", example = "示例")
    private String phone;

    @Schema(description = "BMI", example = "示例")
    private BigDecimal bmi;

    @Schema(description = "身高 cm", example = "示例")
    private BigDecimal height;

    @Schema(description = "体重 kg", example = "示例")
    private BigDecimal weight;

    @Schema(description = "体脂率 %", example = "示例")
    private BigDecimal bodyFat;

    @Schema(description = "肌肉量 kg", example = "示例")
    private BigDecimal muscle;

    @Schema(description = "腰围 cm", example = "示例")
    private BigDecimal waist;

}
