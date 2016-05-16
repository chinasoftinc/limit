package com.athena.module.rolemenu.dao;

import org.springframework.stereotype.Repository;

import com.athena.common.base.dao.AbstractDao;
import com.athena.module.rolemenu.model.RoleMenu;
import com.athena.module.rolemenu.model.RoleMenuExample;

@Repository
public class RoleMenuDaoImp extends AbstractDao<RoleMenu, RoleMenuExample> implements RoleMenuDao {

	@Override
	public String sequenceName() {
		return "T_ROLE_MENU_SEQ";
	}

}
