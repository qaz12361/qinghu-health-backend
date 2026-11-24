package cn.iocoder.yudao.module.system.service.qinghu.wallet;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.wallet.vo.QhWalletPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.wallet.vo.QhWalletSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.wallet.QhWalletDO;

/**
 * 钱包管理 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhWalletService {

    Long createQhWallet(QhWalletSaveReqVO createReqVO);

    void updateQhWallet(QhWalletSaveReqVO updateReqVO);

    void deleteQhWallet(Long id);

    QhWalletDO getQhWallet(Long id);

    PageResult<QhWalletDO> getQhWalletPage(QhWalletPageReqVO pageReqVO);

}
