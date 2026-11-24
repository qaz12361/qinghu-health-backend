package cn.iocoder.yudao.module.system.controller.app.qinghu;

import cn.hutool.json.JSONUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coach.QhCoachDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachbooking.QhCoachBookingDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.coachplan.QhCoachPlanDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.course.QhCourseDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.healthrecord.QhHealthRecordDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.notification.QhNotificationDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.profile.QhProfileDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.student.QhStudentDO;
import cn.iocoder.yudao.module.system.dal.dataobject.qinghu.studentcourse.QhStudentCourseDO;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.coach.QhCoachMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.coachbooking.QhCoachBookingMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.coachplan.QhCoachPlanMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.course.QhCourseMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.healthrecord.QhHealthRecordMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.notification.QhNotificationMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.profile.QhProfileMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.student.QhStudentMapper;
import cn.iocoder.yudao.module.system.dal.mysql.qinghu.studentcourse.QhStudentCourseMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * 用户 App - 青护健康管理 C 端接口
 *
 * 与 qinghu-web 原生 Mock 契约逐字段对齐（qinghu-web/mock/server.js），
 * 数据源为 qh_ 真实表；匿名可访问，由前端携带 tenant-id 头。
 */
@Tag(name = "用户 App - 青护健康管理")
@RestController("appQinghuController")
@RequestMapping("/qinghu")
@PermitAll
@Validated
@SuppressWarnings("unchecked")
public class AppQinghuController {

    /** 当前演示学生（mock 无登录态，固定档案本人） */
    private static final Long CURRENT_STUDENT_ID = 1L;

    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Resource
    private QhCoachMapper qhCoachMapper;
    @Resource
    private QhCoachBookingMapper qhCoachBookingMapper;
    @Resource
    private QhCoachPlanMapper qhCoachPlanMapper;
    @Resource
    private QhCourseMapper qhCourseMapper;
    @Resource
    private QhStudentCourseMapper qhStudentCourseMapper;
    @Resource
    private QhHealthRecordMapper qhHealthRecordMapper;
    @Resource
    private QhStudentMapper qhStudentMapper;
    @Resource
    private QhNotificationMapper qhNotificationMapper;
    @Resource
    private QhProfileMapper qhProfileMapper;

    // ========== 教练 ==========

    @GetMapping("/coaches")
    @Operation(summary = "教练列表")
    public CommonResult<Map<String, Object>> getCoaches() {
        return success(mapOf("list", qhCoachMapper.selectList().stream().map(this::coachMap).collect(Collectors.toList())));
    }

    // ========== 预约 ==========

    @PostMapping("/bookings")
    @Operation(summary = "提交预约")
    public CommonResult<Map<String, Object>> createBooking(@RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhCoachDO coach = body.get("coachId") == null ? null
                : qhCoachMapper.selectById(intVal(body.get("coachId")));
        // 单号：取现有最大 BK 序号 + 1
        int maxNo = qhCoachBookingMapper.selectList().stream()
                .map(QhCoachBookingDO::getBookingNo)
                .filter(Objects::nonNull).filter(s -> s.startsWith("BK"))
                .mapToInt(s -> { try { return Integer.parseInt(s.substring(2)); } catch (Exception e) { return 0; } })
                .max().orElse(2601039);
        QhCoachBookingDO b = new QhCoachBookingDO();
        b.setBookingNo("BK" + (maxNo + 1));
        b.setStuName(strVal(body.get("stuName"), qhProfileMapper.selectById(CURRENT_STUDENT_ID).getName()));
        b.setStuId(longVal(body.get("stuId"), CURRENT_STUDENT_ID));
        b.setCoachId(longVal(body.get("coachId"), 1L));
        b.setCoachName(strVal(body.get("coachName"), coach != null ? coach.getName() : ""));
        b.setGoal(strVal(body.get("goal"), ""));
        b.setGoalDetail(strVal(body.get("goalDetail"), ""));
        b.setServiceId(longVal(body.get("serviceId"), 0L));
        b.setServiceTitle(strVal(body.get("serviceTitle"), ""));
        b.setSessions(intVal(body.get("sessions")));
        b.setDoneSessions(0);
        b.setPrice(decimalVal(body.get("price")));
        b.setQuotePrice(decimalVal(body.get("quotePrice")));
        b.setStatus("待接单");
        b.setBookingDate(LocalDate.now());
        b.setOffline(0);
        b.setPayment("待支付");
        b.setQuoteAccepted(false);
        qhCoachBookingMapper.insert(b);
        pushNotification("coach", "预约", "收到新的预约申请",
                b.getStuName() + " 预约了「" + b.getGoal() + "」，请尽快接单。");
        return success(bookingMap(b));
    }

