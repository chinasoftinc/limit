package com.athena.module.menus.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.athena.common.base.dao.Dao;
import com.athena.module.menus.model.Menu;
import com.athena.module.menus.model.MenuExample;

public interface MenuDao extends Dao<Menu, MenuExample> {

	/**
	 * 查询最大权限位
	 * @return
	 */
	Long selectMaxPrivilegePos();

	/**
	 * 查询指定权限位中的最大权限码
	 * @param privilegePos
	 * @return
	 */
	Long selectMaxPrivilegeCode(@Param("privilegePos") Long privilegePos);

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
	List<Menu> selectMenusByRoleIds(List<BigDecimal> roleIds);
}
