package com.athena.module.users.mapper;

import java.util.List;

import com.athena.common.base.mapper.Mapper;
import com.athena.module.users.model.User;
import com.athena.module.users.model.UserExample;
import com.athena.module.users.model.UserExampleDefined;

public interface UserMapper extends Mapper<User, UserExample> {

	/**
	 * 自定义用户分页查询
	 * @param example
	 * @return
	 */
	List<User> selectPageUser(UserExampleDefined example);

	/**
	 * 自定义用户总数查询
	 * @param example
	 * @return
	 */
	Integer selectUserCount(UserExampleDefined example);
}