    // ========== 课程 ==========

    @GetMapping("/courses")
    @Operation(summary = "课程列表")
    public CommonResult<Map<String, Object>> getCourses() {
        return success(mapOf("list", qhCourseMapper.selectList().stream().map(this::courseMap).collect(Collectors.toList())));
    }

    @GetMapping("/courses/mine")
    @Operation(summary = "我的已购课程")
    public CommonResult<Map<String, Object>> getMyCourses() {
        List<Map<String, Object>> mine = new ArrayList<>();
        for (QhStudentCourseDO sc : qhStudentCourseMapper.selectList(new LambdaQueryWrapper<QhStudentCourseDO>()
                .eq(QhStudentCourseDO::getStudentId, CURRENT_STUDENT_ID).orderByAsc(QhStudentCourseDO::getId))) {
            QhCourseDO c = qhCourseMapper.selectById(sc.getCourseId());
            if (c == null) {
                continue;
            }
            Map<String, Object> m = courseMap(c);
            m.put("buyTime", ds(sc.getBuyTime()));
            m.put("progress", sc.getProgress());
            mine.add(m);
        }
        return success(mapOf("list", mine));
    }

    @PostMapping("/courses/{id}/buy")
    @Operation(summary = "购买课程")
    public CommonResult<Map<String, Object>> buyCourse(@PathVariable("id") Long id) {
        QhCourseDO c = requireCourse(id);
        Long exists = qhStudentCourseMapper.selectCount(new LambdaQueryWrapper<QhStudentCourseDO>()
                .eq(QhStudentCourseDO::getStudentId, CURRENT_STUDENT_ID)
                .eq(QhStudentCourseDO::getCourseId, id));
        if (exists == null || exists == 0) {
            QhStudentCourseDO sc = new QhStudentCourseDO();
            sc.setStudentId(CURRENT_STUDENT_ID);
            sc.setCourseId(id);
            sc.setBuyTime(LocalDate.now());
            sc.setProgress(0);
            qhStudentCourseMapper.insert(sc);
        }
        c.setSales(c.getSales() == null ? 1 : c.getSales() + 1);
        qhCourseMapper.updateById(c);
        pushNotification("student", "购课", "购买成功",
                "已购买课程《" + c.getTitle() + "》，可在「我的课程」中学习。");
        List<Map<String, Object>> scList = qhStudentCourseMapper.selectList().stream()
                .filter(sc -> Objects.equals(sc.getStudentId(), CURRENT_STUDENT_ID))
                .map(sc -> mapOf("courseId", sc.getCourseId(), "buyTime", ds(sc.getBuyTime()), "progress", sc.getProgress()))
                .collect(Collectors.toList());
        return success(mapOf("course", courseMap(c), "studentCourses", scList));
    }

    @PostMapping("/courses/{id}/audit")
    @Operation(summary = "审核课程")
    public CommonResult<Map<String, Object>> auditCourse(@PathVariable("id") Long id,
                                                         @RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhCourseDO c = requireCourse(id);
        boolean pass = Boolean.TRUE.equals(body.get("pass"));
        c.setAuditResult(pass ? "已通过" : "已驳回");
        qhCourseMapper.updateById(c);
        pushNotification("coach", "审核", pass ? "课程审核通过" : "课程审核驳回",
                "《" + c.getTitle() + "》审核结果：" + (pass ? "通过，可安排上架。" : "未通过，请按反馈修改后重新提交。"));
        return success(mapOf("course", courseMap(c)));
    }

