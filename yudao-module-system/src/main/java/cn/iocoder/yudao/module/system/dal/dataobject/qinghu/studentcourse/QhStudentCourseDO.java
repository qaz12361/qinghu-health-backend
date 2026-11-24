package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.studentcourse;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * 已购课程 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_student_course")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhStudentCourseDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 学生编号
     */
    private Long studentId;
    /**
     * 课程编号
     */
    private Long courseId;
    /**
     * 购买日期
     */
    private LocalDate buyTime;
    /**
     * 学习进度 %
     */
    private Integer progress;

}
