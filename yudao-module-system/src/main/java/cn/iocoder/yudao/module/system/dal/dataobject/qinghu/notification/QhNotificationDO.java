package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.notification;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 通知中心 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_notification")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhNotificationDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 接收方
     */
    private String receiver;
    /**
     * 通知类型
     */
    private String type;
    /**
     * 通知标题
     */
    private String title;
    /**
     * 通知内容
     */
    private String description;
    /**
     * 是否已读
     */
    private Boolean isRead;
    /**
     * 通知时间
     */
    private LocalDateTime notifyTime;

}
