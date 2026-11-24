package cn.iocoder.yudao.module.system.controller.app.qinghu;

import cn.hutool.json.JSONUtil;
import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coach.QhCoachDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachbooking.QhCoachBookingDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachplan.QhCoachPlanDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachservice.QhCoachServiceDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.config.QhConfigDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.course.QhCourseDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.healthgoal.QhHealthGoalDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.healthrecord.QhHealthRecordDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.knowledge.QhKnowledgeDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.knowledgepoint.QhKnowledgePointDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.chapter.QhChapterDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.chapter.QhChapterItemDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.notice.QhNoticeDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.notification.QhNotificationDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.plan.QhPlanDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.profile.QhProfileDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.reminder.QhReminderDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.student.QhStudentDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.studentcourse.QhStudentCourseDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.transaction.QhTransactionDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.user.QhUserDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.wallet.QhWalletDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.waterlog.QhWaterLogDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.coach.QhCoachMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.coachbooking.QhCoachBookingMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.coachplan.QhCoachPlanMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.coachservice.QhCoachServiceMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.config.QhConfigMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.course.QhCourseMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.healthgoal.QhHealthGoalMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.healthrecord.QhHealthRecordMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.knowledge.QhKnowledgeMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.knowledgepoint.QhKnowledgePointMapper;
import cn.iocoder.yudao.module.system.service.qinghu.chapter.QhChapterService;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.notice.QhNoticeMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.notification.QhNotificationMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.plan.QhPlanMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.profile.QhProfileMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.reminder.QhReminderMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.student.QhStudentMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.studentcourse.QhStudentCourseMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.transaction.QhTransactionMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.user.QhUserMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.wallet.QhWalletMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.waterlog.QhWaterLogMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * 用户 App - 青护健康管理（毕业设计原型数据接口）
 *
 * 与「毕设/index.html」内部 DATA 结构逐字段对齐：一次性 bootstrap 拉全量，
 * 各资源提供增删改，保证原型页面里的操作落到 qh_ 真表。
 */
@Tag(name = "用户 App - 青护原型数据")
@RestController("appQinghuDataController")
@RequestMapping("/qinghu")
@PermitAll
@Validated
@SuppressWarnings("unchecked")
public class AppQinghuDataController {

    private static final Long CURRENT_STUDENT_ID = 1L;
    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Resource
    private QhHealthRecordMapper qhRecordMapper;
    @Resource
    private QhHealthGoalMapper qhGoalMapper;
    @Resource
    private QhReminderMapper qhReminderMapper;
    @Resource
    private QhKnowledgeMapper qhKnowledgeMapper;
    @Resource
    private QhKnowledgePointMapper qhPointMapper;
    @Resource
    private QhChapterService qhChapterService;
    @Resource
    private QhNoticeMapper qhNoticeMapper;
    @Resource
    private QhUserMapper qhUserMapper;
    @Resource
    private QhCourseMapper qhCourseMapper;
    @Resource
    private QhStudentCourseMapper qhStudentCourseMapper;
    @Resource
    private QhPlanMapper qhPlanMapper;
    @Resource
    private QhCoachPlanMapper qhCoachPlanMapper;
    @Resource
    private QhCoachBookingMapper qhBookingMapper;
    @Resource
    private QhCoachMapper qhCoachMapper;
    @Resource
    private QhCoachServiceMapper qhServiceMapper;
    @Resource
    private QhStudentMapper qhStudentMapper;
    @Resource
    private QhNotificationMapper qhNotificationMapper;
    @Resource
    private QhProfileMapper qhProfileMapper;
    @Resource
    private QhTransactionMapper qhTransactionMapper;
    @Resource
    private QhWalletMapper qhWalletMapper;
    @Resource
    private QhWaterLogMapper qhWaterLogMapper;
    @Resource
    private QhConfigMapper qhConfigMapper;

