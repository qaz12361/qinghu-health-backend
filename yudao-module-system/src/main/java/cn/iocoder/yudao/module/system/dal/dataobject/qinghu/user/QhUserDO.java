package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.user;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * 平台用户 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_user")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhUserDO extends TenantBaseDO {

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
     * 角色
     */
    private String role;
    /**
     * 状态
     */
    private String status;
    /**
     * 注册日期
     */
    private LocalDate regTime;
    /**
     * 入驻审核状态
     */
    private String applyStatus;
    /**
     * 审核通过时间
     */
    private String approveTime;
    /**
     * 专长
     */
    private String specialty;
    /**
     * 资质证书
     */
    private String cert;

}
