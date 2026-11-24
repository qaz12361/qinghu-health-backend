package cn.iocoder.yudao.module.system.service.qinghu.coach;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coach.vo.QhCoachPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coach.vo.QhCoachSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coach.QhCoachDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.coach.QhCoachMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 教练管理 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhCoachServiceImpl")
public class QhCoachServiceImpl implements QhCoachService {

    @Resource
    private QhCoachMapper qhCoachMapper;

    @Override
    public Long createQhCoach(QhCoachSaveReqVO createReqVO) {
        QhCoachDO qhCoach = BeanUtils.toBean(createReqVO, QhCoachDO.class);
        qhCoachMapper.insert(qhCoach);
        return qhCoach.getId();
    }

    @Override
    public void updateQhCoach(QhCoachSaveReqVO updateReqVO) {
        validateQhCoachExists(updateReqVO.getId());
        QhCoachDO updateObj = BeanUtils.toBean(updateReqVO, QhCoachDO.class);
        qhCoachMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhCoach(Long id) {
        validateQhCoachExists(id);
        qhCoachMapper.deleteById(id);
    }

    @Override
    public QhCoachDO getQhCoach(Long id) {
        return qhCoachMapper.selectById(id);
    }

    @Override
    public PageResult<QhCoachDO> getQhCoachPage(QhCoachPageReqVO pageReqVO) {
        return qhCoachMapper.selectPage(pageReqVO);
    }

    private void validateQhCoachExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhCoachMapper.selectById(id) == null) {
            throw new ServiceException(404, "教练管理不存在");
        }
    }

}