    // =========================================================
    // 一次性拉取原型全量数据
    // =========================================================
    @GetMapping("/bootstrap")
    @Operation(summary = "原型全量数据")
    public CommonResult<Map<String, Object>> bootstrap() {
        Map<String, Object> d = new LinkedHashMap<>();

        d.put("records", qhRecordMapper.selectList(new LambdaQueryWrapper<QhHealthRecordDO>()
                        .eq(QhHealthRecordDO::getStudentId, CURRENT_STUDENT_ID)
                        .orderByDesc(QhHealthRecordDO::getRecordDate).orderByDesc(QhHealthRecordDO::getId))
                .stream().map(this::recordMap).collect(Collectors.toList()));

        d.put("goals", qhGoalMapper.selectList(new LambdaQueryWrapper<QhHealthGoalDO>().orderByAsc(QhHealthGoalDO::getId))
                .stream().map(this::goalMap).collect(Collectors.toList()));

        d.put("reminders", qhReminderMapper.selectList(new LambdaQueryWrapper<QhReminderDO>().orderByAsc(QhReminderDO::getId))
                .stream().map(this::reminderMap).collect(Collectors.toList()));

        d.put("knowledge", qhKnowledgeMapper.selectList(new LambdaQueryWrapper<QhKnowledgeDO>().orderByAsc(QhKnowledgeDO::getId))
                .stream().map(this::knowledgeMap).collect(Collectors.toList()));

        // 循证健康指南：章节 + 建议条目 + 用户标记进度
        d.put("chapters", qhChapterService.getQhChapterList().stream()
                .map(this::chapterMap).collect(Collectors.toList()));
        d.put("chapterItems", qhChapterService.getQhChapterItemListAll().stream()
                .map(this::chapterItemMap).collect(Collectors.toList()));
        d.put("kbMarks", qhChapterService.getQhChapterMarks(CURRENT_STUDENT_ID));

        d.put("students", qhStudentMapper.selectList(new LambdaQueryWrapper<QhStudentDO>().orderByAsc(QhStudentDO::getId))
                .stream().map(this::studentMap).collect(Collectors.toList()));

        d.put("plans", qhPlanMapper.selectList(new LambdaQueryWrapper<QhPlanDO>().orderByAsc(QhPlanDO::getId))
                .stream().map(this::planMap).collect(Collectors.toList()));

        d.put("users", qhUserMapper.selectList(new LambdaQueryWrapper<QhUserDO>().orderByAsc(QhUserDO::getId))
                .stream().map(this::userMap).collect(Collectors.toList()));

        d.put("notices", qhNoticeMapper.selectList(new LambdaQueryWrapper<QhNoticeDO>()
                        .orderByDesc(QhNoticeDO::getIsTop).orderByDesc(QhNoticeDO::getPublishTime))
                .stream().map(this::noticeMap).collect(Collectors.toList()));

        QhProfileDO p = qhProfileMapper.selectById(CURRENT_STUDENT_ID);
        d.put("profile", profileMap(p));

        // 饮水：{日期: ml}
        Map<String, Object> water = new LinkedHashMap<>();
        for (QhWaterLogDO w : qhWaterLogMapper.selectList(new LambdaQueryWrapper<QhWaterLogDO>()
                .orderByAsc(QhWaterLogDO::getLogDate))) {
            water.put(ds(w.getLogDate()), w.getAmount());
        }
        d.put("waterLog", water);
        d.put("waterGoal", configInt("water_goal", 2000));
        d.put("commissionRate", configDecimal("commission_rate", new BigDecimal("0.15")));

        d.put("notifications", qhNotificationMapper.selectList(new LambdaQueryWrapper<QhNotificationDO>()
                        .orderByDesc(QhNotificationDO::getId))
                .stream().map(this::notificationMap).collect(Collectors.toList()));

        d.put("wallets", walletsMap());

        d.put("courses", qhCourseMapper.selectList(new LambdaQueryWrapper<QhCourseDO>().orderByAsc(QhCourseDO::getId))
                .stream().map(this::courseMap).collect(Collectors.toList()));

        d.put("studentCourses", qhStudentCourseMapper.selectList(new LambdaQueryWrapper<QhStudentCourseDO>()
                        .eq(QhStudentCourseDO::getStudentId, CURRENT_STUDENT_ID).orderByAsc(QhStudentCourseDO::getId))
                .stream().map(sc -> mapOf("courseId", sc.getCourseId(),
                        "buyTime", ds(sc.getBuyTime()), "progress", sc.getProgress()))
                .collect(Collectors.toList()));

        d.put("transactions", qhTransactionMapper.selectList(new LambdaQueryWrapper<QhTransactionDO>()
                        .orderByDesc(QhTransactionDO::getTxTime).orderByDesc(QhTransactionDO::getId))
                .stream().map(this::txMap).collect(Collectors.toList()));

        d.put("coaches", qhCoachMapper.selectList(new LambdaQueryWrapper<QhCoachDO>().orderByAsc(QhCoachDO::getId))
                .stream().map(this::coachMap).collect(Collectors.toList()));

        d.put("coachServices", qhServiceMapper.selectList(new LambdaQueryWrapper<QhCoachServiceDO>().orderByAsc(QhCoachServiceDO::getId))
                .stream().map(this::serviceMap).collect(Collectors.toList()));

        d.put("coachBookings", qhBookingMapper.selectList(new LambdaQueryWrapper<QhCoachBookingDO>().orderByAsc(QhCoachBookingDO::getId))
                .stream().map(this::bookingMap).collect(Collectors.toList()));

        d.put("coachPlans", qhCoachPlanMapper.selectList(new LambdaQueryWrapper<QhCoachPlanDO>().orderByAsc(QhCoachPlanDO::getId))
                .stream().map(this::coachPlanMap).collect(Collectors.toList()));

        return success(d);
    }

    // =========================================================
    // 健康目标
    // =========================================================
    @PostMapping("/goals")
    public CommonResult<Map<String, Object>> createGoal(@RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhHealthGoalDO g = new QhHealthGoalDO();
        g.setName(strVal(body.get("name"), ""));
        g.setCurrentValue(decVal(body.get("current")));
        g.setTargetValue(decVal(body.get("target")));
        g.setUnit(strVal(body.get("unit"), ""));
        g.setDeadline(strVal(body.get("deadline"), ""));
        g.setStatus(strVal(body.get("status"), "进行中"));
        qhGoalMapper.insert(g);
        return success(goalMap(g));
    }

    @PutMapping("/goals/{id}")
    public CommonResult<Map<String, Object>> updateGoal(@PathVariable("id") Long id,
                                                        @RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhHealthGoalDO g = require(qhGoalMapper.selectById(id), "目标不存在");
        if (body.get("name") != null) g.setName(String.valueOf(body.get("name")));
        if (body.get("current") != null) g.setCurrentValue(decVal(body.get("current")));
        if (body.get("target") != null) g.setTargetValue(decVal(body.get("target")));
        if (body.get("unit") != null) g.setUnit(String.valueOf(body.get("unit")));
        if (body.get("deadline") != null) g.setDeadline(String.valueOf(body.get("deadline")));
        if (body.get("status") != null) g.setStatus(String.valueOf(body.get("status")));
        qhGoalMapper.updateById(g);
        return success(goalMap(g));
    }

    @DeleteMapping("/goals/{id}")
    public CommonResult<Boolean> deleteGoal(@PathVariable("id") Long id) {
        qhGoalMapper.deleteById(id);
        return success(true);
    }

    // =========================================================
    // 提醒
    // =========================================================
    @PostMapping("/reminders")
    public CommonResult<Map<String, Object>> createReminder(@RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhReminderDO r = new QhReminderDO();
        r.setTitle(strVal(body.get("title"), ""));
        r.setRemindTime(strVal(body.get("time"), "08:00"));
        r.setType(strVal(body.get("type"), "运动"));
        r.setEnabled(boolVal(body.get("enable"), true));
        qhReminderMapper.insert(r);
        return success(reminderMap(r));
    }

