package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.chapter;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 循证健康指南 - 章节 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_chapter")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhChapterDO extends TenantBaseDO {

    /**
     * 章节编号
     */
    private Long id;
    /**
     * 章序号
     */
    private Integer num;
    /**
     * 章节标题
     */
    private String title;
    /**
     * 封面图序号
     */
    private Integer cover;
    /**
     * 章节摘要
     */
    private String summary;
    /**
     * 章节正文
     */
    private String content;
    /**
     * 建议条数
     */
    private Integer itemCount;

}
