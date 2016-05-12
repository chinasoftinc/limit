package com.athena.module.users.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athena.common.base.service.AbstractService;
import com.athena.common.context.Constants;
import com.athena.common.dto.PageResult;
import com.athena.module.users.dao.UserDao;
import com.athena.module.users.model.User;
import com.athena.module.users.model.UserExample;

@Service
public class UserServiceImp extends AbstractService<User, UserExample> implements UserService {

	@Autowired
	private UserDao userdao;

	@Override
	public boolean selectIsNotExistUsername(String username) {

		UserExample example = new UserExample();
		example.or().andUserNameEqualTo(username).andIsDelEqualTo(Constants.IS_DEL.NOT.code);
		return countByExample(example) == 0;
	}

	@Override
	public List<User> selectUserPage(PageResult<User> example) {
		return userdao.selectPageUser(example);

	}

	@Override
	public int selectUserCount(PageResult<User> example) {
		return userdao.selectUserCount(example);
	}

	@Override
	public void insertUser(User user, User creator) {

		// 保存角色关联
		if (StringUtils.isNotEmpty(user.getRoles())) {
			String[] roleIds = user.getRoles().split(",");
			for (String roleId : roleIds) {
				releativeUserRole(user.getId(), new BigDecimal(roleId));
			}
		}

		// 记录操作用户
		if (creator != null) {
			user.setCreateUserid(creator.getId());
			user.setUpdateUserid(creator.getId());
		}

		// 记录操作时间
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());

		this.insertSelective(user);
	}

	@Override
	public void updateUser(User user, User creator) {

		// FIXME 角色的更新

		// 记录操作用户
		if (creator != null) {
			user.setCreateUserid(creator.getId());
			user.setUpdateUserid(creator.getId());
		}

		// 记录操作时间
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());

		this.updateByPrimaryKeySelective(user);
	}

	@Override
	public User load(BigDecimal id) {

		User user = this.selectByPrimaryKey(id);

		// FIXME 根据用户id查询角色列表, 设置到user的roles中

		return user;
	}

	@Override
	public void remove(BigDecimal id) {

		// FIXME 权限的删除

		User user = this.selectByPrimaryKey(id);
		user.setIsDel(Constants.IS_DEL.DELED.code);
		this.updateByPrimaryKeySelective(user);
	}

	// 建立并插入用户与角色的关联
	private void releativeUserRole(BigDecimal userId, BigDecimal roleId) {
		// FIXME
	}
}
