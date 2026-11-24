package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.wallet;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 钱包管理 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_wallet")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhWalletDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 归属
     */
    private String owner;
    /**
     * 余额
     */
    private BigDecimal balance;
    /**
     * 可提现金额
     */
    private BigDecimal withdrawable;

}