    @PostMapping("/courses/{id}/shelf")
    @Operation(summary = "课程上下架")
    public CommonResult<Map<String, Object>> shelfCourse(@PathVariable("id") Long id,
                                                         @RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhCourseDO c = requireCourse(id);
        c.setStatus("已下架".equals(body.get("status")) ? "已下架" : "已上架");
        qhCourseMapper.updateById(c);
        pushNotification("coach", "系统", "已上架".equals(c.getStatus()) ? "课程已上架" : "课程已下架",
                "《" + c.getTitle() + "》现已" + c.getStatus() + "。");
        return success(mapOf("course", courseMap(c)));
    }

    // ========== 我的服务 / 方案 ==========

    @GetMapping("/services/mine")
    @Operation(summary = "我的服务总览")
    public CommonResult<Map<String, Object>> getMyServices() {
        QhProfileDO profile = qhProfileMapper.selectById(CURRENT_STUDENT_ID);
        String myName = profile == null ? "" : profile.getName();
        List<Map<String, Object>> bookings = qhCoachBookingMapper.selectList(new LambdaQueryWrapper<QhCoachBookingDO>()
                .eq(QhCoachBookingDO::getStuId, CURRENT_STUDENT_ID).orderByAsc(QhCoachBookingDO::getId))
                .stream().map(this::bookingMap).collect(Collectors.toList());
        List<Map<String, Object>> plans = qhCoachPlanMapper.selectList(new LambdaQueryWrapper<QhCoachPlanDO>()
                .eq(QhCoachPlanDO::getStuName, myName).orderByAsc(QhCoachPlanDO::getId))
                .stream().map(this::coachPlanMap).collect(Collectors.toList());
        List<Map<String, Object>> courses = new ArrayList<>();
        for (QhStudentCourseDO sc : qhStudentCourseMapper.selectList(new LambdaQueryWrapper<QhStudentCourseDO>()
                .eq(QhStudentCourseDO::getStudentId, CURRENT_STUDENT_ID).orderByAsc(QhStudentCourseDO::getId))) {
            QhCourseDO c = qhCourseMapper.selectById(sc.getCourseId());
            if (c == null) {
                continue;
            }
            Map<String, Object> m = courseMap(c);
            m.put("buyTime", ds(sc.getBuyTime()));
            m.put("progress", sc.getProgress());
            courses.add(m);
        }
        return success(mapOf("bookings", bookings, "plans", plans, "courses", courses));
    }

    // ========== 运动计划（教练端） ==========

    @GetMapping("/plans")
    @Operation(summary = "运动计划列表")
    public CommonResult<Map<String, Object>> getPlans() {
        return success(mapOf("list", qhCoachPlanMapper.selectList(new LambdaQueryWrapper<QhCoachPlanDO>()
                .orderByDesc(QhCoachPlanDO::getId)).stream().map(this::coachPlanMap).collect(Collectors.toList())));
    }

    @PostMapping("/plans")
    @Operation(summary = "新建运动计划")
    public CommonResult<Map<String, Object>> createPlan(@RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhCoachPlanDO p = new QhCoachPlanDO();
        p.setBookingNo(strVal(body.get("bookingId"), ""));
        p.setStuName(strVal(body.get("stuName"), ""));
        p.setCoachName(strVal(body.get("coachName"), ""));
        p.setTitle(strVal(body.get("title"), ""));
        p.setPeriod(strVal(body.get("period"), ""));
        p.setGoal(strVal(body.get("goal"), ""));
        Object content = body.get("content");
        p.setContent(content instanceof List ? JSONUtil.toJsonStr(content) : "[]");
        p.setLoadLevel(strVal(body.get("loadLevel"), ""));
        p.setRestAdvice(strVal(body.get("restAdvice"), ""));
        p.setCheckPoint(strVal(body.get("checkPoint"), ""));
        p.setStatus("执行中");
        p.setPlanDate(LocalDate.now());
        p.setPlanUpdateDate(LocalDate.now());
        qhCoachPlanMapper.insert(p);
        pushNotification("student", "计划", "教练发来新运动计划",
                "《" + p.getTitle() + "》已下发，请按计划执行。");
        return success(coachPlanMap(p));
    }

