package cn.iocoder.yudao.module.system.dal.mysql.qinghu.transaction;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.transaction.vo.QhTransactionPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.transaction.QhTransactionDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QhTransactionMapper extends BaseMapperX<QhTransactionDO> {

    default PageResult<QhTransactionDO> selectPage(QhTransactionPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhTransactionDO>()
                .likeIfPresent(QhTransactionDO::getTxNo, reqVO.getTxNo())
                .likeIfPresent(QhTransactionDO::getType, reqVO.getType())
                .orderByDesc(QhTransactionDO::getId));
    }

}
