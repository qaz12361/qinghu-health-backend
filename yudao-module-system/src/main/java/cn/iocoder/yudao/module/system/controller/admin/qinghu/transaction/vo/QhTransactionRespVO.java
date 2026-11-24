package cn.iocoder.yudao.module.system.controller.admin.qinghu.transaction.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 交易流水 Response VO")
@Data
public class QhTransactionRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "流水号", example = "示例")
    private String txNo;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "交易日期", example = "示例")
    private LocalDate txTime;
    @Schema(description = "类型", example = "示例")
    private String type;
    @Schema(description = "归属", example = "示例")
    private String role;
    @Schema(description = "金额", example = "示例")
    private BigDecimal amount;
    @Schema(description = "说明", example = "示例")
    private String description;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
