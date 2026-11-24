package cn.iocoder.yudao.module.groceries.controller.app.member;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.groceries.controller.app.member.vo.GroceriesAddressRespVO;
import cn.iocoder.yudao.module.groceries.controller.app.member.vo.GroceriesMemberRespVO;
import cn.iocoder.yudao.module.groceries.service.member.GroceriesMemberService;
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
 * 用户 App - 生鲜商城会员
 *
 * 演示场景固定使用 1 号会员，不接入登录体系。
 */
@Tag(name = "用户 App - 生鲜商城会员")
@RestController("appGroceriesMemberController")
@RequestMapping("/groceries/member")
@PermitAll
public class AppGroceriesMemberController {

    @Resource
    private GroceriesMemberService memberService;

    @GetMapping("/get")
    @Operation(summary = "获得会员信息")
    @Parameter(name = "id", description = "会员编号", required = true, example = "1")
    @PermitAll
    public CommonResult<GroceriesMemberRespVO> getMember(@RequestParam("id") Integer id) {
        return success(BeanUtils.toBean(memberService.getMember(id), GroceriesMemberRespVO.class));
    }

    @GetMapping("/address-list")
    @Operation(summary = "获得会员收货地址列表")
    @Parameter(name = "memberId", description = "会员编号", required = true, example = "1")
    @PermitAll
    public CommonResult<List<GroceriesAddressRespVO>> getAddressList(@RequestParam("memberId") Integer memberId) {
        return success(BeanUtils.toBean(memberService.getAddressList(memberId), GroceriesAddressRespVO.class));
    }

}
