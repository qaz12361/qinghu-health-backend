package cn.iocoder.yudao.module.groceries.dal.mysql.member;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.groceries.dal.dataobject.member.GroceriesMemberDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员 Mapper
 */
@Mapper
public interface GroceriesMemberMapper extends BaseMapperX<GroceriesMemberDO> {
}
