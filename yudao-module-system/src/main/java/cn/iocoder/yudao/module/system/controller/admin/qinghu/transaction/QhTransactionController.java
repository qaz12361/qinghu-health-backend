package cn.iocoder.yudao.module.system.controller.admin.qinghu.transaction;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.transaction.vo.QhTransactionPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.transaction.vo.QhTransactionRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.transaction.vo.QhTransactionSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.transaction.QhTransactionDO;
import cn.iocoder.yudao.module.system.service.qinghu.transaction.QhTransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·交易流水")
@RestController
@RequestMapping("/system/qinghu/transaction")
@Validated
public class QhTransactionController {

    @Resource
    private QhTransactionService qhTransactionService;

    @PostMapping("/create")
    @Operation(summary = "创建交易流水")
    public CommonResult<Long> createQhTransaction(@Valid @RequestBody QhTransactionSaveReqVO createReqVO) {
        return success(qhTransactionService.createQhTransaction(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改交易流水")
    public CommonResult<Boolean> updateQhTransaction(@Valid @RequestBody QhTransactionSaveReqVO updateReqVO) {
        qhTransactionService.updateQhTransaction(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除交易流水")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhTransaction(@RequestParam("id") Long id) {
        qhTransactionService.deleteQhTransaction(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得交易流水")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhTransactionRespVO> getQhTransaction(@RequestParam("id") Long id) {
        QhTransactionDO qhTransaction = qhTransactionService.getQhTransaction(id);
        return success(BeanUtils.toBean(qhTransaction, QhTransactionRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得交易流水分页")
    public CommonResult<PageResult<QhTransactionRespVO>> getQhTransactionPage(@Validated QhTransactionPageReqVO pageReqVO) {
        PageResult<QhTransactionDO> pageResult = qhTransactionService.getQhTransactionPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhTransactionRespVO.class));
    }

}
