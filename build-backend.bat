@echo off
set JAVA_HOME=D:\dev\jdk21
set PATH=%JAVA_HOME%\bin;%PATH%
cd /d D:\dev\projects\yudao-boot-mini
echo BUILD_START %date% %time% > C:\Users\21028\WorkBuddy\2026-10-10-21-10-50\maven-build.log
D:\dev\apache-maven-3.9.9\bin\mvn.cmd -pl yudao-server -am -DskipTests package >> C:\Users\21028\WorkBuddy\2026-10-10-21-10-50\maven-build.log 2>&1
echo BUILD_EXIT=%ERRORLEVEL% >> C:\Users\21028\WorkBuddy\2026-10-10-21-10-50\maven-build.log
