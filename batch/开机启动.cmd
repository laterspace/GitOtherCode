::date:20.07.03
::author: jeff
::reg_run
::reg add 
@echo off
title 添加至开机启动
color 0a
mode con cols=40 lines=20
set /p softname=软件名(不要后缀)：
set /p location=文件位置：
cls
reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Run" /v %softname% /t REG_SZ /d "%location%\%softname%.exe" /f
echo 添加成功！！
exit
::reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Run" /v RunAny /t REG_SZ /d "F:\soft_tools\1\【RunAny】v5.7.3_一劳永逸的快速启动工具\RunAny-5.7.3\RunAny.exe" /f

