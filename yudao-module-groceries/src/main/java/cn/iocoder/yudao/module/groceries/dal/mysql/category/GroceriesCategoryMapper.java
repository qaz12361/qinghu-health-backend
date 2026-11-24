package cn.iocoder.yudao.module.groceries.dal.mysql.category;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.groceries.dal.dataobject.category.GroceriesCategoryDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品分类 Mapper
 */
@Mapper
public interface GroceriesCategoryMapper extends BaseMapperX<GroceriesCategoryDO> {
}