    @PutMapping("/reminders/{id}")
    public CommonResult<Map<String, Object>> updateReminder(@PathVariable("id") Long id,
                                                            @RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhReminderDO r = require(qhReminderMapper.selectById(id), "提醒不存在");
        if (body.get("title") != null) r.setTitle(String.valueOf(body.get("title")));
        if (body.get("time") != null) r.setRemindTime(String.valueOf(body.get("time")));
        if (body.get("type") != null) r.setType(String.valueOf(body.get("type")));
        if (body.get("enable") != null) r.setEnabled(boolVal(body.get("enable"), true));
        qhReminderMapper.updateById(r);
        return success(reminderMap(r));
    }

    @DeleteMapping("/reminders/{id}")
    public CommonResult<Boolean> deleteReminder(@PathVariable("id") Long id) {
        qhReminderMapper.deleteById(id);
        return success(true);
    }

    // =========================================================
    // 健康知识
    // =========================================================
    @PostMapping("/knowledge")
    public CommonResult<Map<String, Object>> createKnowledge(@RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhKnowledgeDO k = new QhKnowledgeDO();
        k.setTitle(strVal(body.get("title"), ""));
        k.setCat(strVal(body.get("cat"), "运动"));
        k.setCover(strVal(body.get("cover"), "campus"));
        k.setSummary(strVal(body.get("summary"), ""));
        k.setContent(strVal(body.get("content"), strVal(body.get("summary"), "")));
        qhKnowledgeMapper.insert(k);
        writePoints(k.getId(), body.get("points"));
        return success(knowledgeMap(k));
    }

    @PutMapping("/knowledge/{id}")
    public CommonResult<Map<String, Object>> updateKnowledge(@PathVariable("id") Long id,
                                                             @RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhKnowledgeDO k = require(qhKnowledgeMapper.selectById(id), "知识不存在");
        if (body.get("title") != null) k.setTitle(String.valueOf(body.get("title")));
        if (body.get("cat") != null) k.setCat(String.valueOf(body.get("cat")));
        if (body.get("cover") != null) k.setCover(String.valueOf(body.get("cover")));
        if (body.get("summary") != null) k.setSummary(String.valueOf(body.get("summary")));
        if (body.get("content") != null) k.setContent(String.valueOf(body.get("content")));
        qhKnowledgeMapper.updateById(k);
        if (body.get("points") != null) {
            qhPointMapper.delete(new LambdaQueryWrapper<QhKnowledgePointDO>().eq(QhKnowledgePointDO::getKnowledgeId, id));
            writePoints(id, body.get("points"));
        }
        return success(knowledgeMap(k));
    }

    @DeleteMapping("/knowledge/{id}")
    public CommonResult<Boolean> deleteKnowledge(@PathVariable("id") Long id) {
        qhPointMapper.delete(new LambdaQueryWrapper<QhKnowledgePointDO>().eq(QhKnowledgePointDO::getKnowledgeId, id));
        qhKnowledgeMapper.deleteById(id);
        return success(true);
    }

    private void writePoints(Long kid, Object points) {
        if (!(points instanceof List)) {
            return;
        }
        int i = 1;
        for (Object o : (List<Object>) points) {
            if (!(o instanceof List)) {
                continue;
            }
            List<Object> p = (List<Object>) o;
            QhKnowledgePointDO kp = new QhKnowledgePointDO();
            kp.setKnowledgeId(kid);
            kp.setSortNo(i++);
            kp.setPoint(p.size() > 0 ? String.valueOf(p.get(0)) : "");
            kp.setDetail(p.size() > 1 ? String.valueOf(p.get(1)) : "");
            kp.setLevel(p.size() > 2 ? String.valueOf(p.get(2)) : "B");
            qhPointMapper.insert(kp);
        }
    }

    // =========================================================
    // 公告
    // =========================================================
    @PostMapping("/notices")
    public CommonResult<Map<String, Object>> createNotice(@RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhNoticeDO n = new QhNoticeDO();
        n.setTitle(strVal(body.get("title"), ""));
        n.setPublisher(strVal(body.get("publisher"), "管理员"));
        n.setPublishTime(body.get("time") != null ? parseDate(String.valueOf(body.get("time"))) : LocalDate.now());
        n.setIsTop(boolVal(body.get("top"), false));
        n.setStatus(strVal(body.get("status"), "已发布"));
        n.setContent(strVal(body.get("content"), ""));
        qhNoticeMapper.insert(n);
        return success(noticeMap(n));
    }

    @PutMapping("/notices/{id}")
    public CommonResult<Map<String, Object>> updateNotice(@PathVariable("id") Long id,
                                                          @RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhNoticeDO n = require(qhNoticeMapper.selectById(id), "公告不存在");
        if (body.get("title") != null) n.setTitle(String.valueOf(body.get("title")));
        if (body.get("publisher") != null) n.setPublisher(String.valueOf(body.get("publisher")));
        if (body.get("time") != null) n.setPublishTime(parseDate(String.valueOf(body.get("time"))));
        if (body.get("top") != null) n.setIsTop(boolVal(body.get("top"), false));
        if (body.get("status") != null) n.setStatus(String.valueOf(body.get("status")));
        if (body.get("content") != null) n.setContent(String.valueOf(body.get("content")));
        qhNoticeMapper.updateById(n);
        return success(noticeMap(n));
    }

    @DeleteMapping("/notices/{id}")
    public CommonResult<Boolean> deleteNotice(@PathVariable("id") Long id) {
        qhNoticeMapper.deleteById(id);
        return success(true);
    }

