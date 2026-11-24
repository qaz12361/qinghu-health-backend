package cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo.QhChapterItemPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo.QhChapterItemRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo.QhChapterItemSaveReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo.QhChapterPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo.QhChapterRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo.QhChapterSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.chapter.QhChapterDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.chapter.QhChapterItemDO;
import cn.iocoder.yudao.module.system.service.qinghu.chapter.QhChapterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·循证指南章节")
@RestController
@RequestMapping("/system/qinghu/chapter")
@Validated
public class QhChapterController {

    @Resource
    private QhChapterService qhChapterService;

    // ========== 章节 ==========

    @PostMapping("/create")
    @Operation(summary = "创建章节")
    public CommonResult<Long> createQhChapter(@Valid @RequestBody QhChapterSaveReqVO createReqVO) {
        return success(qhChapterService.createQhChapter(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改章节")
    public CommonResult<Boolean> updateQhChapter(@Valid @RequestBody QhChapterSaveReqVO updateReqVO) {
        qhChapterService.updateQhChapter(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除章节")
    @Parameter(name = "id", description = "编号", required = true, example = "1")
    public CommonResult<Boolean> deleteQhChapter(@RequestParam("id") Long id) {
        qhChapterService.deleteQhChapter(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得章节")
    @Parameter(name = "id", description = "编号", required = true, example = "1")
    public CommonResult<QhChapterRespVO> getQhChapter(@RequestParam("id") Long id) {
        QhChapterDO chapter = qhChapterService.getQhChapter(id);
        return success(BeanUtils.toBean(chapter, QhChapterRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得章节分页")
    public CommonResult<PageResult<QhChapterRespVO>> getQhChapterPage(@Validated QhChapterPageReqVO pageReqVO) {
        PageResult<QhChapterDO> pageResult = qhChapterService.getQhChapterPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhChapterRespVO.class));
    }

    // ========== 建议条目 ==========

    @PostMapping("/item/create")
    @Operation(summary = "创建建议条目")
    public CommonResult<Long> createQhChapterItem(@Valid @RequestBody QhChapterItemSaveReqVO createReqVO) {
        return success(qhChapterService.createQhChapterItem(createReqVO));
    }

    @PutMapping("/item/update")
    @Operation(summary = "修改建议条目")
    public CommonResult<Boolean> updateQhChapterItem(@Valid @RequestBody QhChapterItemSaveReqVO updateReqVO) {
        qhChapterService.updateQhChapterItem(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/item/delete")
    @Operation(summary = "删除建议条目")
    @Parameter(name = "id", description = "编号", required = true, example = "1")
    public CommonResult<Boolean> deleteQhChapterItem(@RequestParam("id") Long id) {
        qhChapterService.deleteQhChapterItem(id);
        return success(true);
    }

    @GetMapping("/item/page")
    @Operation(summary = "获得建议条目分页")
    public CommonResult<PageResult<QhChapterItemRespVO>> getQhChapterItemPage(@Validated QhChapterItemPageReqVO pageReqVO) {
        PageResult<QhChapterItemDO> pageResult = qhChapterService.getQhChapterItemPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhChapterItemRespVO.class));
    }

}
