package cn.iocoder.yudao.module.system.service.qinghu.reminder;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.reminder.vo.QhReminderPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.reminder.vo.QhReminderSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.reminder.QhReminderDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.reminder.QhReminderMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 健康提醒 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhReminderServiceImpl")
public class QhReminderServiceImpl implements QhReminderService {

    @Resource
    private QhReminderMapper qhReminderMapper;

    @Override
    public Long createQhReminder(QhReminderSaveReqVO createReqVO) {
        QhReminderDO qhReminder = BeanUtils.toBean(createReqVO, QhReminderDO.class);
        qhReminderMapper.insert(qhReminder);
        return qhReminder.getId();
    }

    @Override
    public void updateQhReminder(QhReminderSaveReqVO updateReqVO) {
        validateQhReminderExists(updateReqVO.getId());
        QhReminderDO updateObj = BeanUtils.toBean(updateReqVO, QhReminderDO.class);
        qhReminderMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhReminder(Long id) {
        validateQhReminderExists(id);
        qhReminderMapper.deleteById(id);
    }

    @Override
    public QhReminderDO getQhReminder(Long id) {
        return qhReminderMapper.selectById(id);
    }

    @Override
    public PageResult<QhReminderDO> getQhReminderPage(QhReminderPageReqVO pageReqVO) {
        return qhReminderMapper.selectPage(pageReqVO);
    }

    private void validateQhReminderExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhReminderMapper.selectById(id) == null) {
            throw new ServiceException(404, "健康提醒不存在");
        }
    }

}
