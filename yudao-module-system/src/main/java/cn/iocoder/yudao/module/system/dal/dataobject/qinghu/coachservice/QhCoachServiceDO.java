package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachservice;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 教练服务包 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_coach_service")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhCoachServiceDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 教练编号
     */
    private Long coachId;
    /**
     * 服务标题
     */
    private String title;
    /**
     * 课时数
     */
    private Integer sessions;
    /**
     * 单次时长 分钟
     */
    private Integer sessionMin;
    /**
     * 总价
     */
    private BigDecimal price;
    /**
     * 单价
     */
    private BigDecimal unitPrice;
    /**
     * 包含内容
     */
    @com.baomidou.mybatisplus.annotation.TableField("`includes`")
    private String includes;
    /**
     * 适合人群
     */
    private String suitable;
    /**
     * 状态
     */
    private String status;

}
