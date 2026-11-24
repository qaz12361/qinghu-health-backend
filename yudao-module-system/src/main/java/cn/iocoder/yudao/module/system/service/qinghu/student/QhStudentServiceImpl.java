package cn.iocoder.yudao.module.system.service.qinghu.student;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.student.vo.QhStudentPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.student.vo.QhStudentSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.student.QhStudentDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.student.QhStudentMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 学生管理 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhStudentServiceImpl")
public class QhStudentServiceImpl implements QhStudentService {

    @Resource
    private QhStudentMapper qhStudentMapper;

    @Override
    public Long createQhStudent(QhStudentSaveReqVO createReqVO) {
        QhStudentDO qhStudent = BeanUtils.toBean(createReqVO, QhStudentDO.class);
        qhStudentMapper.insert(qhStudent);
        return qhStudent.getId();
    }

    @Override
    public void updateQhStudent(QhStudentSaveReqVO updateReqVO) {
        validateQhStudentExists(updateReqVO.getId());
        QhStudentDO updateObj = BeanUtils.toBean(updateReqVO, QhStudentDO.class);
        qhStudentMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhStudent(Long id) {
        validateQhStudentExists(id);
        qhStudentMapper.deleteById(id);
    }

    @Override
    public QhStudentDO getQhStudent(Long id) {
        return qhStudentMapper.selectById(id);
    }

    @Override
    public PageResult<QhStudentDO> getQhStudentPage(QhStudentPageReqVO pageReqVO) {
        return qhStudentMapper.selectPage(pageReqVO);
    }

    private void validateQhStudentExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhStudentMapper.selectById(id) == null) {
            throw new ServiceException(404, "学生管理不存在");
        }
    }

}
