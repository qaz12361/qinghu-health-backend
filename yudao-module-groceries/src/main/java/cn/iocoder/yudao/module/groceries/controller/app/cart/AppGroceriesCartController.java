package cn.iocoder.yudao.module.groceries.controller.app.cart;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.groceries.controller.app.cart.vo.GroceriesCartItemReqVO;
import cn.iocoder.yudao.module.groceries.controller.app.cart.vo.GroceriesCartItemRespVO;
import cn.iocoder.yudao.module.groceries.service.cart.GroceriesCartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * 用户 App - 生鲜商城购物车
 */
@Tag(name = "用户 App - 生鲜商城购物车")
@RestController("appGroceriesCartController")
@RequestMapping("/groceries/cart")
@PermitAll
public class AppGroceriesCartController {

    @Resource
    private GroceriesCartService cartService;

    @GetMapping("/list")
    @Operation(summary = "获得购物车列表")
    @Parameter(name = "memberId", description = "会员编号", required = true, example = "1")
    @PermitAll
    public CommonResult<List<GroceriesCartItemRespVO>> getCartList(@RequestParam("memberId") Integer memberId) {
        return success(cartService.getCartList(memberId));
    }

    @PostMapping("/add")
    @Operation(summary = "加入购物车", description = "已存在则累加数量")
    @PermitAll
    public CommonResult<Boolean> addToCart(@Valid @RequestBody GroceriesCartItemReqVO reqVO) {
        cartService.addToCart(reqVO.getMemberId(), reqVO.getProductId(), reqVO.getQuantity());
        return success(true);
    }

    @PostMapping("/update")
    @Operation(summary = "修改购物车数量", description = "数量为 0 表示移除该商品")
    @PermitAll
    public CommonResult<Boolean> updateQuantity(@Valid @RequestBody GroceriesCartItemReqVO reqVO) {
        cartService.updateQuantity(reqVO.getMemberId(), reqVO.getProductId(), reqVO.getQuantity());
        return success(true);
    }

    @DeleteMapping("/remove")
    @Operation(summary = "移除购物车项")
    @Parameter(name = "memberId", description = "会员编号", required = true, example = "1")
    @Parameter(name = "productId", description = "商品编号", required = true, example = "1")
    @PermitAll
    public CommonResult<Boolean> removeCartItem(@RequestParam("memberId") Integer memberId,
                                                @RequestParam("productId") Integer productId) {
        cartService.removeCartItem(memberId, productId);
        return success(true);
    }

    @DeleteMapping("/clear")
    @Operation(summary = "清空购物车")
    @Parameter(name = "memberId", description = "会员编号", required = true, example = "1")
    @PermitAll
    public CommonResult<Boolean> clearCart(@RequestParam("memberId") Integer memberId) {
        cartService.clearCart(memberId);
        return success(true);
    }

}
