::date:20.07.03
::author: jeff
::reg_run
::reg add 
@echo off
title �������������
color 0a
mode con cols=40 lines=20
set /p softname=�����(��Ҫ��׺)��
set /p location=�ļ�λ�ã�
cls
reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Run" /v %softname% /t REG_SZ /d "%location%\%softname%.exe" /f
echo ��ӳɹ�����
exit
::reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Run" /v RunAny /t REG_SZ /d "F:\soft_tools\1\��RunAny��v5.7.3_һ�����ݵĿ�����������\RunAny-5.7.3\RunAny.exe" /f

