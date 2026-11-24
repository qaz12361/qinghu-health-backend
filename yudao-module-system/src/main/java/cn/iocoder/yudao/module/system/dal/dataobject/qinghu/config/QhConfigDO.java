package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.config;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;



/**
 * 平台配置 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_config")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhConfigDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 配置键
     */
    private String configKey;
    /**
     * 配置值
     */
    private String configValue;
    /**
     * 说明
     */
    private String description;

}
