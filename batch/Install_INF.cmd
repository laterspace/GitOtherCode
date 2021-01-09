@echo off
cd /D %~dp0
pnputil -i -a *.inf
pause