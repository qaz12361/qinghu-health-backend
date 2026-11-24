package cn.iocoder.yudao.module.groceries.controller.app.catalog;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.groceries.controller.app.category.vo.GroceriesCategoryRespVO;
import cn.iocoder.yudao.module.groceries.controller.app.coupon.vo.GroceriesCouponRespVO;
import cn.iocoder.yudao.module.groceries.controller.app.product.vo.GroceriesProductRespVO;
import cn.iocoder.yudao.module.groceries.service.catalog.GroceriesCatalogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * 用户 App - 生鲜商城商品目录
 *
 * 分类、商品、优惠券均为公开数据，匿名可访问。
 */
@Tag(name = "用户 App - 生鲜商城商品目录")
@RestController("appGroceriesCatalogController")
@RequestMapping("/groceries")
@PermitAll
public class AppGroceriesCatalogController {

    @Resource
    private GroceriesCatalogService catalogService;

    @GetMapping("/category/list")
    @Operation(summary = "获得商品分类列表")
    @PermitAll
    public CommonResult<List<GroceriesCategoryRespVO>> getCategoryList() {
        return success(BeanUtils.toBean(catalogService.getCategoryList(), GroceriesCategoryRespVO.class));
    }

    @GetMapping("/product/list")
    @Operation(summary = "获得商品列表")
    @Parameter(name = "catId", description = "分类编号，不传表示全部", example = "veg")
    @Parameter(name = "keyword", description = "关键字，匹配商品名或产地")
    @PermitAll
    public CommonResult<List<GroceriesProductRespVO>> getProductList(
            @RequestParam(value = "catId", required = false) String catId,
            @RequestParam(value = "keyword", required = false) String keyword) {
        return success(BeanUtils.toBean(catalogService.getProductList(catId, keyword),
                GroceriesProductRespVO.class));
    }

    @GetMapping("/product/get")
    @Operation(summary = "获得商品详情")
    @Parameter(name = "id", description = "商品编号", required = true, example = "1")
    @PermitAll
    public CommonResult<GroceriesProductRespVO> getProduct(@RequestParam("id") Integer id) {
        return success(BeanUtils.toBean(catalogService.getProduct(id), GroceriesProductRespVO.class));
    }

    @GetMapping("/coupon/list")
    @Operation(summary = "获得优惠券列表")
    @PermitAll
    public CommonResult<List<GroceriesCouponRespVO>> getCouponList() {
        return success(BeanUtils.toBean(catalogService.getCouponList(), GroceriesCouponRespVO.class));
    }

}
