package cn.iocoder.yudao.module.system.controller.admin.qinghu.wallet;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.wallet.vo.QhWalletPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.wallet.vo.QhWalletRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.wallet.vo.QhWalletSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.wallet.QhWalletDO;
import cn.iocoder.yudao.module.system.service.qinghu.wallet.QhWalletService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·钱包管理")
@RestController
@RequestMapping("/system/qinghu/wallet")
@Validated
public class QhWalletController {

    @Resource
    private QhWalletService qhWalletService;

    @PostMapping("/create")
    @Operation(summary = "创建钱包管理")
    public CommonResult<Long> createQhWallet(@Valid @RequestBody QhWalletSaveReqVO createReqVO) {
        return success(qhWalletService.createQhWallet(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改钱包管理")
    public CommonResult<Boolean> updateQhWallet(@Valid @RequestBody QhWalletSaveReqVO updateReqVO) {
        qhWalletService.updateQhWallet(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除钱包管理")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhWallet(@RequestParam("id") Long id) {
        qhWalletService.deleteQhWallet(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得钱包管理")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhWalletRespVO> getQhWallet(@RequestParam("id") Long id) {
        QhWalletDO qhWallet = qhWalletService.getQhWallet(id);
        return success(BeanUtils.toBean(qhWallet, QhWalletRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得钱包管理分页")
    public CommonResult<PageResult<QhWalletRespVO>> getQhWalletPage(@Validated QhWalletPageReqVO pageReqVO) {
        PageResult<QhWalletDO> pageResult = qhWalletService.getQhWalletPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhWalletRespVO.class));
    }

}
