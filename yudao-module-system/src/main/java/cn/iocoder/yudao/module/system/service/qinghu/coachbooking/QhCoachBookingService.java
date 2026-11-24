package cn.iocoder.yudao.module.system.service.qinghu.coachbooking;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachbooking.vo.QhCoachBookingPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachbooking.vo.QhCoachBookingSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachbooking.QhCoachBookingDO;

/**
 * 预约单 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhCoachBookingService {

    Long createQhCoachBooking(QhCoachBookingSaveReqVO createReqVO);

    void updateQhCoachBooking(QhCoachBookingSaveReqVO updateReqVO);

    void deleteQhCoachBooking(Long id);

    QhCoachBookingDO getQhCoachBooking(Long id);

    PageResult<QhCoachBookingDO> getQhCoachBookingPage(QhCoachBookingPageReqVO pageReqVO);

}
