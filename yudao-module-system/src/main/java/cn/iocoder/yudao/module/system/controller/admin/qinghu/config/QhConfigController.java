package cn.iocoder.yudao.module.system.controller.admin.qinghu.config;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.config.vo.QhConfigPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.config.vo.QhConfigRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.config.vo.QhConfigSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.config.QhConfigDO;
import cn.iocoder.yudao.module.system.service.qinghu.config.QhConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·平台配置")
@RestController
@RequestMapping("/system/qinghu/config")
@Validated
public class QhConfigController {

    @Resource
    private QhConfigService qhConfigService;

    @PostMapping("/create")
    @Operation(summary = "创建平台配置")
    public CommonResult<Long> createQhConfig(@Valid @RequestBody QhConfigSaveReqVO createReqVO) {
        return success(qhConfigService.createQhConfig(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改平台配置")
    public CommonResult<Boolean> updateQhConfig(@Valid @RequestBody QhConfigSaveReqVO updateReqVO) {
        qhConfigService.updateQhConfig(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除平台配置")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhConfig(@RequestParam("id") Long id) {
        qhConfigService.deleteQhConfig(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得平台配置")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhConfigRespVO> getQhConfig(@RequestParam("id") Long id) {
        QhConfigDO qhConfig = qhConfigService.getQhConfig(id);
        return success(BeanUtils.toBean(qhConfig, QhConfigRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得平台配置分页")
    public CommonResult<PageResult<QhConfigRespVO>> getQhConfigPage(@Validated QhConfigPageReqVO pageReqVO) {
        PageResult<QhConfigDO> pageResult = qhConfigService.getQhConfigPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhConfigRespVO.class));
    }

}
