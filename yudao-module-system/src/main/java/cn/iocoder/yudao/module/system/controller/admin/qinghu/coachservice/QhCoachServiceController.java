package cn.iocoder.yudao.module.system.controller.admin.qinghu.coachservice;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachservice.vo.QhCoachServicePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachservice.vo.QhCoachServiceRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.coachservice.vo.QhCoachServiceSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachservice.QhCoachServiceDO;
import cn.iocoder.yudao.module.system.service.qinghu.coachservice.QhCoachServiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·教练服务包")
@RestController
@RequestMapping("/system/qinghu/coach-service")
@Validated
public class QhCoachServiceController {

    @Resource
    private QhCoachServiceService qhCoachServiceService;

    @PostMapping("/create")
    @Operation(summary = "创建教练服务包")
    public CommonResult<Long> createQhCoachService(@Valid @RequestBody QhCoachServiceSaveReqVO createReqVO) {
        return success(qhCoachServiceService.createQhCoachService(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改教练服务包")
    public CommonResult<Boolean> updateQhCoachService(@Valid @RequestBody QhCoachServiceSaveReqVO updateReqVO) {
        qhCoachServiceService.updateQhCoachService(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除教练服务包")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhCoachService(@RequestParam("id") Long id) {
        qhCoachServiceService.deleteQhCoachService(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得教练服务包")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhCoachServiceRespVO> getQhCoachService(@RequestParam("id") Long id) {
        QhCoachServiceDO qhCoachService = qhCoachServiceService.getQhCoachService(id);
        return success(BeanUtils.toBean(qhCoachService, QhCoachServiceRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得教练服务包分页")
    public CommonResult<PageResult<QhCoachServiceRespVO>> getQhCoachServicePage(@Validated QhCoachServicePageReqVO pageReqVO) {
        PageResult<QhCoachServiceDO> pageResult = qhCoachServiceService.getQhCoachServicePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhCoachServiceRespVO.class));
    }

}
