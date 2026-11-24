package cn.iocoder.yudao.module.system.controller.admin.qinghu.coachplan;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachplan.vo.QhCoachPlanPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachplan.vo.QhCoachPlanRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachplan.vo.QhCoachPlanSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachplan.QhCoachPlanDO;
import cn.iocoder.yudao.module.system.service.qinghu.coachplan.QhCoachPlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·教练计划")
@RestController
@RequestMapping("/system/qinghu/coach-plan")
@Validated
public class QhCoachPlanController {

    @Resource
    private QhCoachPlanService qhCoachPlanService;

    @PostMapping("/create")
    @Operation(summary = "创建教练计划")
    public CommonResult<Long> createQhCoachPlan(@Valid @RequestBody QhCoachPlanSaveReqVO createReqVO) {
        return success(qhCoachPlanService.createQhCoachPlan(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改教练计划")
    public CommonResult<Boolean> updateQhCoachPlan(@Valid @RequestBody QhCoachPlanSaveReqVO updateReqVO) {
        qhCoachPlanService.updateQhCoachPlan(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除教练计划")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhCoachPlan(@RequestParam("id") Long id) {
        qhCoachPlanService.deleteQhCoachPlan(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得教练计划")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhCoachPlanRespVO> getQhCoachPlan(@RequestParam("id") Long id) {
        QhCoachPlanDO qhCoachPlan = qhCoachPlanService.getQhCoachPlan(id);
        return success(BeanUtils.toBean(qhCoachPlan, QhCoachPlanRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得教练计划分页")
    public CommonResult<PageResult<QhCoachPlanRespVO>> getQhCoachPlanPage(@Validated QhCoachPlanPageReqVO pageReqVO) {
        PageResult<QhCoachPlanDO> pageResult = qhCoachPlanService.getQhCoachPlanPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhCoachPlanRespVO.class));
    }

}
