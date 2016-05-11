package com.athena.module.users.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.athena.common.base.dao.AbstractDao;
import com.athena.common.dto.PageResult;
import com.athena.module.users.mapper.UserMapper;
import com.athena.module.users.model.User;
import com.athena.module.users.model.UserExample;

@Repository
public class UserDaoImp extends AbstractDao<User, UserExample> implements UserDao {

	@Autowired
	private UserMapper usermapper;

	@Override
	public String sequenceName() {
		return "T_USER_SEQ";
	}

	@Override
	public List<User> selectPageUser(PageResult<User> example) {
		return usermapper.selectPageUser(example);
	}

	@Override
	public Integer selectUserCount(PageResult<User> example) {
		return usermapper.selectUserCount(example);
	}

}
