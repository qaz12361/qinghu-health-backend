# 青护 · 大学生健康管理平台（后端）

基于 **Spring Boot 3.2 + MyBatis-Plus + MySQL + Redis + JWT** 的健康管理平台后端，
为「学生 / 教练 / 管理员」三种角色提供健康数据管理、教练预约与支付、循证健康指南等能力。
项目基于 [yudao-boot-mini](https://gitee.com/yudaocode/yudao-boot-mini) 开源脚手架二次开发，
业务模块（`qinghu` / `fresh`）为独立设计与实现。

> 配套前端：Vue 3 + Vite（C 端）与 yudao-ui-admin-vue3（管理后台），分别运行于 5173 / 80 端口。

## 技术栈

- 框架：Spring Boot 3.2、MyBatis-Plus、JDK 17
- 存储：MySQL 8.0、Redis 6+
- 安全：JWT 鉴权、多租户（`tenant-id` 请求头）
- 构建：Maven 3.9（ JDK 17 编译）

## 核心功能

| 角色 | 主要功能 |
|------|----------|
| 学生 | 健康数据记录与图表、教练广场浏览/预约、订单支付与钱包、循证指南阅读与标记 |
| 教练 | 学员管理、训练计划制定、报价与课次打卡、服务结算 |
| 管理员 | 用户/教练管理、课程与内容管理、数据看板、循证指南章节与条目维护 |

系统采用**聚合接口**设计：`/app-api/qinghu/bootstrap` 一次下发健康记录、目标、教练、订单、钱包、流水、指南等十余类数据，前端统一水合渲染，降低首屏请求数。

## 目录结构

```
yudao-module-system/   业务模块（controller/service/dal/dataobject 下的 qinghu、fresh 包）
yudao-server/          启动模块与配置文件（application*.yaml）
sql/mysql/             本项目的建表、菜单与数据脚本（qh_*.sql）
script/                构建与部署辅助脚本
```

## 本地运行

> ⚠️ 本项目已公开的配置文件中，所有密码/密钥均已替换为 `${CHANGE_ME}` 占位符，
> **首次运行前请填写你自己的本地配置**，切勿把真实密码提交到公开仓库。

1. 安装 JDK 17、Maven 3.9、MySQL 8.0、Redis。
2. 创建数据库 `fresh_market`，依次执行 `sql/mysql/` 下的 `qh_*.sql` 脚本。
3. 打开 `yudao-server/src/main/resources/application-local.yaml`，
   将 `${CHANGE_ME}` 替换为本地的 MySQL 密码与 Redis 密码（其余第三方密钥按实际需要填写，无则可留空）。
4. 编译并启动：

   ```bash
   mvn clean install -DskipTests
   cd yudao-server && mvn spring-boot:run
   ```

   服务默认监听 `48080` 端口。

## 说明

- 所有数据库脚本位于 `sql/mysql/`，使用 `utf8mb4` 字符集；表结构变更均提供增量脚本。
- 业务接口分为 C 端（`/app-api/qinghu/**`）与管理端（`/admin-api/**`），请求需带 `tenant-id: 1`。
- 本项目仅用于毕业设计与学习交流，第三方服务的密钥与真实业务数据未包含在内。
