package cn.iocoder.yudao.module.system.dal.mysql.qinghu.plan;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.plan.vo.QhPlanPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.plan.QhPlanDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhPlanMapper extends BaseMapperX<QhPlanDO> {

    default PageResult<QhPlanDO> selectPage(QhPlanPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhPlanDO>()
                .likeIfPresent(QhPlanDO::getStuName, reqVO.getStuName())
                .likeIfPresent(QhPlanDO::getTitle, reqVO.getTitle())
                .orderByDesc(QhPlanDO::getId));
    }

}
