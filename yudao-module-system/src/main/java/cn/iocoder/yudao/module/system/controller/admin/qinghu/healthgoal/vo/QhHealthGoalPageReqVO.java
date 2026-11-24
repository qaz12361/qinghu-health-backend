package cn.iocoder.yudao.module.system.controller.admin.qinghu.healthgoal.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 健康目标分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhHealthGoalPageReqVO extends PageParam {

    @Schema(description = "目标名称", example = "示例")
    private String name;

    @Schema(description = "状态", example = "示例")
    private String status;

}
