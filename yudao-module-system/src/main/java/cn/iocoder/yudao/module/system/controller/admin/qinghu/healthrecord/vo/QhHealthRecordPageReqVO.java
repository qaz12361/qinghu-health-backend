package cn.iocoder.yudao.module.system.controller.admin.qinghu.healthrecord.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 健康记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhHealthRecordPageReqVO extends PageParam {

    @Schema(description = "指标类型", example = "示例")
    private String type;

    @Schema(description = "备注", example = "示例")
    private String note;

    @Schema(description = "所属学生ID", example = "1")
    private Long studentId;

}
