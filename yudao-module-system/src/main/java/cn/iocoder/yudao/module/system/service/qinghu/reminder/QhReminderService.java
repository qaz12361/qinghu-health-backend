package cn.iocoder.yudao.module.system.service.qinghu.reminder;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.reminder.vo.QhReminderPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.reminder.vo.QhReminderSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.reminder.QhReminderDO;

/**
 * 健康提醒 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhReminderService {

    Long createQhReminder(QhReminderSaveReqVO createReqVO);

    void updateQhReminder(QhReminderSaveReqVO updateReqVO);

    void deleteQhReminder(Long id);

    QhReminderDO getQhReminder(Long id);

    PageResult<QhReminderDO> getQhReminderPage(QhReminderPageReqVO pageReqVO);

}
