package cn.iocoder.yudao.module.system.dal.mysql.qinghu.config;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.config.vo.QhConfigPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.config.QhConfigDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhConfigMapper extends BaseMapperX<QhConfigDO> {

    default PageResult<QhConfigDO> selectPage(QhConfigPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhConfigDO>()
                .likeIfPresent(QhConfigDO::getConfigKey, reqVO.getConfigKey())
                .orderByDesc(QhConfigDO::getId));
    }

}
