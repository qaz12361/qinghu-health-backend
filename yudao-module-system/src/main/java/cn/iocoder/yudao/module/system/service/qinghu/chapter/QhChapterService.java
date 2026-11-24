package cn.iocoder.yudao.module.system.service.qinghu.chapter;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo.QhChapterItemPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo.QhChapterItemSaveReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo.QhChapterPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo.QhChapterSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.chapter.QhChapterDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.chapter.QhChapterItemDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.chapter.QhChapterMarkDO;

import java.util.List;
import java.util.Map;

/**
 * 循证健康指南 Service 接口
 *
 * @author 芋道 + 本地扩展
 */
public interface QhChapterService {

    // ========== 章节 ==========

    Long createQhChapter(QhChapterSaveReqVO createReqVO);

    void updateQhChapter(QhChapterSaveReqVO updateReqVO);

    void deleteQhChapter(Long id);

    QhChapterDO getQhChapter(Long id);

    PageResult<QhChapterDO> getQhChapterPage(QhChapterPageReqVO pageReqVO);

    List<QhChapterDO> getQhChapterList();

    // ========== 建议条目 ==========

    Long createQhChapterItem(QhChapterItemSaveReqVO createReqVO);

    void updateQhChapterItem(QhChapterItemSaveReqVO updateReqVO);

    void deleteQhChapterItem(Long id);

    PageResult<QhChapterItemDO> getQhChapterItemPage(QhChapterItemPageReqVO pageReqVO);

    List<QhChapterItemDO> getQhChapterItemList(Long chapterId);

    List<QhChapterItemDO> getQhChapterItemListAll();

    // ========== 标记进度 ==========

    /**
     * 取某学生的全部标记，返回 Map<"chapterId-itemIndex", markState>
     */
    Map<String, Integer> getQhChapterMarks(Long studentId);

    /**
     * 设置/更新某一条标记。state=0 表示取消标记（删除记录）
     */
    void setQhChapterMark(Long chapterId, Integer itemIndex, Integer state, Long studentId);

}
