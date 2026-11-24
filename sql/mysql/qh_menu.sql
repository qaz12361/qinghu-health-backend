/*
 青护健康管理 —— yudao 后台菜单（参考生鲜杂货店格式）
 幂等：先删 9100-9121 再插入；并把 qh_ 种子数据租户刷为 1
*/
DELETE FROM system_menu WHERE id BETWEEN 9100 AND 9130;

INSERT INTO system_menu (id, name, permission, type, sort, parent_id, path, icon, component, component_name, status, visible, keep_alive, always_show, creator, create_time, updater, update_time, deleted) VALUES
(9100, '健康管理', '', 1, 1, 0, '/qinghu', 'ep:first-aid-kit', NULL, '', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9101, '健康记录', '', 2, 1, 9100, 'health-record', 'ep:notebook', 'qinghu/healthrecord/index', 'QhHealthRecord', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9102, '健康目标', '', 2, 2, 9100, 'health-goal', 'ep:aim', 'qinghu/healthgoal/index', 'QhHealthGoal', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9103, '健康提醒', '', 2, 3, 9100, 'reminder', 'ep:alarm-clock', 'qinghu/reminder/index', 'QhReminder', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9104, '饮水打卡', '', 2, 4, 9100, 'water-log', 'ep:glass', 'qinghu/waterlog/index', 'QhWaterLog', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9105, '健康知识', '', 2, 5, 9100, 'knowledge', 'ep:reading', 'qinghu/knowledge/index', 'QhKnowledge', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9106, '知识要点', '', 2, 6, 9100, 'knowledge-point', 'ep:collection', 'qinghu/knowledgepoint/index', 'QhKnowledgePoint', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9107, '学生管理', '', 2, 7, 9100, 'student', 'ep:user', 'qinghu/student/index', 'QhStudent', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9108, '学生档案', '', 2, 8, 9100, 'profile', 'ep:postcard', 'qinghu/profile/index', 'QhProfile', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9109, '教练管理', '', 2, 9, 9100, 'coach', 'ep:avatar', 'qinghu/coach/index', 'QhCoach', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9110, '教练服务包', '', 2, 10, 9100, 'coach-service', 'ep:suitcase', 'qinghu/coachservice/index', 'QhCoachService', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9111, '预约单', '', 2, 11, 9100, 'coach-booking', 'ep:calendar', 'qinghu/coachbooking/index', 'QhCoachBooking', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9112, '教练计划', '', 2, 12, 9100, 'coach-plan', 'ep:tickets', 'qinghu/coachplan/index', 'QhCoachPlan', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9113, '运动计划', '', 2, 13, 9100, 'plan', 'ep:stopwatch', 'qinghu/plan/index', 'QhPlan', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9114, '课程管理', '', 2, 14, 9100, 'course', 'ep:video-play', 'qinghu/course/index', 'QhCourse', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9115, '已购课程', '', 2, 15, 9100, 'student-course', 'ep:shopping-bag', 'qinghu/studentcourse/index', 'QhStudentCourse', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9116, '交易流水', '', 2, 16, 9100, 'transaction', 'ep:money', 'qinghu/transaction/index', 'QhTransaction', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9117, '钱包管理', '', 2, 17, 9100, 'wallet', 'ep:wallet', 'qinghu/wallet/index', 'QhWallet', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9118, '平台用户', '', 2, 18, 9100, 'user', 'ep:user-filled', 'qinghu/user/index', 'QhUser', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9119, '公告管理', '', 2, 19, 9100, 'notice', 'ep:bell', 'qinghu/notice/index', 'QhNotice', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9120, '通知中心', '', 2, 20, 9100, 'notification', 'ep:message', 'qinghu/notification/index', 'QhNotification', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9121, '平台配置', '', 2, 21, 9100, 'config', 'ep:setting', 'qinghu/config/index', 'QhConfig', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0'),
(9122, '循证指南', '', 2, 22, 9100, 'chapter', 'ep:reading', 'qinghu/chapter/index', 'QhChapter', 0, b'1', b'0', b'1', 'admin', NOW(), 'admin', NOW(), b'0');

-- 种子数据租户对齐管理端(tenant_id=1)
UPDATE qh_health_record SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_health_goal SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_reminder SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_water_log SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_knowledge SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_knowledge_point SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_student SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_profile SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_coach SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_coach_service SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_coach_booking SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_coach_plan SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_plan SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_course SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_student_course SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_transaction SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_wallet SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_user SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_notice SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_notification SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_config SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_chapter SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_chapter_item SET tenant_id = 1 WHERE tenant_id = 0;
UPDATE qh_chapter_mark SET tenant_id = 1 WHERE tenant_id = 0;
