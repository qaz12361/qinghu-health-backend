package cn.iocoder.yudao.module.system.controller.admin.fresh.member.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 生鲜会员分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class MemberPageReqVO extends PageParam {

    @Schema(description = "会员姓名，模糊匹配", example = "王")
    private String name;

    @Schema(description = "手机号，模糊匹配", example = "138")
    private String phone;

    @Schema(description = "会员等级", example = "Lv.3")
    private String level;

}