    @PostMapping("/plans/{id}/feedback")
    @Operation(summary = "计划反馈下发")
    public CommonResult<Map<String, Object>> feedbackPlan(@PathVariable("id") Long id,
                                                          @RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhCoachPlanDO p = qhCoachPlanMapper.selectById(id);
        if (p == null) {
            throw new ServiceException(404, "计划不存在");
        }
        String text = body.get("text") != null ? String.valueOf(body.get("text"))
                : (body.get("feedback") != null ? String.valueOf(body.get("feedback")) : "");
        p.setFeedback(text);
        p.setPlanUpdateDate(LocalDate.now());
        qhCoachPlanMapper.updateById(p);
        pushNotification("student", "反馈", "教练发来新指导", "《" + p.getTitle() + "》：" + text);
        return success(mapOf("plan", coachPlanMap(p)));
    }

    // ========== 健康记录 ==========

    @GetMapping("/records")
    @Operation(summary = "健康记录列表")
    public CommonResult<Map<String, Object>> getRecords() {
        return success(mapOf("list", qhHealthRecordMapper.selectList(new LambdaQueryWrapper<QhHealthRecordDO>()
                .eq(QhHealthRecordDO::getStudentId, CURRENT_STUDENT_ID)
                .orderByAsc(QhHealthRecordDO::getId)).stream().map(this::recordMap).collect(Collectors.toList())));
    }

    @PostMapping("/records")
    @Operation(summary = "新增健康记录")
    public CommonResult<Map<String, Object>> createRecord(@RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhHealthRecordDO r = new QhHealthRecordDO();
        r.setRecordDate(body.get("date") != null ? parseDate(String.valueOf(body.get("date"))) : LocalDate.now());
        r.setType(strVal(body.get("type"), ""));
        r.setValue(strVal(body.get("value"), ""));
        r.setUnit(strVal(body.get("unit"), ""));
        r.setNote(strVal(body.get("note"), ""));
        r.setStudentId(CURRENT_STUDENT_ID);
        qhHealthRecordMapper.insert(r);
        return success(recordMap(r));
    }

    @PutMapping("/records/{id}")
    @Operation(summary = "修改健康记录")
    public CommonResult<Map<String, Object>> updateRecord(@PathVariable("id") Long id,
                                                          @RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhHealthRecordDO r = qhHealthRecordMapper.selectById(id);
        if (r == null || !CURRENT_STUDENT_ID.equals(r.getStudentId())) {
            throw new ServiceException(404, "记录不存在");
        }
        if (body.get("date") != null) {
            r.setRecordDate(parseDate(String.valueOf(body.get("date"))));
        }
        if (body.get("type") != null) {
            r.setType(String.valueOf(body.get("type")));
        }
        if (body.get("value") != null) {
            r.setValue(String.valueOf(body.get("value")));
        }
        if (body.get("unit") != null) {
            r.setUnit(String.valueOf(body.get("unit")));
        }
        if (body.get("note") != null) {
            r.setNote(String.valueOf(body.get("note")));
        }
        qhHealthRecordMapper.updateById(r);
        return success(mapOf("record", recordMap(r)));
    }

    @DeleteMapping("/records/{id}")
    @Operation(summary = "删除健康记录")
    public CommonResult<Map<String, Object>> deleteRecord(@PathVariable("id") Long id) {
        QhHealthRecordDO r = qhHealthRecordMapper.selectById(id);
        if (r == null || !CURRENT_STUDENT_ID.equals(r.getStudentId())) {
            throw new ServiceException(404, "记录不存在");
        }
        qhHealthRecordMapper.deleteById(id);
        return success(mapOf("ok", true));
    }

