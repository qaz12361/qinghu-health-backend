package cn.iocoder.yudao.module.system.service.qinghu.healthgoal;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.healthgoal.vo.QhHealthGoalPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.healthgoal.vo.QhHealthGoalSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.healthgoal.QhHealthGoalDO;

/**
 * 健康目标 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhHealthGoalService {

    Long createQhHealthGoal(QhHealthGoalSaveReqVO createReqVO);

    void updateQhHealthGoal(QhHealthGoalSaveReqVO updateReqVO);

    void deleteQhHealthGoal(Long id);

    QhHealthGoalDO getQhHealthGoal(Long id);

    PageResult<QhHealthGoalDO> getQhHealthGoalPage(QhHealthGoalPageReqVO pageReqVO);

}
