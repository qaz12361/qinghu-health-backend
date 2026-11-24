package cn.iocoder.yudao.module.system.dal.mysql.qinghu.healthgoal;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.healthgoal.vo.QhHealthGoalPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.healthgoal.QhHealthGoalDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhHealthGoalMapper extends BaseMapperX<QhHealthGoalDO> {

    default PageResult<QhHealthGoalDO> selectPage(QhHealthGoalPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhHealthGoalDO>()
                .likeIfPresent(QhHealthGoalDO::getName, reqVO.getName())
                .likeIfPresent(QhHealthGoalDO::getStatus, reqVO.getStatus())
                .orderByDesc(QhHealthGoalDO::getId));
    }

}
