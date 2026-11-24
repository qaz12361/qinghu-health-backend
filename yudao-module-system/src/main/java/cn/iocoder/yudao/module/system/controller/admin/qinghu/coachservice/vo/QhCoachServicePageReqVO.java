package cn.iocoder.yudao.module.system.controller.admin.qinghu.coachservice.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 教练服务包分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhCoachServicePageReqVO extends PageParam {

    @Schema(description = "服务标题", example = "示例")
    private String title;

    @Schema(description = "状态", example = "示例")
    private String status;

}
