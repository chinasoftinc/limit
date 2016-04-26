package limit.module.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import limit.common.base.service.AbstractService;
import limit.common.dto.EasyUITreeNode;
import limit.module.menu.dao.RoleMenuDao;
import limit.module.menu.model.RoleMenu;
import limit.module.menu.model.RoleMenuExam;
import limit.module.user.dao.RoleDao;
import limit.module.user.dao.UserRoleDao;
import limit.module.user.model.Role;
import limit.module.user.model.RoleExam;
import limit.module.user.model.UserRoleExam;

/**
 * 角色业务层
 * @author Binxiao
 */
@Service
public class RoleServiceImp extends AbstractService<Role, RoleExam> implements RoleService {

	@Autowired
	private RoleDao dao;
	
	@Autowired
	private RoleMenuDao roleMenuDao;
	
	@Autowired
	private UserRoleDao userRoleDao;


	public String getEntityType() {
		return "角色管理";
	}

	// 插入角色, 并保存角色权限的关联
	@Override
	public void insertRole(Role role) {
		// 插入角色和权限关联
		if (StringUtils.isNotEmpty(role.getPrivilegeIds())) {
			for (String privilegeId : role.getPrivilegeIds().split(",")) {
				RoleMenu rm = new RoleMenu();
				rm.setRoleId(role.getId());
				rm.setMenuId(new Long(privilegeId));
				roleMenuDao.insert(rm);
			}
		}

		dao.insert(role);
	}

	// 更新角色消息, 并保存角色权限的关联
	@Override
	public void updateRole(Role role) {
		// 查询原权限ids字符串
		RoleMenuExam exam = new RoleMenuExam();
		exam.or().andRoleIdEqualTo(role.getId());
		List<RoleMenu> rms = roleMenuDao.selectByExample(exam);

		// 处理权限id的新旧替换
		if (StringUtils.isNotEmpty(role.getPrivilegeIds())) {
			// 组装新的privilegeIds为list集合, 用于调用contains方法
			List<String> newPrivilegeList = new ArrayList<String>();
			newPrivilegeList.addAll(Arrays.asList((role.getPrivilegeIds().split(","))));
			// 检测是否包含原有privilegeId
			for (RoleMenu rm : rms) {
				if (!newPrivilegeList.contains(rm.getMenuId().toString())) {
					// 新的权限ID不包含原有,用户去掉该勾选, 删除原有记录
					roleMenuDao.deleteByPrimaryKey(rm.getId());
				} else {
					// 包含, 从新idlist中删除
					String temp = rm.getMenuId().toString();
					newPrivilegeList.remove(temp);
				}
			}

			// 剩下的newIdlist中就是新增加的权限[菜单id]
			if (CollectionUtils.isNotEmpty(newPrivilegeList)) {
				for (String newId : newPrivilegeList) {
					RoleMenu rm = new RoleMenu();
					rm.setMenuId(new Long(newId));
					rm.setRoleId(role.getId());
					roleMenuDao.insert(rm);
				}
			}

		} else {
			// 用户没有勾选任何权限id, 删除所有原id
			RoleMenuExam rmExam = new RoleMenuExam();
			exam.or().andRoleIdEqualTo(role.getId());
			roleMenuDao.deleteByExample(rmExam);
		}

		dao.updateByPrimaryKeySelective(role);
	}

	// 获取角色和权限信息
	@Override
	public Role selectRole(Long id) {
		Role role = dao.selectByPrimaryKey(id);
		// 查询角色权限关联信息
		RoleMenuExam exam = new RoleMenuExam();
		exam.or().andRoleIdEqualTo(id);
		List<RoleMenu> rms = roleMenuDao.selectByExample(exam);

		if (CollectionUtils.isNotEmpty(rms)) {
			// 组装权限ID字符串, 逗号分割
			StringBuffer sb = new StringBuffer();
			for (RoleMenu rm : rms) {
				sb.append(rm.getMenuId() + ",");
			}
			role.setPrivilegeIds(sb.substring(0, sb.length() - 1));
		}
		return role;
	}

	// 删除角色并删除权限关联
	@Override
	public void deleteRole(Long id) {
		// 查询对应角色
		Role role = dao.selectByPrimaryKey(id);
		// 删除权限关联
		RoleMenuExam exam = new RoleMenuExam();
		exam.or().andRoleIdEqualTo(role.getId());
		roleMenuDao.deleteByExample(exam);
		// 删除用户关联
		UserRoleExam urexam = new UserRoleExam();
		urexam.or().andRoleIdEqualTo(id);
		userRoleDao.deleteByExample(urexam);

		dao.deleteByPrimaryKey(role.getId());
	}

	// 生成角色的树结构 [easyui treeNode]
	@Override
	public List<EasyUITreeNode> selectRoleTree() {
		// 查询所有角色
		RoleExam exam = new RoleExam();
		List<Role> roles = dao.selectByExample(exam);

		// 生成树节点
		List<EasyUITreeNode> treeNodes = null;
		if (CollectionUtils.isNotEmpty(roles)) {
			treeNodes = new ArrayList<EasyUITreeNode>();
			EasyUITreeNode node;
			for (Role role : roles) {
				node = new EasyUITreeNode();
				node.setId(role.getId().toString());
				node.setText(role.getRolename());
				treeNodes.add(node);
			}
		}

		return treeNodes;
	}

}
