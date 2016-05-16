package com.athena.module.menus.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.athena.common.base.mapper.Mapper;
import com.athena.module.menus.model.Menu;
import com.athena.module.menus.model.MenuExample;

public interface MenuMapper extends Mapper<Menu, MenuExample> {

	/**
	 * 查询最大权限位
	 * @return
	 */
	Integer selectMaxPrivilegePos();

	/**
	 * 查询指定权限位中的最大权限码
	 * @param privilegePos
	 * @return
	 */
	Long selectMaxPrivilegeCode(@Param("privilegePos") Integer privilegePos);

	/**
	 * 查询当前数据库最大的菜单排序
	 * @return
	 */
	Short selectMaxSortNo(BigDecimal id);

	/**
	 * 根据角色id集合查询所有菜单
	 * @param roleIds
	 * @return
	 */
	List<Menu> selectMenusByRoleIds(List<Long> roleIds);
}