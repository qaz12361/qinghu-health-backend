package cn.iocoder.yudao.module.system.controller.admin.qinghu.notice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 公告管理 Response VO")
@Data
public class QhNoticeRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "标题", example = "示例")
    private String title;
    @Schema(description = "发布人", example = "示例")
    private String publisher;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "发布日期", example = "示例")
    private LocalDate publishTime;
    @Schema(description = "是否置顶", example = "示例")
    private Boolean isTop;
    @Schema(description = "状态", example = "示例")
    private String status;
    @Schema(description = "正文", example = "示例")
    private String content;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
