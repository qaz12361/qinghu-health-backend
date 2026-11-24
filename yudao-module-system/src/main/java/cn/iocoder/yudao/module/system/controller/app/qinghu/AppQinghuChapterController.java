package cn.iocoder.yudao.module.system.controller.app.qinghu;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.chapter.QhChapterDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.chapter.QhChapterItemDO;
import cn.iocoder.yudao.module.system.service.qinghu.chapter.QhChapterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * 用户 App - 循证健康指南
 * <p>
 * 章节与建议条目通过 bootstrap 全量下发（见 AppQinghuDataController），
 * 这里只提供标记进度的写入接口。
 *
 * @author 芋道 + 本地扩展
 */
@Tag(name = "用户 App - 循证健康指南")
@RestController
@RequestMapping("/qinghu")
@PermitAll
public class AppQinghuChapterController {

    /** C 端当前登录学生ID；接入登录态后改为从 SecurityContext / member 取 */
    private static final Long CURRENT_STUDENT_ID = 1L;

    @Resource
    private QhChapterService qhChapterService;

    /**
     * 取某章详情（含建议条目），供 C 端章节详情抽屉使用
     */
    @GetMapping("/chapters/{id}")
    @Operation(summary = "获得章节详情")
    public CommonResult<Map<String, Object>> getChapterDetail(@Parameter(description = "章节编号", required = true)
                                                              @PathVariable("id") Long id) {
        QhChapterDO chapter = qhChapterService.getQhChapter(id);
        Map<String, Object> d = new LinkedHashMap<>();
        if (chapter != null) {
            d.put("id", chapter.getId());
            d.put("num", chapter.getNum());
            d.put("title", chapter.getTitle());
            d.put("cover", chapter.getCover());
            d.put("summary", chapter.getSummary());
            d.put("content", chapter.getContent());
            d.put("count", chapter.getItemCount());
        }
        List<QhChapterItemDO> items = qhChapterService.getQhChapterItemList(id);
        d.put("items", items.stream().map(it -> {
            Map<String, Object> m = new LinkedHashMap<>();
            m.put("sortNo", it.getSortNo());
            m.put("title", it.getTitle());
            m.put("detail", it.getDetail());
            m.put("level", it.getLevel());
            return m;
        }).collect(java.util.stream.Collectors.toList()));
        return success(d);
    }

    /**
     * 设置/更新一条标记进度。
     * state: 0 取消标记 / 1 待做 / 2 已做到
     */
    @PostMapping("/chapters/mark")
    @Operation(summary = "设置章节标记进度")
    public CommonResult<Boolean> setChapterMark(@RequestBody Map<String, Object> body) {
        Long chapterId = body.get("chapterId") == null ? null
                : Long.valueOf(String.valueOf(body.get("chapterId")));
        Integer itemIndex = body.get("itemIndex") == null ? null
                : Integer.valueOf(String.valueOf(body.get("itemIndex")));
        Integer state = body.get("state") == null ? null
                : Integer.valueOf(String.valueOf(body.get("state")));
        qhChapterService.setQhChapterMark(chapterId, itemIndex, state, CURRENT_STUDENT_ID);
        return success(true);
    }

}
