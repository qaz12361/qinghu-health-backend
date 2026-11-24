package cn.iocoder.yudao.module.system.dal.mysql.qinghu.healthrecord;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.healthrecord.vo.QhHealthRecordPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.healthrecord.QhHealthRecordDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhHealthRecordMapper extends BaseMapperX<QhHealthRecordDO> {

    default PageResult<QhHealthRecordDO> selectPage(QhHealthRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhHealthRecordDO>()
                .likeIfPresent(QhHealthRecordDO::getType, reqVO.getType())
                .likeIfPresent(QhHealthRecordDO::getNote, reqVO.getNote())
                .eqIfPresent(QhHealthRecordDO::getStudentId, reqVO.getStudentId())
                .orderByDesc(QhHealthRecordDO::getId));
    }

}
