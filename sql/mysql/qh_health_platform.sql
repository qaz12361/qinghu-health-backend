/*
 青护大学生健康管理平台（qinghu-web）数据库初始化脚本
 生成源：D:/dev/projects/qinghu-web/mock/data.js
 规范：对齐 yudao-boot-mini/sql/mysql/ruoyi-vue-pro.sql
 目标库：fresh_market
 表前缀：qh_
 表数量：21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for qh_health_record
-- ----------------------------
DROP TABLE IF EXISTS `qh_health_record`;
CREATE TABLE `qh_health_record`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `record_date` date NOT NULL COMMENT '记录日期',
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '指标类型：体重/步数/睡眠/心率/饮水',
  `value` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '指标值',
  `unit` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '单位',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '备注',
  `student_id` bigint NOT NULL DEFAULT 1 COMMENT '所属学生ID',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  INDEX `idx_record_date`(`record_date` ASC) USING BTREE,
  INDEX `idx_student_date`(`student_id` ASC, `record_date` ASC) USING BTREE,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '健康数据记录表';

-- ----------------------------
-- Records of qh_health_record
-- ----------------------------
BEGIN;
INSERT INTO `qh_health_record` (`id`, `record_date`, `type`, `value`, `unit`, `note`) VALUES
(1, '2026-10-08', '体重', '68.5', 'kg', '晨起空腹'),
(2, '2026-10-08', '步数', '8432', '步', '绕操场5圈'),
(3, '2026-10-07', '睡眠', '7.2', 'h', '23:30入睡'),
(4, '2026-10-07', '心率', '72', 'bpm', '静息心率'),
(5, '2026-10-06', '体重', '69.0', 'kg', ''),
(6, '2026-10-06', '饮水', '1500', 'ml', '偏低'),
(7, '2026-10-05', '步数', '10230', '步', '骑行+步行'),
(8, '2026-10-05', '睡眠', '6.5', 'h', '熬夜赶作业'),
(9, '2026-10-04', '体重', '69.3', 'kg', ''),
(10, '2026-10-04', '心率', '75', 'bpm', ''),
(101, '2026-10-03', '体重', '69.4', 'kg', '晨起空腹'),
(102, '2026-10-03', '步数', '8150', '步', '操场夜跑'),
(103, '2026-10-03', '睡眠', '6.7', 'h', '23:40入睡'),
(104, '2026-10-03', '心率', '70', 'bpm', '静息心率'),
(105, '2026-10-02', '体重', '69.5', 'kg', ''),
(106, '2026-10-02', '步数', '11240', '步', '外出徒步'),
(107, '2026-10-02', '睡眠', '7.1', 'h', ''),
(108, '2026-10-01', '体重', '69.6', 'kg', '晨起空腹'),
(109, '2026-10-01', '步数', '6890', '步', ''),
(110, '2026-10-01', '睡眠', '7.8', 'h', '假期补觉'),
(111, '2026-10-01', '心率', '72', 'bpm', ''),
(112, '2026-09-30', '体重', '69.8', 'kg', ''),
(113, '2026-09-30', '步数', '9450', '步', '骑行+步行'),
(114, '2026-09-30', '睡眠', '6.9', 'h', ''),
(115, '2026-09-29', '体重', '70.0', 'kg', ''),
(116, '2026-09-29', '步数', '7310', '步', ''),
(117, '2026-09-29', '睡眠', '7.2', 'h', ''),
(118, '2026-09-29', '心率', '71', 'bpm', '静息心率'),
(119, '2026-09-28', '体重', '70.1', 'kg', '晨起空腹'),
(120, '2026-09-28', '步数', '8960', '步', ''),
(121, '2026-09-28', '睡眠', '6.4', 'h', '赶作业'),
(122, '2026-09-27', '体重', '70.2', 'kg', ''),
(123, '2026-09-27', '步数', '5240', '步', '宅宿舍'),
(124, '2026-09-27', '睡眠', '7.5', 'h', ''),
(125, '2026-09-27', '心率', '73', 'bpm', ''),
(126, '2026-09-26', '体重', '70.3', 'kg', ''),
(127, '2026-09-26', '步数', '7830', '步', ''),
(128, '2026-09-26', '睡眠', '7.0', 'h', ''),
(129, '2026-09-25', '体重', '70.4', 'kg', '晨起空腹'),
(130, '2026-09-25', '步数', '6120', '步', ''),
(131, '2026-09-25', '睡眠', '6.8', 'h', '23:20入睡'),
(132, '2026-09-25', '心率', '74', 'bpm', '静息心率');
COMMIT;

-- ----------------------------
-- Table structure for qh_health_goal
-- ----------------------------
DROP TABLE IF EXISTS `qh_health_goal`;
CREATE TABLE `qh_health_goal`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '目标名称',
  `current_value` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '当前值',
  `target_value` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '目标值',
  `unit` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '单位',
  `deadline` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '截止时间（日期或“长期坚持”）',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '状态：进行中/滞后/已完成',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '健康目标表';

-- ----------------------------
-- Records of qh_health_goal
-- ----------------------------
BEGIN;
INSERT INTO `qh_health_goal` (`id`, `name`, `current_value`, `target_value`, `unit`, `deadline`, `status`) VALUES
(1, '减重目标', 69.3, 65, 'kg', '2026-12-31', '进行中'),
(2, '每日步数', 8432, 10000, '步', '长期坚持', '进行中'),
(3, '规律睡眠', 7, 8, 'h', '长期坚持', '进行中'),
(4, '学期跑步', 42, 100, 'km', '2027-01-20', '滞后');
COMMIT;

-- ----------------------------
-- Table structure for qh_reminder
-- ----------------------------
DROP TABLE IF EXISTS `qh_reminder`;
CREATE TABLE `qh_reminder`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '提醒标题',
  `remind_time` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '提醒时间 HH:mm',
  `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '提醒类型：运动/饮水/医疗/作息',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否启用',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '健康提醒表';

-- ----------------------------
-- Records of qh_reminder
-- ----------------------------
BEGIN;
INSERT INTO `qh_reminder` (`id`, `title`, `remind_time`, `type`, `enabled`) VALUES
(1, '晨跑提醒', '07:00', '运动', 1),
(2, '喝水提醒', '10:00', '饮水', 1),
(3, '体检预约', '14:30', '医疗', 0),
(4, '早睡提醒', '22:30', '作息', 1),
(5, '健身打卡', '18:00', '运动', 0);
COMMIT;

-- ----------------------------
-- Table structure for qh_knowledge
-- ----------------------------
DROP TABLE IF EXISTS `qh_knowledge`;
CREATE TABLE `qh_knowledge`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '标题',
  `cat` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '分类：营养/运动/作息/心理/急救/消费/学业',
  `cover` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '封面主题键',
  `summary` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '摘要',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '正文',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  INDEX `idx_cat`(`cat` ASC) USING BTREE,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '健康知识表';

-- ----------------------------
-- Records of qh_knowledge
-- ----------------------------
BEGIN;
INSERT INTO `qh_knowledge` (`id`, `title`, `cat`, `cover`, `summary`, `content`) VALUES
(1, '大学生科学减脂指南', '营养', 'diet', '控制热量缺口、提升蛋白质摄入、规律有氧与力量结合。', '减脂的核心是制造合理的热量缺口。大学生最常见的问题是「一天只吃一顿」和「只做有氧」，前者容易掉肌肉、反弹快，后者会让基础代谢下降。正确做法是三餐规律、蛋白质吃够，再把有氧和力量按周排开。'),
(2, '久坐人群的拉伸动作', '运动', 'stretch', '图书馆和宿舍久坐必备的肩颈与腰背拉伸。', '每坐 1 小时起身活动 3 到 5 分钟，比一次性练一小时更能缓解僵硬。以下动作在座位旁就能做，每个保持 20 到 30 秒、重复 2 到 3 组。'),
(3, '改善睡眠的10个习惯', '作息', 'sleep', '从光照、咖啡因到睡前仪式，系统改善睡眠质量。', '睡眠问题的关键往往不是「睡得不够早」，而是节律乱了。固定起床时间比强迫早睡更容易做到，也更能带动入睡时间前移。'),
(4, '均衡膳食餐盘法', '营养', 'meal', '用「餐盘法则」在食堂快速搭出一顿饭。', '不用称重、不用算卡路里，看盘子的比例就够了：蔬菜占一半，优质蛋白占四分之一，主食占四分之一。'),
(5, '心率区间与燃脂', '运动', 'run', '了解最大心率与不同区间的训练效果。', '最大心率的常用估算是 220 减年龄。算出区间后，可以用「能不能说话」来粗略判断强度，不必每次戴表。'),
(6, '心理健康的自我觉察', '心理', 'mind', '识别压力信号、建立支持系统、及时求助。', '压力不是软弱的证明，是身体在报警。值得关注的是持续时间：偶尔低落很正常，连续两周以上就值得认真对待。'),
(7, '校园急救：心脏骤停怎么救', '急救', 'firstaid', '按压位置、频率与呼叫顺序，几分钟内要做的动作。', '心脏骤停后每一分钟都在流失生存机会。多数心脏骤停发生在家里，学会按压，最先能救到的其实是身边人。'),
(8, '一杯奶茶值多少', '消费', 'money', '把饮料、外卖和订阅费摊开算，比省小钱有效。', '学生阶段的省钱重点不是抠单价，而是先看清「每天一笔、不易察觉」的支出。把它乘上 30，数字通常比想象中大。'),
(9, '期末周的作息与精力分配', '学业', 'study', '把有限的时间放在精力高峰，而不是延长熬夜。', '期末周的错觉是「时间不够」，实际往往是「注意力不够」。与其把学习时间从 6 小时延长到 10 小时，不如把最难的事放进精力最好的两小时。'),
(10, '手机与颈椎：低头族自救', '运动', 'stretch', '减少低头时间，配合肩颈力量与拉伸。', '低头时颈椎承受的压力会随角度明显增加。完全不用手机不现实，能改的是姿势和时长，以及给颈后肌群一点力量。'),
(11, '感冒药别叠加着吃', '急救', 'medicine', '常备药的几条硬规则，避开最常见的用药事故。', '不用处方能买，不等于怎么吃都行。最常见的用药事故不是吃错药，而是几种药里含同一成分、被一起吃下去。'),
(12, '宿舍运动：无器械也能练', '运动', 'dumbbell', '没有器械、没有场地时的一套基础安排。', '宿舍训练的难点不是动作，是噪音和空间。选静音动作、铺一条毛巾，20 分钟也能练到主要肌群。');
COMMIT;

-- ----------------------------
-- Table structure for qh_knowledge_point
-- ----------------------------
DROP TABLE IF EXISTS `qh_knowledge_point`;
CREATE TABLE `qh_knowledge_point`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `knowledge_id` bigint NOT NULL COMMENT '所属知识编号',
  `sort_no` int NOT NULL DEFAULT 0 COMMENT '排序号',
  `point` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '要点标题',
  `detail` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '要点说明',
  `level` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '重要级别 A/B/C',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  INDEX `idx_knowledge_id`(`knowledge_id` ASC) USING BTREE,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '健康知识要点表';

-- ----------------------------
-- Records of qh_knowledge_point
-- ----------------------------
BEGIN;
INSERT INTO `qh_knowledge_point` (`id`, `knowledge_id`, `sort_no`, `point`, `detail`, `level`) VALUES
(1, 1, 1, '热量缺口控制在每天 300 到 500 kcal', '缺口太大会掉肌肉、也难坚持，慢慢减反而更稳。', 'A'),
(2, 1, 2, '蛋白质吃到每公斤体重 1.2 到 1.6 克', '鸡蛋、鸡胸、豆腐、酸奶都算，一餐一个手掌大小。', 'B'),
(3, 1, 3, '每周 3 到 5 次中等强度有氧', '快走、慢跑、骑行、游泳都行，每次 30 分钟起。', 'A'),
(4, 1, 4, '每周 2 次力量训练', '保住肌肉，减下去才不容易反弹。', 'B'),
(5, 1, 5, '别用极端节食换速度', '掉得快、反弹也快，还容易伤代谢。', 'A'),
(6, 2, 1, '颈部侧倾拉伸', '手轻扶头部向一侧倾斜，肩膀下沉，感受颈侧拉开。', 'C'),
(7, 2, 2, '胸大肌靠墙拉伸', '前臂贴墙、身体反向转，改善圆肩。', 'C'),
(8, 2, 3, '猫牛式脊柱活动', '四点支撑下拱背与塌腰交替，唤醒整条脊柱。', 'B'),
(9, 2, 4, '髋部屈肌拉伸', '单膝跪地、重心前移，缓解久坐带来的髋前紧张。', 'C'),
(10, 2, 5, '每小时起身一次', '打断久坐本身就有独立收益，不必等攒够运动量。', 'B'),
(11, 3, 1, '先固定起床时间', '不管前一晚几点睡，第二天同一时间起，节律会自己回正。', 'A'),
(12, 3, 2, '睡前 1 小时离开蓝光', '把手机放远，或开护眼模式，给身体一个该收了的信号。', 'B'),
(13, 3, 3, '下午 3 点后不喝浓茶咖啡', '咖啡因的半衰期比你以为的长得多。', 'A'),
(14, 3, 4, '午休不超过 30 分钟', '超过容易睡沉，醒来更晕，也会影响晚上入睡。', 'C'),
(15, 3, 5, '周末最多晚起 1 小时', '一次暴睡会把整周节律打乱。', 'B'),
(16, 4, 1, '蔬菜占一半', '深色蔬菜尽量占其中一半，食堂多打一份青菜就能做到。', 'A'),
(17, 4, 2, '优质蛋白占四分之一', '一餐一个手掌大小，鸡蛋、鱼、豆腐、鸡胸都算。', 'B'),
(18, 4, 3, '主食占四分之一，且换一半粗粮', '杂粮饭、玉米、燕麦都行，饱腹感更强、血糖更稳。', 'B'),
(19, 4, 4, '饮料换成无糖', '一杯全糖奶茶的热量大致相当于一碗半米饭。', 'B'),
(20, 4, 5, '三餐定时，别靠夜宵补', '不吃早餐的结果，通常是中午和夜里吃更多。', 'A'),
(21, 5, 1, '先估算最大心率', '用 220 减年龄得到一个参考值。', 'C'),
(22, 5, 2, '燃脂区间大致在最大心率的 60% 到 70%', '这个强度下能连续说话，但唱歌会有点吃力。', 'B'),
(23, 5, 3, '高强度间歇能省时间', '短时间高效，但需要一定基础，先从低强度起步。', 'B'),
(24, 5, 4, '热身和放松各留 5 分钟', '降低受伤概率，也让心率的升降更平缓。', 'C'),
(25, 5, 5, '有心慌、胸闷立刻停下', '运动中出现异常症状，先就医再谈训练量。', 'A'),
(26, 6, 1, '认出需要重视的信号', '连续两周情绪低落、失眠、注意力下降、对什么都没兴趣。', 'A'),
(27, 6, 2, '规律运动是基础项', '每周三次、每次 30 分钟中等强度，对情绪的改善有稳定证据。', 'A'),
(28, 6, 3, '把担心写下来', '写在纸上往往比在脑子里反复转更能停下来。', 'B'),
(29, 6, 4, '用呼吸把节奏拉慢', '吸气 4 秒、屏住 4 秒、呼气 6 秒，重复 10 轮。', 'B'),
(30, 6, 5, '求助是有效动作', '学校心理咨询中心免费且保密，去一次比自己扛一学期划算。', 'A'),
(31, 7, 1, '先确认现场安全再施救', '触电、火灾、车流中要先断电、隔离、拦车，否则受伤的会变成两个人。', 'A'),
(32, 7, 2, '立刻开始胸外按压', '位置在两乳头连线中点，双手交叠垂直下压 5 到 6 厘米。', 'A'),
(33, 7, 3, '频率保持 100 到 120 次每分', '大致是每秒两下的节奏，中间尽量不中断。', 'A'),
(34, 7, 4, '同时让人拨打 120 并取 AED', '别先挂电话，听调度员指挥，AED 到了就按语音提示用。', 'B'),
(35, 7, 5, '食物卡喉用海姆立克', '站到身后，拳眼抵住肚脐上方，快速向内向上冲击。', 'A'),
(36, 8, 1, '先算每天一杯饮料的月支出', '一杯按 15 元算，一个月就是 450 元，接近半个月饭钱。', 'B'),
(37, 8, 2, '清一遍自动续费', '视频会员、云盘、软件订阅，一年很容易悄悄花掉几百元。', 'A'),
(38, 8, 3, '按次付费优先于年卡', '健身房、自习室先按次体验一个月，再决定要不要买卡。', 'B'),
(39, 8, 4, '警惕凑单满减', '为了满减多买的那部分，通常是你原本不需要的东西。', 'C'),
(40, 8, 5, '留 500 到 1000 元备用金', '一笔小额备用金，能避免一次突发事件打乱整个月。', 'B'),
(41, 9, 1, '找出自己的精力高峰', '把最难的内容放进那两小时，比硬撑一整天有效。', 'B'),
(42, 9, 2, '把任务切到 25 分钟一轮', '先做一轮再决定要不要继续，开始比坚持难。', 'B'),
(43, 9, 3, '提前一晚定好第一件事', '早上不用重新决策，起步速度差很多。', 'B'),
(44, 9, 4, '连续熬夜不超过三晚', '连熬三晚之后注意力和情绪会明显下滑，宁可早起两小时。', 'B'),
(45, 9, 5, '每天留出 30 分钟运动', '看起来占时间，实际能提高之后几小时的效率。', 'B'),
(46, 10, 1, '把手机举到接近视线高度', '只是换个姿势，颈部受力就会小很多。', 'B'),
(47, 10, 2, '每 30 分钟抬头活动一次', '比连续低头两小时再猛拉伸更有效。', 'C'),
(48, 10, 3, '练颈后与背部力量', '靠墙收下巴、俯身划船类动作，能改善前倾体态。', 'B'),
(49, 10, 4, '屏幕高度与眼睛齐平', '笔记本垫高、外接键盘，是最省事的改良。', 'C'),
(50, 10, 5, '持续手麻、头晕要就医', '这类信号不是拉伸能解决的。', 'A'),
(51, 11, 1, '退烧药别叠加着吃', '多种感冒药常含同一成分，叠加容易伤肝。', 'A'),
(52, 11, 2, '抗生素按疗程吃完', '自行减停容易复发，也会带来耐药。', 'A'),
(53, 11, 3, '止痛药别长期自行加量', '长期大剂量可能伤胃、伤肾。', 'A'),
(54, 11, 4, '过期药及时清理', '失效还只是小事，变质可能更麻烦。', 'B'),
(55, 11, 5, '误服后先别催吐', '带上药瓶尽快就医，让医生判断。', 'A'),
(56, 12, 1, '深蹲 2 到 3 组', '脚与肩同宽，膝盖方向与脚尖一致。', 'C'),
(57, 12, 2, '俯卧撑或跪姿俯卧撑', '做不动标准版就先跪姿，重点是动作完整。', 'C'),
(58, 12, 3, '平板支撑 3 组', '每组 30 到 60 秒，腰不要塌。', 'B'),
(59, 12, 4, '臀桥与死虫式', '补上久坐后最弱的臀部和核心。', 'B'),
(60, 12, 5, '每周至少安排 2 次', '频率比单次强度更决定效果。', 'B');
COMMIT;

-- ----------------------------
-- Table structure for qh_student
-- ----------------------------
DROP TABLE IF EXISTS `qh_student`;
CREATE TABLE `qh_student`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `stu_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '学号',
  `gender` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '性别',
  `age` int NOT NULL DEFAULT 0 COMMENT '年龄',
  `coach_status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '教练绑定状态：已绑定/未绑定',
  `bmi` decimal(4,1) NOT NULL DEFAULT 0.0 COMMENT 'BMI',
  `last_active` date NULL DEFAULT NULL COMMENT '最近活跃日期',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '手机号',
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '邮箱',
  `wechat` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '微信号',
  `service_status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '服务状态',
  `goal` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '目标方向',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  UNIQUE INDEX `uk_stu_no`(`stu_no` ASC) USING BTREE,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '学生表';

-- ----------------------------
-- Records of qh_student
-- ----------------------------
BEGIN;
INSERT INTO `qh_student` (`id`, `name`, `stu_no`, `gender`, `age`, `coach_status`, `bmi`, `last_active`, `phone`, `email`, `wechat`, `service_status`, `goal`) VALUES
(1, '沈嘉禾', '2023010101', '男', 20, '已绑定', 22.4, '2026-10-08', '138****2201', 'shenjh@stu.edu.cn', 'shenjh_2023', '服务中', '减脂塑形'),
(2, '林知遥', '2023010102', '女', 19, '未绑定', 20.1, '2026-10-07', '139****8876', 'linzy@stu.edu.cn', 'linzy_0612', '待预约', '体态矫正'),
(3, '周砚青', '2023010103', '男', 21, '已绑定', 24.8, '2026-10-06', '137****3345', 'zhouyq@stu.edu.cn', 'zhouyq_9527', '服务中', '增肌'),
(4, '苏念', '2023010104', '女', 20, '未绑定', 19.6, '2026-10-05', '135****9912', 'sunian@stu.edu.cn', 'sunian_0408', '未预约', '增肌塑形'),
(5, '陈屿', '2023010105', '男', 22, '已绑定', 23.5, '2026-10-04', '136****5580', 'chenyu@stu.edu.cn', 'chenyu_1180', '服务结束', '体能提升'),
(6, '何昭', '2023010106', '女', 20, '未绑定', 21.7, '2026-10-03', '188****6623', 'hezhao@stu.edu.cn', 'hezhao_0915', '未预约', '减脂');
COMMIT;

-- ----------------------------
-- Table structure for qh_plan
-- ----------------------------
DROP TABLE IF EXISTS `qh_plan`;
CREATE TABLE `qh_plan`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `stu_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '学生姓名',
  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '计划标题',
  `content` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '计划内容',
  `start_date` date NULL DEFAULT NULL COMMENT '开始日期',
  `end_date` date NULL DEFAULT NULL COMMENT '结束日期',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '状态：执行中/已完成',
  `feedback` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '教练反馈',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '运动计划表（教练端）';

-- ----------------------------
-- Records of qh_plan
-- ----------------------------
BEGIN;
INSERT INTO `qh_plan` (`id`, `stu_name`, `title`, `content`, `start_date`, `end_date`, `status`, `feedback`) VALUES
(1, '沈嘉禾', '减脂塑形计划', '每周3次有氧+2次力量，控制饮食热量', '2026-10-01', '2026-12-31', '执行中', '体重已连续下降，继续保持。下周增加1次 HIIT，注意观察静息心率。'),
(2, '周砚青', '增肌计划', '渐进负荷力量训练，蛋白2g/kg', '2026-10-05', '2027-01-05', '执行中', ''),
(3, '陈屿', '体能提升计划', 'HIIT+核心稳定性训练', '2026-09-20', '2026-12-20', '已完成', '12 周计划圆满完成，体能与核心稳定性显著提升，建议进入维持期。');
COMMIT;

-- ----------------------------
-- Table structure for qh_user
-- ----------------------------
DROP TABLE IF EXISTS `qh_user`;
CREATE TABLE `qh_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `account` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '登录账号',
  `role` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '角色：student/coach/admin',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '状态：正常/停用',
  `reg_time` date NULL DEFAULT NULL COMMENT '注册日期',
  `apply_status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '入驻审核状态',
  `approve_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '审核通过时间',
  `specialty` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '专长（教练）',
  `cert` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '资质证书（教练）',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  UNIQUE INDEX `uk_account`(`account` ASC) USING BTREE,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '平台用户表（管理员端）';

-- ----------------------------
-- Records of qh_user
-- ----------------------------
BEGIN;
INSERT INTO `qh_user` (`id`, `name`, `account`, `role`, `status`, `reg_time`, `apply_status`, `approve_time`, `specialty`, `cert`) VALUES
(1, '沈嘉禾', '2023010101', 'student', '正常', '2026-09-01', '', '', '', ''),
(2, '刘教练', 'C001', 'coach', '正常', '2026-08-20', '已通过', '2026-08-21', '减脂·体态', '国家社会体育指导员（三级）'),
(3, '林知遥', '2023010102', 'student', '正常', '2026-09-01', '', '', '', ''),
(5, '周砚青', '2023010103', 'student', '停用', '2026-09-02', '', '', '', ''),
(6, '管理员', 'admin', 'admin', '正常', '2026-08-01', '', '', '', ''),
(7, '陈可欣', 'C002', 'coach', '正常', '2026-09-05', '待审核', '', '增肌·力量', '健身教练职业资格证'),
(8, '赵铭', 'C003', 'coach', '正常', '2026-09-11', '待审核', '', '体测·康复', '康复治疗师（初级）'),
(9, '吴珊', 'C004', 'coach', '正常', '2026-07-18', '已通过', '2026-07-19', '瑜伽·拉伸', 'RYT-200 瑜伽教练'),
(10, '周乐', 'C005', 'coach', '正常', '2026-05-30', '已通过', '2026-06-08', '跑步·耐力', '体适能教练（中级）'),
(11, '林岚', 'C006', 'coach', '正常', '2026-05-18', '已通过', '2026-05-22', '增肌·力量', '中国健美协会中级教练员'),
(12, '苏航', 'C007', 'coach', '正常', '2026-10-13', '待审核', '', '体能·基础', '健身教练职业资格证');
COMMIT;

-- ----------------------------
-- Table structure for qh_notice
-- ----------------------------
DROP TABLE IF EXISTS `qh_notice`;
CREATE TABLE `qh_notice`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '标题',
  `publisher` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '发布人',
  `publish_time` date NULL DEFAULT NULL COMMENT '发布日期',
  `is_top` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否置顶',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '状态：已发布/草稿',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '正文',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '公告表';

-- ----------------------------
-- Records of qh_notice
-- ----------------------------
BEGIN;
INSERT INTO `qh_notice` (`id`, `title`, `publisher`, `publish_time`, `is_top`, `status`, `content`) VALUES
(1, '关于2026年秋季学期体测安排的通知', '管理员', '2026-09-25', 1, '已发布', '本学期体测将于10月15日-10月30日进行，请同学们提前做好准备，按要求完成各项测试。'),
(2, '心理健康月活动预告', '管理员', '2026-09-20', 0, '已发布', '10月为心理健康月，将开展讲座、团体辅导与线下游园活动，欢迎参与。'),
(3, '系统升级维护公告', '管理员', '2026-09-10', 0, '草稿', '平台将于本周末进行升级维护，期间部分功能暂不可用。');
COMMIT;

-- ----------------------------
-- Table structure for qh_profile
-- ----------------------------
DROP TABLE IF EXISTS `qh_profile`;
CREATE TABLE `qh_profile`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `stu_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '学号',
  `gender` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '性别',
  `age` int NOT NULL DEFAULT 0 COMMENT '年龄',
  `college` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '学院',
  `major` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '专业',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '手机号',
  `bmi` decimal(4,1) NOT NULL DEFAULT 0.0 COMMENT 'BMI',
  `height` decimal(5,1) NOT NULL DEFAULT 0.0 COMMENT '身高 cm',
  `weight` decimal(5,2) NOT NULL DEFAULT 0.00 COMMENT '体重 kg',
  `body_fat` decimal(4,1) NOT NULL DEFAULT 0.0 COMMENT '体脂率 %',
  `muscle` decimal(5,2) NOT NULL DEFAULT 0.00 COMMENT '肌肉量 kg',
  `waist` decimal(5,1) NOT NULL DEFAULT 0.0 COMMENT '腰围 cm',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '学生健康档案表';

-- ----------------------------
-- Records of qh_profile
-- ----------------------------
BEGIN;
INSERT INTO `qh_profile` (`id`, `name`, `stu_no`, `gender`, `age`, `college`, `major`, `phone`, `bmi`, `height`, `weight`, `body_fat`, `muscle`, `waist`) VALUES
(1, '沈嘉禾', '2023010101', '男', 20, '计算机学院', '软件工程', '138****1234', 22.4, 175, 68.5, 18.5, 32.1, 78);
COMMIT;

-- ----------------------------
-- Table structure for qh_water_log
-- ----------------------------
DROP TABLE IF EXISTS `qh_water_log`;
CREATE TABLE `qh_water_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `log_date` date NOT NULL COMMENT '打卡日期',
  `amount` int NOT NULL DEFAULT 0 COMMENT '饮水量 ml',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  UNIQUE INDEX `uk_log_date`(`log_date` ASC) USING BTREE,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '饮水打卡表';

-- ----------------------------
-- Records of qh_water_log
-- ----------------------------
BEGIN;
INSERT INTO `qh_water_log` (`id`, `log_date`, `amount`) VALUES
(1, '2026-09-25', 1400),
(2, '2026-09-26', 1600),
(3, '2026-09-27', 1800),
(4, '2026-09-28', 1200),
(5, '2026-09-29', 1700),
(6, '2026-09-30', 1900),
(7, '2026-10-01', 1500),
(8, '2026-10-02', 2100),
(9, '2026-10-03', 1600),
(10, '2026-10-04', 1200),
(11, '2026-10-05', 1000),
(12, '2026-10-06', 1500),
(13, '2026-10-07', 2000),
(14, '2026-10-08', 1500);
COMMIT;

-- ----------------------------
-- Table structure for qh_course
-- ----------------------------
DROP TABLE IF EXISTS `qh_course`;
CREATE TABLE `qh_course`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '课程标题',
  `coach` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '授课教练',
  `cover` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '封面主题键',
  `price` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '价格（0 为免费）',
  `category` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '分类',
  `lessons` int NOT NULL DEFAULT 0 COMMENT '课时数',
  `sales` int NOT NULL DEFAULT 0 COMMENT '销量',
  `is_free` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否免费',
  `rating` decimal(2,1) NOT NULL DEFAULT 0.0 COMMENT '评分',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '状态：已上架/已下架',
  `description` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '课程简介',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  INDEX `idx_category`(`category` ASC) USING BTREE,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '课程表';

-- ----------------------------
-- Records of qh_course
-- ----------------------------
BEGIN;
INSERT INTO `qh_course` (`id`, `title`, `coach`, `cover`, `price`, `category`, `lessons`, `sales`, `is_free`, `rating`, `status`, `description`) VALUES
(1, '4 周零基础减脂训练营', '刘教练', 'diet', 0, '减脂', 16, 128, 1, 4.8, '已上架', '针对大学生宿舍场景，无需器械，4 周科学减脂，配套饮食建议与每日打卡。'),
(2, '增肌塑形基础课', '刘教练', 'dumbbell', 129, '增肌', 20, 64, 0, 4.7, '已上架', '渐进负荷力量训练入门，适合健身房新手，含每周计划表与动作示范。'),
(3, '宿舍拉伸与体态矫正', '王教练', 'stretch', 0, '拉伸', 12, 203, 1, 4.9, '已上架', '久坐人群必备，改善圆肩驼背，10 分钟跟练，随时可学。'),
(4, '规律作息睡眠营', '王教练', 'sleep', 0, '作息', 10, 156, 1, 4.6, '已上架', '21 天睡眠习惯养成，睡前仪式 + 白噪声指导，告别熬夜。'),
(5, '跑步姿势与心肺提升', '刘教练', 'run', 79, '有氧', 14, 88, 0, 4.8, '已上架', '纠正跑姿，降低受伤风险，提升耐力，适合备考久坐人群。'),
(6, '瑜伽入门与减压', '王教练', 'yoga', 0, '瑜伽', 12, 175, 1, 4.7, '已上架', '零基础哈他瑜伽，缓解久坐僵硬与考试焦虑，宿舍可练。'),
(7, '普拉提核心塑形', '王教练', 'core', 89, '普拉提', 16, 97, 0, 4.8, '已上架', '强化核心与体态，改善腰背痛，适合长期伏案人群。'),
(8, '骑行有氧耐力课', '刘教练', 'cycling', 69, '有氧', 10, 112, 0, 4.6, '已上架', '室外骑行或动感单车均可，提升心肺与下肢耐力。'),
(9, 'HIIT 高效燃脂', '刘教练', 'hiit', 109, '减脂', 18, 143, 0, 4.9, '已上架', '短时高效间歇训练，20 分钟燃脂，适合时间紧的学生。'),
(10, '大学生营养搭配课', '王教练', 'meal', 0, '营养', 14, 188, 1, 4.7, '已上架', '食堂与外卖也能吃对，宏量营养素与控卡实操。'),
(11, '体态矫正与柔韧', '王教练', 'stretch', 0, '拉伸', 8, 221, 1, 4.8, '已上架', '改善圆肩驼背与久坐僵硬，每天 10 分钟跟练。'),
(12, '压力管理正念课', '王教练', 'mind', 0, '心理', 10, 134, 1, 4.6, '已上架', '正念呼吸与放松训练，缓解学业焦虑与改善睡眠。');
COMMIT;

-- ----------------------------
-- Table structure for qh_student_course
-- ----------------------------
DROP TABLE IF EXISTS `qh_student_course`;
CREATE TABLE `qh_student_course`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `student_id` bigint NOT NULL DEFAULT 1 COMMENT '学生编号',
  `course_id` bigint NOT NULL COMMENT '课程编号',
  `buy_time` date NULL DEFAULT NULL COMMENT '购买日期',
  `progress` int NOT NULL DEFAULT 0 COMMENT '学习进度 %',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  INDEX `idx_student_id`(`student_id` ASC) USING BTREE,
  INDEX `idx_course_id`(`course_id` ASC) USING BTREE,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '学生已购课程表';

-- ----------------------------
-- Records of qh_student_course
-- ----------------------------
BEGIN;
INSERT INTO `qh_student_course` (`id`, `student_id`, `course_id`, `buy_time`, `progress`) VALUES
(1, 1, 3, '2026-09-05', 100),
(2, 1, 5, '2026-09-20', 62),
(3, 1, 8, '2026-10-01', 35);
COMMIT;

-- ----------------------------
-- Table structure for qh_transaction
-- ----------------------------
DROP TABLE IF EXISTS `qh_transaction`;
CREATE TABLE `qh_transaction`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `tx_no` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '流水号',
  `tx_time` date NULL DEFAULT NULL COMMENT '交易日期',
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '类型：服务收入/平台抽成/课程收入',
  `role` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '归属：coach/platform',
  `amount` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '金额',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '说明',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  UNIQUE INDEX `uk_tx_no`(`tx_no` ASC) USING BTREE,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '交易流水表';

-- ----------------------------
-- Records of qh_transaction
-- ----------------------------
BEGIN;
INSERT INTO `qh_transaction` (`id`, `tx_no`, `tx_time`, `type`, `role`, `amount`, `description`) VALUES
(1, 'TX9001', '2026-09-12', '服务收入', 'coach', 1470, 'BK2601001 减脂塑形 8 周私教 · 首期结算'),
(2, 'TX9002', '2026-09-20', '平台抽成', 'platform', 220.5, 'BK2601001 平台佣金 15%'),
(3, 'TX9003', '2026-09-25', '服务收入', 'coach', 420, 'BK2601020 久坐体态矫正 6 次 · 尾款'),
(4, 'TX9004', '2026-09-25', '平台抽成', 'platform', 63, 'BK2601020 平台佣金 15%'),
(5, 'TX9005', '2026-10-02', '服务收入', 'coach', 1470, 'BK2601015 减脂塑形 8 周私教 · 首期结算'),
(6, 'TX9006', '2026-10-02', '平台抽成', 'platform', 220.5, 'BK2601015 平台佣金 15%'),
(7, 'TX9007', '2026-10-11', '服务收入', 'coach', 700, 'BK2601024 肩颈腰背舒缓 8 次 · 首期结算'),
(8, 'TX9008', '2026-10-11', '平台抽成', 'platform', 105, 'BK2601024 平台佣金 15%'),
(9, 'TX9009', '2026-10-05', '课程收入', 'platform', 9.9, '精品私教课包成交 · 抽成'),
(10, 'TX9010', '2026-10-08', '课程收入', 'platform', 9.9, '精品私教课包成交 · 抽成');
COMMIT;

-- ----------------------------
-- Table structure for qh_coach
-- ----------------------------
DROP TABLE IF EXISTS `qh_coach`;
CREATE TABLE `qh_coach`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `account` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '登录账号',
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '头像路径',
  `photo_pos` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '头像定位',
  `gender` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '性别',
  `age` int NOT NULL DEFAULT 0 COMMENT '年龄',
  `cert` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '资质证书',
  `specialty` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '专长',
  `tags` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '标签（逗号分隔）',
  `years` int NOT NULL DEFAULT 0 COMMENT '从业年限',
  `student_count` int NOT NULL DEFAULT 0 COMMENT '学员数',
  `rating` decimal(2,1) NOT NULL DEFAULT 0.0 COMMENT '评分',
  `order_count` int NOT NULL DEFAULT 0 COMMENT '接单数',
  `price_from` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '起价',
  `intro` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '简介',
  `apply_status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '入驻审核状态',
  `approve_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '审核通过时间',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '状态：在职/待入驻',
  `online` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否在线',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  UNIQUE INDEX `uk_account`(`account` ASC) USING BTREE,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '教练表';

-- ----------------------------
-- Records of qh_coach
-- ----------------------------
BEGIN;
INSERT INTO `qh_coach` (`id`, `name`, `account`, `photo`, `photo_pos`, `gender`, `age`, `cert`, `specialty`, `tags`, `years`, `student_count`, `rating`, `order_count`, `price_from`, `intro`, `apply_status`, `approve_time`, `status`, `online`) VALUES
(1, '刘教练', 'C001', '/assets/coaches/coach1.jpg', 'center 16%', '女', 29, '国家社会体育指导员（三级）· 运动康复师（初级）', '减脂塑形', '减脂,体态矫正,拉伸', 6, 48, 4.9, 132, 120, '体育学院运动人体科学硕士，6 年一线带教经验。擅长久坐人群的圆肩驼背与体态问题，方案以「先评估、再分级、后进阶」为主，不做超出能力范围的承诺。', '已通过', '2026-08-21', '在职', 1),
(2, '吴珊', 'C004', '/assets/coaches/coach3.jpg', 'center 18%', '女', 31, 'RYT-200 瑜伽教练 · 普拉提垫上教练', '瑜伽拉伸', '瑜伽,拉伸,产后修复', 8, 65, 4.8, 97, 100, '专注办公室人群的肩颈与腰背疼痛缓解，课程以呼吸与体式结合为主，课后给可自行完成的小练习清单。', '已通过', '2026-07-19', '在职', 1),
(3, '陈可欣', 'C002', '/assets/coaches/coach6.jpg', 'center 16%', '女', 26, '健身教练职业资格证', '增肌力量', '增肌,力量训练,塑形', 3, 12, 4.6, 15, 150, '健美体系训练背景，擅长为零基础学生设计渐进负荷的增肌路径，重视动作规范与恢复。', '待审核', '', '待入驻', 0),
(4, '赵铭', 'C003', '/assets/coaches/coach4.jpg', 'center 16%', '男', 34, '康复治疗师（初级）· 功能性动作筛查（FMS）认证', '体测康复', '体测,康复,姿态评估', 10, 31, 4.7, 44, 180, '医院康复科背景转私人教练，擅长慢性疼痛人群的评估与渐进式康复训练，接课前必做一次完整体测。', '待审核', '', '待入驻', 0),
(5, '周乐', 'C005', '/assets/coaches/coach5.jpg', 'center 18%', '男', 30, '国家田径级运动健将 · 体适能教练（中级）', '跑步耐力', '跑步,耐力,减脂', 7, 56, 4.8, 118, 130, '省队短跑组退役，现专注校园跑姿纠正与 5 公里配速提升。每周根据晨跑心率浮动调整强度，不追求单次成绩，只追求能持续跑下去。', '已通过', '2026-06-08', '在职', 1),
(6, '林岚', 'C006', '/assets/coaches/coach2.jpg', 'center 16%', '女', 32, '中国健美协会中级教练员 · 运动营养师（初级）', '力量增肌', '增肌,力量训练,塑形', 9, 73, 4.9, 156, 160, '健美体系训练背景，擅长为零基础学生设计渐进负荷的增肌路径。教学节奏偏严格但讲得清楚，重视动作规范与恢复，不推销补剂。', '已通过', '2026-05-22', '在职', 1),
(7, '苏航', 'C007', '/assets/coaches/coach7.jpg', 'center 18%', '男', 26, '健身教练职业资格证 · 功能性动作筛查（FMS）认证', '体能基础', '体能,基础塑形,习惯养成', 3, 19, 4.6, 28, 95, '体育学院毕业，带教风格耐心。专门接零基础学生，先把动作模式和训练习惯建立起来，再谈强度，课程以每周 3 次的小课为主。', '待审核', '', '待入驻', 0);
COMMIT;

-- ----------------------------
-- Table structure for qh_coach_service
-- ----------------------------
DROP TABLE IF EXISTS `qh_coach_service`;
CREATE TABLE `qh_coach_service`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `coach_id` bigint NOT NULL COMMENT '教练编号',
  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '服务标题',
  `sessions` int NOT NULL DEFAULT 0 COMMENT '课时数',
  `session_min` int NOT NULL DEFAULT 0 COMMENT '单次时长 分钟',
  `price` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '总价',
  `unit_price` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '单价',
  `includes` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '包含内容（JSON 数组）',
  `suitable` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '适合人群',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '状态：在售/下架',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  INDEX `idx_coach_id`(`coach_id` ASC) USING BTREE,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '教练服务包表';

-- ----------------------------
-- Records of qh_coach_service
-- ----------------------------
BEGIN;
INSERT INTO `qh_coach_service` (`id`, `coach_id`, `title`, `sessions`, `session_min`, `price`, `unit_price`, `includes`, `suitable`, `status`) VALUES
(1, 1, '减脂塑形 8 周私教', 16, 60, 1680, 105, '["每周 2 次线下 1 对 1","每次训练后饮食建议","8 周体态与围度复测","微信随时答疑"]', '体脂偏高、无运动基础、需要全程督促的在校生', '在售'),
(2, 1, '久坐体态矫正 6 次', 6, 50, 480, 80, '["圆肩驼背包法纠正","含 1 次 FMS 动作筛查","居家跟练视频 6 条","复测与调整方案"]', '长期伏案、已有轻微含胸或骨盆前倾的学生', '在售'),
(3, 1, '单次体验课', 1, 60, 120, 120, '["1 次 1 对 1 训练","基础体能评估","训练后拉伸指导"]', '首次接触私教、想先试一试', '在售'),
(4, 2, '肩颈腰背舒缓 8 次', 8, 55, 800, 100, '["呼吸放松 + 体式修复","每次课后居家小练习","办公室场景维护建议"]', '久坐肩颈不适、久坐腰痛的学生', '在售'),
(5, 2, '瑜伽入门 10 次', 10, 60, 1000, 100, '["哈他基础体系","呼吸与冥想练习","课后饮食作息建议"]', '零基础、偏好舒缓节奏的学生', '在售');
COMMIT;

-- ----------------------------
-- Table structure for qh_coach_booking
-- ----------------------------
DROP TABLE IF EXISTS `qh_coach_booking`;
CREATE TABLE `qh_coach_booking`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `booking_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '预约单号',
  `stu_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '学生姓名',
  `stu_id` bigint NOT NULL DEFAULT 0 COMMENT '学生编号',
  `coach_id` bigint NOT NULL DEFAULT 0 COMMENT '教练编号',
  `coach_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '教练姓名',
  `goal` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '目标',
  `goal_detail` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '目标详情',
  `service_id` bigint NOT NULL DEFAULT 0 COMMENT '服务包编号（0 表示待报价）',
  `service_title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '服务包标题',
  `sessions` int NOT NULL DEFAULT 0 COMMENT '总次数',
  `done_sessions` int NOT NULL DEFAULT 0 COMMENT '已完成次数',
  `price` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '金额',
  `quote_price` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '报价金额',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '状态',
  `booking_date` date NULL DEFAULT NULL COMMENT '预约创建日期',
  `start_date` date NULL DEFAULT NULL COMMENT '开始日期',
  `last_session_date` date NULL DEFAULT NULL COMMENT '最近一次上课日期',
  `next_session_date` date NULL DEFAULT NULL COMMENT '下次上课日期',
  `offline` int NOT NULL DEFAULT 0 COMMENT '线下已上次数',
  `payment` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '支付状态',
  `quote_accepted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否接受报价',
  `plan_id` bigint NULL DEFAULT NULL COMMENT '关联计划编号',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  UNIQUE INDEX `uk_booking_no`(`booking_no` ASC) USING BTREE,
  INDEX `idx_stu_id`(`stu_id` ASC) USING BTREE,
  INDEX `idx_coach_id`(`coach_id` ASC) USING BTREE,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '教练预约单表';

-- ----------------------------
-- Records of qh_coach_booking
-- ----------------------------
BEGIN;
INSERT INTO `qh_coach_booking` (`id`, `booking_no`, `stu_name`, `stu_id`, `coach_id`, `coach_name`, `goal`, `goal_detail`, `service_id`, `service_title`, `sessions`, `done_sessions`, `price`, `quote_price`, `status`, `booking_date`, `start_date`, `last_session_date`, `next_session_date`, `offline`, `payment`, `quote_accepted`, `plan_id`) VALUES
(1, 'BK2601001', '沈嘉禾', 1, 1, '刘教练', '减脂塑形', '体重偏高点，想在不影响上课的前提下 3 个月降 4kg，希望有人监督', 1, '减脂塑形 8 周私教', 16, 9, 1680, 0, '执行中', '2026-09-12', '2026-09-20', '2026-10-11', '2026-10-16', 8, '已支付', 1, 1),
(2, 'BK2601015', '周砚青', 3, 1, '刘教练', '增肌', '健身基础为零，希望系统增肌不受伤', 1, '减脂塑形 8 周私教', 16, 3, 1680, 0, '执行中', '2026-10-02', '2026-10-08', '2026-10-13', '2026-10-15', 3, '已支付', 1, 2),
(3, 'BK2601020', '陈屿', 5, 1, '刘教练', '体能提升', '准备体测，想提升 1000 米成绩', 2, '久坐体态矫正 6 次', 6, 6, 480, 0, '已完成', '2026-08-18', '2026-08-25', '2026-09-30', NULL, 6, '已支付', 1, 3),
(4, 'BK2601024', '苏念', 4, 2, '吴珊', '体态改善', '长期伏案，肩颈酸痛明显', 4, '肩颈腰背舒缓 8 次', 8, 0, 800, 0, '待制定计划', '2026-10-11', NULL, NULL, NULL, 0, '已支付', 1, NULL),
(5, 'BK2601027', '何昭', 6, 1, '刘教练', '减脂', '想先试试，咨询一下价格', 0, '', 0, 0, 0, 0, '待报价', '2026-10-14', NULL, NULL, NULL, 0, '待支付', 0, NULL),
(6, 'BK2601028', '林知遥', 2, 2, '吴珊', '体态矫正', '含胸，想改善体态', 0, '', 0, 0, 0, 0, '待接单', '2026-10-13', NULL, NULL, NULL, 0, '待支付', 0, NULL),
(7, 'BK2601031', '沈嘉禾', 1, 1, '刘教练', '体态改善', '长期伏案，肩颈容易酸胀，想改善圆肩', 2, '久坐体态矫正 6 次', 6, 6, 480, 0, '已完成', '2026-08-05', '2026-08-12', '2026-09-20', NULL, 6, '已支付', 1, NULL),
(8, 'BK2601035', '沈嘉禾', 1, 1, '刘教练', '肩颈放松', '想先做一次体验课试试效果', 0, '', 0, 0, 0, 0, '待报价', '2026-10-14', NULL, NULL, NULL, 0, '待支付', 0, NULL),
(9, 'BK2601036', '沈嘉禾', 1, 2, '吴珊', '体态矫正', '长期伏案，想改善圆肩含胸，每周能安排 2 次', 4, '肩颈腰背舒缓 8 次', 8, 0, 640, 640, '待报价', '2026-10-14', NULL, NULL, NULL, 0, '待支付', 0, NULL);
COMMIT;

-- ----------------------------
-- Table structure for qh_coach_plan
-- ----------------------------
DROP TABLE IF EXISTS `qh_coach_plan`;
CREATE TABLE `qh_coach_plan`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `booking_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '关联预约单号',
  `stu_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '学生姓名',
  `coach_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '教练姓名',
  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '计划标题',
  `period` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '周期',
  `goal` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '阶段目标',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '计划内容（JSON 数组）',
  `load_level` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '负荷等级',
  `rest_advice` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '休息建议',
  `check_point` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '检查节点',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '状态：执行中/已完成',
  `plan_date` date NULL DEFAULT NULL COMMENT '制定日期',
  `plan_update_date` date NULL DEFAULT NULL COMMENT '更新日期',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  INDEX `idx_booking_no`(`booking_no` ASC) USING BTREE,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '教练计划表';

-- ----------------------------
-- Records of qh_coach_plan
-- ----------------------------
BEGIN;
INSERT INTO `qh_coach_plan` (`id`, `booking_no`, `stu_name`, `coach_name`, `title`, `period`, `goal`, `content`, `load_level`, `rest_advice`, `check_point`, `status`, `plan_date`, `plan_update_date`) VALUES
(1, 'BK2601001', '沈嘉禾', '刘教练', '减脂塑形 8 周 · 第一阶段', '第 1-4 周', '建立运动习惯，心率区间稳定在 120-140', '["每周 2 次有氧 40 分钟（快走/慢跑交替）","每周 1 次全身力量循环（自重为主）","每日步数目标 8000 步以上","每周固定 2 天 23:30 前入睡"]', '中等', '训练日之间至少间隔 1 天；出现持续酸痛超过 3 天需降强度', '第 4 周复测体脂与腰围；体重降幅目标 1.5-2kg', '执行中', '2026-09-19', '2026-10-10'),
(2, 'BK2601015', '周砚青', '刘教练', '增肌基础 · 12 周渐进负荷', '第 1-3 周', '适应训练模式，关节无不适', '["每周 2 次器械力量（推 / 拉 / 腿 分日）","每次训练前 10 分钟动态热身","每日蛋白质摄入 1.6g/kg 体重","训练后 30 分钟补充碳水+蛋白"]', '中低', '同一肌群间隔 48 小时；每次训练记录重量与次数', '第 3 周评估深蹲动作，确认可进阶至中高负荷', '执行中', '2026-10-07', '2026-10-12'),
(3, 'BK2601020', '陈屿', '刘教练', '体能提升 · 12 周完整方案', '已完成', '1000 米成绩提升 40 秒', '["每周 3 次间歇跑（400m×6 组）","每周 2 次核心与下肢力量","每周 1 次长距离有氧 20 分钟","每 4 周一次 1000 米测试"]', '中高', '每周至少 1 天完全休息；睡眠不少于 7 小时', '12 周复测 1000 米，已达成目标，进入维持期', '已完成', '2026-09-18', '2026-09-29');
COMMIT;

-- ----------------------------
-- Table structure for qh_wallet
-- ----------------------------
DROP TABLE IF EXISTS `qh_wallet`;
CREATE TABLE `qh_wallet`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `owner` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '归属：student/coach/platform',
  `balance` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '余额',
  `withdrawable` decimal(10,2) NULL DEFAULT NULL COMMENT '可提现金额',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  UNIQUE INDEX `uk_owner`(`owner` ASC) USING BTREE,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '钱包表';

-- ----------------------------
-- Records of qh_wallet
-- ----------------------------
BEGIN;
INSERT INTO `qh_wallet` (`id`, `owner`, `balance`, `withdrawable`) VALUES
(1, 'student', 356, NULL),
(2, 'coach', 4060, 3060),
(3, 'platform', 0, NULL);
COMMIT;

-- ----------------------------
-- Table structure for qh_notification
-- ----------------------------
DROP TABLE IF EXISTS `qh_notification`;
CREATE TABLE `qh_notification`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `receiver` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'all' COMMENT '接收方：all/student/coach/admin',
  `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '通知类型',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '通知标题',
  `description` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '通知内容',
  `is_read` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否已读',
  `notify_time` datetime NULL DEFAULT NULL COMMENT '通知时间',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  INDEX `idx_receiver`(`receiver` ASC) USING BTREE,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '通知表';

-- ----------------------------
-- Table structure for qh_config
-- ----------------------------
DROP TABLE IF EXISTS `qh_config`;
CREATE TABLE `qh_config`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `config_key` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '配置键',
  `config_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '配置值',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '说明',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  UNIQUE INDEX `uk_config_key`(`config_key` ASC) USING BTREE,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '平台配置表';

-- ----------------------------
-- Records of qh_config
-- ----------------------------
BEGIN;
INSERT INTO `qh_config` (`id`, `config_key`, `config_value`, `description`) VALUES
(1, 'commission_rate', '0.15', '平台抽成比例'),
(2, 'water_goal', '2000', '每日饮水目标（ml）');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
