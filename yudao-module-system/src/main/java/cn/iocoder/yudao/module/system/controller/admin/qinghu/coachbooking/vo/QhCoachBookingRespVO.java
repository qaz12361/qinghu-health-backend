package cn.iocoder.yudao.module.system.controller.admin.qinghu.coachbooking.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 预约单 Response VO")
@Data
public class QhCoachBookingRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "预约单号", example = "示例")
    private String bookingNo;
    @Schema(description = "学生姓名", example = "示例")
    private String stuName;
    @Schema(description = "学生编号", example = "示例")
    private Long stuId;
    @Schema(description = "教练编号", example = "示例")
    private Long coachId;
    @Schema(description = "教练姓名", example = "示例")
    private String coachName;
    @Schema(description = "目标", example = "示例")
    private String goal;
    @Schema(description = "目标详情", example = "示例")
    private String goalDetail;
    @Schema(description = "服务包编号", example = "示例")
    private Long serviceId;
    @Schema(description = "服务包标题", example = "示例")
    private String serviceTitle;
    @Schema(description = "总次数", example = "示例")
    private Integer sessions;
    @Schema(description = "已完成次数", example = "示例")
    private Integer doneSessions;
    @Schema(description = "金额", example = "示例")
    private BigDecimal price;
    @Schema(description = "报价金额", example = "示例")
    private BigDecimal quotePrice;
    @Schema(description = "状态", example = "示例")
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "预约创建日期", example = "示例")
    private LocalDate bookingDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "开始日期", example = "示例")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "最近一次上课日期", example = "示例")
    private LocalDate lastSessionDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "下次上课日期", example = "示例")
    private LocalDate nextSessionDate;
    @Schema(description = "线下已上次数", example = "示例")
    private Integer offline;
    @Schema(description = "支付状态", example = "示例")
    private String payment;
    @Schema(description = "是否接受报价", example = "示例")
    private Boolean quoteAccepted;
    @Schema(description = "关联计划编号", example = "示例")
    private Long planId;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
