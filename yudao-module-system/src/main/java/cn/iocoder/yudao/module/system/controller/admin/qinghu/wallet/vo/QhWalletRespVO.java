package cn.iocoder.yudao.module.system.controller.admin.qinghu.wallet.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 钱包管理 Response VO")
@Data
public class QhWalletRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "归属", example = "示例")
    private String owner;
    @Schema(description = "余额", example = "示例")
    private BigDecimal balance;
    @Schema(description = "可提现金额", example = "示例")
    private BigDecimal withdrawable;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
