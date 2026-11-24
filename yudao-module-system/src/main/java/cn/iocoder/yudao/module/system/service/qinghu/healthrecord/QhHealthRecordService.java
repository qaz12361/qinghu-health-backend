package cn.iocoder.yudao.module.system.service.qinghu.healthrecord;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.healthrecord.vo.QhHealthRecordPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.healthrecord.vo.QhHealthRecordSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.healthrecord.QhHealthRecordDO;

/**
 * 健康记录 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhHealthRecordService {

    Long createQhHealthRecord(QhHealthRecordSaveReqVO createReqVO);

    void updateQhHealthRecord(QhHealthRecordSaveReqVO updateReqVO);

    void deleteQhHealthRecord(Long id);

    QhHealthRecordDO getQhHealthRecord(Long id);

    PageResult<QhHealthRecordDO> getQhHealthRecordPage(QhHealthRecordPageReqVO pageReqVO);

}
