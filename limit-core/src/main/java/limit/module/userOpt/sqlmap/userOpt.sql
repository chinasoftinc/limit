CREATE TABLE `kernel_user_opt` (
  `id` bigint(20) NOT NULL AOTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '管理员ID',
  `nickname` varchar(20) NOT NULL COMMENT '管理员昵称',
  `is_success` char(1) NOT NULL COMMENT '操作是否成功 [0:失败; 1:成功]',
  `opt_type` char(1) NOT NULL COMMENT '操作类型 [1:插入; 2:更新; 0:删除]',
  `entity_type` varchar(50) NOT NULL COMMENT '操作实体的类型 [具体在静态或字典中定义, 存中文]',
  `entity_id` bigint(20) NOT NULL COMMENT '操作实体的ID',
  `entity_title` varchar(50) NOT NULL COMMENT '操作实体的标题',
  `opt_time` datetime default NULL COMMENT '操作时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
