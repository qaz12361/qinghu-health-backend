package cn.iocoder.yudao.module.system.controller.admin.qinghu.coach.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 教练管理创建/修改 Request VO")
@Data
public class QhCoachSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @NotBlank(message = "姓名不能为空")
    @Schema(description = "姓名", example = "示例")
    private String name;

    @NotBlank(message = "登录账号不能为空")
    @Schema(description = "登录账号", example = "示例")
    private String account;

    @Schema(description = "头像路径", example = "示例")
    private String photo;

    @Schema(description = "头像定位", example = "示例")
    private String photoPos;

    @NotBlank(message = "性别不能为空")
    @Schema(description = "性别", example = "示例")
    private String gender;

    @Schema(description = "年龄", example = "示例")
    private Integer age;

    @Schema(description = "资质证书", example = "示例")
    private String cert;

    @NotBlank(message = "专长不能为空")
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

    @NotBlank(message = "入驻审核状态不能为空")
    @Schema(description = "入驻审核状态", example = "示例")
    private String applyStatus;

    @Schema(description = "审核通过时间", example = "示例")
    private String approveTime;

    @NotBlank(message = "状态不能为空")
    @Schema(description = "状态", example = "示例")
    private String status;

    @Schema(description = "是否在线", example = "示例")
    private Boolean online;

}
