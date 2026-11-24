package cn.iocoder.yudao.module.system.dal.dataobject.fresh.member;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 生鲜会员 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("member")
@Data
@EqualsAndHashCode(callSuper = true)
public class MemberDO extends BaseDO {

    /**
     * 会员ID
     */
    private Long id;
    /**
     * 会员姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 会员等级
     */
    private String level;
    /**
     * 账户余额
     */
    private BigDecimal balance;

}
