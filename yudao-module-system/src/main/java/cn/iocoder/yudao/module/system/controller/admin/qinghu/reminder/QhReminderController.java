package cn.iocoder.yudao.module.system.controller.admin.qinghu.reminder;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.reminder.vo.QhReminderPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.reminder.vo.QhReminderRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.reminder.vo.QhReminderSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.reminder.QhReminderDO;
import cn.iocoder.yudao.module.system.service.qinghu.reminder.QhReminderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·健康提醒")
@RestController
@RequestMapping("/system/qinghu/reminder")
@Validated
public class QhReminderController {

    @Resource
    private QhReminderService qhReminderService;

    @PostMapping("/create")
    @Operation(summary = "创建健康提醒")
    public CommonResult<Long> createQhReminder(@Valid @RequestBody QhReminderSaveReqVO createReqVO) {
        return success(qhReminderService.createQhReminder(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改健康提醒")
    public CommonResult<Boolean> updateQhReminder(@Valid @RequestBody QhReminderSaveReqVO updateReqVO) {
        qhReminderService.updateQhReminder(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除健康提醒")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhReminder(@RequestParam("id") Long id) {
        qhReminderService.deleteQhReminder(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得健康提醒")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhReminderRespVO> getQhReminder(@RequestParam("id") Long id) {
        QhReminderDO qhReminder = qhReminderService.getQhReminder(id);
        return success(BeanUtils.toBean(qhReminder, QhReminderRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得健康提醒分页")
    public CommonResult<PageResult<QhReminderRespVO>> getQhReminderPage(@Validated QhReminderPageReqVO pageReqVO) {
        PageResult<QhReminderDO> pageResult = qhReminderService.getQhReminderPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhReminderRespVO.class));
    }

}
