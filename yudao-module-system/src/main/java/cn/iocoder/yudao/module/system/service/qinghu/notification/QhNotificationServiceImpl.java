package cn.iocoder.yudao.module.system.service.qinghu.notification;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.notification.vo.QhNotificationPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.notification.vo.QhNotificationSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.notification.QhNotificationDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.notification.QhNotificationMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 通知中心 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhNotificationServiceImpl")
public class QhNotificationServiceImpl implements QhNotificationService {

    @Resource
    private QhNotificationMapper qhNotificationMapper;

    @Override
    public Long createQhNotification(QhNotificationSaveReqVO createReqVO) {
        QhNotificationDO qhNotification = BeanUtils.toBean(createReqVO, QhNotificationDO.class);
        qhNotificationMapper.insert(qhNotification);
        return qhNotification.getId();
    }

    @Override
    public void updateQhNotification(QhNotificationSaveReqVO updateReqVO) {
        validateQhNotificationExists(updateReqVO.getId());
        QhNotificationDO updateObj = BeanUtils.toBean(updateReqVO, QhNotificationDO.class);
        qhNotificationMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhNotification(Long id) {
        validateQhNotificationExists(id);
        qhNotificationMapper.deleteById(id);
    }

    @Override
    public QhNotificationDO getQhNotification(Long id) {
        return qhNotificationMapper.selectById(id);
    }

    @Override
    public PageResult<QhNotificationDO> getQhNotificationPage(QhNotificationPageReqVO pageReqVO) {
        return qhNotificationMapper.selectPage(pageReqVO);
    }

    private void validateQhNotificationExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhNotificationMapper.selectById(id) == null) {
            throw new ServiceException(404, "通知中心不存在");
        }
    }

}
