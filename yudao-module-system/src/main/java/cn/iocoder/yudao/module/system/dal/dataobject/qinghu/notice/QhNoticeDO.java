package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.notice;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * 公告管理 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_notice")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhNoticeDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 发布人
     */
    private String publisher;
    /**
     * 发布日期
     */
    private LocalDate publishTime;
    /**
     * 是否置顶
     */
    private Boolean isTop;
    /**
     * 状态
     */
    private String status;
    /**
     * 正文
     */
    private String content;

}
