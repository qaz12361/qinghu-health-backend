package cn.iocoder.yudao.module.system.controller.admin.qinghu.healthrecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 健康记录 Response VO")
@Data
public class QhHealthRecordRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "记录日期", example = "示例")
    private LocalDate recordDate;
    @Schema(description = "指标类型", example = "示例")
    private String type;
    @Schema(description = "指标值", example = "示例")
    private String value;
    @Schema(description = "单位", example = "示例")
    private String unit;
    @Schema(description = "备注", example = "示例")
    private String note;

    @Schema(description = "所属学生ID", example = "1")
    private Long studentId;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
