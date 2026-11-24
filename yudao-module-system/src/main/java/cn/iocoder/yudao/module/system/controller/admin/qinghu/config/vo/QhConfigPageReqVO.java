package cn.iocoder.yudao.module.system.controller.admin.qinghu.config.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 平台配置分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhConfigPageReqVO extends PageParam {

    @Schema(description = "配置键", example = "示例")
    private String configKey;

}
