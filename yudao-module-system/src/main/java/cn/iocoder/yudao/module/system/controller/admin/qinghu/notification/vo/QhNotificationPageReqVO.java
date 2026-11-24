package cn.iocoder.yudao.module.system.controller.admin.qinghu.notification.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 通知中心分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhNotificationPageReqVO extends PageParam {

    @Schema(description = "接收方", example = "示例")
    private String receiver;

    @Schema(description = "通知标题", example = "示例")
    private String title;

}
