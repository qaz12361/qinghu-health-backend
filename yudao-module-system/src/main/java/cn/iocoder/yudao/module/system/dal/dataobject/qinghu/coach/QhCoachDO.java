package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coach;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 教练管理 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_coach")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhCoachDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 登录账号
     */
    private String account;
    /**
     * 头像路径
     */
    private String photo;
    /**
     * 头像定位
     */
    private String photoPos;
    /**
     * 性别
     */
    private String gender;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 资质证书
     */
    private String cert;
    /**
     * 专长
     */
    private String specialty;
    /**
     * 标签
     */
    private String tags;
    /**
     * 从业年限
     */
    private Integer years;
    /**
     * 学员数
     */
    private Integer studentCount;
    /**
     * 评分
     */
    private BigDecimal rating;
    /**
     * 接单数
     */
    private Integer orderCount;
    /**
     * 起价
     */
    private BigDecimal priceFrom;
    /**
     * 简介
     */
    private String intro;
    /**
     * 入驻审核状态
     */
    private String applyStatus;
    /**
     * 审核通过时间
     */
    private String approveTime;
    /**
     * 状态
     */
    private String status;
    /**
     * 是否在线
     */
    private Boolean online;

}
