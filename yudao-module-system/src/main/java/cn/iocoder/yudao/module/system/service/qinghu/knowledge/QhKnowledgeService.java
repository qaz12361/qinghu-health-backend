package cn.iocoder.yudao.module.system.service.qinghu.knowledge;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledge.vo.QhKnowledgePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledge.vo.QhKnowledgeSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.knowledge.QhKnowledgeDO;

/**
 * 健康知识 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhKnowledgeService {

    Long createQhKnowledge(QhKnowledgeSaveReqVO createReqVO);

    void updateQhKnowledge(QhKnowledgeSaveReqVO updateReqVO);

    void deleteQhKnowledge(Long id);

    QhKnowledgeDO getQhKnowledge(Long id);

    PageResult<QhKnowledgeDO> getQhKnowledgePage(QhKnowledgePageReqVO pageReqVO);

}
