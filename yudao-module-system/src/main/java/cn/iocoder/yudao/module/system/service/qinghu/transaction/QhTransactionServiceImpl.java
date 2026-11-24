package cn.iocoder.yudao.module.system.service.qinghu.transaction;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.transaction.vo.QhTransactionPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.transaction.vo.QhTransactionSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.transaction.QhTransactionDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.transaction.QhTransactionMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 交易流水 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhTransactionServiceImpl")
public class QhTransactionServiceImpl implements QhTransactionService {

    @Resource
    private QhTransactionMapper qhTransactionMapper;

    @Override
    public Long createQhTransaction(QhTransactionSaveReqVO createReqVO) {
        QhTransactionDO qhTransaction = BeanUtils.toBean(createReqVO, QhTransactionDO.class);
        qhTransactionMapper.insert(qhTransaction);
        return qhTransaction.getId();
    }

    @Override
    public void updateQhTransaction(QhTransactionSaveReqVO updateReqVO) {
        validateQhTransactionExists(updateReqVO.getId());
        QhTransactionDO updateObj = BeanUtils.toBean(updateReqVO, QhTransactionDO.class);
        qhTransactionMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhTransaction(Long id) {
        validateQhTransactionExists(id);
        qhTransactionMapper.deleteById(id);
    }

    @Override
    public QhTransactionDO getQhTransaction(Long id) {
        return qhTransactionMapper.selectById(id);
    }

    @Override
    public PageResult<QhTransactionDO> getQhTransactionPage(QhTransactionPageReqVO pageReqVO) {
        return qhTransactionMapper.selectPage(pageReqVO);
    }

    private void validateQhTransactionExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhTransactionMapper.selectById(id) == null) {
            throw new ServiceException(404, "交易流水不存在");
        }
    }

}
