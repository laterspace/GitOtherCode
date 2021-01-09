@echo off

del %windir%\system32\drivers\etc\hosts
del %windir%\sysnative\drivers\etc\hosts

rem cd C:\WINDOWS\system32\drivers\etc

echo #7346ce6e-b23e-410e-8344-e718d1af2669>>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.142 zhu.wuyouxitong.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.142 bei.wuyouxitong.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.142 zsxd.wuyouxitong.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.142 kz.wuyouxitong.com >>C:\WINDOWS\system32\drivers\etc\hosts

echo 192.168.1.142 zhu.heisha.net >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.142 bei.heisha.net >>C:\WINDOWS\system32\drivers\etc\hosts

echo 192.168.1.142 bei.118wa.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.142 zhu.118wa.com >>C:\WINDOWS\system32\drivers\etc\hosts

echo 192.168.1.142 link1.lmtonlink.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.142 link2.lmtonlink.com >>C:\WINDOWS\system32\drivers\etc\hosts

echo 192.168.1.142 link1.dbconlink.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.142 link2.dbconlink.com >>C:\WINDOWS\system32\drivers\etc\hosts

echo 192.168.1.142 link1.dndonlink.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.142 link2.dndonlink.com >>C:\WINDOWS\system32\drivers\etc\hosts

echo 192.168.1.142 rjgjz1.qishixitong.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.142 rjgjb1.qishixitong.com >>C:\WINDOWS\system32\drivers\etc\hosts

echo 192.168.1.142 zhu.drivewlink.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.142 bei.drivewlink.com >>C:\WINDOWS\system32\drivers\etc\hosts

echo 192.168.1.87 driverz.qishixitong.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.87 driverb.qishixitong.com >>C:\WINDOWS\system32\drivers\etc\hosts

echo 192.168.1.10 driver.win2008.com >>C:\WINDOWS\system32\drivers\etc\hosts

echo 192.168.1.142 zhu.geniuslinkz.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.142 bei.geniuslinkz.com >>C:\WINDOWS\system32\drivers\etc\hosts

echo 192.168.1.142 zhu.dadilink.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.142 bei.dadilink.com >>C:\WINDOWS\system32\drivers\etc\hosts

echo 192.168.1.142 zhu.onekeylinks.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.142 bei.onekeylinks.com >>C:\WINDOWS\system32\drivers\etc\hosts

echo 192.168.1.142 rm-wz96wu1324a747r6po.mysql.rds.aliyuncs.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.142 rm-wz9d0a15l4108kg58ro.mysql.rds.aliyuncs.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.142 rm-wz9uiy80b748sigl4o.mysql.rds.aliyuncs.com >>C:\WINDOWS\system32\drivers\etc\hosts

echo 192.168.1.29 driverz.qishixitong.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.29 driverb.qishixitong.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.29 drive.ruanjiandown.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.142 zhu.amuzhuangji.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.142 bei.amuzhuangji.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.198 rj.ruanjiandown.com >>C:\WINDOWS\system32\drivers\etc\hosts
echo 192.168.1.198 xbyb.ruanjiandown.com >>C:\WINDOWS\system32\drivers\etc\hosts




rem >>C:\WINDOWS\system32\drivers\etc\hosts
rem >C:\WINDOWS\system32\drivers\etc\hosts

md "D:\WINDOWS\system32\drivers\etc\"

copy %windir%\system32\drivers\etc\hosts D:\WINDOWS\system32\drivers\etc\

ping zhu.wuyouxitong.com
ping zhu.heisha.net

ping zhu.118wa.com

exit