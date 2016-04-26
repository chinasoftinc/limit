package limit.module.menu.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import limit.common.base.service.AbstractService;
import limit.common.dto.EasyUITreeNode;
import limit.common.dto.Pagination;
import limit.module.menu.dao.MenuDao;
import limit.module.menu.dao.RoleMenuDao;
import limit.module.menu.dao.RoleMenuSupportDao;
import limit.module.menu.model.Menu;
import limit.module.menu.model.MenuExam;
import limit.module.menu.model.RoleMenuExam;
import limit.module.menu.model.MenuExam.Criteria;
import limit.module.user.dao.UserRoleDao;
import limit.module.user.model.UserRole;
import limit.module.user.model.UserRoleExam;

/**
 * 菜单业务层实现类
 * @author niebinxiao
 */
@Service
public class MenuServiceImp extends AbstractService<Menu, MenuExam> implements MenuService {

	// 菜单移动位置的方向
	public enum Direction {
		UP, DOWN
	}

	@Autowired
	private MenuDao dao;

	@Autowired
	private RoleMenuDao roleMenuDao;

	@Autowired
	private RoleMenuSupportDao roleMenuCascadeDao;

	@Autowired
	private UserRoleDao userRoleDao;

	public String getEntityType() {
		return "系统菜单";
	}

	// 获取菜单的树结构 [easyui treeGrid]
	@Override
	public List<Menu> selectMenuTree() {
		MenuExam exam = new MenuExam();
		exam.setOrderByClause("menu_order");
		exam.or().andParentIdEqualTo(0L);
		// 一级菜单
		List<Menu> firstMenus = dao.selectByExample(exam);

		// 遍历查询二级菜单
		for (Menu menu : firstMenus) {
			menu.setParentName("主菜单");
			exam = new MenuExam();
			exam.setOrderByClause("menu_order");
			exam.or().andParentIdEqualTo(menu.getId());
			List<Menu> secondMenus = selectByExample(exam);
			for (Menu menu2 : secondMenus) {
				// 设置二级菜单的父菜单名称
				menu2.setParentName(menu.getMenuName());
			}
			// 将二级菜单添加到一级菜单的子菜单集合中 children [easyui显示需求]
			menu.setChildren(secondMenus);
		}

		return firstMenus;
	}

	// 添加菜单
	@Override
	public void insertMenu(Menu menu) {
		// 设置菜单排序, 查询当前最大的菜单排序 +1
		Integer maxOrder = dao.selectMaxMenuOrder();
		if (maxOrder == null || maxOrder < 1) {
			maxOrder = 1;
		}
		menu.setMenuOrder(maxOrder);

		// 设置权限码和权限位, 查询最高的权限码和最高的权限位
		Integer maxPos = dao.selectMaxPrivilegePos();
		if (maxPos != null) {
			// 查询最大权限位最大权限码
			Long maxCode = dao.selectMaxPrivilegeCode(maxPos);
			// 权限码已经移63位, 另起权限位, 权限码从1开始计算
			if (maxCode << 1 < 0) {
				menu.setPrivilegePos(maxPos + 1);
				menu.setPrivilegeCode(new Long(1));
			} else {
				// 否则权限位向后移1位
				menu.setPrivilegePos(maxPos);
				menu.setPrivilegeCode(maxCode << 1);
			}
		} else {
			// 权限位为空, 无任何菜单, 权限位从0开始, 权限码从1开始
			menu.setPrivilegePos(0);
			menu.setPrivilegeCode(new Long(1));
		}

		dao.insert(menu);
	}

	// 删除菜单
	@Override
	public void deleteMenu(Long id) {
		// 查询该菜单的子菜单
		MenuExam exam = new MenuExam();
		exam.or().andParentIdEqualTo(id);
		List<Menu> children = dao.selectByExample(exam);

		// 删除子菜单
		for (Menu menu : children) {
			// 删除子菜单和角色的关联
			RoleMenuExam rmExam = new RoleMenuExam();
			rmExam.or().andMenuIdEqualTo(menu.getId());
			roleMenuDao.deleteByExample(rmExam);
			dao.deleteByPrimaryKey(menu.getId());
		}

		// 删除该菜单和角色的关联
		RoleMenuExam rmExam = new RoleMenuExam();
		rmExam.or().andMenuIdEqualTo(id);
		roleMenuDao.deleteByExample(rmExam);

		// 删除该菜单
		dao.deleteByPrimaryKey(id);
	}

