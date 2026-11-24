package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.reminder;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;



/**
 * 健康提醒 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_reminder")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhReminderDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 提醒标题
     */
    private String title;
    /**
     * 提醒时间 HH:mm
     */
    private String remindTime;
    /**
     * 提醒类型
     */
    private String type;
    /**
     * 是否启用
     */
    private Boolean enabled;

}
