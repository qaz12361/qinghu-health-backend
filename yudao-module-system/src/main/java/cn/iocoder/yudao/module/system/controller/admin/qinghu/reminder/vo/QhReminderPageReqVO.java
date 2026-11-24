package cn.iocoder.yudao.module.system.controller.admin.qinghu.reminder.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 健康提醒分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhReminderPageReqVO extends PageParam {

    @Schema(description = "提醒标题", example = "示例")
    private String title;

    @Schema(description = "提醒类型", example = "示例")
    private String type;

}
