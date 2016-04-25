CREATE TABLE `kernel_opt_dic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `opt_name` varchar(100) default '' COMMENT '选项字典名称',
  `opt_key` varchar(100) default '' COMMENT '选项储存值',
  `opt_val` varchar(500) default '' COMMENT '选项显示值',
  `parent_id` bigint(20) default NULL COMMENT '父菜单ID',
  `description` varchar(1000) default '' COMMENT '选项说明',
  PRIMARY KEY  (`id`),
  KEY `opt_name_index` (`opt_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统选项字典'
