package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.student;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 学生管理 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_student")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhStudentDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 学号
     */
    private String stuNo;
    /**
     * 性别
     */
    private String gender;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 教练绑定状态
     */
    private String coachStatus;
    /**
     * BMI
     */
    private BigDecimal bmi;
    /**
     * 最近活跃日期
     */
    private LocalDate lastActive;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 微信号
     */
    private String wechat;
    /**
     * 服务状态
     */
    private String serviceStatus;
    /**
     * 目标方向
     */
    private String goal;

}
