@echo off
::�˵�����
color 0a
mode con cols=60 lines=20
title �򿪷�������
:menu

::echo ***** �򿪷������� *****
::echo.
::echo 1.����������
::echo.
::echo 2.Edge�������
::echo.
::echo ************************
::set /p aa=��ѡ��
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