    // =========================================================
    // 平台用户
    // =========================================================
    @PostMapping("/users")
    public CommonResult<Map<String, Object>> createUser(@RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhUserDO u = new QhUserDO();
        u.setName(strVal(body.get("name"), ""));
        u.setAccount(strVal(body.get("account"), ""));
        u.setRole(strVal(body.get("role"), "student"));
        u.setStatus(strVal(body.get("status"), "正常"));
        u.setRegTime(LocalDate.now());
        u.setApplyStatus(strVal(body.get("applyStatus"), ""));
        u.setApproveTime(strVal(body.get("approveTime"), ""));
        u.setSpecialty(strVal(body.get("specialty"), ""));
        u.setCert(strVal(body.get("cert"), ""));
        qhUserMapper.insert(u);
        return success(userMap(u));
    }

    @PutMapping("/users/{id}")
    public CommonResult<Map<String, Object>> updateUser(@PathVariable("id") Long id,
                                                        @RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhUserDO u = require(qhUserMapper.selectById(id), "用户不存在");
        if (body.get("name") != null) u.setName(String.valueOf(body.get("name")));
        if (body.get("account") != null) u.setAccount(String.valueOf(body.get("account")));
        if (body.get("role") != null) u.setRole(String.valueOf(body.get("role")));
        if (body.get("status") != null) u.setStatus(String.valueOf(body.get("status")));
        if (body.get("applyStatus") != null) u.setApplyStatus(String.valueOf(body.get("applyStatus")));
        if (body.get("approveTime") != null) u.setApproveTime(String.valueOf(body.get("approveTime")));
        if (body.get("specialty") != null) u.setSpecialty(String.valueOf(body.get("specialty")));
        if (body.get("cert") != null) u.setCert(String.valueOf(body.get("cert")));
        qhUserMapper.updateById(u);
        return success(userMap(u));
    }

    @DeleteMapping("/users/{id}")
    public CommonResult<Boolean> deleteUser(@PathVariable("id") Long id) {
        qhUserMapper.deleteById(id);
        return success(true);
    }

    // =========================================================
    // 课程（新增 / 编辑 / 删除）
    // =========================================================
    @PostMapping("/courses")
    public CommonResult<Map<String, Object>> createCourse(@RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhCourseDO c = new QhCourseDO();
        c.setTitle(strVal(body.get("title"), ""));
        c.setCoach(strVal(body.get("coach"), ""));
        c.setCover(strVal(body.get("cover"), "diet"));
        c.setPrice(decVal(body.get("price")));
        c.setCategory(strVal(body.get("category"), "减脂"));
        c.setLessons(intVal(body.get("lessons"), 0));
        c.setSales(intVal(body.get("sales"), 0));
        c.setIsFree(c.getPrice().compareTo(BigDecimal.ZERO) <= 0);
        c.setRating(decVal(body.get("rating") == null ? "4.8" : body.get("rating")));
        c.setStatus(strVal(body.get("status"), "待审核"));
        c.setDescription(strVal(body.get("desc"), ""));
        c.setAuditResult("");
        qhCourseMapper.insert(c);
        return success(courseMap(c));
    }

    @PutMapping("/courses/{id}")
    public CommonResult<Map<String, Object>> updateCourse(@PathVariable("id") Long id,
                                                          @RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhCourseDO c = require(qhCourseMapper.selectById(id), "课程不存在");
        if (body.get("title") != null) c.setTitle(String.valueOf(body.get("title")));
        if (body.get("coach") != null) c.setCoach(String.valueOf(body.get("coach")));
        if (body.get("cover") != null) c.setCover(String.valueOf(body.get("cover")));
        if (body.get("price") != null) {
            c.setPrice(decVal(body.get("price")));
            c.setIsFree(c.getPrice().compareTo(BigDecimal.ZERO) <= 0);
        }
        if (body.get("category") != null) c.setCategory(String.valueOf(body.get("category")));
        if (body.get("lessons") != null) c.setLessons(intVal(body.get("lessons"), 0));
        if (body.get("sales") != null) c.setSales(intVal(body.get("sales"), 0));
        if (body.get("status") != null) c.setStatus(String.valueOf(body.get("status")));
        if (body.get("desc") != null) c.setDescription(String.valueOf(body.get("desc")));
        qhCourseMapper.updateById(c);
        return success(courseMap(c));
    }

    @DeleteMapping("/courses/{id}")
    public CommonResult<Boolean> deleteCourse(@PathVariable("id") Long id) {
        qhCourseMapper.deleteById(id);
        return success(true);
    }

    @PutMapping("/courses/{id}/progress")
    public CommonResult<Map<String, Object>> updateProgress(@PathVariable("id") Long id,
                                                            @RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhStudentCourseDO sc = qhStudentCourseMapper.selectOne(new LambdaQueryWrapper<QhStudentCourseDO>()
                .eq(QhStudentCourseDO::getStudentId, CURRENT_STUDENT_ID)
                .eq(QhStudentCourseDO::getCourseId, id).last("limit 1"));
        if (sc == null) {
            throw new ServiceException(404, "尚未购买该课程");
        }
        sc.setProgress(intVal(body.get("progress"), 0));
        qhStudentCourseMapper.updateById(sc);
        return success(mapOf("courseId", id, "progress", sc.getProgress()));
    }

