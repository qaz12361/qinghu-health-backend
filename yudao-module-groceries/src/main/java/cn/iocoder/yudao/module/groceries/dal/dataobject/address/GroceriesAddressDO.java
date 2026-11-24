package cn.iocoder.yudao.module.groceries.dal.dataobject.address;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 收货地址 DO
 */
@TableName("address")
@Data
@EqualsAndHashCode(callSuper = true)
public class GroceriesAddressDO extends BaseDO {

    /** 地址编号 */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 会员编号 */
    private Integer memberId;

    /** 收件人 */
    private String receiver;

    /** 联系电话 */
    private String phone;

    /** 详细地址 */
    private String detail;

    /** 是否默认地址 */
    private Boolean isDefault;

}
