
/** 菜单表*/
CREATE TABLE `kernel_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单编号',
  `menu_name` varchar(20) NOT NULL COMMENT '菜单名称',
  `menu_url` varchar(255) default NULL COMMENT '菜单URL',
  `parent_id` bigint(20) default NULL COMMENT '父菜单ID',
  `privilege_code` bigint(20) NOT NULL COMMENT '权限码',
  `privilege_pos` int(11) NOT NULL COMMENT '权限位',
  `description` varchar(255) default NULL COMMENT '菜单说明',
  `menu_order` int(11) NOT NULL COMMENT '菜单顺序',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台管理系统导航菜单'


/** 菜单角色关联表*/
CREATE TABLE `kernel_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和菜单权限关联表'


/*
	查看是否有权限: 总和 & 权限码  [相同组]
	计算每组权限总和: 权限码 | 权限码
	添加, 查询目前最大的权限位, 在查询最大权限码, 添加
	用户权限总和, 遍历用户对应角色的所有权限, 根据权限位分组求和, 存入Map<pos,codeSum> tip: group by
*/