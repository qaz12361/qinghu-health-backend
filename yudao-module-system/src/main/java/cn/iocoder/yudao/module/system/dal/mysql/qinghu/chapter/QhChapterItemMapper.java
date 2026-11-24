package cn.iocoder.yudao.module.system.dal.mysql.qinghu.chapter;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo.QhChapterItemPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.chapter.QhChapterItemDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QhChapterItemMapper extends BaseMapperX<QhChapterItemDO> {

    default PageResult<QhChapterItemDO> selectPage(QhChapterItemPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<QhChapterItemDO>()
                .eqIfPresent(QhChapterItemDO::getChapterId, reqVO.getChapterId())
                .likeIfPresent(QhChapterItemDO::getTitle, reqVO.getTitle())
                .orderByAsc(QhChapterItemDO::getChapterId)
                .orderByAsc(QhChapterItemDO::getSortNo));
    }

    /**
     * 按章节取全部条目，按排序号升序（C 端 bootstrap 用）
     */
    default List<QhChapterItemDO> selectListByChapter(Long chapterId) {
        return selectList(new LambdaQueryWrapperX<QhChapterItemDO>()
                .eq(QhChapterItemDO::getChapterId, chapterId)
                .orderByAsc(QhChapterItemDO::getSortNo));
    }

    /**
     * 取全部条目，按章节 + 排序号升序（C 端 bootstrap 一次拉全量用）
     */
    default List<QhChapterItemDO> selectListAll() {
        return selectList(new LambdaQueryWrapperX<QhChapterItemDO>()
                .orderByAsc(QhChapterItemDO::getChapterId)
                .orderByAsc(QhChapterItemDO::getSortNo));
    }

}
