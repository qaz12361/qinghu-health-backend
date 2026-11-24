package cn.iocoder.yudao.module.system.dal.mysql.fresh.category;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.fresh.category.FreshCategoryDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FreshCategoryMapper extends BaseMapperX<FreshCategoryDO> {

    /**
     * 查询全部有效分类（按 id 排序）
     */
    default List<FreshCategoryDO> selectSimpleList() {
        return selectList(new LambdaQueryWrapperX<FreshCategoryDO>()
                .orderByAsc(FreshCategoryDO::getId));
    }

    /**
     * 按 id 查询分类
     */
    default FreshCategoryDO selectByIdStr(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return selectById(id);
    }

}
