package cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 循证指南章节分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhChapterPageReqVO extends PageParam {

    @Schema(description = "章节标题", example = "示例")
    private String title;

}
