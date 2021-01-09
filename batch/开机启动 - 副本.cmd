::date:20.07.03
::author: jeff
::reg_run
::reg add 
REM @echo off
REM title 添加至开机启动
REM color 0a
REM mode con cols=40 lines=20
REM set /p softname=软件名(不要后缀)：
REM set /p location=文件位置：
REM cls
REM reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Run" /v %softname% /t REG_SZ /d "%location%\%softname%.exe" /f
REM echo 添加成功！！
REM exit
reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Run" /v flux /t REG_SZ /d "C:\Users\Administrator\AppData\Local\FluxSoftware\Flux\flux.exe" /f

