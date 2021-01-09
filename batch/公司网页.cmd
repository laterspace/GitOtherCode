
@ECHO OFF
::data:20.06.22
title 公司工作网页集中
::   color /?	个人喜欢的颜色:2F(绿中带白)，0a（黑中带绿）
color 0a
mode con cols=60 lines=20


:: ============================================================
echo	===========公司工作网页集中=============
:menu
ECHO.
ECHO.
echo 	请选择要进行的操作，并按回车：
ECHO.
ECHO 	1.发布工具网页
ECHO.
ECHO 	2.禅道
ECHO.
ECHO 	3.退出
ECHO.
ECHO.
SET /P aa=请选择：
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




::    echo 您的计算机是否需要开启声音输出服务?
  ::  echo 1.开启 2.关闭
::    set "choice="&set/p choice=输入你的选择(1/2/q):
::    if /i "%choice%"=="q" goto end
::    echo %choice%|findstr "^[12]$">nul 2>nul&&goto choice%choice%
::    goto end
 ::   :choice1
 ::   sc config AudioSrv start= AUTO
::    goto end
::   :choice2
 ::   sc config AudioSrv start= DISABLED

    