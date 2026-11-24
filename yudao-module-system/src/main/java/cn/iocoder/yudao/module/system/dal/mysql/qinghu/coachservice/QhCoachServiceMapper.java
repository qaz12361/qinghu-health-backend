package cn.iocoder.yudao.module.system.dal.mysql.qinghu.coachservice;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachservice.vo.QhCoachServicePageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachservice.QhCoachServiceDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhCoachServiceMapper extends BaseMapperX<QhCoachServiceDO> {

    default PageResult<QhCoachServiceDO> selectPage(QhCoachServicePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhCoachServiceDO>()
                .likeIfPresent(QhCoachServiceDO::getTitle, reqVO.getTitle())
                .likeIfPresent(QhCoachServiceDO::getStatus, reqVO.getStatus())
                .orderByDesc(QhCoachServiceDO::getId));
    }

}
