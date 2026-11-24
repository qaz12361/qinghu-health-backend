package cn.iocoder.yudao.module.system.controller.admin.qinghu.coachservice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 教练服务包 Response VO")
@Data
public class QhCoachServiceRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "教练编号", example = "示例")
    private Long coachId;
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
    @Schema(description = "状态", example = "示例")
    private String status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
