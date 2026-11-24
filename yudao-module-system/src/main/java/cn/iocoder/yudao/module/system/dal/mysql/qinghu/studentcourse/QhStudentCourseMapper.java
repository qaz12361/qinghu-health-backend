package cn.iocoder.yudao.module.system.dal.mysql.qinghu.studentcourse;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.studentcourse.vo.QhStudentCoursePageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.studentcourse.QhStudentCourseDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhStudentCourseMapper extends BaseMapperX<QhStudentCourseDO> {

    default PageResult<QhStudentCourseDO> selectPage(QhStudentCoursePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhStudentCourseDO>()
                // 无搜索条件
                .orderByDesc(QhStudentCourseDO::getId));
    }

}
