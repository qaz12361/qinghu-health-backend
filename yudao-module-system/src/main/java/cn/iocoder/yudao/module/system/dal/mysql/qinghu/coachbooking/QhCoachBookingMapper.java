package cn.iocoder.yudao.module.system.dal.mysql.qinghu.coachbooking;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachbooking.vo.QhCoachBookingPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachbooking.QhCoachBookingDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhCoachBookingMapper extends BaseMapperX<QhCoachBookingDO> {

    default PageResult<QhCoachBookingDO> selectPage(QhCoachBookingPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhCoachBookingDO>()
                .likeIfPresent(QhCoachBookingDO::getBookingNo, reqVO.getBookingNo())
                .likeIfPresent(QhCoachBookingDO::getStuName, reqVO.getStuName())
                .orderByDesc(QhCoachBookingDO::getId));
    }

}