    // =========================================================
    // 预约单（状态流转 / 报价 / 上课进度）
    // =========================================================
    @PutMapping("/bookings/{no}")
    public CommonResult<Map<String, Object>> updateBooking(@PathVariable("no") String no,
                                                           @RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhCoachBookingDO b = qhBookingMapper.selectOne(new LambdaQueryWrapper<QhCoachBookingDO>()
                .eq(QhCoachBookingDO::getBookingNo, no).last("limit 1"));
        if (b == null) {
            throw new ServiceException(404, "预约单不存在");
        }
        if (body.get("status") != null) b.setStatus(String.valueOf(body.get("status")));
        if (body.get("payment") != null) b.setPayment(String.valueOf(body.get("payment")));
        if (body.get("price") != null) b.setPrice(decVal(body.get("price")));
        if (body.get("quotePrice") != null) b.setQuotePrice(decVal(body.get("quotePrice")));
        if (body.get("sessions") != null) b.setSessions(intVal(body.get("sessions"), 0));
        if (body.get("doneSessions") != null) b.setDoneSessions(intVal(body.get("doneSessions"), 0));
        if (body.get("offline") != null) b.setOffline(intVal(body.get("offline"), 0));
        if (body.get("startDate") != null) b.setStartDate(parseDateOrNull(String.valueOf(body.get("startDate"))));
        if (body.get("lastSession") != null) b.setLastSessionDate(parseDateOrNull(String.valueOf(body.get("lastSession"))));
        if (body.get("nextDate") != null) b.setNextSessionDate(parseDateOrNull(String.valueOf(body.get("nextDate"))));
        if (body.get("planId") != null) b.setPlanId(longVal(body.get("planId"), null));
        if (body.get("quoteAccepted") != null) b.setQuoteAccepted(boolVal(body.get("quoteAccepted"), false));
        qhBookingMapper.updateById(b);
        return success(bookingMap(b));
    }

    // =========================================================
    // 训练计划（教练端）
    // =========================================================
    @PutMapping("/plans/{id}")
    public CommonResult<Map<String, Object>> updateCoachPlan(@PathVariable("id") Long id,
                                                             @RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhCoachPlanDO p = require(qhCoachPlanMapper.selectById(id), "计划不存在");
        if (body.get("title") != null) p.setTitle(String.valueOf(body.get("title")));
        if (body.get("period") != null) p.setPeriod(String.valueOf(body.get("period")));
        if (body.get("goal") != null) p.setGoal(String.valueOf(body.get("goal")));
        if (body.get("content") != null) {
            p.setContent(body.get("content") instanceof List
                    ? JSONUtil.toJsonStr(body.get("content")) : String.valueOf(body.get("content")));
        }
        if (body.get("loadLevel") != null) p.setLoadLevel(String.valueOf(body.get("loadLevel")));
        if (body.get("restAdvice") != null) p.setRestAdvice(String.valueOf(body.get("restAdvice")));
        if (body.get("checkPoint") != null) p.setCheckPoint(String.valueOf(body.get("checkPoint")));
        if (body.get("status") != null) p.setStatus(String.valueOf(body.get("status")));
        p.setPlanUpdateDate(LocalDate.now());
        qhCoachPlanMapper.updateById(p);
        return success(coachPlanMap(p));
    }

    // =========================================================
    // 饮水打卡
    // =========================================================
    @PostMapping("/water")
    public CommonResult<Map<String, Object>> addWater(@RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        LocalDate date = body.get("date") != null ? parseDate(String.valueOf(body.get("date"))) : LocalDate.now();
        int delta = intVal(body.get("amount"), 0);
        QhWaterLogDO w = qhWaterLogMapper.selectOne(new LambdaQueryWrapper<QhWaterLogDO>()
                .eq(QhWaterLogDO::getLogDate, date).last("limit 1"));
        if (w == null) {
            w = new QhWaterLogDO();
            w.setLogDate(date);
            w.setAmount(Math.max(0, delta));
            qhWaterLogMapper.insert(w);
        } else {
            w.setAmount(Math.max(0, (w.getAmount() == null ? 0 : w.getAmount()) + delta));
            qhWaterLogMapper.updateById(w);
        }
        return success(mapOf("date", ds(date), "amount", w.getAmount()));
    }

    // =========================================================
    // 钱包 / 交易
    // =========================================================
    @PostMapping("/wallet/recharge")
    public CommonResult<Map<String, Object>> recharge(@RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        BigDecimal amt = decVal(body.get("amount"));
        if (amt.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ServiceException(400, "充值金额需大于 0");
        }
        QhWalletDO w = walletOf("student");
        w.setBalance(nz(w.getBalance()).add(amt));
        qhWalletMapper.updateById(w);
        addTx("充值", "student", amt, strVal(body.get("desc"), "账户充值"));
        return success(walletsMap());
    }

    @PostMapping("/wallet/withdraw")
    public CommonResult<Map<String, Object>> withdraw(@RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhWalletDO w = walletOf("coach");
        BigDecimal amt = nz(w.getWithdrawable());
        if (amt.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ServiceException(400, "暂无可提现金额");
        }
        w.setBalance(nz(w.getBalance()).subtract(amt));
        w.setWithdrawable(BigDecimal.ZERO);
        qhWalletMapper.updateById(w);
        addTx("提现", "coach", amt, strVal(body.get("desc"), "提现至银行卡"));
        return success(walletsMap());
    }

    @PostMapping("/wallet/service-pay")
    public CommonResult<Map<String, Object>> servicePay(@RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        String no = strVal(body.get("bookingNo"), "");
        BigDecimal price = decVal(body.get("price"));
        BigDecimal fee = decVal(body.get("fee"));
        BigDecimal total = decVal(body.get("total"));
        String method = strVal(body.get("method"), "wallet");
        QhCoachBookingDO b = qhBookingMapper.selectOne(new LambdaQueryWrapper<QhCoachBookingDO>()
                .eq(QhCoachBookingDO::getBookingNo, no).last("limit 1"));
        if (b == null) {
            throw new ServiceException(404, "预约单不存在");
        }
        if ("wallet".equals(method)) {
            QhWalletDO sw = walletOf("student");
            if (nz(sw.getBalance()).compareTo(total) < 0) {
                throw new ServiceException(400, "钱包余额不足");
            }
            sw.setBalance(nz(sw.getBalance()).subtract(total));
            qhWalletMapper.updateById(sw);
        }
        QhWalletDO cw = walletOf("coach");
        cw.setBalance(nz(cw.getBalance()).add(price));
        cw.setWithdrawable(nz(cw.getWithdrawable()).add(price));
        qhWalletMapper.updateById(cw);

        QhWalletDO pw = walletOf("platform");
        pw.setBalance(nz(pw.getBalance()).add(fee));
        if (pw.getWithdrawable() == null) {
            pw.setWithdrawable(BigDecimal.ZERO);
        }
        qhWalletMapper.updateById(pw);

        addTx("支出", "student", total, "教练服务 · " + b.getServiceTitle());
        addTx("平台抽成", "platform", fee, "教练服务 · " + b.getServiceTitle() + " 平台服务费");
        addTx("教练收益", "coach", price, "教练服务 · " + b.getServiceTitle() + " 结算");

        b.setPayment("已支付");
        b.setQuoteAccepted(true);
        if ("待报价".equals(b.getStatus()) || "待接单".equals(b.getStatus())) {
            b.setStatus("待制定计划");
        }
        qhBookingMapper.updateById(b);
        return success(mapOf("booking", bookingMap(b), "wallets", walletsMap()));
    }

