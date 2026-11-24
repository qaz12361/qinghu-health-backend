package cn.iocoder.yudao.module.system.controller.admin.qinghu.student.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - 学生管理分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhStudentPageReqVO extends PageParam {

    @Schema(description = "姓名", example = "示例")
    private String name;

    @Schema(description = "学号", example = "示例")
    private String stuNo;

}
