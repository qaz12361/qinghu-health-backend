package cn.iocoder.yudao.module.system.controller.admin.qinghu.coachservice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 教练服务包创建/修改 Request VO")
@Data
public class QhCoachServiceSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @NotNull(message = "教练编号不能为空")
    @Schema(description = "教练编号", example = "示例")
    private Long coachId;

    @NotBlank(message = "服务标题不能为空")
    @Schema(description = "服务标题", example = "示例")
    private String title;

    @Schema(description = "课时数", example = "示例")
    private Integer sessions;

    @Schema(description = "单次时长 分钟", example = "示例")
    private Integer sessionMin;

    @Schema(description = "总价", example = "示例")
    private BigDecimal price;

    @Schema(description = "单价", example = "示例")
    private BigDecimal unitPrice;

    @Schema(description = "包含内容", example = "示例")
    private String includes;

    @Schema(description = "适合人群", example = "示例")
    private String suitable;

    @NotBlank(message = "状态不能为空")
    @Schema(description = "状态", example = "示例")
    private String status;

}
