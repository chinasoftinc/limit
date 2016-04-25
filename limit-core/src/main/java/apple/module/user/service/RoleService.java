package apple.module.user.service;

import java.util.List;

import apple.common.base.service.Service;
import apple.common.dto.EasyUITreeNode;
import apple.module.user.model.Role;
import apple.module.user.model.RoleExam;

/**
 * 角色业务层
 * @author Binxiao
 */
public interface RoleService extends Service<Role, RoleExam> {

	/**
	 * 插入角色, 并保存角色权限的关联
	 * @param role
	 */
	void insertRole(Role role);

	/**
	 * 更新角色消息, 并保存角色权限的关联
	 * @param role
	 */
	void updateRole(Role role);

	/**
	 * 获取角色和权限信息
	 * @param id
	 * @return
	 */
	Role selectRole(Long id);

	/**
	 * 删除角色并删除权限关联
	 * @param id
	 */
	void deleteRole(Long id);

	/**
	 * 生成角色的树结构 [easyui treeNode]
	 * @return
	 */
	List<EasyUITreeNode> selectRoleTree();

}
