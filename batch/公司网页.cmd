
@ECHO OFF
::data:20.06.22
title ��˾������ҳ����
::   color /?	����ϲ������ɫ:2F(���д���)��0a�����д��̣�
color 0a
mode con cols=60 lines=20


:: ============================================================
echo	===========��˾������ҳ����=============
:menu
ECHO.
ECHO.
echo 	��ѡ��Ҫ���еĲ����������س���
ECHO.
ECHO 	1.����������ҳ
ECHO.
ECHO 	2.����
ECHO.
ECHO 	3.�˳�
ECHO.
ECHO.
SET /P aa=��ѡ��
GOTO choice%aa%

:choice1
rem start iexplore "http://www.publisher.com/"
start "" "F:\soft_tools\1\maxthon_portable_5.3.8.2000\MaxthonPortable\Bin\Maxthon.exe" "http://www.publisher.com/"
pause
cls
GOTO menu

:choice2
rem start iexplore "http://www.publisher.com/"
start "" "F:\soft_tools\RunningCheeseFirefox\Firefox\firefox.exe" "http://192.168.1.197/zentao/doc-browse-111-all-0-id_desc.html"
pause
cls
GOTO menu


:choice3
exit

:: ==============================================================
::ECHO %confirm% | FINDSTR /I "y" > NUL && GOTO confirm




::    echo ���ļ�����Ƿ���Ҫ���������������?
  ::  echo 1.���� 2.�ر�
::    set "choice="&set/p choice=�������ѡ��(1/2/q):
::    if /i "%choice%"=="q" goto end
::    echo %choice%|findstr "^[12]$">nul 2>nul&&goto choice%choice%
::    goto end
 ::   :choice1
 ::   sc config AudioSrv start= AUTO
::    goto end
::   :choice2
 ::   sc config AudioSrv start= DISABLED

    