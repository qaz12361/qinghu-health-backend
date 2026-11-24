package cn.iocoder.yudao.module.system.dal.mysql.qinghu.profile;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.profile.vo.QhProfilePageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.profile.QhProfileDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhProfileMapper extends BaseMapperX<QhProfileDO> {

    default PageResult<QhProfileDO> selectPage(QhProfilePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhProfileDO>()
                .likeIfPresent(QhProfileDO::getName, reqVO.getName())
                .likeIfPresent(QhProfileDO::getStuNo, reqVO.getStuNo())
                .orderByDesc(QhProfileDO::getId));
    }

}
