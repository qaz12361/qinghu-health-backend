package cn.iocoder.yudao.module.system.service.qinghu.coachbooking;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachbooking.vo.QhCoachBookingPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachbooking.vo.QhCoachBookingSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachbooking.QhCoachBookingDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.coachbooking.QhCoachBookingMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 预约单 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhCoachBookingServiceImpl")
public class QhCoachBookingServiceImpl implements QhCoachBookingService {

    @Resource
    private QhCoachBookingMapper qhCoachBookingMapper;

    @Override
    public Long createQhCoachBooking(QhCoachBookingSaveReqVO createReqVO) {
        QhCoachBookingDO qhCoachBooking = BeanUtils.toBean(createReqVO, QhCoachBookingDO.class);
        qhCoachBookingMapper.insert(qhCoachBooking);
        return qhCoachBooking.getId();
    }

    @Override
    public void updateQhCoachBooking(QhCoachBookingSaveReqVO updateReqVO) {
        validateQhCoachBookingExists(updateReqVO.getId());
        QhCoachBookingDO updateObj = BeanUtils.toBean(updateReqVO, QhCoachBookingDO.class);
        qhCoachBookingMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhCoachBooking(Long id) {
        validateQhCoachBookingExists(id);
        qhCoachBookingMapper.deleteById(id);
    }

    @Override
    public QhCoachBookingDO getQhCoachBooking(Long id) {
        return qhCoachBookingMapper.selectById(id);
    }

    @Override
    public PageResult<QhCoachBookingDO> getQhCoachBookingPage(QhCoachBookingPageReqVO pageReqVO) {
        return qhCoachBookingMapper.selectPage(pageReqVO);
    }

    private void validateQhCoachBookingExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhCoachBookingMapper.selectById(id) == null) {
            throw new ServiceException(404, "预约单不存在");
        }
    }

}
