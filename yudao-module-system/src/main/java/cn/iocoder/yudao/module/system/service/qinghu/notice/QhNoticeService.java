package cn.iocoder.yudao.module.system.service.qinghu.notice;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.notice.vo.QhNoticePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.notice.vo.QhNoticeSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.notice.QhNoticeDO;

/**
 * 公告管理 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhNoticeService {

    Long createQhNotice(QhNoticeSaveReqVO createReqVO);

    void updateQhNotice(QhNoticeSaveReqVO updateReqVO);

    void deleteQhNotice(Long id);

    QhNoticeDO getQhNotice(Long id);

    PageResult<QhNoticeDO> getQhNoticePage(QhNoticePageReqVO pageReqVO);

}
