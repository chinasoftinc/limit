package com.athena.module.users.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.athena.common.base.dao.AbstractDao;
import com.athena.module.users.mapper.UserMapper;
import com.athena.module.users.model.User;
import com.athena.module.users.model.UserExample;
import com.athena.module.users.model.UserExampleDefined;

@Repository
public class UserDaoImp extends AbstractDao<User, UserExample> implements UserDao {

	@Autowired
	private UserMapper usermapper;

	@Override
	public String sequenceName() {
		return "T_USER_SEQ";
	}

	@Override
	public List<User> selectPageUser(UserExampleDefined example) {
		return usermapper.selectPageUser(example);
	}

	@Override
	public Integer selectUserCount(UserExampleDefined example) {
		return usermapper.selectUserCount(example);
	}

}
