package limit.module.user.service;

import java.util.List;

import limit.common.base.service.Service;
import limit.common.dto.EasyUITreeNode;
import limit.module.user.model.Role;
import limit.module.user.model.RoleExam;

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
