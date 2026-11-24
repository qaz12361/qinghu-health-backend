@echo off
set JAVA_HOME=D:\dev\jdk21
set PATH=%JAVA_HOME%\bin;%PATH%
REM 杀掉占用 48080 端口的旧后端（它在占用 yudao-server.jar，导致无法 repackage）
for /f "tokens=5" %%a in ('netstat -aon ^| findstr :48080 ^| findstr LISTENING') do taskkill /f /pid %%a
timeout /t 3 >nul
cd /d D:\dev\projects\yudao-boot-mini
echo REBUILD_START %date% %time% > C:\Users\21028\WorkBuddy\2026-10-10-21-10-50\maven-build.log
D:\dev\apache-maven-3.9.9\bin\mvn.cmd -pl yudao-server -am -DskipTests package >> C:\Users\21028\WorkBuddy\2026-10-10-21-10-50\maven-build.log 2>&1
echo BUILD_EXIT=%ERRORLEVEL% >> C:\Users\21028\WorkBuddy\2026-10-10-21-10-50\maven-build.log
