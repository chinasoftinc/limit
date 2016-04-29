CREATE TABLE `kernel_area` (
  `AreaId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '地区ID',
  `AreaName` varchar(50) NOT NULL COMMENT '地区名称',
  `ParentAreaId` bigint(20) NOT NULL COMMENT '地区父Id,顶级地域时值为0',
  `AreaLevel` int(1) NOT NULL COMMENT '地区层级',
  PRIMARY KEY  (`AreaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='地域基本信息表'