    // =========================================================
    // 个人资料
    // =========================================================
    @PutMapping("/profile")
    public CommonResult<Map<String, Object>> updateProfile(@RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhProfileDO p = qhProfileMapper.selectById(CURRENT_STUDENT_ID);
        if (p == null) {
            p = new QhProfileDO();
            p.setId(CURRENT_STUDENT_ID);
            p.setName(strVal(body.get("name"), "沈嘉禾"));
            qhProfileMapper.insert(p);
        }
        if (body.get("height") != null) p.setHeight(decVal(body.get("height")));
        if (body.get("weight") != null) p.setWeight(decVal(body.get("weight")));
        if (body.get("bmi") != null) p.setBmi(decVal(body.get("bmi")));
        if (body.get("bodyFat") != null) p.setBodyFat(decVal(body.get("bodyFat")));
        if (body.get("muscle") != null) p.setMuscle(decVal(body.get("muscle")));
        if (body.get("waist") != null) p.setWaist(decVal(body.get("waist")));
        qhProfileMapper.updateById(p);
        return success(profileMap(p));
    }

    // =========================================================
    // 通知
    // =========================================================
    @PostMapping("/notifications")
    public CommonResult<Map<String, Object>> createNotification(@RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhNotificationDO n = new QhNotificationDO();
        n.setReceiver(strVal(body.get("to"), "all"));
        n.setType(strVal(body.get("type"), "系统"));
        n.setTitle(strVal(body.get("title"), ""));
        n.setDescription(strVal(body.get("desc"), ""));
        n.setIsRead(false);
        n.setNotifyTime(LocalDateTime.now());
        qhNotificationMapper.insert(n);
        return success(notificationMap(n));
    }

    // =========================================================
    // 组装（与原型 DATA 字段一致）
    // =========================================================
    private Map<String, Object> recordMap(QhHealthRecordDO r) {
        return mapOf("id", r.getId(), "date", ds(r.getRecordDate()), "type", r.getType(),
                "value", r.getValue(), "unit", r.getUnit(), "note", r.getNote());
    }

    private Map<String, Object> goalMap(QhHealthGoalDO g) {
        return mapOf("id", g.getId(), "name", g.getName(), "current", g.getCurrentValue(),
                "target", g.getTargetValue(), "unit", g.getUnit(), "deadline", g.getDeadline(), "status", g.getStatus());
    }

    private Map<String, Object> reminderMap(QhReminderDO r) {
        return mapOf("id", r.getId(), "title", r.getTitle(), "time", r.getRemindTime(),
                "type", r.getType(), "enable", Boolean.TRUE.equals(r.getEnabled()));
    }

    private Map<String, Object> knowledgeMap(QhKnowledgeDO k) {
        List<List<String>> points = qhPointMapper.selectList(new LambdaQueryWrapper<QhKnowledgePointDO>()
                        .eq(QhKnowledgePointDO::getKnowledgeId, k.getId())
                        .orderByAsc(QhKnowledgePointDO::getSortNo))
                .stream().map(p -> Arrays.asList(ns(p.getPoint()), ns(p.getDetail()), ns(p.getLevel())))
                .collect(Collectors.toList());
        Map<String, Object> m = mapOf("id", k.getId(), "title", k.getTitle(), "cat", k.getCat(),
                "cover", k.getCover(), "summary", k.getSummary(), "content", k.getContent());
        m.put("points", points);
        return m;
    }

    private Map<String, Object> chapterMap(QhChapterDO c) {
        return mapOf("id", c.getId(), "num", c.getNum(), "title", c.getTitle(), "cover", c.getCover(),
                "summary", c.getSummary(), "content", c.getContent(), "count", c.getItemCount());
    }

    private Map<String, Object> chapterItemMap(QhChapterItemDO it) {
        return mapOf("chapterId", it.getChapterId(), "sortNo", it.getSortNo(), "title", it.getTitle(),
                "detail", it.getDetail(), "level", it.getLevel());
    }

    private Map<String, Object> studentMap(QhStudentDO s) {
        return mapOf("id", s.getId(), "name", s.getName(), "stuNo", s.getStuNo(), "gender", s.getGender(),
                "age", s.getAge(), "coach", s.getCoachStatus(), "bmi", s.getBmi(),
                "lastActive", ds(s.getLastActive()), "phone", s.getPhone(), "email", s.getEmail(),
                "wechat", s.getWechat(), "serviceStatus", s.getServiceStatus(), "goal", s.getGoal());
    }

    private Map<String, Object> planMap(QhPlanDO p) {
        return mapOf("id", p.getId(), "stuName", p.getStuName(), "title", p.getTitle(),
                "content", p.getContent(), "start", ds(p.getStartDate()), "end", ds(p.getEndDate()),
                "status", p.getStatus(), "feedback", ns(p.getFeedback()));
    }