    // ========== 学生（教练端） ==========

    @GetMapping("/students")
    @Operation(summary = "学生列表")
    public CommonResult<Map<String, Object>> getStudents() {
        return success(mapOf("list", qhStudentMapper.selectList().stream().map(this::studentMap).collect(Collectors.toList())));
    }

    @PostMapping("/students/{id}/bind")
    @Operation(summary = "绑定学生")
    public CommonResult<Map<String, Object>> bindStudent(@PathVariable("id") Long id) {
        QhStudentDO s = requireStudent(id);
        s.setCoachStatus("已绑定");
        s.setServiceStatus("服务中");
        qhStudentMapper.updateById(s);
        pushNotification("student", "绑定", "教练已绑定你", "你已成为我的健康教练，可随时沟通训练安排。");
        pushNotification("admin", "绑定", "学生已绑定", "教练绑定了学生 " + s.getName() + "。");
        return success(mapOf("student", studentMap(s)));
    }

    @PostMapping("/students/{id}/unbind")
    @Operation(summary = "解绑学生")
    public CommonResult<Map<String, Object>> unbindStudent(@PathVariable("id") Long id) {
        QhStudentDO s = requireStudent(id);
        s.setCoachStatus("未绑定");
        s.setServiceStatus("待预约");
        qhStudentMapper.updateById(s);
        return success(mapOf("student", studentMap(s)));
    }

    // ========== 管理端：教练 ==========

    @GetMapping("/admin/coaches")
    @Operation(summary = "管理端教练列表")
    public CommonResult<Map<String, Object>> getAdminCoaches() {
        return success(mapOf("list", qhCoachMapper.selectList().stream().map(this::coachMap).collect(Collectors.toList())));
    }

    @PostMapping("/admin/coaches/{id}/audit")
    @Operation(summary = "教练入驻审核")
    public CommonResult<Map<String, Object>> auditCoach(@PathVariable("id") Long id,
                                                        @RequestBody(required = false) Map<String, Object> body) {
        body = body == null ? Collections.emptyMap() : body;
        QhCoachDO c = qhCoachMapper.selectById(id);
        if (c == null) {
            throw new ServiceException(404, "教练不存在");
        }
        String status = body.get("status") != null ? String.valueOf(body.get("status")) : "已通过";
        c.setApplyStatus(status);
        if ("已通过".equals(status)) {
            c.setApproveTime(LocalDate.now().format(DF));
            c.setStatus("在职");
            c.setOnline(true);
        } else if ("驳回".equals(status) || "已拒绝".equals(status)) {
            c.setStatus("待入驻");
            c.setOnline(false);
        }
        qhCoachMapper.updateById(c);
        pushNotification("coach", "审核", "入驻申请已审核", c.getName() + " 的入驻申请审核结果：" + status + "。");
        return success(mapOf("coach", coachMap(c)));
    }

    // ========== 通知 ==========

    @GetMapping("/notifications")
    @Operation(summary = "通知列表")
    public CommonResult<Map<String, Object>> getNotifications() {
        return success(mapOf("list", qhNotificationMapper.selectList(new LambdaQueryWrapper<QhNotificationDO>()
                .orderByDesc(QhNotificationDO::getId)).stream().map(this::notificationMap).collect(Collectors.toList())));
    }

    @PostMapping("/notifications/{id}/read")
    @Operation(summary = "标记已读")
    public CommonResult<Map<String, Object>> readNotification(@PathVariable("id") Long id) {
        QhNotificationDO n = qhNotificationMapper.selectById(id);
        if (n != null) {
            n.setIsRead(true);
            qhNotificationMapper.updateById(n);
        }
        return success(mapOf("notification", n == null ? null : notificationMap(n)));
    }

    // ========== 个人资料 ==========

