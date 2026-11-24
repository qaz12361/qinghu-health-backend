package cn.iocoder.yudao.module.system.service.qinghu.notice;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.notice.vo.QhNoticePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.notice.vo.QhNoticeSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.notice.QhNoticeDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.notice.QhNoticeMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 公告管理 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhNoticeServiceImpl")
public class QhNoticeServiceImpl implements QhNoticeService {

    @Resource
    private QhNoticeMapper qhNoticeMapper;

    @Override
    public Long createQhNotice(QhNoticeSaveReqVO createReqVO) {
        QhNoticeDO qhNotice = BeanUtils.toBean(createReqVO, QhNoticeDO.class);
        qhNoticeMapper.insert(qhNotice);
        return qhNotice.getId();
    }

    @Override
    public void updateQhNotice(QhNoticeSaveReqVO updateReqVO) {
        validateQhNoticeExists(updateReqVO.getId());
        QhNoticeDO updateObj = BeanUtils.toBean(updateReqVO, QhNoticeDO.class);
        qhNoticeMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhNotice(Long id) {
        validateQhNoticeExists(id);
        qhNoticeMapper.deleteById(id);
    }

    @Override
    public QhNoticeDO getQhNotice(Long id) {
        return qhNoticeMapper.selectById(id);
    }

    @Override
    public PageResult<QhNoticeDO> getQhNoticePage(QhNoticePageReqVO pageReqVO) {
        return qhNoticeMapper.selectPage(pageReqVO);
    }

    private void validateQhNoticeExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhNoticeMapper.selectById(id) == null) {
            throw new ServiceException(404, "公告管理不存在");
        }
    }

}
