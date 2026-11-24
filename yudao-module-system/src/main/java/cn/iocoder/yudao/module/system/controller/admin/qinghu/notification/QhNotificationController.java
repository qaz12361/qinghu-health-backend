package cn.iocoder.yudao.module.system.controller.admin.qinghu.notification;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.notification.vo.QhNotificationPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.notification.vo.QhNotificationRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.notification.vo.QhNotificationSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.notification.QhNotificationDO;
import cn.iocoder.yudao.module.system.service.qinghu.notification.QhNotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·通知中心")
@RestController
@RequestMapping("/system/qinghu/notification")
@Validated
public class QhNotificationController {

    @Resource
    private QhNotificationService qhNotificationService;

    @PostMapping("/create")
    @Operation(summary = "创建通知中心")
    public CommonResult<Long> createQhNotification(@Valid @RequestBody QhNotificationSaveReqVO createReqVO) {
        return success(qhNotificationService.createQhNotification(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改通知中心")
    public CommonResult<Boolean> updateQhNotification(@Valid @RequestBody QhNotificationSaveReqVO updateReqVO) {
        qhNotificationService.updateQhNotification(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除通知中心")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhNotification(@RequestParam("id") Long id) {
        qhNotificationService.deleteQhNotification(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得通知中心")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhNotificationRespVO> getQhNotification(@RequestParam("id") Long id) {
        QhNotificationDO qhNotification = qhNotificationService.getQhNotification(id);
        return success(BeanUtils.toBean(qhNotification, QhNotificationRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得通知中心分页")
    public CommonResult<PageResult<QhNotificationRespVO>> getQhNotificationPage(@Validated QhNotificationPageReqVO pageReqVO) {
        PageResult<QhNotificationDO> pageResult = qhNotificationService.getQhNotificationPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhNotificationRespVO.class));
    }

}
