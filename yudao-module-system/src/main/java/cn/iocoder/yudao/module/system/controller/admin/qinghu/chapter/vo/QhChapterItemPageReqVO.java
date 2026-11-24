package cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 循证指南建议条目分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhChapterItemPageReqVO extends PageParam {

    @Schema(description = "所属章节ID", example = "1")
    private Long chapterId;

    @Schema(description = "建议标题", example = "示例")
    private String title;

}
