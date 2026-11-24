package cn.iocoder.yudao.module.system.controller.admin.qinghu.coach;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coach.vo.QhCoachPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coach.vo.QhCoachRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coach.vo.QhCoachSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coach.QhCoachDO;
import cn.iocoder.yudao.module.system.service.qinghu.coach.QhCoachService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·教练管理")
@RestController
@RequestMapping("/system/qinghu/coach")
@Validated
public class QhCoachController {

    @Resource
    private QhCoachService qhCoachService;

    @PostMapping("/create")
    @Operation(summary = "创建教练管理")
    public CommonResult<Long> createQhCoach(@Valid @RequestBody QhCoachSaveReqVO createReqVO) {
        return success(qhCoachService.createQhCoach(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改教练管理")
    public CommonResult<Boolean> updateQhCoach(@Valid @RequestBody QhCoachSaveReqVO updateReqVO) {
        qhCoachService.updateQhCoach(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除教练管理")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhCoach(@RequestParam("id") Long id) {
        qhCoachService.deleteQhCoach(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得教练管理")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhCoachRespVO> getQhCoach(@RequestParam("id") Long id) {
        QhCoachDO qhCoach = qhCoachService.getQhCoach(id);
        return success(BeanUtils.toBean(qhCoach, QhCoachRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得教练管理分页")
    public CommonResult<PageResult<QhCoachRespVO>> getQhCoachPage(@Validated QhCoachPageReqVO pageReqVO) {
        PageResult<QhCoachDO> pageResult = qhCoachService.getQhCoachPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhCoachRespVO.class));
    }

}