    private Map<String, Object> userMap(QhUserDO u) {
        return mapOf("id", u.getId(), "name", u.getName(), "account", u.getAccount(), "role", u.getRole(),
                "status", u.getStatus(), "regTime", ds(u.getRegTime()), "applyStatus", u.getApplyStatus(),
                "approveTime", u.getApproveTime(), "specialty", u.getSpecialty(), "cert", u.getCert());
    }

    private Map<String, Object> noticeMap(QhNoticeDO n) {
        return mapOf("id", n.getId(), "title", n.getTitle(), "publisher", n.getPublisher(),
                "time", ds(n.getPublishTime()), "top", Boolean.TRUE.equals(n.getIsTop()),
                "status", n.getStatus(), "content", n.getContent());
    }

    private Map<String, Object> profileMap(QhProfileDO p) {
        if (p == null) {
            return new LinkedHashMap<>();
        }
        return mapOf("name", p.getName(), "stuNo", p.getStuNo(), "gender", p.getGender(), "age", p.getAge(),
                "college", p.getCollege(), "major", p.getMajor(), "phone", p.getPhone(), "bmi", p.getBmi(),
                "height", p.getHeight(), "weight", p.getWeight(), "bodyFat", p.getBodyFat(),
                "muscle", p.getMuscle(), "waist", p.getWaist());
    }

    private Map<String, Object> notificationMap(QhNotificationDO n) {
        return mapOf("id", n.getId(), "to", n.getReceiver(), "type", n.getType(), "title", n.getTitle(),
                "desc", n.getDescription(), "read", Boolean.TRUE.equals(n.getIsRead()),
                "time", n.getNotifyTime() == null ? "" : n.getNotifyTime().format(DTF));
    }

    private Map<String, Object> courseMap(QhCourseDO c) {
        return mapOf("id", c.getId(), "title", c.getTitle(), "coach", c.getCoach(), "cover", c.getCover(),
                "price", c.getPrice(), "category", c.getCategory(), "lessons", c.getLessons(),
                "sales", c.getSales(), "isFree", Boolean.TRUE.equals(c.getIsFree()), "rating", c.getRating(),
                "status", c.getStatus(), "desc", c.getDescription());
    }

    private Map<String, Object> txMap(QhTransactionDO t) {
        return mapOf("id", t.getTxNo(), "time", ds(t.getTxTime()), "type", t.getType(),
                "role", t.getRole(), "amount", t.getAmount(), "desc", t.getDescription());
    }

    private Map<String, Object> coachMap(QhCoachDO c) {
        Map<String, Object> m = mapOf("id", c.getId(), "name", c.getName(), "account", c.getAccount(),
                "photo", c.getPhoto(), "photoPos", c.getPhotoPos(), "gender", c.getGender(), "age", c.getAge(),
                "cert", c.getCert(), "specialty", c.getSpecialty(), "years", c.getYears(),
                "students", c.getStudentCount(), "rating", c.getRating(), "orderCount", c.getOrderCount(),
                "priceFrom", c.getPriceFrom(), "intro", c.getIntro(), "applyStatus", c.getApplyStatus(),
                "approveTime", c.getApproveTime(), "status", c.getStatus(), "online", Boolean.TRUE.equals(c.getOnline()));
        m.put("tags", c.getTags() == null || c.getTags().isEmpty()
                ? new ArrayList<>() : Arrays.asList(c.getTags().split(",")));
        return m;
    }

    private Map<String, Object> serviceMap(QhCoachServiceDO s) {
        Map<String, Object> m = mapOf("id", s.getId(), "coachId", s.getCoachId(), "title", s.getTitle(),
                "sessions", s.getSessions(), "sessionMin", s.getSessionMin(), "price", s.getPrice(),
                "unitPrice", s.getUnitPrice(), "suitable", s.getSuitable(), "status", s.getStatus());
        try {
            m.put("includes", s.getIncludes() == null ? new ArrayList<>()
                    : JSONUtil.toList(s.getIncludes(), String.class));
        } catch (Exception e) {
            m.put("includes", new ArrayList<>());
        }
        return m;
    }

    private Map<String, Object> bookingMap(QhCoachBookingDO b) {
        return mapOf("id", b.getBookingNo(), "stuName", b.getStuName(), "stuId", b.getStuId(),
                "coachId", b.getCoachId(), "coachName", b.getCoachName(), "goal", b.getGoal(),
                "goalDetail", b.getGoalDetail(), "serviceId", b.getServiceId(), "serviceTitle", b.getServiceTitle(),
                "sessions", b.getSessions(), "doneSessions", b.getDoneSessions(), "price", b.getPrice(),
                "quotePrice", b.getQuotePrice(), "status", b.getStatus(), "createdAt", ds(b.getBookingDate()),
                "startDate", ds(b.getStartDate()), "lastSession", ds(b.getLastSessionDate()),
                "nextDate", ds(b.getNextSessionDate()), "offline", b.getOffline(), "payment", b.getPayment(),
                "quoteAccepted", Boolean.TRUE.equals(b.getQuoteAccepted()),
                "planId", b.getPlanId() == null ? "" : String.valueOf(b.getPlanId()));
    }

    private Map<String, Object> coachPlanMap(QhCoachPlanDO p) {
        Map<String, Object> m = mapOf("id", p.getId(), "bookingId", p.getBookingNo(), "stuName", p.getStuName(),
                "coachName", p.getCoachName(), "title", p.getTitle(), "period", p.getPeriod(), "goal", p.getGoal(),
                "loadLevel", p.getLoadLevel(), "restAdvice", p.getRestAdvice(), "checkPoint", p.getCheckPoint(),
                "status", p.getStatus(), "createdAt", ds(p.getPlanDate()), "updatedAt", ds(p.getPlanUpdateDate()),
                "feedback", ns(p.getFeedback()));
        try {
            m.put("content", p.getContent() == null ? new ArrayList<>()
                    : JSONUtil.toList(p.getContent(), String.class));
        } catch (Exception e) {
            m.put("content", new ArrayList<>());
        }
        return m;
    }

