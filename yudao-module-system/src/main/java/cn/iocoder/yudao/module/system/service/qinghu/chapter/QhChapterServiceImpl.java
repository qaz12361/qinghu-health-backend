package cn.iocoder.yudao.module.system.service.qinghu.chapter;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo.QhChapterItemPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo.QhChapterItemSaveReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo.QhChapterPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.qinghu.chapter.vo.QhChapterSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.chapter.QhChapterDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.chapter.QhChapterItemDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.chapter.QhChapterMarkDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.chapter.QhChapterItemMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.chapter.QhChapterMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.chapter.QhChapterMarkMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 循证健康指南 Service 实现类
 *
 * @author 芋道 + 本地扩展
 */
@Service("qhChapterServiceImpl")
public class QhChapterServiceImpl implements QhChapterService {

    @Resource
    private QhChapterMapper qhChapterMapper;
    @Resource
    private QhChapterItemMapper qhChapterItemMapper;
    @Resource
    private QhChapterMarkMapper qhChapterMarkMapper;

    // ========== 章节 ==========

    @Override
    public Long createQhChapter(QhChapterSaveReqVO createReqVO) {
        QhChapterDO chapter = BeanUtils.toBean(createReqVO, QhChapterDO.class);
        qhChapterMapper.insert(chapter);
        return chapter.getId();
    }

    @Override
    public void updateQhChapter(QhChapterSaveReqVO updateReqVO) {
        validateQhChapterExists(updateReqVO.getId());
        QhChapterDO updateObj = BeanUtils.toBean(updateReqVO, QhChapterDO.class);
        qhChapterMapper.updateById(updateObj);
    }

    @Override
    public void deleteQhChapter(Long id) {
        validateQhChapterExists(id);
        qhChapterMapper.deleteById(id);
        // 级联删除该章节下的条目
        qhChapterItemMapper.delete(new com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper<QhChapterItemDO>()
                .eq(QhChapterItemDO::getChapterId, id));
    }

    @Override
    public QhChapterDO getQhChapter(Long id) {
        return qhChapterMapper.selectById(id);
    }

    @Override
    public PageResult<QhChapterDO> getQhChapterPage(QhChapterPageReqVO pageReqVO) {
        return qhChapterMapper.selectPage(pageReqVO);
    }

    @Override
    public List<QhChapterDO> getQhChapterList() {
        return qhChapterMapper.selectListByNumAsc();
    }

    private void validateQhChapterExists(Long id) {
        if (id == null) {
            return;
        }
        if (qhChapterMapper.selectById(id) == null) {
            throw new ServiceException(404, "章节不存在");
        }
    }

    // ========== 建议条目 ==========

    @Override
    public Long createQhChapterItem(QhChapterItemSaveReqVO createReqVO) {
        validateQhChapterItemChapter(createReqVO.getChapterId());
        QhChapterItemDO item = BeanUtils.toBean(createReqVO, QhChapterItemDO.class);
        qhChapterItemMapper.insert(item);
        refreshChapterItemCount(createReqVO.getChapterId());
        return item.getId();
    }

    @Override
    public void updateQhChapterItem(QhChapterItemSaveReqVO updateReqVO) {
        if (qhChapterItemMapper.selectById(updateReqVO.getId()) == null) {
            throw new ServiceException(404, "建议条目不存在");
        }
        QhChapterItemDO updateObj = BeanUtils.toBean(updateReqVO, QhChapterItemDO.class);
        qhChapterItemMapper.updateById(updateObj);
        if (updateReqVO.getChapterId() != null) {
            refreshChapterItemCount(updateReqVO.getChapterId());
        }
    }

    @Override
    public void deleteQhChapterItem(Long id) {
        QhChapterItemDO item = qhChapterItemMapper.selectById(id);
        if (item == null) {
            throw new ServiceException(404, "建议条目不存在");
        }
        qhChapterItemMapper.deleteById(id);
        refreshChapterItemCount(item.getChapterId());
    }

    @Override
    public PageResult<QhChapterItemDO> getQhChapterItemPage(QhChapterItemPageReqVO pageReqVO) {
        return qhChapterItemMapper.selectPage(pageReqVO);
    }

    @Override
    public List<QhChapterItemDO> getQhChapterItemList(Long chapterId) {
        return qhChapterItemMapper.selectListByChapter(chapterId);
    }

    @Override
    public List<QhChapterItemDO> getQhChapterItemListAll() {
        return qhChapterItemMapper.selectListAll();
    }

    private void validateQhChapterItemChapter(Long chapterId) {
        if (chapterId == null || qhChapterMapper.selectById(chapterId) == null) {
            throw new ServiceException(404, "章节不存在");
        }
    }

    /**
     * 条目增删后同步章节上的 item_count，保持冗余计数与实际一致
     */
    private void refreshChapterItemCount(Long chapterId) {
        if (chapterId == null) {
            return;
        }
        QhChapterDO chapter = qhChapterMapper.selectById(chapterId);
        if (chapter == null) {
            return;
        }
        Integer count = Math.toIntExact(qhChapterItemMapper.selectCount(
                new com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper<QhChapterItemDO>()
                        .eq(QhChapterItemDO::getChapterId, chapterId)));
        QhChapterDO update = new QhChapterDO();
        update.setId(chapterId);
        update.setItemCount(count);
        qhChapterMapper.updateById(update);
    }

    // ========== 标记进度 ==========

    @Override
    public Map<String, Integer> getQhChapterMarks(Long studentId) {
        List<QhChapterMarkDO> marks = qhChapterMarkMapper.selectListByStudent(studentId);
        Map<String, Integer> map = new HashMap<>();
        for (QhChapterMarkDO m : marks) {
            map.put(m.getChapterId() + "-" + m.getItemIndex(), m.getMarkState());
        }
        return map;
    }

    @Override
    public void setQhChapterMark(Long chapterId, Integer itemIndex, Integer state, Long studentId) {
        if (chapterId == null || itemIndex == null || studentId == null) {
            throw new ServiceException(400, "参数不完整");
        }
        if (state != null && (state < 0 || state > 2)) {
            throw new ServiceException(400, "标记状态不合法");
        }
        // state = 0 表示取消标记
        if (state != null && state == 0) {
            QhChapterMarkDO exist = qhChapterMarkMapper.selectByKey(chapterId, itemIndex, studentId);
            if (exist != null) {
                qhChapterMarkMapper.deleteById(exist.getId());
            }
            return;
        }
        QhChapterMarkDO exist = qhChapterMarkMapper.selectByKey(chapterId, itemIndex, studentId);
        if (exist == null) {
            QhChapterMarkDO mark = new QhChapterMarkDO();
            mark.setChapterId(chapterId);
            mark.setItemIndex(itemIndex);
            mark.setMarkState(state);
            mark.setStudentId(studentId);
            qhChapterMarkMapper.insert(mark);
        } else {
            QhChapterMarkDO update = new QhChapterMarkDO();
            update.setId(exist.getId());
            update.setMarkState(state);
            qhChapterMarkMapper.updateById(update);
        }
    }

}
