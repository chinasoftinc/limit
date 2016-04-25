## 使用yum安装VSFtp
	yum -y install vsfptd 安装
	
	# 加入到自启动
	chkconfig --list | grep vsftpd 查看自启项目代号
	chkconfig --level 2345 vsftpd on 开启自启
	
	# 简单配置
	anounmous_enable = NO 改为NO, 禁用匿名
	#vi /etc/vsftpd/vsftpd.conf 配置文件位置
	/usr/sbin/adduser -d /opt/ftpuser -g ftp -s /sbin/nologin ftpuser 增加一个ftp用户, 限制登录, 并指定用户的根目录
	chroot_local_user=yes 限制用户目录	
	编辑/etc/selinux/config，找到SELINUX 行修改成为：SELINUX=disabled 重启系统。
	
## VSFtp配置详解:
	1. /etc/vsftpd.ftpusers: 处于该文件中的用户都不能访问ftp
	2. /etc/vsftpd.user_list: 如果/etc/vsftpd/vsftpd.config中的userlist_deny=yes, 则该文件所有的用户不能访问ftp
	3. vsftpd.conf
		1. idle_session_timeout: 连接被静止多长时间会自动断开, 单位秒 推荐: 30
		2. data_connection_time: 传输过程被阻塞的最长时间, 超过该时间自动断开, 推荐100
		3. max_per: 单个客户端IP的最大连接数, 限定注入迅雷,bt都下载手段, 默认为0, 不限定
		4. local_max_rate: 限定用户的传输速度, 单位: b/s.