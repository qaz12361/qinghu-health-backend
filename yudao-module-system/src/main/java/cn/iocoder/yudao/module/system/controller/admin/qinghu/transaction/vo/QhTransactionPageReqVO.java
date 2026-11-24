package cn.iocoder.yudao.module.system.controller.admin.qinghu.transaction.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 交易流水分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhTransactionPageReqVO extends PageParam {

    @Schema(description = "流水号", example = "示例")
    private String txNo;

    @Schema(description = "类型", example = "示例")
    private String type;

}
