package apple.module.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import apple.module.user.mapper.UserRoleSupportMapper;
import apple.module.user.model.User;
import apple.module.user.model.UserSupportExam;

/**
 * 用户角色扩展dao实现
 * @author niebinxiao
 */
@Repository
public class UserRoleSupportDaoImp implements UserRoleSupportDao {

	@Autowired
	private UserRoleSupportMapper userRoleSupportMapper;

	// 根据角色id查询用户集合
	@Override
	public List<User> selectUserOfRoleId(Long roleId) {
		return userRoleSupportMapper.selectUserOfRoleId(roleId);
	}

	// 根据条件查询用户分页数据
	@Override
	public List<User> selectPageUser(UserSupportExam support) {
		return userRoleSupportMapper.selectPageUser(support);
	}

	// 根据条件查询用户总数
	public int selectPageUserCount(UserSupportExam support) {
		return userRoleSupportMapper.selectPageUserCount(support);
	}

}
