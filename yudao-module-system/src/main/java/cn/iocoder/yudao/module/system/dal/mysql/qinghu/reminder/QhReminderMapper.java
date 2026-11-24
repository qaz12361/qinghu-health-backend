package cn.iocoder.yudao.module.system.dal.mysql.qinghu.reminder;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.reminder.vo.QhReminderPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.reminder.QhReminderDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhReminderMapper extends BaseMapperX<QhReminderDO> {

    default PageResult<QhReminderDO> selectPage(QhReminderPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhReminderDO>()
                .likeIfPresent(QhReminderDO::getTitle, reqVO.getTitle())
                .likeIfPresent(QhReminderDO::getType, reqVO.getType())
                .orderByDesc(QhReminderDO::getId));
    }

}
