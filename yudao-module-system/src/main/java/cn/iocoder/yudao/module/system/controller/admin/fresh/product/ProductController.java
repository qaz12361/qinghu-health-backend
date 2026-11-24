package cn.iocoder.yudao.module.system.controller.admin.fresh.product;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import java.util.List;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.fresh.product.vo.ProductPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.fresh.product.vo.ProductRespVO;
import cn.iocoder.yudao.module.system.controller.admin.fresh.product.vo.ProductSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.fresh.product.ProductDO;
import cn.iocoder.yudao.module.system.service.fresh.product.ProductService;
import cn.iocoder.yudao.module.system.controller.admin.fresh.product.vo.ProductCategorySimpleRespVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 生鲜商品")
@RestController
@RequestMapping("/system/fresh/product")
@Validated
public class ProductController {

    @Resource
    private ProductService productService;

    @PostMapping("/create")
    @Operation(summary = "创建商品")
    public CommonResult<Long> createProduct(@Valid @RequestBody ProductSaveReqVO createReqVO) {
        return success(productService.createProduct(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改商品")
    public CommonResult<Boolean> updateProduct(@Valid @RequestBody ProductSaveReqVO updateReqVO) {
        productService.updateProduct(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除商品")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteProduct(@RequestParam("id") Long id) {
        productService.deleteProduct(id);
        return success(true);
    }

    @GetMapping("/page")
    @Operation(summary = "获得商品分页")
    public CommonResult<PageResult<ProductRespVO>> getProductPage(@Validated ProductPageReqVO pageReqVO) {
        PageResult<ProductDO> pageResult = productService.getProductPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ProductRespVO.class));
    }

    @GetMapping("/get")
    @Operation(summary = "获得商品")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<ProductRespVO> getProduct(@RequestParam("id") Long id) {
        ProductDO product = productService.getProduct(id);
        return success(BeanUtils.toBean(product, ProductRespVO.class));
    }

    @GetMapping("/category-list")
    @Operation(summary = "获得全部有效分类（用于新增商品下拉选择）")
    public CommonResult<List<ProductCategorySimpleRespVO>> getCategoryList() {
        List<ProductCategorySimpleRespVO> list = productService.getCategorySimpleList();
        return success(list);
    }

}
