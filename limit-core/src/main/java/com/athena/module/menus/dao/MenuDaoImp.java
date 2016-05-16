package com.athena.module.menus.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.athena.common.base.dao.AbstractDao;
import com.athena.module.menus.mapper.MenuMapper;
import com.athena.module.menus.model.Menu;
import com.athena.module.menus.model.MenuExample;

@Repository
public class MenuDaoImp extends AbstractDao<Menu, MenuExample> implements MenuDao {

	@Autowired
	private MenuMapper menuMapper;

	@Override
	public String sequenceName() {
		return "T_MENUS_SEQ";
	}

	@Override
	public Integer selectMaxPrivilegePos() {
		return menuMapper.selectMaxPrivilegePos();
	}

	@Override
	public Long selectMaxPrivilegeCode(Integer privilegePos) {
		return menuMapper.selectMaxPrivilegeCode(privilegePos);
	}

	@Override
	public Short selectMaxSortNo(BigDecimal id) {
		Short order = menuMapper.selectMaxSortNo(id);
		return order == null || order < 1 ? 1 : order;
	}

	@Override
	public List<Menu> selectMenusByRoleIds(List<Long> roleIds) {
		return menuMapper.selectMenusByRoleIds(roleIds);
	}

}
