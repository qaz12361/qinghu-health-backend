package cn.iocoder.yudao.module.system.controller.admin.qinghu.coach.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 教练管理分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhCoachPageReqVO extends PageParam {

    @Schema(description = "姓名", example = "示例")
    private String name;

    @Schema(description = "登录账号", example = "示例")
    private String account;

}
