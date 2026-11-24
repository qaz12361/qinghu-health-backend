package cn.iocoder.yudao.module.system.service.fresh.product;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.fresh.product.vo.ProductCategorySimpleRespVO;
import cn.iocoder.yudao.module.system.controller.admin.fresh.product.vo.ProductPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.fresh.product.vo.ProductSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.fresh.product.ProductDO;

import java.util.List;

/**
 * 生鲜商品 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface ProductService {

    /**
     * 创建商品
     */
    Long createProduct(ProductSaveReqVO createReqVO);

    /**
     * 更新商品
     */
    void updateProduct(ProductSaveReqVO updateReqVO);

    /**
     * 删除商品
     */
    void deleteProduct(Long id);

    /**
     * 获得商品
     */
    ProductDO getProduct(Long id);

    /**
     * 获得商品分页
     */
    PageResult<ProductDO> getProductPage(ProductPageReqVO pageReqVO);

    /**
     * 获得分类精简列表（用于新增商品下拉框）
     */
    List<ProductCategorySimpleRespVO> getCategorySimpleList();

}
