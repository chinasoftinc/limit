package com.athena.module.users.service;

import java.math.BigDecimal;
import java.util.List;

import com.athena.common.base.service.Service;
import com.athena.common.dto.PageResult;
import com.athena.module.users.model.User;
import com.athena.module.users.model.UserExample;

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
	void insertUser(User model, User creator);

	/**
	 * 更新用户, 更新用户和角色和部门机构的关联
	 * @param user
	 */
	void updateUser(User user, User creator);

	/**
	 * 自定义用户分页查询
	 * @param exam
	 * @return
	 */
	List<User> selectUserPage(PageResult<User> example);

	/**
	 * 自定义用户总数查询
	 * @param support
	 * @return
	 */
	int selectUserCount(PageResult<User> example);

	/**
	 * 查询用户级联角色机构部门名称
	 * @param id
	 * @return
	 */
	User getUserInfo(BigDecimal id);

	/**
	 * 查询用户级联角色id
	 * @param id
	 * @return
	 */
	User getUserWithRoleIds(BigDecimal id);

	/**
	 * 删除用户, 级联删除权限关系
	 * @param id
	 * @param creator 
	 */
	void removeUser(BigDecimal id, User creator);

	/**
	 * 检测用户名是否没有被使用
	 * @param username
	 * @return
	 */
	boolean isNotExistUserName(String username);
}
