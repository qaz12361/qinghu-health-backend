package cn.iocoder.yudao.module.system.dal.mysql.qinghu.waterlog;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.waterlog.vo.QhWaterLogPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.waterlog.QhWaterLogDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhWaterLogMapper extends BaseMapperX<QhWaterLogDO> {

    default PageResult<QhWaterLogDO> selectPage(QhWaterLogPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhWaterLogDO>()
                // 无搜索条件
                .orderByDesc(QhWaterLogDO::getId));
    }

}
