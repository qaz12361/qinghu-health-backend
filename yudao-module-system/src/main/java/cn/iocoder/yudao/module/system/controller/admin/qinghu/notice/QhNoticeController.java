package cn.iocoder.yudao.module.system.controller.admin.qinghu.notice;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.notice.vo.QhNoticePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.notice.vo.QhNoticeRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.notice.vo.QhNoticeSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.notice.QhNoticeDO;
import cn.iocoder.yudao.module.system.service.qinghu.notice.QhNoticeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·公告管理")
@RestController
@RequestMapping("/system/qinghu/notice")
@Validated
public class QhNoticeController {

    @Resource
    private QhNoticeService qhNoticeService;

    @PostMapping("/create")
    @Operation(summary = "创建公告管理")
    public CommonResult<Long> createQhNotice(@Valid @RequestBody QhNoticeSaveReqVO createReqVO) {
        return success(qhNoticeService.createQhNotice(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改公告管理")
    public CommonResult<Boolean> updateQhNotice(@Valid @RequestBody QhNoticeSaveReqVO updateReqVO) {
        qhNoticeService.updateQhNotice(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除公告管理")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhNotice(@RequestParam("id") Long id) {
        qhNoticeService.deleteQhNotice(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得公告管理")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhNoticeRespVO> getQhNotice(@RequestParam("id") Long id) {
        QhNoticeDO qhNotice = qhNoticeService.getQhNotice(id);
        return success(BeanUtils.toBean(qhNotice, QhNoticeRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得公告管理分页")
    public CommonResult<PageResult<QhNoticeRespVO>> getQhNoticePage(@Validated QhNoticePageReqVO pageReqVO) {
        PageResult<QhNoticeDO> pageResult = qhNoticeService.getQhNoticePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhNoticeRespVO.class));
    }

}