    private Map<String, Object> walletsMap() {
        Map<String, Object> m = new LinkedHashMap<>();
        QhWalletDO sw = findWallet("student");
        QhWalletDO cw = findWallet("coach");
        QhWalletDO pw = findWallet("platform");
        m.put("student", mapOf("balance", nz(sw == null ? null : sw.getBalance())));
        m.put("coach", mapOf("balance", nz(cw == null ? null : cw.getBalance()),
                "withdrawable", nz(cw == null ? null : cw.getWithdrawable())));
        BigDecimal gmv = qhTransactionMapper.selectList(new LambdaQueryWrapper<QhTransactionDO>()
                        .in(QhTransactionDO::getType, Arrays.asList("服务收入", "平台抽成", "教练收益")))
                .stream().map(t -> nz(t.getAmount())).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal courseGmv = qhTransactionMapper.selectList(new LambdaQueryWrapper<QhTransactionDO>()
                        .eq(QhTransactionDO::getType, "课程收入"))
                .stream().map(t -> nz(t.getAmount())).reduce(BigDecimal.ZERO, BigDecimal::add);
        // 平台佣金收入 = 服务抽成 + 课程收入（钱包余额只体现未分配部分，不适合直接当营收展示）
        BigDecimal revenue = qhTransactionMapper.selectList(new LambdaQueryWrapper<QhTransactionDO>()
                        .in(QhTransactionDO::getType, Arrays.asList("平台抽成", "课程收入")))
                .stream().map(t -> nz(t.getAmount())).reduce(BigDecimal.ZERO, BigDecimal::add);
        m.put("platform", mapOf("revenue", revenue,
                "serviceGMV", gmv, "courseGMV", courseGmv));
        return m;
    }

    // =========================================================
    // 工具
    // =========================================================
    private QhWalletDO findWallet(String owner) {
        return qhWalletMapper.selectOne(new LambdaQueryWrapper<QhWalletDO>()
                .eq(QhWalletDO::getOwner, owner).last("limit 1"));
    }

    private QhWalletDO walletOf(String owner) {
        QhWalletDO w = findWallet(owner);
        if (w == null) {
            w = new QhWalletDO();
            w.setOwner(owner);
            w.setBalance(BigDecimal.ZERO);
            w.setWithdrawable(BigDecimal.ZERO);
            qhWalletMapper.insert(w);
        }
        return w;
    }

    private void addTx(String type, String role, BigDecimal amount, String desc) {
        QhTransactionDO t = new QhTransactionDO();
        t.setTxNo("TX" + System.currentTimeMillis() % 100000000L);
        t.setTxTime(LocalDate.now());
        t.setType(type);
        t.setRole(role);
        t.setAmount(amount);
        t.setDescription(desc);
        qhTransactionMapper.insert(t);
    }

    private Integer configInt(String key, int def) {
        QhConfigDO c = qhConfigMapper.selectOne(new LambdaQueryWrapper<QhConfigDO>()
                .eq(QhConfigDO::getConfigKey, key).last("limit 1"));
        try {
            return c == null ? def : Integer.parseInt(c.getConfigValue());
        } catch (Exception e) {
            return def;
        }
    }

    private BigDecimal configDecimal(String key, BigDecimal def) {
        QhConfigDO c = qhConfigMapper.selectOne(new LambdaQueryWrapper<QhConfigDO>()
                .eq(QhConfigDO::getConfigKey, key).last("limit 1"));
        try {
            return c == null ? def : new BigDecimal(c.getConfigValue());
        } catch (Exception e) {
            return def;
        }
    }

    private static <T> T require(T v, String msg) {
        if (v == null) {
            throw new ServiceException(404, msg);
        }
        return v;
    }

    private static BigDecimal nz(BigDecimal v) {
        return v == null ? BigDecimal.ZERO : v;
    }

    private static String ns(String v) {
        return v == null ? "" : v;
    }

    private static String ds(LocalDate d) {
        return d == null ? "" : d.format(DF);
    }

    private static LocalDate parseDate(String s) {
        try {
            return LocalDate.parse(s, DF);
        } catch (Exception e) {
            return LocalDate.now();
        }
    }

    private static LocalDate parseDateOrNull(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        try {
            return LocalDate.parse(s, DF);
        } catch (Exception e) {
            return null;
        }
    }

    private static String strVal(Object o, String def) {
        return o == null ? def : String.valueOf(o);
    }

    private static boolean boolVal(Object o, boolean def) {
        if (o == null) return def;
        if (o instanceof Boolean) return (Boolean) o;
        String s = String.valueOf(o);
        return "true".equalsIgnoreCase(s) || "1".equals(s) || "是".equals(s);
    }

    private static Integer intVal(Object o, int def) {
        if (o instanceof Number) return ((Number) o).intValue();
        try {
            return o == null ? def : (int) Double.parseDouble(String.valueOf(o));
        } catch (Exception e) {
            return def;
        }
    }

    private static Long longVal(Object o, Long def) {
        if (o instanceof Number) return ((Number) o).longValue();
        try {
            return o == null || String.valueOf(o).isEmpty() ? def : Long.parseLong(String.valueOf(o));
        } catch (Exception e) {
            return def;
        }
    }

    private static BigDecimal decVal(Object o) {
        if (o == null) return BigDecimal.ZERO;
        try {
            return new BigDecimal(String.valueOf(o));
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    private static Map<String, Object> mapOf(Object... kv) {
        Map<String, Object> m = new LinkedHashMap<>();
        for (int i = 0; i + 1 < kv.length; i += 2) {
            m.put(String.valueOf(kv[i]), kv[i + 1]);
        }
        return m;
    }
}
