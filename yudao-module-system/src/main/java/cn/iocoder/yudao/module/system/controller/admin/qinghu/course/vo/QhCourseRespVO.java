package cn.iocoder.yudao.module.system.controller.admin.qinghu.course.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 课程管理 Response VO")
@Data
public class QhCourseRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "课程标题", example = "示例")
    private String title;
    @Schema(description = "授课教练", example = "示例")
    private String coach;
    @Schema(description = "封面主题键", example = "示例")
    private String cover;
    @Schema(description = "价格", example = "示例")
    private BigDecimal price;
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
    @Schema(description = "状态", example = "示例")
    private String status;
    @Schema(description = "课程简介", example = "示例")
    private String description;
    @Schema(description = "审核结果", example = "示例")
    private String auditResult;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
