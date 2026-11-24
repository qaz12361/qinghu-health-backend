package cn.iocoder.yudao.module.system.controller.admin.qinghu.waterlog.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Schema(description = "管理后台 - 饮水打卡创建/修改 Request VO")
@Data
public class QhWaterLogSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "打卡日期不能为空")
    @Schema(description = "打卡日期", example = "示例")
    private LocalDate logDate;

    @Schema(description = "饮水量 ml", example = "示例")
    private Integer amount;

}
