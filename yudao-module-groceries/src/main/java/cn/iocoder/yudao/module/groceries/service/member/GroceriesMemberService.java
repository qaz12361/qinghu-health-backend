package cn.iocoder.yudao.module.groceries.service.member;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.module.groceries.dal.dataobject.address.GroceriesAddressDO;
import cn.iocoder.yudao.module.groceries.dal.dataobject.member.GroceriesMemberDO;
import cn.iocoder.yudao.module.groceries.dal.mysql.address.GroceriesAddressMapper;
import cn.iocoder.yudao.module.groceries.dal.mysql.member.GroceriesMemberMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 生鲜商城 - 会员与地址 Service
 *
 * 当前为演示场景：前台固定使用 1 号会员（王小雨），不接入登录体系。
 */
@Service
public class GroceriesMemberService {

    @Resource
    private GroceriesMemberMapper groceriesMemberMapper;
    @Resource
    private GroceriesAddressMapper groceriesAddressMapper;

    /**
     * 获得会员，不存在时抛业务异常
     */
    public GroceriesMemberDO getMember(Integer id) {
        GroceriesMemberDO member = id == null ? null : groceriesMemberMapper.selectById(id);
        if (member == null) {
            throw new ServiceException(404, "会员不存在");
        }
        return member;
    }

    /**
     * 校验会员存在，供下单时使用
     */
    public void validateMemberExists(Integer id) {
        getMember(id);
    }

    /**
     * 查询会员的收货地址列表
     */
    public List<GroceriesAddressDO> getAddressList(Integer memberId) {
        return groceriesAddressMapper.selectListByMemberId(memberId);
    }

    /**
     * 获得默认收货地址，没有则返回第一条，仍没有则返回 null
     */
    public GroceriesAddressDO getDefaultAddress(Integer memberId) {
        List<GroceriesAddressDO> list = getAddressList(memberId);
        return list.isEmpty() ? null : list.get(0);
    }

}
