package cn.iocoder.yudao.module.system.controller.admin.qinghu.notice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Schema(description = "管理后台 - 公告管理创建/修改 Request VO")
@Data
public class QhNoticeSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @NotBlank(message = "标题不能为空")
    @Schema(description = "标题", example = "示例")
    private String title;

    @NotBlank(message = "发布人不能为空")
    @Schema(description = "发布人", example = "示例")
    private String publisher;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "发布日期", example = "示例")
    private LocalDate publishTime;

    @Schema(description = "是否置顶", example = "示例")
    private Boolean isTop;

    @NotBlank(message = "状态不能为空")
    @Schema(description = "状态", example = "示例")
    private String status;

    @Schema(description = "正文", example = "示例")
    private String content;

}
