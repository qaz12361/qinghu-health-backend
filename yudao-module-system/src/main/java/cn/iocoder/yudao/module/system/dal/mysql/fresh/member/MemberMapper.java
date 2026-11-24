package cn.iocoder.yudao.module.system.dal.mysql.fresh.member;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.fresh.member.vo.MemberPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.fresh.member.MemberDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper extends BaseMapperX<MemberDO> {

    default PageResult<MemberDO> selectPage(MemberPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MemberDO>()
                .likeIfPresent(MemberDO::getName, reqVO.getName())
                .likeIfPresent(MemberDO::getPhone, reqVO.getPhone())
                .eqIfPresent(MemberDO::getLevel, reqVO.getLevel())
                .orderByDesc(MemberDO::getId));
    }

}
