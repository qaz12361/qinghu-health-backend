package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachplan;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * 教练计划 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_coach_plan")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhCoachPlanDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 关联预约单号
     */
    private String bookingNo;
    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 教练姓名
     */
    private String coachName;
    /**
     * 计划标题
     */
    private String title;
    /**
     * 周期
     */
    private String period;
    /**
     * 阶段目标
     */
    private String goal;
    /**
     * 计划内容
     */
    private String content;
    /**
     * 负荷等级
     */
    private String loadLevel;
    /**
     * 休息建议
     */
    private String restAdvice;
    /**
     * 检查节点
     */
    private String checkPoint;
    /**
     * 状态
     */
    private String status;
    /**
     * 制定日期
     */
    private LocalDate planDate;
    /**
     * 更新日期
     */
    private LocalDate planUpdateDate;
    /**
     * 教练反馈
     */
    private String feedback;

}