    @GetMapping("/profile")
    @Operation(summary = "当前用户资料")
    public CommonResult<Map<String, Object>> getProfile() {
        QhProfileDO p = qhProfileMapper.selectById(CURRENT_STUDENT_ID);
        Map<String, Object> profile = p == null ? new LinkedHashMap<>() : mapOf(
                "name", p.getName(), "stuNo", p.getStuNo(), "gender", p.getGender(), "age", p.getAge(),
                "college", p.getCollege(), "major", p.getMajor(), "phone", p.getPhone(),
                "bmi", p.getBmi(), "height", p.getHeight(), "weight", p.getWeight(),
                "bodyFat", p.getBodyFat(), "muscle", p.getMuscle(), "waist", p.getWaist());
        return success(mapOf("profile", profile,
                "user", p == null ? "" : p.getName(), "role", "student"));
    }

    // ========== 组装（mock 契约字段名） ==========

    private Map<String, Object> coachMap(QhCoachDO c) {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("id", c.getId());
        m.put("name", c.getName());
        m.put("account", c.getAccount());
        m.put("photo", c.getPhoto());
        m.put("photoPos", c.getPhotoPos());
        m.put("gender", c.getGender());
        m.put("age", c.getAge());
        m.put("cert", c.getCert());
        m.put("specialty", c.getSpecialty());
        m.put("tags", c.getTags() == null || c.getTags().isEmpty()
                ? new ArrayList<>() : Arrays.asList(c.getTags().split(",")));
        m.put("years", c.getYears());
        m.put("students", c.getStudentCount());
        m.put("rating", c.getRating());
        m.put("orderCount", c.getOrderCount());
        m.put("priceFrom", c.getPriceFrom());
        m.put("intro", c.getIntro());
        m.put("applyStatus", c.getApplyStatus());
        m.put("approveTime", c.getApproveTime());
        m.put("status", c.getStatus());
        m.put("online", Boolean.TRUE.equals(c.getOnline()));
        return m;
    }

    private Map<String, Object> courseMap(QhCourseDO c) {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("id", c.getId());
        m.put("title", c.getTitle());
        m.put("coach", c.getCoach());
        m.put("cover", c.getCover());
        m.put("price", c.getPrice());
        m.put("category", c.getCategory());
        m.put("lessons", c.getLessons());
        m.put("sales", c.getSales());
        m.put("isFree", Boolean.TRUE.equals(c.getIsFree()));
        m.put("rating", c.getRating());
        m.put("status", c.getStatus());
        m.put("desc", c.getDescription());
        m.put("auditResult", c.getAuditResult());
        return m;
    }

    private Map<String, Object> bookingMap(QhCoachBookingDO b) {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("id", b.getBookingNo());
        m.put("stuName", b.getStuName());
        m.put("stuId", b.getStuId());
        m.put("coachId", b.getCoachId());
        m.put("coachName", b.getCoachName());
        m.put("goal", b.getGoal());
        m.put("goalDetail", b.getGoalDetail());
        m.put("serviceId", b.getServiceId());
        m.put("serviceTitle", b.getServiceTitle());
        m.put("sessions", b.getSessions());
        m.put("doneSessions", b.getDoneSessions());
        m.put("price", b.getPrice());
        m.put("quotePrice", b.getQuotePrice());
        m.put("status", b.getStatus());
        m.put("createdAt", ds(b.getBookingDate()));
        m.put("startDate", ds(b.getStartDate()));
        m.put("lastSession", ds(b.getLastSessionDate()));
        m.put("nextDate", ds(b.getNextSessionDate()));
        m.put("offline", b.getOffline());
        m.put("payment", b.getPayment());
        m.put("quoteAccepted", Boolean.TRUE.equals(b.getQuoteAccepted()));
        m.put("planId", b.getPlanId() == null ? "" : String.valueOf(b.getPlanId()));
        return m;
    }

