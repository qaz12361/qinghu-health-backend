package cn.iocoder.yudao.module.groceries.dal.dataobject.member;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 生鲜小店会员 DO
 */
@TableName("member")
@Data
@EqualsAndHashCode(callSuper = true)
public class GroceriesMemberDO extends BaseDO {

    /** 会员编号 */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 会员姓名 */
    private String name;

    /** 手机号 */
    private String phone;

    /** 会员等级，例如 Lv.3 */
    private String level;

    /** 账户余额 */
    private BigDecimal balance;

}
