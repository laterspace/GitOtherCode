@echo off
::菜单配置
color 0a
mode con cols=60 lines=20
title 打开发布工具
:menu

::echo ***** 打开发布工具 *****
::echo.
::echo 1.火狐浏览器打开
::echo.
::echo 2.Edge浏览器打开
::echo.
::echo ************************
::set /p aa=请选：
::GOTO choice%aa%

:::choice1
start "" "F:\soft_tools\RunningCheeseFirefox\Firefox\firefox.exe" "http://www.publisher.com/"
::exit
::pause
::cls
::GOTO menu

:::choice2
rem start iexplore "http://www.publisher.com/"
::start "" "F:\soft_tools\RunningCheeseEdge\msedge.exe" "http://www.publisher.com/"
::exit
::pause
::cls
::GOTO menu


