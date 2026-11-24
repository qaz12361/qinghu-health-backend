package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.course;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 课程管理 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_course")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhCourseDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 课程标题
     */
    private String title;
    /**
     * 授课教练
     */
    private String coach;
    /**
     * 封面主题键
     */
    private String cover;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 分类
     */
    private String category;
    /**
     * 课时数
     */
    private Integer lessons;
    /**
     * 销量
     */
    private Integer sales;
    /**
     * 是否免费
     */
    private Boolean isFree;
    /**
     * 评分
     */
    private BigDecimal rating;
    /**
     * 状态
     */
    private String status;
    /**
     * 课程简介
     */
    private String description;
    /**
     * 审核结果
     */
    private String auditResult;

}
