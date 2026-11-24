package cn.iocoder.yudao.module.groceries.dal.mysql.cart;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.groceries.dal.dataobject.cart.GroceriesCartDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 购物车 Mapper
 */
@Mapper
public interface GroceriesCartMapper extends BaseMapperX<GroceriesCartDO> {

    /**
     * 查询某会员的购物车，按加入时间倒序
     */
    default List<GroceriesCartDO> selectListByMemberId(Integer memberId) {
        return selectList(new LambdaQueryWrapperX<GroceriesCartDO>()
                .eq(GroceriesCartDO::getMemberId, memberId)
                .orderByDesc(GroceriesCartDO::getId));
    }

    /**
     * 查询某会员指定商品的购物车项
     */
    default GroceriesCartDO selectByMemberIdAndProductId(Integer memberId, Integer productId) {
        return selectOne(new LambdaQueryWrapperX<GroceriesCartDO>()
                .eq(GroceriesCartDO::getMemberId, memberId)
                .eq(GroceriesCartDO::getProductId, productId));
    }

    /**
     * 查询某会员指定商品的购物车项（忽略逻辑删除标记）
     *
     * <p>购物车表存在唯一索引 (member_id, product_id)，历史上被逻辑删除的行仍占用该索引，
     * 因此新增前需要连已删除的行使一起查出来，做「复活」处理，避免唯一键冲突。
     */
    @Select("SELECT * FROM cart WHERE member_id = #{memberId} AND product_id = #{productId} LIMIT 1")
    GroceriesCartDO selectAnyByMemberIdAndProductId(@Param("memberId") Integer memberId,
                                                    @Param("productId") Integer productId);

    /**
     * 复活一条被逻辑删除的购物车记录，并覆盖数量
     */
    @Update("UPDATE cart SET quantity = #{quantity}, deleted = 0, update_time = NOW() "
            + "WHERE id = #{id}")
    int reviveById(@Param("id") Integer id, @Param("quantity") Integer quantity);

    /**
     * 物理删除某会员的指定商品（购物车是临时数据，不留逻辑删除垃圾，避免唯一键冲突）
     */
    @Delete("DELETE FROM cart WHERE member_id = #{memberId} AND product_id = #{productId}")
    int physicalDeleteByMemberIdAndProductId(@Param("memberId") Integer memberId,
                                             @Param("productId") Integer productId);

    /**
     * 物理清空某会员的购物车
     */
    @Delete("DELETE FROM cart WHERE member_id = #{memberId}")
    int physicalDeleteByMemberId(@Param("memberId") Integer memberId);

}
