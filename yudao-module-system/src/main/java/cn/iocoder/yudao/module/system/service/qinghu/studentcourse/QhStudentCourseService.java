package cn.iocoder.yudao.module.system.service.qinghu.studentcourse;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.studentcourse.vo.QhStudentCoursePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.studentcourse.vo.QhStudentCourseSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.studentcourse.QhStudentCourseDO;

/**
 * 已购课程 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhStudentCourseService {

    Long createQhStudentCourse(QhStudentCourseSaveReqVO createReqVO);

    void updateQhStudentCourse(QhStudentCourseSaveReqVO updateReqVO);

    void deleteQhStudentCourse(Long id);

    QhStudentCourseDO getQhStudentCourse(Long id);

    PageResult<QhStudentCourseDO> getQhStudentCoursePage(QhStudentCoursePageReqVO pageReqVO);

}
