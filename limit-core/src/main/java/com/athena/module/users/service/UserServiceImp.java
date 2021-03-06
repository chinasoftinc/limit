package com.athena.module.users.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athena.common.base.service.AbstractService;
import com.athena.common.context.Constants.IS_DEL;
import com.athena.common.context.Constants.UserModel.LoginStatus;
import com.athena.common.dto.PageResult;
import com.athena.common.utils.EncryptUtils;
import com.athena.common.utils.EncryptUtils.EncryType;
import com.athena.common.utils.UUIDUtils;
import com.athena.module.departments.dao.DepartmentDao;
import com.athena.module.roles.dao.RoleDao;
import com.athena.module.roles.model.Role;
import com.athena.module.roleuser.dao.RoleUserDao;
import com.athena.module.roleuser.model.RoleUser;
import com.athena.module.roleuser.model.RoleUserExample;
import com.athena.module.users.dao.UserDao;
import com.athena.module.users.model.User;
import com.athena.module.users.model.UserExample;

@Service
public class UserServiceImp extends AbstractService<User, UserExample> implements UserService {

	@Autowired
	private UserDao userdao;

	@Autowired
	private RoleUserDao roleUserDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private DepartmentDao deptDao;

	@Override
	public boolean selectIsNotExistUsername(String username) {

		UserExample example = new UserExample();
		example.or().andUserNameEqualTo(username).andIsDelEqualTo(IS_DEL.NOT.code);
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

		user.setId(userdao.nextSEQ());
		user.setUserCode(String.valueOf(Math.abs(user.getUserName().hashCode())));
		user.setPasswdSalt(UUIDUtils.UUIDEXcludeDash().substring(0, 3));

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

		user.setPassWord(EncryptUtils.encrypt(user.getPassWord(), EncryType.MD5, user.getPasswdSalt()));
		this.insertSelective(user);

	}

	@Override
	public void updateUser(User user, User creator) {

		// 角色的更新, 查询原权限ids字符串
		RoleUserExample roleuserexample = new RoleUserExample();
		roleuserexample.or().andUserIdEqualTo(user.getId());
		List<RoleUser> roleusers = roleUserDao.selectByExample(roleuserexample);

		// 更新和删除角色关联
		if (StringUtils.isNotEmpty(user.getRoles())) {
			List<String> updateRoles = new ArrayList<String>();
			updateRoles.addAll(Arrays.asList((user.getRoles().split(","))));

			for (RoleUser ur : roleusers) {
				if (!updateRoles.contains(String.valueOf(ur.getRoleId()))) {
					roleUserDao.deleteByPrimaryKey(ur.getId());
				} else {
					updateRoles.remove(String.valueOf(ur.getRoleId()));
				}
			}

			if (CollectionUtils.isNotEmpty(updateRoles)) {
				for (String newId : updateRoles) {
					releativeUserRole(user.getId(), new BigDecimal(newId));
				}
			}

		} else {
			roleUserDao.deleteByExample(roleuserexample);
		}

		// 记录操作用户
		if (creator != null) {
			user.setCreateUserid(creator.getId());
			user.setUpdateUserid(creator.getId());
		}

		// 记录操作时间
		user.setUpdateTime(new Date());

		this.updateByPrimaryKeySelective(user);
	}

	@Override
	public User getUserInfo(BigDecimal id) {

		User user = this.selectByPrimaryKey(id);

		if (!user.getUserStatus().equals(LoginStatus.ADMIN.code)) {
			// 查询用户所有角色, 设置到user的roles中
			List<Role> roles = roleDao.selectRolesByUserId(id);
			StringBuffer sb = new StringBuffer();
			for (Role role : roles) {
				sb.append(role.getRoleName().concat(" "));
			}
			user.setRoles(new String(sb));

			// 查询机构名称
			user.setOrgName(deptDao.selectByPrimaryKey(user.getOrgId()).getDeptShortName());

			// 查询部门名称
			user.setDeptName(deptDao.selectByPrimaryKey(user.getDepartmentId()).getDeptShortName());
		}

		return user;
	}

	@Override
	public User getUserWithRoleIds(BigDecimal id) {
		User user = this.selectByPrimaryKey(id);

		// 查询用户所有角色, 设置到user的roles中
		List<Role> roles = roleDao.selectRolesByUserId(id);
		StringBuffer sb = new StringBuffer();
		for (Role role : roles) {
			sb.append(String.valueOf(role.getId()).concat(","));
		}

		user.setRoles(sb.substring(0, sb.length() - 1));
		return user;
	}

	@Override
	public void removeUser(BigDecimal id, User creator) {

		// 删除角色关联
		RoleUserExample example = new RoleUserExample();
		example.or().andUserIdEqualTo(id);
		roleUserDao.deleteByExample(example);

		User user = new User();

		// 记录操作用户
		if (creator != null) {
			user.setCreateUserid(creator.getId());
			user.setUpdateUserid(creator.getId());
		}

		// 记录操作时间
		user.setUpdateTime(new Date());

		user.setId(id);
		user.setIsDel(IS_DEL.DELED.code);
		this.updateByPrimaryKeySelective(user);
	}

	// 建立并插入用户与角色的关联
	private void releativeUserRole(BigDecimal userId, BigDecimal roleId) {
		RoleUser ru = new RoleUser();
		ru.setUserId(userId);
		ru.setRoleId(roleId);
		roleUserDao.insertRoleUser(ru);
	}

	@Override
	public boolean isNotExistUserName(String userName) {
		UserExample example = new UserExample();
		example.or().andUserNameEqualTo(userName);
		return this.countByExample(example) == 0;
	}

}
