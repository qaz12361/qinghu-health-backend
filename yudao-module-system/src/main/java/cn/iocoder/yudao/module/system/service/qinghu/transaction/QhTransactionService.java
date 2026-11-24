package cn.iocoder.yudao.module.system.service.qinghu.transaction;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.transaction.vo.QhTransactionPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.transaction.vo.QhTransactionSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.transaction.QhTransactionDO;

/**
 * 交易流水 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhTransactionService {

    Long createQhTransaction(QhTransactionSaveReqVO createReqVO);

    void updateQhTransaction(QhTransactionSaveReqVO updateReqVO);

    void deleteQhTransaction(Long id);

    QhTransactionDO getQhTransaction(Long id);

    PageResult<QhTransactionDO> getQhTransactionPage(QhTransactionPageReqVO pageReqVO);

}
