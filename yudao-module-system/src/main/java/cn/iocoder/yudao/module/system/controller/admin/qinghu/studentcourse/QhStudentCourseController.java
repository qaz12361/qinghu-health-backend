package cn.iocoder.yudao.module.system.controller.admin.qinghu.studentcourse;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.studentcourse.vo.QhStudentCoursePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.studentcourse.vo.QhStudentCourseRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.studentcourse.vo.QhStudentCourseSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.studentcourse.QhStudentCourseDO;
import cn.iocoder.yudao.module.system.service.qinghu.studentcourse.QhStudentCourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·已购课程")
@RestController
@RequestMapping("/system/qinghu/student-course")
@Validated
public class QhStudentCourseController {

    @Resource
    private QhStudentCourseService qhStudentCourseService;

    @PostMapping("/create")
    @Operation(summary = "创建已购课程")
    public CommonResult<Long> createQhStudentCourse(@Valid @RequestBody QhStudentCourseSaveReqVO createReqVO) {
        return success(qhStudentCourseService.createQhStudentCourse(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改已购课程")
    public CommonResult<Boolean> updateQhStudentCourse(@Valid @RequestBody QhStudentCourseSaveReqVO updateReqVO) {
        qhStudentCourseService.updateQhStudentCourse(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除已购课程")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhStudentCourse(@RequestParam("id") Long id) {
        qhStudentCourseService.deleteQhStudentCourse(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得已购课程")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhStudentCourseRespVO> getQhStudentCourse(@RequestParam("id") Long id) {
        QhStudentCourseDO qhStudentCourse = qhStudentCourseService.getQhStudentCourse(id);
        return success(BeanUtils.toBean(qhStudentCourse, QhStudentCourseRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得已购课程分页")
    public CommonResult<PageResult<QhStudentCourseRespVO>> getQhStudentCoursePage(@Validated QhStudentCoursePageReqVO pageReqVO) {
        PageResult<QhStudentCourseDO> pageResult = qhStudentCourseService.getQhStudentCoursePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhStudentCourseRespVO.class));
    }

}
