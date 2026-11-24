package cn.iocoder.yudao.module.system.service.qinghu.coach;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coach.vo.QhCoachPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coach.vo.QhCoachSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coach.QhCoachDO;

/**
 * 教练管理 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhCoachService {

    Long createQhCoach(QhCoachSaveReqVO createReqVO);

    void updateQhCoach(QhCoachSaveReqVO updateReqVO);

    void deleteQhCoach(Long id);

    QhCoachDO getQhCoach(Long id);

    PageResult<QhCoachDO> getQhCoachPage(QhCoachPageReqVO pageReqVO);

}
