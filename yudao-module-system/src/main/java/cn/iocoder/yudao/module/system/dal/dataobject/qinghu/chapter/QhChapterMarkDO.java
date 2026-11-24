package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.chapter;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 循证健康指南 - 用户标记进度 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_chapter_mark")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhChapterMarkDO extends TenantBaseDO {

    /**
     * 标记编号
     */
    private Long id;
    /**
     * 章节ID
     */
    private Long chapterId;
    /**
     * 条目序号（从 0 开始，对应前端数组索引）
     */
    private Integer itemIndex;
    /**
     * 标记状态 0未标记 1待做 2已做到
     */
    private Integer markState;
    /**
     * 学生ID
     */
    private Long studentId;

}
