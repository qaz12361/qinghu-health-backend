package cn.iocoder.yudao.module.system.service.qinghu.waterlog;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.waterlog.vo.QhWaterLogPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.waterlog.vo.QhWaterLogSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.waterlog.QhWaterLogDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.waterlog.QhWaterLogMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 饮水打卡 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhWaterLogServiceImpl")
public class QhWaterLogServiceImpl implements QhWaterLogService {

    @Resource
    private QhWaterLogMapper qhWaterLogMapper;

    @Override
    public Long createQhWaterLog(QhWaterLogSaveReqVO createReqVO) {
        QhWaterLogDO qhWaterLog = BeanUtils.toBean(createReqVO, QhWaterLogDO.class);
        qhWaterLogMapper.insert(qhWaterLog);
        return qhWaterLog.getId();
    }

    @Override
    public void updateQhWaterLog(QhWaterLogSaveReqVO updateReqVO) {
        validateQhWaterLogExists(updateReqVO.getId());
        QhWaterLogDO updateObj = BeanUtils.toBean(updateReqVO, QhWaterLogDO.class);
        qhWaterLogMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhWaterLog(Long id) {
        validateQhWaterLogExists(id);
        qhWaterLogMapper.deleteById(id);
    }

    @Override
    public QhWaterLogDO getQhWaterLog(Long id) {
        return qhWaterLogMapper.selectById(id);
    }

    @Override
    public PageResult<QhWaterLogDO> getQhWaterLogPage(QhWaterLogPageReqVO pageReqVO) {
        return qhWaterLogMapper.selectPage(pageReqVO);
    }

    private void validateQhWaterLogExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhWaterLogMapper.selectById(id) == null) {
            throw new ServiceException(404, "饮水打卡不存在");
        }
    }

}
