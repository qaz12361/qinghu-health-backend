package cn.iocoder.yudao.module.system.dal.mysql.qinghu.coachplan;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachplan.vo.QhCoachPlanPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachplan.QhCoachPlanDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhCoachPlanMapper extends BaseMapperX<QhCoachPlanDO> {

    default PageResult<QhCoachPlanDO> selectPage(QhCoachPlanPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhCoachPlanDO>()
                .likeIfPresent(QhCoachPlanDO::getTitle, reqVO.getTitle())
                .likeIfPresent(QhCoachPlanDO::getStuName, reqVO.getStuName())
                .orderByDesc(QhCoachPlanDO::getId));
    }

}
