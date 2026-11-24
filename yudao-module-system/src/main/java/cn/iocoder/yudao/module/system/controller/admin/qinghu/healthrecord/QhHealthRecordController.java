package cn.iocoder.yudao.module.system.controller.admin.qinghu.healthrecord;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.healthrecord.vo.QhHealthRecordPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.healthrecord.vo.QhHealthRecordRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.healthrecord.vo.QhHealthRecordSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.healthrecord.QhHealthRecordDO;
import cn.iocoder.yudao.module.system.service.qinghu.healthrecord.QhHealthRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·健康记录")
@RestController
@RequestMapping("/system/qinghu/health-record")
@Validated
public class QhHealthRecordController {

    @Resource
    private QhHealthRecordService qhHealthRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建健康记录")
    public CommonResult<Long> createQhHealthRecord(@Valid @RequestBody QhHealthRecordSaveReqVO createReqVO) {
        return success(qhHealthRecordService.createQhHealthRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改健康记录")
    public CommonResult<Boolean> updateQhHealthRecord(@Valid @RequestBody QhHealthRecordSaveReqVO updateReqVO) {
        qhHealthRecordService.updateQhHealthRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除健康记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhHealthRecord(@RequestParam("id") Long id) {
        qhHealthRecordService.deleteQhHealthRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得健康记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhHealthRecordRespVO> getQhHealthRecord(@RequestParam("id") Long id) {
        QhHealthRecordDO qhHealthRecord = qhHealthRecordService.getQhHealthRecord(id);
        return success(BeanUtils.toBean(qhHealthRecord, QhHealthRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得健康记录分页")
    public CommonResult<PageResult<QhHealthRecordRespVO>> getQhHealthRecordPage(@Validated QhHealthRecordPageReqVO pageReqVO) {
        PageResult<QhHealthRecordDO> pageResult = qhHealthRecordService.getQhHealthRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhHealthRecordRespVO.class));
    }

}
