package cn.iocoder.yudao.module.system.service.qinghu.course;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.course.vo.QhCoursePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.course.vo.QhCourseSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.course.QhCourseDO;

/**
 * 课程管理 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhCourseService {

    Long createQhCourse(QhCourseSaveReqVO createReqVO);

    void updateQhCourse(QhCourseSaveReqVO updateReqVO);

    void deleteQhCourse(Long id);

    QhCourseDO getQhCourse(Long id);

    PageResult<QhCourseDO> getQhCoursePage(QhCoursePageReqVO pageReqVO);

}