	// 交换两个菜单的排序位置
	@Override
	public void updateMenuPos(Long menuId, Direction direction) {
		// 当前菜单
		Menu currentMenu = dao.selectByPrimaryKey(menuId);

		// 条件为, 父级菜单相同, 排序相邻的
		MenuExam exam = new MenuExam();
		Criteria criteria = exam.or().andParentIdEqualTo(currentMenu.getParentId());
		if (Direction.UP == direction) {
			// 查询小于当前order, 并且是最大的
			criteria.andMenuOrderLessThan(currentMenu.getMenuOrder());
			exam.setOrderByClause("menu_order desc");
		} else {
			// 查询大于当前order, 并且是最小的
			criteria.andMenuOrderGreaterThan(currentMenu.getMenuOrder());
			exam.setOrderByClause("menu_order asc");
		}
		// 只查询相邻的一个
		exam.setPagination(new Pagination(1, 1));
		List<Menu> result = dao.selectByExample(exam);

		if (CollectionUtils.isNotEmpty(result)) {
			Menu targetMenu = result.get(0); // 相邻的目标菜单
			// 交换菜单的排序
			Integer tempOrder = targetMenu.getMenuOrder();
			targetMenu.setMenuOrder(currentMenu.getMenuOrder());
			currentMenu.setMenuOrder(tempOrder);
			dao.updateByPrimaryKeySelective(targetMenu);
			dao.updateByPrimaryKeySelective(currentMenu);
		}
	}

	// 获取菜单树结构 [easyui treeNode]
	@Override
	public List<EasyUITreeNode> selectEasyUITreeNodes() {
		List<EasyUITreeNode> treeNodes = new ArrayList<EasyUITreeNode>();
		// 查询出一级菜单按order排序
		MenuExam exam = new MenuExam();
		exam.setOrderByClause("menu_order");
		exam.or().andParentIdEqualTo(0L);
		List<Menu> firstMenus = dao.selectByExample(exam);

		EasyUITreeNode node = null;
		List<EasyUITreeNode> children = null;
		List<Menu> secondMenus = null;
		EasyUITreeNode child = null;
		// 处理一级菜单的转换
		for (Menu menu : firstMenus) {
			node = new EasyUITreeNode();
			node.setText(menu.getMenuName());
			node.setId(menu.getId().toString());
			node.setState("closed");
			exam = new MenuExam();
			exam.setOrderByClause("menu_order"); // 排序
			exam.or().andParentIdEqualTo(menu.getId());
			secondMenus = selectByExample(exam);

			// 处理二级菜单转化
			if (CollectionUtils.isNotEmpty(secondMenus)) {
				children = new ArrayList<EasyUITreeNode>();
				for (Menu menu2 : secondMenus) {
					child = new EasyUITreeNode();
					child.setId(menu2.getId().toString());
					child.setText(menu2.getMenuName());
					children.add(child);
				}
				node.setChildren(children); // 一级菜单添加二级菜单
				treeNodes.add(node); // 一级菜单添加进菜单list
			}
		}

		return treeNodes;
	}

	// 查询最大的权限位
	@Override
	public Integer selectMaxPrivilegePos() {
		return dao.selectMaxPrivilegePos();
	}

	// 查询指定用户的所有菜单
	@Override
	public List<Menu> selectUserMenus(Long userId) {
		// 根据userId对应的所有roleId
		UserRoleExam exam = new UserRoleExam();
		exam.or().andUserIdEqualTo(userId);
		List<UserRole> userRoles = userRoleDao.selectByExample(exam);
		List<Long> roleIds = new ArrayList<Long>();
		for (UserRole ur : userRoles) {
			roleIds.add(ur.getRoleId());
		}

		if (!roleIds.isEmpty()) {
			return roleMenuCascadeDao.selectMenusByRoleIds(roleIds);
		} else {
			return new ArrayList<Menu>();
		}
	}

}
