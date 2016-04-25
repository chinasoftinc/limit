package apple.module.user.service;

import java.util.List;

import apple.common.base.service.Service;
import apple.module.user.model.User;
import apple.module.user.model.UserExam;
import apple.module.user.model.UserSupportExam;

/**
 * 用户业务层
 * @author Binxiao
 */
public interface UserService extends Service<User, UserExam> {

	/**
	 * 检测用户名没有被录入
	 * @param username
	 * @return true: 没有被录入; false:已经存在
	 */
	boolean selectIsNotExistUsername(String username);

	/**
	 * 添加用户, 并插入用户和角色的关联
	 * @param user
	 */
	void insertUser(User user);

	/**
	 * 更新用户, 更新用户和橘色的关联
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * 删除多个用户, 级联删除除用户和角色的关联
	 * @param
	 */
	void deleteMulitUser(List<Long> userIds);

	/**
	 * 查询用户分页数据
	 * @param exam
	 * @return
	 */
	List<User> selectUserPage(UserSupportExam support);

	/**
	 * 查询分页用户总数
	 * @param support
	 * @return
	 */
	int selectUserPageCount(UserSupportExam support);

	/**
	 * 查询用户和角色信息
	 * @param id
	 * @return
	 */
	User selectUserById(Long id);
}
