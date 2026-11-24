package cn.iocoder.yudao.module.system.controller.admin.qinghu.waterlog;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.waterlog.vo.QhWaterLogPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.waterlog.vo.QhWaterLogRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.waterlog.vo.QhWaterLogSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.waterlog.QhWaterLogDO;
import cn.iocoder.yudao.module.system.service.qinghu.waterlog.QhWaterLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·饮水打卡")
@RestController
@RequestMapping("/system/qinghu/water-log")
@Validated
public class QhWaterLogController {

    @Resource
    private QhWaterLogService qhWaterLogService;

    @PostMapping("/create")
    @Operation(summary = "创建饮水打卡")
    public CommonResult<Long> createQhWaterLog(@Valid @RequestBody QhWaterLogSaveReqVO createReqVO) {
        return success(qhWaterLogService.createQhWaterLog(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改饮水打卡")
    public CommonResult<Boolean> updateQhWaterLog(@Valid @RequestBody QhWaterLogSaveReqVO updateReqVO) {
        qhWaterLogService.updateQhWaterLog(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除饮水打卡")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhWaterLog(@RequestParam("id") Long id) {
        qhWaterLogService.deleteQhWaterLog(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得饮水打卡")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhWaterLogRespVO> getQhWaterLog(@RequestParam("id") Long id) {
        QhWaterLogDO qhWaterLog = qhWaterLogService.getQhWaterLog(id);
        return success(BeanUtils.toBean(qhWaterLog, QhWaterLogRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得饮水打卡分页")
    public CommonResult<PageResult<QhWaterLogRespVO>> getQhWaterLogPage(@Validated QhWaterLogPageReqVO pageReqVO) {
        PageResult<QhWaterLogDO> pageResult = qhWaterLogService.getQhWaterLogPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhWaterLogRespVO.class));
    }

}
