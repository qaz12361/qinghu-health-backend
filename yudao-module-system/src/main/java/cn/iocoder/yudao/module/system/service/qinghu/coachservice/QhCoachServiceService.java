package cn.iocoder.yudao.module.system.service.qinghu.coachservice;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachservice.vo.QhCoachServicePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachservice.vo.QhCoachServiceSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachservice.QhCoachServiceDO;

/**
 * 教练服务包 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhCoachServiceService {

    Long createQhCoachService(QhCoachServiceSaveReqVO createReqVO);

    void updateQhCoachService(QhCoachServiceSaveReqVO updateReqVO);

    void deleteQhCoachService(Long id);

    QhCoachServiceDO getQhCoachService(Long id);

    PageResult<QhCoachServiceDO> getQhCoachServicePage(QhCoachServicePageReqVO pageReqVO);

}
