package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.healthgoal;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 健康目标 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_health_goal")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhHealthGoalDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 目标名称
     */
    private String name;
    /**
     * 当前值
     */
    private BigDecimal currentValue;
    /**
     * 目标值
     */
    private BigDecimal targetValue;
    /**
     * 单位
     */
    private String unit;
    /**
     * 截止时间
     */
    private String deadline;
    /**
     * 状态
     */
    private String status;

}
