package cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledgepoint;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledgepoint.vo.QhKnowledgePointPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledgepoint.vo.QhKnowledgePointRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.knowledgepoint.vo.QhKnowledgePointSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.knowledgepoint.QhKnowledgePointDO;
import cn.iocoder.yudao.module.system.service.qinghu.knowledgepoint.QhKnowledgePointService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·知识要点")
@RestController
@RequestMapping("/system/qinghu/knowledge-point")
@Validated
public class QhKnowledgePointController {

    @Resource
    private QhKnowledgePointService qhKnowledgePointService;

    @PostMapping("/create")
    @Operation(summary = "创建知识要点")
    public CommonResult<Long> createQhKnowledgePoint(@Valid @RequestBody QhKnowledgePointSaveReqVO createReqVO) {
        return success(qhKnowledgePointService.createQhKnowledgePoint(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改知识要点")
    public CommonResult<Boolean> updateQhKnowledgePoint(@Valid @RequestBody QhKnowledgePointSaveReqVO updateReqVO) {
        qhKnowledgePointService.updateQhKnowledgePoint(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除知识要点")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhKnowledgePoint(@RequestParam("id") Long id) {
        qhKnowledgePointService.deleteQhKnowledgePoint(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得知识要点")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhKnowledgePointRespVO> getQhKnowledgePoint(@RequestParam("id") Long id) {
        QhKnowledgePointDO qhKnowledgePoint = qhKnowledgePointService.getQhKnowledgePoint(id);
        return success(BeanUtils.toBean(qhKnowledgePoint, QhKnowledgePointRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得知识要点分页")
    public CommonResult<PageResult<QhKnowledgePointRespVO>> getQhKnowledgePointPage(@Validated QhKnowledgePointPageReqVO pageReqVO) {
        PageResult<QhKnowledgePointDO> pageResult = qhKnowledgePointService.getQhKnowledgePointPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhKnowledgePointRespVO.class));
    }

}
