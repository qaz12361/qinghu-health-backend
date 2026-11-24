package cn.iocoder.yudao.module.system.service.qinghu.student;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.student.vo.QhStudentPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.student.vo.QhStudentSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.student.QhStudentDO;

/**
 * 学生管理 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhStudentService {

    Long createQhStudent(QhStudentSaveReqVO createReqVO);

    void updateQhStudent(QhStudentSaveReqVO updateReqVO);

    void deleteQhStudent(Long id);

    QhStudentDO getQhStudent(Long id);

    PageResult<QhStudentDO> getQhStudentPage(QhStudentPageReqVO pageReqVO);

}
