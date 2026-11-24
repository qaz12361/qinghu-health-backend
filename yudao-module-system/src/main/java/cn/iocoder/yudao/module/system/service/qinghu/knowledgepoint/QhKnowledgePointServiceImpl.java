package cn.iocoder.yudao.module.system.service.qinghu.knowledgepoint;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledgepoint.vo.QhKnowledgePointPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledgepoint.vo.QhKnowledgePointSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.knowledgepoint.QhKnowledgePointDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.knowledgepoint.QhKnowledgePointMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 知识要点 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhKnowledgePointServiceImpl")
public class QhKnowledgePointServiceImpl implements QhKnowledgePointService {

    @Resource
    private QhKnowledgePointMapper qhKnowledgePointMapper;

    @Override
    public Long createQhKnowledgePoint(QhKnowledgePointSaveReqVO createReqVO) {
        QhKnowledgePointDO qhKnowledgePoint = BeanUtils.toBean(createReqVO, QhKnowledgePointDO.class);
        qhKnowledgePointMapper.insert(qhKnowledgePoint);
        return qhKnowledgePoint.getId();
    }

    @Override
    public void updateQhKnowledgePoint(QhKnowledgePointSaveReqVO updateReqVO) {
        validateQhKnowledgePointExists(updateReqVO.getId());
        QhKnowledgePointDO updateObj = BeanUtils.toBean(updateReqVO, QhKnowledgePointDO.class);
        qhKnowledgePointMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhKnowledgePoint(Long id) {
        validateQhKnowledgePointExists(id);
        qhKnowledgePointMapper.deleteById(id);
    }

    @Override
    public QhKnowledgePointDO getQhKnowledgePoint(Long id) {
        return qhKnowledgePointMapper.selectById(id);
    }

    @Override
    public PageResult<QhKnowledgePointDO> getQhKnowledgePointPage(QhKnowledgePointPageReqVO pageReqVO) {
        return qhKnowledgePointMapper.selectPage(pageReqVO);
    }

    private void validateQhKnowledgePointExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhKnowledgePointMapper.selectById(id) == null) {
            throw new ServiceException(404, "知识要点不存在");
        }
    }

}
