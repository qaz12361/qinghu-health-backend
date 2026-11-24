package cn.iocoder.yudao.module.system.controller.admin.qinghu.healthgoal.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 健康目标创建/修改 Request VO")
@Data
public class QhHealthGoalSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @NotBlank(message = "目标名称不能为空")
    @Schema(description = "目标名称", example = "示例")
    private String name;

    @Schema(description = "当前值", example = "示例")
    private BigDecimal currentValue;

    @Schema(description = "目标值", example = "示例")
    private BigDecimal targetValue;

    @NotBlank(message = "单位不能为空")
    @Schema(description = "单位", example = "示例")
    private String unit;

    @NotBlank(message = "截止时间不能为空")
    @Schema(description = "截止时间", example = "示例")
    private String deadline;

    @NotBlank(message = "状态不能为空")
    @Schema(description = "状态", example = "示例")
    private String status;

}
