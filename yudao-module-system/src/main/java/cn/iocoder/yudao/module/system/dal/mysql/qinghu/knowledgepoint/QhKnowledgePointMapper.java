package cn.iocoder.yudao.module.system.dal.mysql.qinghu.knowledgepoint;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledgepoint.vo.QhKnowledgePointPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.knowledgepoint.QhKnowledgePointDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhKnowledgePointMapper extends BaseMapperX<QhKnowledgePointDO> {

    default PageResult<QhKnowledgePointDO> selectPage(QhKnowledgePointPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhKnowledgePointDO>()
                .likeIfPresent(QhKnowledgePointDO::getPoint, reqVO.getPoint())
                .orderByDesc(QhKnowledgePointDO::getId));
    }

}
