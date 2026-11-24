package cn.iocoder.yudao.module.system.service.qinghu.profile;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.profile.vo.QhProfilePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.profile.vo.QhProfileSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.profile.QhProfileDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.profile.QhProfileMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 学生档案 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhProfileServiceImpl")
public class QhProfileServiceImpl implements QhProfileService {

    @Resource
    private QhProfileMapper qhProfileMapper;

    @Override
    public Long createQhProfile(QhProfileSaveReqVO createReqVO) {
        QhProfileDO qhProfile = BeanUtils.toBean(createReqVO, QhProfileDO.class);
        qhProfileMapper.insert(qhProfile);
        return qhProfile.getId();
    }

    @Override
    public void updateQhProfile(QhProfileSaveReqVO updateReqVO) {
        validateQhProfileExists(updateReqVO.getId());
        QhProfileDO updateObj = BeanUtils.toBean(updateReqVO, QhProfileDO.class);
        qhProfileMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhProfile(Long id) {
        validateQhProfileExists(id);
        qhProfileMapper.deleteById(id);
    }

    @Override
    public QhProfileDO getQhProfile(Long id) {
        return qhProfileMapper.selectById(id);
    }

    @Override
    public PageResult<QhProfileDO> getQhProfilePage(QhProfilePageReqVO pageReqVO) {
        return qhProfileMapper.selectPage(pageReqVO);
    }

    private void validateQhProfileExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhProfileMapper.selectById(id) == null) {
            throw new ServiceException(404, "学生档案不存在");
        }
    }

}
