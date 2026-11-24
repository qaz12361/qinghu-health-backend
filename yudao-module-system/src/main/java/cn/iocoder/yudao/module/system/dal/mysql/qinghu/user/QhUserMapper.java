package cn.iocoder.yudao.module.system.dal.mysql.qinghu.user;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.user.vo.QhUserPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.user.QhUserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhUserMapper extends BaseMapperX<QhUserDO> {

    default PageResult<QhUserDO> selectPage(QhUserPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhUserDO>()
                .likeIfPresent(QhUserDO::getName, reqVO.getName())
                .likeIfPresent(QhUserDO::getAccount, reqVO.getAccount())
                .orderByDesc(QhUserDO::getId));
    }

}
