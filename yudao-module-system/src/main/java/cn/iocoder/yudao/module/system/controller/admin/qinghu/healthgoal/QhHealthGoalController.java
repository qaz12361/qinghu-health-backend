package cn.iocoder.yudao.module.system.controller.admin.qinghu.healthgoal;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.healthgoal.vo.QhHealthGoalPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.healthgoal.vo.QhHealthGoalRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.healthgoal.vo.QhHealthGoalSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.healthgoal.QhHealthGoalDO;
import cn.iocoder.yudao.module.system.service.qinghu.healthgoal.QhHealthGoalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·健康目标")
@RestController
@RequestMapping("/system/qinghu/health-goal")
@Validated
public class QhHealthGoalController {

    @Resource
    private QhHealthGoalService qhHealthGoalService;

    @PostMapping("/create")
    @Operation(summary = "创建健康目标")
    public CommonResult<Long> createQhHealthGoal(@Valid @RequestBody QhHealthGoalSaveReqVO createReqVO) {
        return success(qhHealthGoalService.createQhHealthGoal(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改健康目标")
    public CommonResult<Boolean> updateQhHealthGoal(@Valid @RequestBody QhHealthGoalSaveReqVO updateReqVO) {
        qhHealthGoalService.updateQhHealthGoal(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除健康目标")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhHealthGoal(@RequestParam("id") Long id) {
        qhHealthGoalService.deleteQhHealthGoal(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得健康目标")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhHealthGoalRespVO> getQhHealthGoal(@RequestParam("id") Long id) {
        QhHealthGoalDO qhHealthGoal = qhHealthGoalService.getQhHealthGoal(id);
        return success(BeanUtils.toBean(qhHealthGoal, QhHealthGoalRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得健康目标分页")
    public CommonResult<PageResult<QhHealthGoalRespVO>> getQhHealthGoalPage(@Validated QhHealthGoalPageReqVO pageReqVO) {
        PageResult<QhHealthGoalDO> pageResult = qhHealthGoalService.getQhHealthGoalPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhHealthGoalRespVO.class));
    }

}
