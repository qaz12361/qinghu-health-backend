package cn.iocoder.yudao.module.system.dal.mysql.qinghu.coach;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coach.vo.QhCoachPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coach.QhCoachDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhCoachMapper extends BaseMapperX<QhCoachDO> {

    default PageResult<QhCoachDO> selectPage(QhCoachPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhCoachDO>()
                .likeIfPresent(QhCoachDO::getName, reqVO.getName())
                .likeIfPresent(QhCoachDO::getAccount, reqVO.getAccount())
                .orderByDesc(QhCoachDO::getId));
    }

}
