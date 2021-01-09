copy C:\Users\Administrator\Desktop\batch\a.txt C:\Users\Administrator\Desktop\batch\2.txt









@echo off  
rem 设置a变量  
set "a=有;b=一;c=只;d=小;e=猫;f=！"  
rem 替换a变量的内容进行多个变量定义  
rem 替换";"号为"&set空格"  
set a=%a:;=&set %  
echo %a%,%b%,%c%,%d%,%e%,%f%  
pause


@echo off  
rem 将test.txt的第一行赋值比变量var  
set /p var=<test.txt  
rem 替换后生成新的文件  
echo %var:看=查% >new_test.txt


@echo off  
rem 设置一个变量  
set "var=一个A，加一个A，在加一个A，在加一个"  
rem 重新定义var,将左边第一次出现的A和A前面的所有字符替换为空  
set var=%var:*A=%  
echo %var%  
pause


@echo off  
rem 设置一个变量  
set var=做车的跟做鞋的打起来了  
rem 删除变量中的"打起来了",替换字符为空,重新定义var  
set var=%var:打起来了=%  
echo %var%  
pause 


@echo off  
rem 设置一个变量  
set var=QQ大战360  
rem 替换变量中的"大战"为"PK",显示出来  
echo %var:大战=PK%  
pause  
rem 重新定义var的值  
set var=%var:大战=PK%  
echo %var%  
pause 


@echo off  
rem 在当前目录下创建了a目录，然后a目录下创建b,b目录下创建c目录  
md a\b\c 


@echo off  
rem 在当前目录创建一个"a b"文件夹  
md "a b"  
rem 出现错误,只创建了一个a文件夹  
md a&b  
rem 在当前目录创建一个"a&b"文件夹  
md "a&b"


@echo off  
rem 在当前目录下创建三个目录aa,bb,cc  
md aa bb cc  
rem 可以使用逗号分隔  
md a1,b1,c1  
rem 可以使用分号分隔  
md a2;b2;c2


@echo off  
rem 在当前目录下创建test目录  
md test  
rem 在d盘根目录下创建test目录  
md d:\test 


    @echo off  
    rem 改变当前目录为"E:\office"  
    cd /d E:\office  
    rem 这时可以直接用start打开文件  
    start WINWORD.EXE  
    pause  


@echo off  
rem 运行的两次命令效果相等  
cd /d C:\Documents and Settings\Administrator  
echo %cd%  
cd /d "C:\Documents and Settings\Administrator"  
echo %cd%  
pause 


@echo off  
rem 当前目录  
echo %cd%  
rem 改变后目录  
cd /d d:\aa  
echo %cd%  
pause  


@echo off  
rem 两个命令都可以生成空文件  
echo. >a.txt  
cd. >b.txt 


@echo off  
rem 进入当前目录  
cd.  
echo %cd%  
rem 进入上一级目录  
cd..  
echo %cd%  
rem 进入根目录  
cd\  
echo %cd%  
pause



@echo off  
rem 删除所有txt文件，不管是当前目录的什么位置和属性都删除  
del /f /s /q /a *.txt 



@echo off  
rem hide.txt含有隐藏属性，无法找到文件  
del hide.txt  
pause  
rem h表示隐藏文件,指定删除隐藏文件hide.txt  
del /ah hide.txt  
del /f a.txt 


@echo off  
rem 删除当前目录下所有目录中的txt文件  
del /f /q /s *.txt  
del /f a.txt 


@echo off  
rem 强制删除当前目录下所有目录包括子目录中的test.txt文件  
del /f /s test.txt  
del /f a.txt 



@echo off  
copy c:\test\test.txt d:\ 


@echo off  
ping /n 1 127.1 >nul && echo yes! || echo no!  
ping /n 1 /w 1000 99.99 >nul && echo yes! || echo no!  
pause 


@echo off  
rem 发送0字节数据包,ping 一个不通的地址99.99,并设置超时间隔为1000毫秒  
ping /n 1 /l 0 /w 1000 99.99 >nul  
echo yes!  
pause 


@echo off  
rem ping 127.0.0.1这个地址4次!  
ping /n 4 127.0.0.1 >nul  
pause


    @echo off  
    rem 因为是只是要显示提示，所以变量名可不写  
    set /p=换<nul  
    set /p=行<nul  
    set /p=符<nul  
    rem echo.相当于换了一行(回车)  
    echo.  
    pause  



    @echo off  
    rem 将a.txt第一行的内容赋值比变量a，并不等待用户输入  
    set /p a=<a.txt  
    rem var值为空字符，并显示提示，不等待用户输入  
    set /p var=test<nul  
    pause  


@echo off  
rem 提示输入网址，批会暂停执行等待用户输入  
set /p var=请输入网址:  
rem "提示"不作变量的值，var的值为用户输入的  
echo %var%  
pause


@echo off  
rem 设置多个变量，变量值为汉字  
set /a a=批,b=处,c=理  
rem 值为0  
echo %a%  
echo %b%  
echo %c%  
pause 


@echo off  
rem 尝试设置变量名"a="的值为test  
set a==test  
rem 显示的是空行，不存在变量a=  
echo.%a=%  
rem 变量值为"=test"  
echo %a%  
pause








@echo off
rem xx01
set var=xxxxx
rem xx02
echo %var%  
pause
rem xx03
set var= 
echo %var% 



rem @echo off 
rem pause
rem start explorer.exe
rem pause >nul

rem @echo off  
rem echo.非常批处理  
rem pause  
rem echo 的常用方法2  
rem echo 跟符号">"或">>" 结合可以用来生成写入文件  
      
rem @echo off  
rem echo 这是个啥？ >test.txt
rem echo 不告诉你 >>test.txt
rem echo xxxx >>test.txt

 
rem 显示所有以字母a开头的变量  
rem set a  
rem pause 
rem @echo off
rem 设置变量var的值为"批处理"  
set var=批处理  
rem 显示变量var的值  
echo %var%  
rem 取消var变量  
set var= 









