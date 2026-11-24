package cn.iocoder.yudao.module.system.dal.mysql.qinghu.notice;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.notice.vo.QhNoticePageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.notice.QhNoticeDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhNoticeMapper extends BaseMapperX<QhNoticeDO> {

    default PageResult<QhNoticeDO> selectPage(QhNoticePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhNoticeDO>()
                .likeIfPresent(QhNoticeDO::getTitle, reqVO.getTitle())
                .likeIfPresent(QhNoticeDO::getPublisher, reqVO.getPublisher())
                .orderByDesc(QhNoticeDO::getId));
    }

}
