package cn.iocoder.yudao.module.system.service.qinghu.studentcourse;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.studentcourse.vo.QhStudentCoursePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.studentcourse.vo.QhStudentCourseSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.studentcourse.QhStudentCourseDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.studentcourse.QhStudentCourseMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 已购课程 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhStudentCourseServiceImpl")
public class QhStudentCourseServiceImpl implements QhStudentCourseService {

    @Resource
    private QhStudentCourseMapper qhStudentCourseMapper;

    @Override
    public Long createQhStudentCourse(QhStudentCourseSaveReqVO createReqVO) {
        QhStudentCourseDO qhStudentCourse = BeanUtils.toBean(createReqVO, QhStudentCourseDO.class);
        qhStudentCourseMapper.insert(qhStudentCourse);
        return qhStudentCourse.getId();
    }

    @Override
    public void updateQhStudentCourse(QhStudentCourseSaveReqVO updateReqVO) {
        validateQhStudentCourseExists(updateReqVO.getId());
        QhStudentCourseDO updateObj = BeanUtils.toBean(updateReqVO, QhStudentCourseDO.class);
        qhStudentCourseMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhStudentCourse(Long id) {
        validateQhStudentCourseExists(id);
        qhStudentCourseMapper.deleteById(id);
    }

    @Override
    public QhStudentCourseDO getQhStudentCourse(Long id) {
        return qhStudentCourseMapper.selectById(id);
    }

    @Override
    public PageResult<QhStudentCourseDO> getQhStudentCoursePage(QhStudentCoursePageReqVO pageReqVO) {
        return qhStudentCourseMapper.selectPage(pageReqVO);
    }

    private void validateQhStudentCourseExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhStudentCourseMapper.selectById(id) == null) {
            throw new ServiceException(404, "已购课程不存在");
        }
    }

}
