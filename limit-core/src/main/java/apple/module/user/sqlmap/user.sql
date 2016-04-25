/**
 * 用户表
 */
CREATE TABLE `kernel_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(50) NOT NULL COMMENT '管理员昵称',
  `password` varchar(64) NOT NULL COMMENT '管理员密码',
  `username` varchar(12) NOT NULL COMMENT '管理员账户',
  `status` char(1) NOT NULL default '1' COMMENT '管理员账户状态 [0:停用; 1:正常]',
  `email` varchar(100) default NULL COMMENT '管理员邮箱',
  `last_access_time` date default NULL COMMENT '最后一次访问时间',
  `last_access_adress` varchar(20) default NULL COMMENT '最后一次访问IP',
  `create_user_id` bigint(20) NOT NULL COMMENT '该账户的创建者ID',
  `create_time` datetime COMMENT '该账户的创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统后台管理员'



/**
 * 角色表
 */
CREATE TABLE `kernel_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(1000) default NULL,
  `rolename` varchar(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统后台管理角色'

/**
 * 用户角色关联
 */
CREATE TABLE `kernel_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) default NULL,
  `role_id` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `user_role_user_id_index` (`user_id`),
  KEY `user_role_role_id_index` (`role_id`),
  KEY `user_role_union_index` (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统后台管理用户和角色的关联表'
