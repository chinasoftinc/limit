package limit.module.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import limit.common.base.service.AbstractService;
import limit.module.user.dao.RoleDao;
import limit.module.user.dao.UserDao;
import limit.module.user.dao.UserRoleDao;
import limit.module.user.dao.UserRoleSupportDao;
import limit.module.user.model.Role;
import limit.module.user.model.RoleExam;
import limit.module.user.model.User;
import limit.module.user.model.UserExam;
import limit.module.user.model.UserRole;
import limit.module.user.model.UserRoleExam;
import limit.module.user.model.UserSupportExam;

/**
 * 用户业务层实现类
 * @author Binxiao
 */
@Service
public class UserServiceImp extends AbstractService<User, UserExam> implements UserService {
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserRoleSupportDao userRoleSupportDao;


	public String getEntityType() {
		return "用户管理";
	}

	// 检测用户名没有被录入
	@Override
	public boolean selectIsNotExistUsername(String username) {
		UserExam exam = new UserExam();
		exam.or().andUsernameEqualTo(username);
		return countByExample(exam) == 0;
	}

	// 添加用户, 并插入用户和角色的关联
	@Override
	public void insertUser(User user) {
		// 保存角色关联
		if (StringUtils.isNotEmpty(user.getRoles())) {
			String[] roleIds = user.getRoles().split(",");
			for (String roleId : roleIds) {
				releativeUserRole(user.getId(), new Long(roleId));
			}
		}
		user.setCreateTime(new Date());
		dao.insert(user);
	}

	// 更新用户, 更新用户和橘色的关联
	@Override
	public void updateUser(User user) {
		// 查询原权限ids字符串
		UserRoleExam urexam = new UserRoleExam();
		urexam.or().andUserIdEqualTo(user.getId());
		List<UserRole> urs = userRoleDao.selectByExample(urexam);

		// 处理角色id的新旧替换
		if (StringUtils.isNotEmpty(user.getRoles())) {
			// 组装新的roles [id]为list集合, 用于调用contains方法
			List<String> newRoleIdList = new ArrayList<String>();
			newRoleIdList.addAll(Arrays.asList((user.getRoles().split(","))));
			// 检测是否包含原有roleId
			for (UserRole ur : urs) {
				if (!newRoleIdList.contains(ur.getRoleId().toString())) {
					// 新的角色ID不包含原有,用户去掉该勾选, 删除原有记录
					userRoleDao.deleteByPrimaryKey(ur.getId());
				} else {
					// 包含, 从新idlist中删除
					String temp = ur.getRoleId().toString();
					newRoleIdList.remove(temp);
				}
			}

			// 剩下的newIdlist中就是新增加的权限[菜单id]
			if (CollectionUtils.isNotEmpty(newRoleIdList)) {
				for (String newId : newRoleIdList) {
					releativeUserRole(user.getId(), new Long(newId));
				}
			}

		} else {
			// 用户没有勾选任何权限id, 删除所有原id
			userRoleDao.deleteByExample(urexam);
		}

		dao.updateByPrimaryKeySelective(user);
	}

	// 删除多个用户, 级联删除除用户和角色的关联
	@Override
	public void deleteMulitUser(List<Long> userIds) {
		for (Long userId : userIds) {
			// 删除用户角色关联
			UserRoleExam exam = new UserRoleExam();
			exam.or().andUserIdEqualTo(userId);
			userRoleDao.deleteByExample(exam);
			dao.deleteByPrimaryKey(userId);
		}
	}

	// 查询用户分页数据和角色信息
	@Override
	public List<User> selectUserPage(UserSupportExam support) {
		// 获取用户分页数据
		List<User> users = userRoleSupportDao.selectPageUser(support);

		// 设置用户的角色信息 [展示值, 空格分割]
		for (User user : users) {
			UserRoleExam exam = new UserRoleExam();
			exam.or().andUserIdEqualTo(user.getId());
			List<UserRole> urs = userRoleDao.selectByExample(exam);
			StringBuffer sb = new StringBuffer();
			for (UserRole ur : urs) {
				RoleExam rexam = new RoleExam();
				rexam.or().andIdEqualTo(ur.getRoleId());
				List<Role> roles = roleDao.selectByExample(rexam);
				Role role = roles.get(0);
				sb.append(role.getRolename() + " ");
			}
			user.setRoles(sb.toString());
		}

		return users;
	}

	// 查询分页用户总数
	@Override
	public int selectUserPageCount(UserSupportExam support) {
		return userRoleSupportDao.selectPageUserCount(support);
	}

	// 查询用户和角色信息
	@Override
	public User selectUserById(Long id) {
		User user = dao.selectByPrimaryKey(id);
		// 查询角色信息
		UserRoleExam exam = new UserRoleExam();
		exam.or().andUserIdEqualTo(id);
		List<UserRole> urs = userRoleDao.selectByExample(exam);
		if (CollectionUtils.isNotEmpty(urs)) {
			StringBuffer sb = new StringBuffer();
			for (UserRole ur : urs) {
				sb.append(ur.getRoleId() + ",");
			}
			user.setRoles(sb.substring(0, sb.length() - 1));
		}

		return user;
	}

	// 建立并插入用户与角色的关联
	private void releativeUserRole(Long userId, Long roleId) {
		UserRole ur = new UserRole();
		ur.setUserId(userId);
		ur.setRoleId(roleId);
		userRoleDao.insert(ur);
	}

}
