package cn.iocoder.yudao.module.system.dal.mysql.qinghu.wallet;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.wallet.vo.QhWalletPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.wallet.QhWalletDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhWalletMapper extends BaseMapperX<QhWalletDO> {

    default PageResult<QhWalletDO> selectPage(QhWalletPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhWalletDO>()
                .likeIfPresent(QhWalletDO::getOwner, reqVO.getOwner())
                .orderByDesc(QhWalletDO::getId));
    }

}
