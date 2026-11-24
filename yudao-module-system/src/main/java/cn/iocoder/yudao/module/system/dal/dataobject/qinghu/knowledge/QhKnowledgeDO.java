package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.knowledge;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;



/**
 * 健康知识 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_knowledge")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhKnowledgeDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 分类
     */
    private String cat;
    /**
     * 封面主题键
     */
    private String cover;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 正文
     */
    private String content;

}
