package cn.iocoder.yudao.module.system.service.qinghu.user;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.user.vo.QhUserPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.user.vo.QhUserSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.user.QhUserDO;

/**
 * 平台用户 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhUserService {

    Long createQhUser(QhUserSaveReqVO createReqVO);

    void updateQhUser(QhUserSaveReqVO updateReqVO);

    void deleteQhUser(Long id);

    QhUserDO getQhUser(Long id);

    PageResult<QhUserDO> getQhUserPage(QhUserPageReqVO pageReqVO);

}
