package cn.iocoder.yudao.module.system.dal.mysql.qinghu.chapter;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.chapter.QhChapterMarkDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QhChapterMarkMapper extends BaseMapperX<QhChapterMarkDO> {

    /**
     * 按学生取全部标记（C 端 bootstrap 用）
     */
    default List<QhChapterMarkDO> selectListByStudent(Long studentId) {
        return selectList(new LambdaQueryWrapperX<QhChapterMarkDO>()
                .eq(QhChapterMarkDO::getStudentId, studentId)
                .orderByAsc(QhChapterMarkDO::getChapterId)
                .orderByAsc(QhChapterMarkDO::getItemIndex));
    }

    /**
     * 按章节 + 条目序号 + 学生取单条标记
     */
    default QhChapterMarkDO selectByKey(Long chapterId, Integer itemIndex, Long studentId) {
        return selectOne(new LambdaQueryWrapperX<QhChapterMarkDO>()
                .eq(QhChapterMarkDO::getChapterId, chapterId)
                .eq(QhChapterMarkDO::getItemIndex, itemIndex)
                .eq(QhChapterMarkDO::getStudentId, studentId));
    }

}
