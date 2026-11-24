package cn.iocoder.yudao.module.system.dal.mysql.qinghu.student;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.student.vo.QhStudentPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.student.QhStudentDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhStudentMapper extends BaseMapperX<QhStudentDO> {

    default PageResult<QhStudentDO> selectPage(QhStudentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhStudentDO>()
                .likeIfPresent(QhStudentDO::getName, reqVO.getName())
                .likeIfPresent(QhStudentDO::getStuNo, reqVO.getStuNo())
                .orderByDesc(QhStudentDO::getId));
    }

}
