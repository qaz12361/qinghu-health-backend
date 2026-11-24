package cn.iocoder.yudao.module.system.service.qinghu.plan;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.plan.vo.QhPlanPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.plan.vo.QhPlanSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.plan.QhPlanDO;

/**
 * 运动计划 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhPlanService {

    Long createQhPlan(QhPlanSaveReqVO createReqVO);

    void updateQhPlan(QhPlanSaveReqVO updateReqVO);

    void deleteQhPlan(Long id);

    QhPlanDO getQhPlan(Long id);

    PageResult<QhPlanDO> getQhPlanPage(QhPlanPageReqVO pageReqVO);

}
