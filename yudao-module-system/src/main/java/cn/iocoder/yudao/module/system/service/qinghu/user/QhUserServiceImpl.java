package cn.iocoder.yudao.module.system.service.qinghu.user;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.user.vo.QhUserPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.user.vo.QhUserSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.user.QhUserDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.user.QhUserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 平台用户 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhUserServiceImpl")
public class QhUserServiceImpl implements QhUserService {

    @Resource
    private QhUserMapper qhUserMapper;

    @Override
    public Long createQhUser(QhUserSaveReqVO createReqVO) {
        QhUserDO qhUser = BeanUtils.toBean(createReqVO, QhUserDO.class);
        qhUserMapper.insert(qhUser);
        return qhUser.getId();
    }

    @Override
    public void updateQhUser(QhUserSaveReqVO updateReqVO) {
        validateQhUserExists(updateReqVO.getId());
        QhUserDO updateObj = BeanUtils.toBean(updateReqVO, QhUserDO.class);
        qhUserMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhUser(Long id) {
        validateQhUserExists(id);
        qhUserMapper.deleteById(id);
    }

    @Override
    public QhUserDO getQhUser(Long id) {
        return qhUserMapper.selectById(id);
    }

    @Override
    public PageResult<QhUserDO> getQhUserPage(QhUserPageReqVO pageReqVO) {
        return qhUserMapper.selectPage(pageReqVO);
    }

    private void validateQhUserExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhUserMapper.selectById(id) == null) {
            throw new ServiceException(404, "平台用户不存在");
        }
    }

}
