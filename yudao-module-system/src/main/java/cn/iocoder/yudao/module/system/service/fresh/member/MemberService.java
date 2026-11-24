package cn.iocoder.yudao.module.system.service.fresh.member;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.fresh.member.vo.MemberPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.fresh.member.vo.MemberSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.fresh.member.MemberDO;

/**
 * 生鲜会员 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface MemberService {

    Long createMember(MemberSaveReqVO createReqVO);

    void updateMember(MemberSaveReqVO updateReqVO);

    void deleteMember(Long id);

    MemberDO getMember(Long id);

    PageResult<MemberDO> getMemberPage(MemberPageReqVO pageReqVO);

}
