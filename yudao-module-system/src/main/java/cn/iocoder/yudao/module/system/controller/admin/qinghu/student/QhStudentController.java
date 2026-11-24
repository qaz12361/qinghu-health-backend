package cn.iocoder.yudao.module.system.controller.admin.qinghu.student;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.student.vo.QhStudentPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.student.vo.QhStudentRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.student.vo.QhStudentSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.student.QhStudentDO;
import cn.iocoder.yudao.module.system.service.qinghu.student.QhStudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·学生管理")
@RestController
@RequestMapping("/system/qinghu/student")
@Validated
public class QhStudentController {

    @Resource
    private QhStudentService qhStudentService;

    @PostMapping("/create")
    @Operation(summary = "创建学生管理")
    public CommonResult<Long> createQhStudent(@Valid @RequestBody QhStudentSaveReqVO createReqVO) {
        return success(qhStudentService.createQhStudent(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改学生管理")
    public CommonResult<Boolean> updateQhStudent(@Valid @RequestBody QhStudentSaveReqVO updateReqVO) {
        qhStudentService.updateQhStudent(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除学生管理")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhStudent(@RequestParam("id") Long id) {
        qhStudentService.deleteQhStudent(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得学生管理")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhStudentRespVO> getQhStudent(@RequestParam("id") Long id) {
        QhStudentDO qhStudent = qhStudentService.getQhStudent(id);
        return success(BeanUtils.toBean(qhStudent, QhStudentRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得学生管理分页")
    public CommonResult<PageResult<QhStudentRespVO>> getQhStudentPage(@Validated QhStudentPageReqVO pageReqVO) {
        PageResult<QhStudentDO> pageResult = qhStudentService.getQhStudentPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhStudentRespVO.class));
    }

}
