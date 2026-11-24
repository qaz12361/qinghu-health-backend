package cn.iocoder.yudao.module.system.dal.mysql.qinghu.chapter;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo.QhChapterPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.chapter.QhChapterDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QhChapterMapper extends BaseMapperX<QhChapterDO> {

    default PageResult<QhChapterDO> selectPage(QhChapterPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhChapterDO>()
                .likeIfPresent(QhChapterDO::getTitle, reqVO.getTitle())
                .orderByAsc(QhChapterDO::getNum));
    }

    /**
     * 按章序号升序取全部章节（C 端 bootstrap 用）
     */
    default List<QhChapterDO> selectListByNumAsc() {
        return selectList(new LambdaQueryWrapperX<QhChapterDO>().orderByAsc(QhChapterDO::getNum));
    }

}
