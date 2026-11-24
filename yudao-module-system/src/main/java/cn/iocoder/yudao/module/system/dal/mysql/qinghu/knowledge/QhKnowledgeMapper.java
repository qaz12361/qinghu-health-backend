package cn.iocoder.yudao.module.system.dal.mysql.qinghu.knowledge;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledge.vo.QhKnowledgePageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.knowledge.QhKnowledgeDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhKnowledgeMapper extends BaseMapperX<QhKnowledgeDO> {

    default PageResult<QhKnowledgeDO> selectPage(QhKnowledgePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhKnowledgeDO>()
                .likeIfPresent(QhKnowledgeDO::getTitle, reqVO.getTitle())
                .likeIfPresent(QhKnowledgeDO::getCat, reqVO.getCat())
                .orderByDesc(QhKnowledgeDO::getId));
    }

}
