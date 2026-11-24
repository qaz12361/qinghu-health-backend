package cn.iocoder.yudao.module.system.dal.mysql.qinghu.notification;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.notification.vo.QhNotificationPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.notification.QhNotificationDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhNotificationMapper extends BaseMapperX<QhNotificationDO> {

    default PageResult<QhNotificationDO> selectPage(QhNotificationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhNotificationDO>()
                .likeIfPresent(QhNotificationDO::getTitle, reqVO.getTitle())
                .likeIfPresent(QhNotificationDO::getReceiver, reqVO.getReceiver())
                .orderByDesc(QhNotificationDO::getId));
    }

}
