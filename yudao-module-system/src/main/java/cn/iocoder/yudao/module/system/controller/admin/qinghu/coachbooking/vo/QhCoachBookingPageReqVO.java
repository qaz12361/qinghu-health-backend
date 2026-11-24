package cn.iocoder.yudao.module.system.controller.admin.qinghu.coachbooking.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 预约单分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhCoachBookingPageReqVO extends PageParam {

    @Schema(description = "预约单号", example = "示例")
    private String bookingNo;

    @Schema(description = "学生姓名", example = "示例")
    private String stuName;

}
