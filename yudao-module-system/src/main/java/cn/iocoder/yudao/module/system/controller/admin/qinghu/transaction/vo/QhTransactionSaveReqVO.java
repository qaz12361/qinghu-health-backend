package cn.iocoder.yudao.module.system.controller.admin.qinghu.transaction.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "管理后台 - 交易流水创建/修改 Request VO")
@Data
public class QhTransactionSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @NotBlank(message = "流水号不能为空")
    @Schema(description = "流水号", example = "示例")
    private String txNo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "交易日期", example = "示例")
    private LocalDate txTime;

    @NotBlank(message = "类型不能为空")
    @Schema(description = "类型", example = "示例")
    private String type;

    @NotBlank(message = "归属不能为空")
    @Schema(description = "归属", example = "示例")
    private String role;

    @Schema(description = "金额", example = "示例")
    private BigDecimal amount;

    @Schema(description = "说明", example = "示例")
    private String description;

}
