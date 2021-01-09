@echo off 
color 1F 
@title=优化系统 
echo 您好我是优化软件，先为您查询今日日期和现在的时间。 
ping 127.0.0.1 /n 2 >nul 
echo %date:~0,4%年%date:~5,2%月%date:~8,2%日%time:~0,8% 
pause 
ping%