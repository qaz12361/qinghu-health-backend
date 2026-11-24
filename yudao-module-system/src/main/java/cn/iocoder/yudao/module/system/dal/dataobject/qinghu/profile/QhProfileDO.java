package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.profile;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 学生档案 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_profile")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhProfileDO extends TenantBaseDO {

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
     * 学院
     */
    private String college;
    /**
     * 专业
     */
    private String major;
    /**
     * 手机号
     */
    private String phone;
    /**
     * BMI
     */
    private BigDecimal bmi;
    /**
     * 身高 cm
     */
    private BigDecimal height;
    /**
     * 体重 kg
     */
    private BigDecimal weight;
    /**
     * 体脂率 %
     */
    private BigDecimal bodyFat;
    /**
     * 肌肉量 kg
     */
    private BigDecimal muscle;
    /**
     * 腰围 cm
     */
    private BigDecimal waist;

}
