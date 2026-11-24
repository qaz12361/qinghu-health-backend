package cn.iocoder.yudao.module.system.service.qinghu.course;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.course.vo.QhCoursePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.course.vo.QhCourseSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.course.QhCourseDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.course.QhCourseMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 课程管理 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhCourseServiceImpl")
public class QhCourseServiceImpl implements QhCourseService {

    @Resource
    private QhCourseMapper qhCourseMapper;

    @Override
    public Long createQhCourse(QhCourseSaveReqVO createReqVO) {
        QhCourseDO qhCourse = BeanUtils.toBean(createReqVO, QhCourseDO.class);
        qhCourseMapper.insert(qhCourse);
        return qhCourse.getId();
    }

    @Override
    public void updateQhCourse(QhCourseSaveReqVO updateReqVO) {
        validateQhCourseExists(updateReqVO.getId());
        QhCourseDO updateObj = BeanUtils.toBean(updateReqVO, QhCourseDO.class);
        qhCourseMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhCourse(Long id) {
        validateQhCourseExists(id);
        qhCourseMapper.deleteById(id);
    }

    @Override
    public QhCourseDO getQhCourse(Long id) {
        return qhCourseMapper.selectById(id);
    }

    @Override
    public PageResult<QhCourseDO> getQhCoursePage(QhCoursePageReqVO pageReqVO) {
        return qhCourseMapper.selectPage(pageReqVO);
    }

    private void validateQhCourseExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhCourseMapper.selectById(id) == null) {
            throw new ServiceException(404, "课程管理不存在");
        }
    }

}
