package cn.iocoder.yudao.module.system.service.fresh.member;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.fresh.member.vo.MemberPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.fresh.member.vo.MemberSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.fresh.member.MemberDO;
import cn.iocoder.yudao.module.system.dal.mysql.fresh.member.MemberMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 生鲜会员 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("freshMemberServiceImpl")
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Override
    public Long createMember(MemberSaveReqVO createReqVO) {
        MemberDO member = BeanUtils.toBean(createReqVO, MemberDO.class);
        memberMapper.insert(member);
        return member.getId();
    }

    @Override
    public void updateMember(MemberSaveReqVO updateReqVO) {
        validateMemberExists(updateReqVO.getId());
        MemberDO updateObj = BeanUtils.toBean(updateReqVO, MemberDO.class);
        memberMapper.updateById(updateObj);
    }

    @Override
    public void deleteMember(Long id) {
        validateMemberExists(id);
        memberMapper.deleteById(id);
    }

    @Override
    public MemberDO getMember(Long id) {
        return memberMapper.selectById(id);
    }

    @Override
    public PageResult<MemberDO> getMemberPage(MemberPageReqVO pageReqVO) {
        return memberMapper.selectPage(pageReqVO);
    }

    private void validateMemberExists(Long id) {
        if (id == null) {
            return;
        }
        if (memberMapper.selectById(id) == null) {
            throw new ServiceException(404, "会员不存在");
        }
    }

}
