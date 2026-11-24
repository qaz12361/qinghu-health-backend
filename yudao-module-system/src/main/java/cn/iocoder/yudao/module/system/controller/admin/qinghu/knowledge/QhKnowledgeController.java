package cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledge;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledge.vo.QhKnowledgePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledge.vo.QhKnowledgeRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledge.vo.QhKnowledgeSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.knowledge.QhKnowledgeDO;
import cn.iocoder.yudao.module.system.service.qinghu.knowledge.QhKnowledgeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·健康知识")
@RestController
@RequestMapping("/system/qinghu/knowledge")
@Validated
public class QhKnowledgeController {

    @Resource
    private QhKnowledgeService qhKnowledgeService;

    @PostMapping("/create")
    @Operation(summary = "创建健康知识")
    public CommonResult<Long> createQhKnowledge(@Valid @RequestBody QhKnowledgeSaveReqVO createReqVO) {
        return success(qhKnowledgeService.createQhKnowledge(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改健康知识")
    public CommonResult<Boolean> updateQhKnowledge(@Valid @RequestBody QhKnowledgeSaveReqVO updateReqVO) {
        qhKnowledgeService.updateQhKnowledge(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除健康知识")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhKnowledge(@RequestParam("id") Long id) {
        qhKnowledgeService.deleteQhKnowledge(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得健康知识")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhKnowledgeRespVO> getQhKnowledge(@RequestParam("id") Long id) {
        QhKnowledgeDO qhKnowledge = qhKnowledgeService.getQhKnowledge(id);
        return success(BeanUtils.toBean(qhKnowledge, QhKnowledgeRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得健康知识分页")
    public CommonResult<PageResult<QhKnowledgeRespVO>> getQhKnowledgePage(@Validated QhKnowledgePageReqVO pageReqVO) {
        PageResult<QhKnowledgeDO> pageResult = qhKnowledgeService.getQhKnowledgePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhKnowledgeRespVO.class));
    }

}
