package cn.iocoder.yudao.module.system.service.qinghu.config;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.config.vo.QhConfigPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.config.vo.QhConfigSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.config.QhConfigDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.config.QhConfigMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 平台配置 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhConfigServiceImpl")
public class QhConfigServiceImpl implements QhConfigService {

    @Resource
    private QhConfigMapper qhConfigMapper;

    @Override
    public Long createQhConfig(QhConfigSaveReqVO createReqVO) {
        QhConfigDO qhConfig = BeanUtils.toBean(createReqVO, QhConfigDO.class);
        qhConfigMapper.insert(qhConfig);
        return qhConfig.getId();
    }

    @Override
    public void updateQhConfig(QhConfigSaveReqVO updateReqVO) {
        validateQhConfigExists(updateReqVO.getId());
        QhConfigDO updateObj = BeanUtils.toBean(updateReqVO, QhConfigDO.class);
        qhConfigMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhConfig(Long id) {
        validateQhConfigExists(id);
        qhConfigMapper.deleteById(id);
    }

    @Override
    public QhConfigDO getQhConfig(Long id) {
        return qhConfigMapper.selectById(id);
    }

    @Override
    public PageResult<QhConfigDO> getQhConfigPage(QhConfigPageReqVO pageReqVO) {
        return qhConfigMapper.selectPage(pageReqVO);
    }

    private void validateQhConfigExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhConfigMapper.selectById(id) == null) {
            throw new ServiceException(404, "平台配置不存在");
        }
    }

}
