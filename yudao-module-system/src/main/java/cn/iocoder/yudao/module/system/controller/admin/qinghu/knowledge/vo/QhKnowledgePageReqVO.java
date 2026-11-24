package cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledge.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 健康知识分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhKnowledgePageReqVO extends PageParam {

    @Schema(description = "标题", example = "示例")
    private String title;

    @Schema(description = "分类", example = "示例")
    private String cat;

}
