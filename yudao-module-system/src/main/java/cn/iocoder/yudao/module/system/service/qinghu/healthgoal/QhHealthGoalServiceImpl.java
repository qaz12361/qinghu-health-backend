package cn.iocoder.yudao.module.system.service.qinghu.healthgoal;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.healthgoal.vo.QhHealthGoalPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.healthgoal.vo.QhHealthGoalSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.healthgoal.QhHealthGoalDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.healthgoal.QhHealthGoalMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 健康目标 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhHealthGoalServiceImpl")
public class QhHealthGoalServiceImpl implements QhHealthGoalService {

    @Resource
    private QhHealthGoalMapper qhHealthGoalMapper;

    @Override
    public Long createQhHealthGoal(QhHealthGoalSaveReqVO createReqVO) {
        QhHealthGoalDO qhHealthGoal = BeanUtils.toBean(createReqVO, QhHealthGoalDO.class);
        qhHealthGoalMapper.insert(qhHealthGoal);
        return qhHealthGoal.getId();
    }

    @Override
    public void updateQhHealthGoal(QhHealthGoalSaveReqVO updateReqVO) {
        validateQhHealthGoalExists(updateReqVO.getId());
        QhHealthGoalDO updateObj = BeanUtils.toBean(updateReqVO, QhHealthGoalDO.class);
        qhHealthGoalMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhHealthGoal(Long id) {
        validateQhHealthGoalExists(id);
        qhHealthGoalMapper.deleteById(id);
    }

    @Override
    public QhHealthGoalDO getQhHealthGoal(Long id) {
        return qhHealthGoalMapper.selectById(id);
    }

    @Override
    public PageResult<QhHealthGoalDO> getQhHealthGoalPage(QhHealthGoalPageReqVO pageReqVO) {
        return qhHealthGoalMapper.selectPage(pageReqVO);
    }

    private void validateQhHealthGoalExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhHealthGoalMapper.selectById(id) == null) {
            throw new ServiceException(404, "健康目标不存在");
        }
    }

}
