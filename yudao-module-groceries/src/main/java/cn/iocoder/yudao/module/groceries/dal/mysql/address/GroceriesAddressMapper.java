package cn.iocoder.yudao.module.groceries.dal.mysql.address;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.groceries.dal.dataobject.address.GroceriesAddressDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 收货地址 Mapper
 */
@Mapper
public interface GroceriesAddressMapper extends BaseMapperX<GroceriesAddressDO> {

    /**
     * 查询某会员的地址列表，默认地址排在最前
     */
    default List<GroceriesAddressDO> selectListByMemberId(Integer memberId) {
        return selectList(new LambdaQueryWrapperX<GroceriesAddressDO>()
                .eq(GroceriesAddressDO::getMemberId, memberId)
                .orderByDesc(GroceriesAddressDO::getIsDefault)
                .orderByAsc(GroceriesAddressDO::getId));
    }

}
