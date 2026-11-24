package cn.iocoder.yudao.module.system.controller.admin.qinghu.wallet.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 钱包管理创建/修改 Request VO")
@Data
public class QhWalletSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @NotBlank(message = "归属不能为空")
    @Schema(description = "归属", example = "示例")
    private String owner;

    @Schema(description = "余额", example = "示例")
    private BigDecimal balance;

    @Schema(description = "可提现金额", example = "示例")
    private BigDecimal withdrawable;

}
