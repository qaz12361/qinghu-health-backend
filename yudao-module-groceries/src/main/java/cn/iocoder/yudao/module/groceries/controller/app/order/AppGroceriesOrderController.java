package cn.iocoder.yudao.module.groceries.controller.app.order;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.groceries.controller.app.order.vo.GroceriesOrderCreateReqVO;
import cn.iocoder.yudao.module.groceries.controller.app.order.vo.GroceriesOrderRespVO;
import cn.iocoder.yudao.module.groceries.service.order.GroceriesOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * 用户 App - 生鲜商城订单
 */
@Tag(name = "用户 App - 生鲜商城订单")
@RestController("appGroceriesOrderController")
@RequestMapping("/groceries/order")
@PermitAll
public class AppGroceriesOrderController {

    @Resource
    private GroceriesOrderService orderService;

    @PostMapping("/create")
    @Operation(summary = "创建订单", description = "下单成功后扣减库存、核销优惠券并清理购物车")
    @PermitAll
    public CommonResult<Integer> createOrder(@Valid @RequestBody GroceriesOrderCreateReqVO reqVO) {
        return success(orderService.createOrder(reqVO));
    }

    @GetMapping("/list")
    @Operation(summary = "获得订单列表")
    @Parameter(name = "memberId", description = "会员编号", required = true, example = "1")
    @PermitAll
    public CommonResult<List<GroceriesOrderRespVO>> getOrderList(@RequestParam("memberId") Integer memberId) {
        return success(orderService.getOrderList(memberId));
    }

    @GetMapping("/get")
    @Operation(summary = "获得订单详情")
    @Parameter(name = "id", description = "订单编号", required = true, example = "1")
    @PermitAll
    public CommonResult<GroceriesOrderRespVO> getOrder(@RequestParam("id") Integer id) {
        return success(orderService.getOrder(id));
    }

    @PutMapping("/update-status")
    @Operation(summary = "更新订单状态", description = "供前台「模拟下一步」流转使用")
    @Parameter(name = "id", description = "订单编号", required = true, example = "1")
    @Parameter(name = "status", description = "目标状态：待发货/配送中/已完成/已取消", required = true)
    @PermitAll
    public CommonResult<Boolean> updateStatus(@RequestParam("id") Integer id,
                                              @RequestParam("status") String status) {
        orderService.updateStatus(id, status);
        return success(true);
    }

}
