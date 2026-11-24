package cn.iocoder.yudao.module.system.service.qinghu.profile;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.profile.vo.QhProfilePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.profile.vo.QhProfileSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.profile.QhProfileDO;

/**
 * 学生档案 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhProfileService {

    Long createQhProfile(QhProfileSaveReqVO createReqVO);

    void updateQhProfile(QhProfileSaveReqVO updateReqVO);

    void deleteQhProfile(Long id);

    QhProfileDO getQhProfile(Long id);

    PageResult<QhProfileDO> getQhProfilePage(QhProfilePageReqVO pageReqVO);

}
