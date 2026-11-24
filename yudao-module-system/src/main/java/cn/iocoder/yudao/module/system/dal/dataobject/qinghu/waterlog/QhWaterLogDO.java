package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.waterlog;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * 饮水打卡 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_water_log")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhWaterLogDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 打卡日期
     */
    private LocalDate logDate;
    /**
     * 饮水量 ml
     */
    private Integer amount;

}