    private Map<String, Object> coachPlanMap(QhCoachPlanDO p) {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("id", p.getId());
        m.put("bookingId", p.getBookingNo());
        m.put("stuName", p.getStuName());
        m.put("coachName", p.getCoachName());
        m.put("title", p.getTitle());
        m.put("period", p.getPeriod());
        m.put("goal", p.getGoal());
        try {
            m.put("content", p.getContent() == null ? new ArrayList<>()
                    : JSONUtil.toList(p.getContent(), String.class));
        } catch (Exception e) {
            m.put("content", new ArrayList<>());
        }
        m.put("loadLevel", p.getLoadLevel());
        m.put("restAdvice", p.getRestAdvice());
        m.put("checkPoint", p.getCheckPoint());
        m.put("status", p.getStatus());
        m.put("createdAt", ds(p.getPlanDate()));
        m.put("updatedAt", ds(p.getPlanUpdateDate()));
        m.put("feedback", p.getFeedback() == null ? "" : p.getFeedback());
        return m;
    }

    private Map<String, Object> recordMap(QhHealthRecordDO r) {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("id", r.getId());
        m.put("date", ds(r.getRecordDate()));
        m.put("type", r.getType());
        m.put("value", r.getValue());
        m.put("unit", r.getUnit());
        m.put("note", r.getNote());
        return m;
    }

    private Map<String, Object> studentMap(QhStudentDO s) {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("id", s.getId());
        m.put("name", s.getName());
        m.put("stuNo", s.getStuNo());
        m.put("gender", s.getGender());
        m.put("age", s.getAge());
        m.put("coach", s.getCoachStatus());
        m.put("bmi", s.getBmi());
        m.put("lastActive", ds(s.getLastActive()));
        m.put("phone", s.getPhone());
        m.put("email", s.getEmail());
        m.put("wechat", s.getWechat());
        m.put("serviceStatus", s.getServiceStatus());
        m.put("goal", s.getGoal());
        return m;
    }

    private Map<String, Object> notificationMap(QhNotificationDO n) {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("id", n.getId());
        m.put("to", n.getReceiver());
        m.put("type", n.getType());
        m.put("title", n.getTitle());
        m.put("desc", n.getDescription());
        m.put("read", Boolean.TRUE.equals(n.getIsRead()));
        m.put("time", n.getNotifyTime() == null ? "" : n.getNotifyTime().format(DTF));
        return m;
    }

    // ========== 工具 ==========

    private void pushNotification(String receiver, String type, String title, String desc) {
        QhNotificationDO n = new QhNotificationDO();
        n.setReceiver(receiver);
        n.setType(type);
        n.setTitle(title);
        n.setDescription(desc);
        n.setIsRead(false);
        n.setNotifyTime(LocalDateTime.now());
        qhNotificationMapper.insert(n);
    }

    private QhCourseDO requireCourse(Long id) {
        QhCourseDO c = qhCourseMapper.selectById(id);
        if (c == null) {
            throw new ServiceException(404, "课程不存在");
        }
        return c;
    }

    private QhStudentDO requireStudent(Long id) {
        QhStudentDO s = qhStudentMapper.selectById(id);
        if (s == null) {
            throw new ServiceException(404, "学生不存在");
        }
        return s;
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

    private static String strVal(Object o, String def) {
        return o == null ? def : String.valueOf(o);
    }

    private static Integer intVal(Object o) {
        return o instanceof Number ? ((Number) o).intValue() : null;
    }

    private static Integer intVal(Object o, int def) {
        return o instanceof Number ? ((Number) o).intValue() : def;
    }

    private static Long longVal(Object o, Long def) {
        return o instanceof Number ? ((Number) o).longValue() : def;
    }

    private static BigDecimal decimalVal(Object o) {
        return o instanceof Number ? new BigDecimal(String.valueOf(o)) : BigDecimal.ZERO;
    }

    private static Map<String, Object> mapOf(Object... kv) {
        Map<String, Object> m = new LinkedHashMap<>();
        for (int i = 0; i + 1 < kv.length; i += 2) {
            m.put(String.valueOf(kv[i]), kv[i + 1]);
        }
        return m;
    }

}
