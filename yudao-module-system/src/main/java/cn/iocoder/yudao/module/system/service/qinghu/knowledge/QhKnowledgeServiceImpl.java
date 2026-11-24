package cn.iocoder.yudao.module.system.service.qinghu.knowledge;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledge.vo.QhKnowledgePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledge.vo.QhKnowledgeSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.knowledge.QhKnowledgeDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.knowledge.QhKnowledgeMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 健康知识 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhKnowledgeServiceImpl")
public class QhKnowledgeServiceImpl implements QhKnowledgeService {

    @Resource
    private QhKnowledgeMapper qhKnowledgeMapper;

    @Override
    public Long createQhKnowledge(QhKnowledgeSaveReqVO createReqVO) {
        QhKnowledgeDO qhKnowledge = BeanUtils.toBean(createReqVO, QhKnowledgeDO.class);
        qhKnowledgeMapper.insert(qhKnowledge);
        return qhKnowledge.getId();
    }

    @Override
    public void updateQhKnowledge(QhKnowledgeSaveReqVO updateReqVO) {
        validateQhKnowledgeExists(updateReqVO.getId());
        QhKnowledgeDO updateObj = BeanUtils.toBean(updateReqVO, QhKnowledgeDO.class);
        qhKnowledgeMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhKnowledge(Long id) {
        validateQhKnowledgeExists(id);
        qhKnowledgeMapper.deleteById(id);
    }

    @Override
    public QhKnowledgeDO getQhKnowledge(Long id) {
        return qhKnowledgeMapper.selectById(id);
    }

    @Override
    public PageResult<QhKnowledgeDO> getQhKnowledgePage(QhKnowledgePageReqVO pageReqVO) {
        return qhKnowledgeMapper.selectPage(pageReqVO);
    }

    private void validateQhKnowledgeExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhKnowledgeMapper.selectById(id) == null) {
            throw new ServiceException(404, "健康知识不存在");
        }
    }

}
