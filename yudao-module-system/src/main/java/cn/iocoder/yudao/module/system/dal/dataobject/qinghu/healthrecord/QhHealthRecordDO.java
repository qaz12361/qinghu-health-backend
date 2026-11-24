package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.healthrecord;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * 健康记录 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_health_record")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhHealthRecordDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 记录日期
     */
    private LocalDate recordDate;
    /**
     * 指标类型
     */
    private String type;
    /**
     * 指标值
     */
    private String value;
    /**
     * 单位
     */
    private String unit;
    /**
     * 备注
     */
    private String note;
    /**
     * 所属学生ID
     */
    private Long studentId;

}
