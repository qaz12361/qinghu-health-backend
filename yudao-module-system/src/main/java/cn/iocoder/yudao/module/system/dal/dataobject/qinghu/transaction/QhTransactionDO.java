package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.transaction;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 交易流水 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_transaction")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhTransactionDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 流水号
     */
    private String txNo;
    /**
     * 交易日期
     */
    private LocalDate txTime;
    /**
     * 类型
     */
    private String type;
    /**
     * 归属
     */
    private String role;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 说明
     */
    private String description;

}
