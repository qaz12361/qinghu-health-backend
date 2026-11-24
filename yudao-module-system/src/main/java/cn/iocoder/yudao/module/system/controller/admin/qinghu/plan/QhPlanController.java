package cn.iocoder.yudao.module.system.controller.admin.qinghu.plan;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.plan.vo.QhPlanPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.plan.vo.QhPlanRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.plan.vo.QhPlanSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.plan.QhPlanDO;
import cn.iocoder.yudao.module.system.service.qinghu.plan.QhPlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·运动计划")
@RestController
@RequestMapping("/system/qinghu/plan")
@Validated
public class QhPlanController {

    @Resource
    private QhPlanService qhPlanService;

    @PostMapping("/create")
    @Operation(summary = "创建运动计划")
    public CommonResult<Long> createQhPlan(@Valid @RequestBody QhPlanSaveReqVO createReqVO) {
        return success(qhPlanService.createQhPlan(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改运动计划")
    public CommonResult<Boolean> updateQhPlan(@Valid @RequestBody QhPlanSaveReqVO updateReqVO) {
        qhPlanService.updateQhPlan(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除运动计划")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhPlan(@RequestParam("id") Long id) {
        qhPlanService.deleteQhPlan(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得运动计划")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhPlanRespVO> getQhPlan(@RequestParam("id") Long id) {
        QhPlanDO qhPlan = qhPlanService.getQhPlan(id);
        return success(BeanUtils.toBean(qhPlan, QhPlanRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得运动计划分页")
    public CommonResult<PageResult<QhPlanRespVO>> getQhPlanPage(@Validated QhPlanPageReqVO pageReqVO) {
        PageResult<QhPlanDO> pageResult = qhPlanService.getQhPlanPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhPlanRespVO.class));
    }

}
