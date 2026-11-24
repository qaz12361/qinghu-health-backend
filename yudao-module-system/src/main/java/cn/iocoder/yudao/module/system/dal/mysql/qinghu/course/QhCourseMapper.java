package cn.iocoder.yudao.module.system.dal.mysql.qinghu.course;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.course.vo.QhCoursePageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.course.QhCourseDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhCourseMapper extends BaseMapperX<QhCourseDO> {

    default PageResult<QhCourseDO> selectPage(QhCoursePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhCourseDO>()
                .likeIfPresent(QhCourseDO::getTitle, reqVO.getTitle())
                .likeIfPresent(QhCourseDO::getCoach, reqVO.getCoach())
                .orderByDesc(QhCourseDO::getId));
    }

}
