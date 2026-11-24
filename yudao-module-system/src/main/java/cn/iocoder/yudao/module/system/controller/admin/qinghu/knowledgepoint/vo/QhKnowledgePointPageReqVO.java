package cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledgepoint.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 知识要点分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhKnowledgePointPageReqVO extends PageParam {

    @Schema(description = "要点标题", example = "示例")
    private String point;

}
