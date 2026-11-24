package cn.iocoder.yudao.module.system.controller.admin.qinghu.coach.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 教练管理 Response VO")
@Data
public class QhCoachRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
    @Schema(description = "姓名", example = "示例")
    private String name;
    @Schema(description = "登录账号", example = "示例")
    private String account;
    @Schema(description = "头像路径", example = "示例")
    private String photo;
    @Schema(description = "头像定位", example = "示例")
    private String photoPos;
    @Schema(description = "性别", example = "示例")
    private String gender;
    @Schema(description = "年龄", example = "示例")
    private Integer age;
    @Schema(description = "资质证书", example = "示例")
    private String cert;
    @Schema(description = "专长", example = "示例")
    private String specialty;
    @Schema(description = "标签", example = "示例")
    private String tags;
    @Schema(description = "从业年限", example = "示例")
    private Integer years;
    @Schema(description = "学员数", example = "示例")
    private Integer studentCount;
    @Schema(description = "评分", example = "示例")
    private BigDecimal rating;
    @Schema(description = "接单数", example = "示例")
    private Integer orderCount;
    @Schema(description = "起价", example = "示例")
    private BigDecimal priceFrom;
    @Schema(description = "简介", example = "示例")
    private String intro;
    @Schema(description = "入驻审核状态", example = "示例")
    private String applyStatus;
    @Schema(description = "审核通过时间", example = "示例")
    private String approveTime;
    @Schema(description = "状态", example = "示例")
    private String status;
    @Schema(description = "是否在线", example = "示例")
    private Boolean online;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
