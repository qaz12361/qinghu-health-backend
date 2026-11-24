package cn.iocoder.yudao.module.system.controller.admin.qinghu.course.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 课程管理创建/修改 Request VO")
@Data
public class QhCourseSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @NotBlank(message = "课程标题不能为空")
    @Schema(description = "课程标题", example = "示例")
    private String title;

    @NotBlank(message = "授课教练不能为空")
    @Schema(description = "授课教练", example = "示例")
    private String coach;

    @NotBlank(message = "封面主题键不能为空")
    @Schema(description = "封面主题键", example = "示例")
    private String cover;

    @Schema(description = "价格", example = "示例")
    private BigDecimal price;

    @NotBlank(message = "分类不能为空")
    @Schema(description = "分类", example = "示例")
    private String category;

    @Schema(description = "课时数", example = "示例")
    private Integer lessons;

    @Schema(description = "销量", example = "示例")
    private Integer sales;

    @Schema(description = "是否免费", example = "示例")
    private Boolean isFree;

    @Schema(description = "评分", example = "示例")
    private BigDecimal rating;

    @NotBlank(message = "状态不能为空")
    @Schema(description = "状态", example = "示例")
    private String status;

    @Schema(description = "课程简介", example = "示例")
    private String description;

    @Schema(description = "审核结果", example = "示例")
    private String auditResult;

}
