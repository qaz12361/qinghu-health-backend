package cn.iocoder.yudao.module.system.service.qinghu.notification;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.notification.vo.QhNotificationPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.notification.vo.QhNotificationSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.notification.QhNotificationDO;

/**
 * 通知中心 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhNotificationService {

    Long createQhNotification(QhNotificationSaveReqVO createReqVO);

    void updateQhNotification(QhNotificationSaveReqVO updateReqVO);

    void deleteQhNotification(Long id);

    QhNotificationDO getQhNotification(Long id);

    PageResult<QhNotificationDO> getQhNotificationPage(QhNotificationPageReqVO pageReqVO);

}
