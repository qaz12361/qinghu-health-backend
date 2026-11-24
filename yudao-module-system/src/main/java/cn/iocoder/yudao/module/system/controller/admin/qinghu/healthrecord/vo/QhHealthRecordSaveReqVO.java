package cn.iocoder.yudao.module.system.controller.admin.qinghu.healthrecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Schema(description = "管理后台 - 健康记录创建/修改 Request VO")
@Data
public class QhHealthRecordSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "记录日期不能为空")
    @Schema(description = "记录日期", example = "示例")
    private LocalDate recordDate;

    @NotBlank(message = "指标类型不能为空")
    @Schema(description = "指标类型", example = "示例")
    private String type;

    @NotBlank(message = "指标值不能为空")
    @Schema(description = "指标值", example = "示例")
    private String value;

    @NotBlank(message = "单位不能为空")
    @Schema(description = "单位", example = "示例")
    private String unit;

    @Schema(description = "备注", example = "示例")
    private String note;

    @Schema(description = "所属学生ID", example = "1")
    private Long studentId;

}
