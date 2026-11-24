package cn.iocoder.yudao.module.system.controller.admin.qinghu.course;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.course.vo.QhCoursePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.course.vo.QhCourseRespVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.course.vo.QhCourseSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.course.QhCourseDO;
import cn.iocoder.yudao.module.system.service.qinghu.course.QhCourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 健康管理·课程管理")
@RestController
@RequestMapping("/system/qinghu/course")
@Validated
public class QhCourseController {

    @Resource
    private QhCourseService qhCourseService;

    @PostMapping("/create")
    @Operation(summary = "创建课程管理")
    public CommonResult<Long> createQhCourse(@Valid @RequestBody QhCourseSaveReqVO createReqVO) {
        return success(qhCourseService.createQhCourse(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改课程管理")
    public CommonResult<Boolean> updateQhCourse(@Valid @RequestBody QhCourseSaveReqVO updateReqVO) {
        qhCourseService.updateQhCourse(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除课程管理")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteQhCourse(@RequestParam("id") Long id) {
        qhCourseService.deleteQhCourse(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得课程管理")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<QhCourseRespVO> getQhCourse(@RequestParam("id") Long id) {
        QhCourseDO qhCourse = qhCourseService.getQhCourse(id);
        return success(BeanUtils.toBean(qhCourse, QhCourseRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得课程管理分页")
    public CommonResult<PageResult<QhCourseRespVO>> getQhCoursePage(@Validated QhCoursePageReqVO pageReqVO) {
        PageResult<QhCourseDO> pageResult = qhCourseService.getQhCoursePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, QhCourseRespVO.class));
    }

}
