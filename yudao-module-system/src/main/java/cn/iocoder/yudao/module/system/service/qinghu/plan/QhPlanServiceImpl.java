package cn.iocoder.yudao.module.system.service.qinghu.plan;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.plan.vo.QhPlanPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.plan.vo.QhPlanSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.plan.QhPlanDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.plan.QhPlanMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 运动计划 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhPlanServiceImpl")
public class QhPlanServiceImpl implements QhPlanService {

    @Resource
    private QhPlanMapper qhPlanMapper;

    @Override
    public Long createQhPlan(QhPlanSaveReqVO createReqVO) {
        QhPlanDO qhPlan = BeanUtils.toBean(createReqVO, QhPlanDO.class);
        qhPlanMapper.insert(qhPlan);
        return qhPlan.getId();
    }

    @Override
    public void updateQhPlan(QhPlanSaveReqVO updateReqVO) {
        validateQhPlanExists(updateReqVO.getId());
        QhPlanDO updateObj = BeanUtils.toBean(updateReqVO, QhPlanDO.class);
        qhPlanMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhPlan(Long id) {
        validateQhPlanExists(id);
        qhPlanMapper.deleteById(id);
    }

    @Override
    public QhPlanDO getQhPlan(Long id) {
        return qhPlanMapper.selectById(id);
    }

    @Override
    public PageResult<QhPlanDO> getQhPlanPage(QhPlanPageReqVO pageReqVO) {
        return qhPlanMapper.selectPage(pageReqVO);
    }

    private void validateQhPlanExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhPlanMapper.selectById(id) == null) {
            throw new ServiceException(404, "运动计划不存在");
        }
    }

}
