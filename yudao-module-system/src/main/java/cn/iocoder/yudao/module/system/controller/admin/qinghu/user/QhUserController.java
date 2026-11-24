package cn.iocoder.yudao.module.system.controller.admin.qinghu.user;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.user.vo.QhUserPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.user.vo.QhUserRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.user.vo.QhUserSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.user.QhUserDO;
import cn.iocoder.yudao.module.system.service.qinghu.user.QhUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·平台用户")
@RestController
@RequestMapping("/system/qinghu/user")
@Validated
public class QhUserController {

    @Resource
    private QhUserService qhUserService;

    @PostMapping("/create")
    @Operation(summary = "创建平台用户")
    public CommonResult<Long> createQhUser(@Valid @RequestBody QhUserSaveReqVO createReqVO) {
        return success(qhUserService.createQhUser(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改平台用户")
    public CommonResult<Boolean> updateQhUser(@Valid @RequestBody QhUserSaveReqVO updateReqVO) {
        qhUserService.updateQhUser(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除平台用户")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhUser(@RequestParam("id") Long id) {
        qhUserService.deleteQhUser(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得平台用户")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhUserRespVO> getQhUser(@RequestParam("id") Long id) {
        QhUserDO qhUser = qhUserService.getQhUser(id);
        return success(BeanUtils.toBean(qhUser, QhUserRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得平台用户分页")
    public CommonResult<PageResult<QhUserRespVO>> getQhUserPage(@Validated QhUserPageReqVO pageReqVO) {
        PageResult<QhUserDO> pageResult = qhUserService.getQhUserPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhUserRespVO.class));
    }

}
