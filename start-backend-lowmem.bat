@echo off
chcp 65001 >nul
set JAVA_HOME=D:\dev\jdk21
set PATH=%JAVA_HOME%\bin;%PATH%
title yudao-server  [低内存模式 1GB]

echo ============================================================
echo   yudao-server  低内存启动
echo ------------------------------------------------------------
echo   堆上限 1GB  ^(JVM 默认是 3.9GB，会跟浏览器抢内存^)
echo   串行 GC     ^(小堆比 G1 省 200~400MB^)
echo   OOM 即退出  ^(不会卡成假死，直接报错^)
echo ------------------------------------------------------------
echo   如果启动报 OutOfMemoryError，把下面的 -Xmx1024m 改成 -Xmx1536m
echo ============================================================
echo.

D:\dev\jdk21\bin\java.exe -Xms256m -Xmx1024m -Xss512k -XX:MaxMetaspaceSize=256m -XX:MaxDirectMemorySize=256m -XX:+UseSerialGC -XX:+ExitOnOutOfMemoryError -Dfile.encoding=UTF-8 -jar D:\dev\projects\yudao-boot-mini\yudao-server\target\yudao-server.jar --server.port=48080

echo.
echo ============================================================
echo   服务已退出，按任意键关闭窗口
echo ============================================================
pause >nul
