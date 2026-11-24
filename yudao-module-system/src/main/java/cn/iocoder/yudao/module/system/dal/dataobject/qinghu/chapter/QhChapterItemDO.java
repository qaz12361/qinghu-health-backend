package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.chapter;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 循证健康指南 - 建议条目 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_chapter_item")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhChapterItemDO extends TenantBaseDO {

    /**
     * 条目编号
     */
    private Long id;
    /**
     * 所属章节ID
     */
    private Long chapterId;
    /**
     * 排序号
     */
    private Integer sortNo;
    /**
     * 建议标题
     */
    private String title;
    /**
     * 建议说明
     */
    private String detail;
    /**
     * 证据等级 A/B/C
     */
    private String level;

}
