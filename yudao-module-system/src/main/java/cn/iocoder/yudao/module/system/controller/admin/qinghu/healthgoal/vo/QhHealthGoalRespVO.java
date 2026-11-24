package cn.iocoder.yudao.module.system.controller.admin.qinghu.healthgoal.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 健康目标 Response VO")
@Data
public class QhHealthGoalRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "目标名称", example = "示例")
    private String name;
    @Schema(description = "当前值", example = "示例")
    private BigDecimal currentValue;
    @Schema(description = "目标值", example = "示例")
    private BigDecimal targetValue;
    @Schema(description = "单位", example = "示例")
    private String unit;
    @Schema(description = "截止时间", example = "示例")
    private String deadline;
    @Schema(description = "状态", example = "示例")
    private String status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
