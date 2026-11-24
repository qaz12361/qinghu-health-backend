package cn.iocoder.yudao.module.system.controller.admin.qinghu.course.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 课程管理分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhCoursePageReqVO extends PageParam {

    @Schema(description = "课程标题", example = "示例")
    private String title;

    @Schema(description = "授课教练", example = "示例")
    private String coach;

}
