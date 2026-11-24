package cn.iocoder.yudao.module.system.service.qinghu.waterlog;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.waterlog.vo.QhWaterLogPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.waterlog.vo.QhWaterLogSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.waterlog.QhWaterLogDO;

/**
 * 饮水打卡 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhWaterLogService {

    Long createQhWaterLog(QhWaterLogSaveReqVO createReqVO);

    void updateQhWaterLog(QhWaterLogSaveReqVO updateReqVO);

    void deleteQhWaterLog(Long id);

    QhWaterLogDO getQhWaterLog(Long id);

    PageResult<QhWaterLogDO> getQhWaterLogPage(QhWaterLogPageReqVO pageReqVO);

}
