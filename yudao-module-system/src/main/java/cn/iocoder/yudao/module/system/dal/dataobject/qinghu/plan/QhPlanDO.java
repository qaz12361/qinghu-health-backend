package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.plan;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * 运动计划 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_plan")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhPlanDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 计划标题
     */
    private String title;
    /**
     * 计划内容
     */
    private String content;
    /**
     * 开始日期
     */
    private LocalDate startDate;
    /**
     * 结束日期
     */
    private LocalDate endDate;
    /**
     * 状态
     */
    private String status;
    /**
     * 教练反馈
     */
    private String feedback;

}
