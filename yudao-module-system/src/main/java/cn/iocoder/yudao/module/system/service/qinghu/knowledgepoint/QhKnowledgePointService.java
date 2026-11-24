package cn.iocoder.yudao.module.system.service.qinghu.knowledgepoint;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledgepoint.vo.QhKnowledgePointPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledgepoint.vo.QhKnowledgePointSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.knowledgepoint.QhKnowledgePointDO;

/**
 * 知识要点 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhKnowledgePointService {

    Long createQhKnowledgePoint(QhKnowledgePointSaveReqVO createReqVO);

    void updateQhKnowledgePoint(QhKnowledgePointSaveReqVO updateReqVO);

    void deleteQhKnowledgePoint(Long id);

    QhKnowledgePointDO getQhKnowledgePoint(Long id);

    PageResult<QhKnowledgePointDO> getQhKnowledgePointPage(QhKnowledgePointPageReqVO pageReqVO);

}
