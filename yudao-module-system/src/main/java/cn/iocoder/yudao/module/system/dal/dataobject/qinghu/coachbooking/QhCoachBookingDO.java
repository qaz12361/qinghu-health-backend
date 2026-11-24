package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachbooking;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 预约单 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_coach_booking")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhCoachBookingDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 预约单号
     */
    private String bookingNo;
    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 学生编号
     */
    private Long stuId;
    /**
     * 教练编号
     */
    private Long coachId;
    /**
     * 教练姓名
     */
    private String coachName;
    /**
     * 目标
     */
    private String goal;
    /**
     * 目标详情
     */
    private String goalDetail;
    /**
     * 服务包编号
     */
    private Long serviceId;
    /**
     * 服务包标题
     */
    private String serviceTitle;
    /**
     * 总次数
     */
    private Integer sessions;
    /**
     * 已完成次数
     */
    private Integer doneSessions;
    /**
     * 金额
     */
    private BigDecimal price;
    /**
     * 报价金额
     */
    private BigDecimal quotePrice;
    /**
     * 状态
     */
    private String status;
    /**
     * 预约创建日期
     */
    private LocalDate bookingDate;
    /**
     * 开始日期
     */
    private LocalDate startDate;
    /**
     * 最近一次上课日期
     */
    private LocalDate lastSessionDate;
    /**
     * 下次上课日期
     */
    private LocalDate nextSessionDate;
    /**
     * 线下已上次数
     */
    private Integer offline;
    /**
     * 支付状态
     */
    private String payment;
    /**
     * 是否接受报价
     */
    private Boolean quoteAccepted;
    /**
     * 关联计划编号
     */
    private Long planId;

}
