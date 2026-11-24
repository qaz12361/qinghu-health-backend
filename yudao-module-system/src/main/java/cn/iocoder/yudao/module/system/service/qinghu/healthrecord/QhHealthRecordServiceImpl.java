package cn.iocoder.yudao.module.system.service.qinghu.healthrecord;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.healthrecord.vo.QhHealthRecordPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.healthrecord.vo.QhHealthRecordSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.healthrecord.QhHealthRecordDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.healthrecord.QhHealthRecordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 健康记录 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhHealthRecordServiceImpl")
public class QhHealthRecordServiceImpl implements QhHealthRecordService {

    @Resource
    private QhHealthRecordMapper qhHealthRecordMapper;

    @Override
    public Long createQhHealthRecord(QhHealthRecordSaveReqVO createReqVO) {
        QhHealthRecordDO qhHealthRecord = BeanUtils.toBean(createReqVO, QhHealthRecordDO.class);
        qhHealthRecordMapper.insert(qhHealthRecord);
        return qhHealthRecord.getId();
    }

    @Override
    public void updateQhHealthRecord(QhHealthRecordSaveReqVO updateReqVO) {
        validateQhHealthRecordExists(updateReqVO.getId());
        QhHealthRecordDO updateObj = BeanUtils.toBean(updateReqVO, QhHealthRecordDO.class);
        qhHealthRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhHealthRecord(Long id) {
        validateQhHealthRecordExists(id);
        qhHealthRecordMapper.deleteById(id);
    }

    @Override
    public QhHealthRecordDO getQhHealthRecord(Long id) {
        return qhHealthRecordMapper.selectById(id);
    }

    @Override
    public PageResult<QhHealthRecordDO> getQhHealthRecordPage(QhHealthRecordPageReqVO pageReqVO) {
        return qhHealthRecordMapper.selectPage(pageReqVO);
    }

    private void validateQhHealthRecordExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhHealthRecordMapper.selectById(id) == null) {
            throw new ServiceException(404, "健康记录不存在");
        }
    }

}
