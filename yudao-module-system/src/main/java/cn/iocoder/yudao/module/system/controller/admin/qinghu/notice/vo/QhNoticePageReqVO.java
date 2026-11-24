package cn.iocoder.yudao.module.system.controller.admin.qinghu.notice.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 公告管理分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhNoticePageReqVO extends PageParam {

    @Schema(description = "标题", example = "示例")
    private String title;

    @Schema(description = "发布人", example = "示例")
    private String publisher;

}
