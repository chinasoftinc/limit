package limit.module.user.dao;

import java.util.List;

import limit.module.user.model.User;
import limit.module.user.model.UserSupportExam;

/**
 * 用户角色扩展dao
 * @author niebinxiao
 */
public interface UserRoleSupportDao {

	/**
	 * 根据角色id查询用户集合
	 * @param roleId
	 * @return
	 */
	List<User> selectUserOfRoleId(Long roleId);

	/**
	 * 根据条件查询用户分页数据
	 * @param support
	 * @return
	 */
	List<User> selectPageUser(UserSupportExam support);

	/**
	 * 根据条件查询用户总数
	 * @param support
	 * @return
	 */
	int selectPageUserCount(UserSupportExam support);
}
