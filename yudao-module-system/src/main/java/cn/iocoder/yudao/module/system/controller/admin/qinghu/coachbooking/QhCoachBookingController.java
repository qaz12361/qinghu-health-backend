package cn.iocoder.yudao.module.system.controller.admin.qinghu.coachbooking;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachbooking.vo.QhCoachBookingPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachbooking.vo.QhCoachBookingRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachbooking.vo.QhCoachBookingSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachbooking.QhCoachBookingDO;
import cn.iocoder.yudao.module.system.service.qinghu.coachbooking.QhCoachBookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·预约单")
@RestController
@RequestMapping("/system/qinghu/coach-booking")
@Validated
public class QhCoachBookingController {

    @Resource
    private QhCoachBookingService qhCoachBookingService;

    @PostMapping("/create")
    @Operation(summary = "创建预约单")
    public CommonResult<Long> createQhCoachBooking(@Valid @RequestBody QhCoachBookingSaveReqVO createReqVO) {
        return success(qhCoachBookingService.createQhCoachBooking(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改预约单")
    public CommonResult<Boolean> updateQhCoachBooking(@Valid @RequestBody QhCoachBookingSaveReqVO updateReqVO) {
        qhCoachBookingService.updateQhCoachBooking(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除预约单")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhCoachBooking(@RequestParam("id") Long id) {
        qhCoachBookingService.deleteQhCoachBooking(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得预约单")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhCoachBookingRespVO> getQhCoachBooking(@RequestParam("id") Long id) {
        QhCoachBookingDO qhCoachBooking = qhCoachBookingService.getQhCoachBooking(id);
        return success(BeanUtils.toBean(qhCoachBooking, QhCoachBookingRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得预约单分页")
    public CommonResult<PageResult<QhCoachBookingRespVO>> getQhCoachBookingPage(@Validated QhCoachBookingPageReqVO pageReqVO) {
        PageResult<QhCoachBookingDO> pageResult = qhCoachBookingService.getQhCoachBookingPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhCoachBookingRespVO.class));
    }

}
