package cn.iocoder.yudao.module.system.controller.admin.qinghu.profile;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.profile.vo.QhProfilePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.profile.vo.QhProfileRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.profile.vo.QhProfileSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.profile.QhProfileDO;
import cn.iocoder.yudao.module.system.service.qinghu.profile.QhProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·学生档案")
@RestController
@RequestMapping("/system/qinghu/profile")
@Validated
public class QhProfileController {

    @Resource
    private QhProfileService qhProfileService;

    @PostMapping("/create")
    @Operation(summary = "创建学生档案")
    public CommonResult<Long> createQhProfile(@Valid @RequestBody QhProfileSaveReqVO createReqVO) {
        return success(qhProfileService.createQhProfile(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改学生档案")
    public CommonResult<Boolean> updateQhProfile(@Valid @RequestBody QhProfileSaveReqVO updateReqVO) {
        qhProfileService.updateQhProfile(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除学生档案")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhProfile(@RequestParam("id") Long id) {
        qhProfileService.deleteQhProfile(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得学生档案")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhProfileRespVO> getQhProfile(@RequestParam("id") Long id) {
        QhProfileDO qhProfile = qhProfileService.getQhProfile(id);
        return success(BeanUtils.toBean(qhProfile, QhProfileRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得学生档案分页")
    public CommonResult<PageResult<QhProfileRespVO>> getQhProfilePage(@Validated QhProfilePageReqVO pageReqVO) {
        PageResult<QhProfileDO> pageResult = qhProfileService.getQhProfilePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhProfileRespVO.class));
    }

}
