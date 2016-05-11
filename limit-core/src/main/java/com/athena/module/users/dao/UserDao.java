package com.athena.module.users.dao;

import java.util.List;

import com.athena.common.base.dao.Dao;
import com.athena.common.dto.PageResult;
import com.athena.module.users.model.User;
import com.athena.module.users.model.UserExample;

public interface UserDao extends Dao<User, UserExample> {

	/**
	 * 自定义用户分页查询
	 * @param example
	 * @return
	 */
	List<User> selectPageUser(PageResult<User> example);

	/**
	 * 自定义用户总数查询
	 * @param example
	 * @return
	 */
	Integer selectUserCount(PageResult<User> example);
}
