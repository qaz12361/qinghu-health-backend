package cn.iocoder.yudao.module.system.dal.dataobject.qinghu.knowledgepoint;

import cn.iocoder.yudao.framework.tenant.core.db.TenantBaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;



/**
 * 知识要点 DO
 *
 * @author 芋道 + 本地扩展
 */
@TableName("qh_knowledge_point")
@Data
@EqualsAndHashCode(callSuper = true)
public class QhKnowledgePointDO extends TenantBaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 所属知识编号
     */
    private Long knowledgeId;
    /**
     * 排序号
     */
    private Integer sortNo;
    /**
     * 要点标题
     */
    private String point;
    /**
     * 要点说明
     */
    private String detail;
    /**
     * 重要级别 A/B/C
     */
    private String level;

}
