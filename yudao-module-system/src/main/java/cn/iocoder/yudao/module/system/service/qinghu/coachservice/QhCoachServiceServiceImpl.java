package cn.iocoder.yudao.module.system.service.qinghu.coachservice;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachservice.vo.QhCoachServicePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachservice.vo.QhCoachServiceSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachservice.QhCoachServiceDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.coachservice.QhCoachServiceMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 教练服务包 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhCoachServiceServiceImpl")
public class QhCoachServiceServiceImpl implements QhCoachServiceService {

    @Resource
    private QhCoachServiceMapper qhCoachServiceMapper;

    @Override
    public Long createQhCoachService(QhCoachServiceSaveReqVO createReqVO) {
        QhCoachServiceDO qhCoachService = BeanUtils.toBean(createReqVO, QhCoachServiceDO.class);
        qhCoachServiceMapper.insert(qhCoachService);
        return qhCoachService.getId();
    }

    @Override
    public void updateQhCoachService(QhCoachServiceSaveReqVO updateReqVO) {
        validateQhCoachServiceExists(updateReqVO.getId());
        QhCoachServiceDO updateObj = BeanUtils.toBean(updateReqVO, QhCoachServiceDO.class);
        qhCoachServiceMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhCoachService(Long id) {
        validateQhCoachServiceExists(id);
        qhCoachServiceMapper.deleteById(id);
    }

    @Override
    public QhCoachServiceDO getQhCoachService(Long id) {
        return qhCoachServiceMapper.selectById(id);
    }

    @Override
    public PageResult<QhCoachServiceDO> getQhCoachServicePage(QhCoachServicePageReqVO pageReqVO) {
        return qhCoachServiceMapper.selectPage(pageReqVO);
    }

    private void validateQhCoachServiceExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhCoachServiceMapper.selectById(id) == null) {
            throw new ServiceException(404, "教练服务包不存在");
        }
    }

}
