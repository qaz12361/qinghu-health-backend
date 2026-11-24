package cn.iocoder.yudao.module.system.service.fresh.product;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import java.util.List;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.fresh.product.vo.ProductCategorySimpleRespVO;
import cn.iocoder.yudao.module.system.controller.admin.fresh.product.vo.ProductPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.fresh.product.vo.ProductSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.fresh.category.FreshCategoryDO;
import cn.iocoder.yudao.module.system.dal.dataobject.fresh.product.ProductDO;
import cn.iocoder.yudao.module.system.dal.mysql.fresh.category.FreshCategoryMapper;
import cn.iocoder.yudao.module.system.dal.mysql.fresh.product.ProductMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 生鲜商品 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private FreshCategoryMapper freshCategoryMapper;

    @Override
    public Long createProduct(ProductSaveReqVO createReqVO) {
        validateCategory(createReqVO.getCatId());
        ProductDO product = BeanUtils.toBean(createReqVO, ProductDO.class);
        productMapper.insert(product);
        return product.getId();
    }

    @Override
    public void updateProduct(ProductSaveReqVO updateReqVO) {
        validateProductExists(updateReqVO.getId());
        validateCategory(updateReqVO.getCatId());
        ProductDO updateObj = BeanUtils.toBean(updateReqVO, ProductDO.class);
        productMapper.updateById(updateObj);
    }

    @Override
    public void deleteProduct(Long id) {
        validateProductExists(id);
        productMapper.deleteById(id);
    }

    @Override
    public ProductDO getProduct(Long id) {
        return productMapper.selectById(id);
    }

    @Override
    public PageResult<ProductDO> getProductPage(ProductPageReqVO pageReqVO) {
        return productMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ProductCategorySimpleRespVO> getCategorySimpleList() {
        List<FreshCategoryDO> categories = freshCategoryMapper.selectSimpleList();
        return BeanUtils.toBean(categories, ProductCategorySimpleRespVO.class);
    }

    private void validateProductExists(Long id) {
        if (id == null) {
            return;
        }
        if (productMapper.selectById(id) == null) {
            throw new ServiceException(404, "商品不存在");
        }
    }

    private void validateCategory(String catId) {
        if (catId == null || catId.trim().isEmpty()) {
            throw new ServiceException(400, "请选择商品分类");
        }
        FreshCategoryDO category = freshCategoryMapper.selectByIdStr(catId.trim());
        if (category == null) {
            throw new ServiceException(400, "分类「" + catId + "」不存在，请在下拉框中选择已有分类");
        }
    }

}
