package cn.iocoder.yudao.module.system.controller.admin.qinghu.profile.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 学生档案 Response VO")
@Data
public class QhProfileRespVO {

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

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
