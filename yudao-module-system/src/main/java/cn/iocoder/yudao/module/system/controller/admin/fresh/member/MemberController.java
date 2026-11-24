package cn.iocoder.yudao.module.system.controller.admin.fresh.member;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.fresh.member.vo.MemberPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.fresh.member.vo.MemberRespVO;
import cn.iocoder.yudao.module.system.controller.admin.fresh.member.vo.MemberSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.fresh.member.MemberDO;
import cn.iocoder.yudao.module.system.service.fresh.member.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 生鲜会员")
@RestController
@RequestMapping("/system/fresh/member")
@Validated
public class MemberController {

    @Resource
    private MemberService memberService;

    @PostMapping("/create")
    @Operation(summary = "创建会员")
    public CommonResult<Long> createMember(@Valid @RequestBody MemberSaveReqVO createReqVO) {
        return success(memberService.createMember(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改会员")
    public CommonResult<Boolean> updateMember(@Valid @RequestBody MemberSaveReqVO updateReqVO) {
        memberService.updateMember(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除会员")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteMember(@RequestParam("id") Long id) {
        memberService.deleteMember(id);
        return success(true);
    }

    @GetMapping("/page")
    @Operation(summary = "获得会员分页")
    public CommonResult<PageResult<MemberRespVO>> getMemberPage(@Validated MemberPageReqVO pageReqVO) {
        PageResult<MemberDO> pageResult = memberService.getMemberPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MemberRespVO.class));
    }

    @GetMapping("/get")
    @Operation(summary = "获得会员")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<MemberRespVO> getMember(@RequestParam("id") Long id) {
        MemberDO member = memberService.getMember(id);
        return success(BeanUtils.toBean(member, MemberRespVO.class));
    }

}
