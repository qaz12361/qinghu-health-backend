package cn.iocoder.yudao.module.system.service.qinghu.wallet;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.wallet.vo.QhWalletPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.wallet.vo.QhWalletSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.wallet.QhWalletDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.wallet.QhWalletMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 钱包管理 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhWalletServiceImpl")
public class QhWalletServiceImpl implements QhWalletService {

    @Resource
    private QhWalletMapper qhWalletMapper;

    @Override
    public Long createQhWallet(QhWalletSaveReqVO createReqVO) {
        QhWalletDO qhWallet = BeanUtils.toBean(createReqVO, QhWalletDO.class);
        qhWalletMapper.insert(qhWallet);
        return qhWallet.getId();
    }

    @Override
    public void updateQhWallet(QhWalletSaveReqVO updateReqVO) {
        validateQhWalletExists(updateReqVO.getId());
        QhWalletDO updateObj = BeanUtils.toBean(updateReqVO, QhWalletDO.class);
        qhWalletMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhWallet(Long id) {
        validateQhWalletExists(id);
        qhWalletMapper.deleteById(id);
    }

    @Override
    public QhWalletDO getQhWallet(Long id) {
        return qhWalletMapper.selectById(id);
    }

    @Override
    public PageResult<QhWalletDO> getQhWalletPage(QhWalletPageReqVO pageReqVO) {
        return qhWalletMapper.selectPage(pageReqVO);
    }

    private void validateQhWalletExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhWalletMapper.selectById(id) == null) {
            throw new ServiceException(404, "钱包管理不存在");
        }
    }

}
