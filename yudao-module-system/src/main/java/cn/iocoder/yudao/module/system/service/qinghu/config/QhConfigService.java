package cn.iocoder.yudao.module.system.service.qinghu.config;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.config.vo.QhConfigPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.config.vo.QhConfigSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.config.QhConfigDO;

/**
 * 平台配置 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhConfigService {

    Long createQhConfig(QhConfigSaveReqVO createReqVO);

    void updateQhConfig(QhConfigSaveReqVO updateReqVO);

    void deleteQhConfig(Long id);

    QhConfigDO getQhConfig(Long id);

    PageResult<QhConfigDO> getQhConfigPage(QhConfigPageReqVO pageReqVO);

}
