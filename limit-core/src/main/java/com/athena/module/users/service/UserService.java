package com.athena.module.users.service;

import java.math.BigDecimal;
import java.util.List;

import com.athena.common.base.service.Service;
import com.athena.module.users.model.User;
import com.athena.module.users.model.UserExample;
import com.athena.module.users.model.UserExampleDefined;

public interface UserService extends Service<User, UserExample> {

	/**
	 * 检测用户名没有被录入
	 * @param username
	 */
	boolean selectIsNotExistUsername(String username);

	/**
	 * 插入用户
	 * @param model
	 * @param createor
	 * @return
	 */
	void insert(User model, User creator);

	/**
	 * 更新用户, 更新用户和角色和部门机构的关联
	 * @param user
	 */
	void update(User user);

	/**
	 * 自定义用户分页查询
	 * @param exam
	 * @return
	 */
	List<User> selectUserPage(UserExampleDefined example);

	/**
	 * 自定义用户总数查询
	 * @param support
	 * @return
	 */
	int selectUserCount(UserExampleDefined example);

	/**
	 * 查询用户级联角色信息
	 * @param id
	 * @return
	 */
	User load(BigDecimal id);

	/**
	 * 删除用户, 级联删除权限关系
	 * @param id
	 */
	void remove(BigDecimal id);
}
