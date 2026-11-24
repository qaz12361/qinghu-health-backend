package cn.iocoder.yudao.module.groceries.dal.mysql.product;

import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.groceries.dal.dataobject.product.GroceriesProductDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 生鲜商品 Mapper
 */
@Mapper
public interface GroceriesProductMapper extends BaseMapperX<GroceriesProductDO> {

    /**
     * 按分类与关键字查询商品列表
     *
     * @param catId   分类编号，传空表示全部
     * @param keyword 关键字，匹配商品名或产地，传空表示不过滤
     */
    default List<GroceriesProductDO> selectListByCondition(String catId, String keyword) {
        return selectList(new LambdaQueryWrapperX<GroceriesProductDO>()
                .eqIfPresent(GroceriesProductDO::getCatId, catId)
                .and(keyword != null && !keyword.isBlank(),
                        wrapper -> wrapper.like(GroceriesProductDO::getName, keyword)
                                .or().like(GroceriesProductDO::getOrigin, keyword))
                .orderByDesc(GroceriesProductDO::getTag)
                .orderByAsc(GroceriesProductDO::getId));
    }

}
