package cn.iocoder.yudao.module.system.service.qinghu.coachplan;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachplan.vo.QhCoachPlanPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachplan.vo.QhCoachPlanSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachplan.QhCoachPlanDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.coachplan.QhCoachPlanMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 教练计划 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhCoachPlanServiceImpl")
public class QhCoachPlanServiceImpl implements QhCoachPlanService {

    @Resource
    private QhCoachPlanMapper qhCoachPlanMapper;

    @Override
    public Long createQhCoachPlan(QhCoachPlanSaveReqVO createReqVO) {
        QhCoachPlanDO qhCoachPlan = BeanUtils.toBean(createReqVO, QhCoachPlanDO.class);
        qhCoachPlanMapper.insert(qhCoachPlan);
        return qhCoachPlan.getId();
    }

    @Override
    public void updateQhCoachPlan(QhCoachPlanSaveReqVO updateReqVO) {
        validateQhCoachPlanExists(updateReqVO.getId());
        QhCoachPlanDO updateObj = BeanUtils.toBean(updateReqVO, QhCoachPlanDO.class);
        qhCoachPlanMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhCoachPlan(Long id) {
        validateQhCoachPlanExists(id);
        qhCoachPlanMapper.deleteById(id);
    }

    @Override
    public QhCoachPlanDO getQhCoachPlan(Long id) {
        return qhCoachPlanMapper.selectById(id);
    }

    @Override
    public PageResult<QhCoachPlanDO> getQhCoachPlanPage(QhCoachPlanPageReqVO pageReqVO) {
        return qhCoachPlanMapper.selectPage(pageReqVO);
    }

    private void validateQhCoachPlanExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhCoachPlanMapper.selectById(id) == null) {
            throw new ServiceException(404, "教练计划不存在");
        }
    }

}
