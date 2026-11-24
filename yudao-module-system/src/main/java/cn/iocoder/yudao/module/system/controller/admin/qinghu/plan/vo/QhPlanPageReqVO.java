package cn.iocoder.yudao.module.system.controller.admin.qinghu.plan.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 运动计划分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhPlanPageReqVO extends PageParam {

    @Schema(description = "学生姓名", example = "示例")
    private String stuName;

    @Schema(description = "计划标题", example = "示例")
    private String title;

}
