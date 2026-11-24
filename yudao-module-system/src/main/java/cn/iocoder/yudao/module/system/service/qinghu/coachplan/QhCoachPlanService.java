package cn.iocoder.yudao.module.system.service.qinghu.coachplan;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachplan.vo.QhCoachPlanPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachplan.vo.QhCoachPlanSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachplan.QhCoachPlanDO;

/**
 * 教练计划 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhCoachPlanService {

    Long createQhCoachPlan(QhCoachPlanSaveReqVO createReqVO);

    void updateQhCoachPlan(QhCoachPlanSaveReqVO updateReqVO);

    void deleteQhCoachPlan(Long id);

    QhCoachPlanDO getQhCoachPlan(Long id);

    PageResult<QhCoachPlanDO> getQhCoachPlanPage(QhCoachPlanPageReqVO pageReqVO);

}
