package apple.module.menu.dao;

import org.apache.ibatis.annotations.Param;

import apple.common.base.dao.Dao;
import apple.module.menu.model.Menu;
import apple.module.menu.model.MenuExam;

public interface MenuDao extends Dao<Menu, MenuExam> {

	/**
	 * 查询最大权限位
	 * @return
	 */
	Integer selectMaxPrivilegePos();

	/**
	 * 查询指定权限位中的最大权限码
	 * @param privilegePos
	 * @return
	 */
	Long selectMaxPrivilegeCode(@Param("privilegePos") Integer privilegePos);

	/**
	 * 查询当前数据库最大的菜单排序
	 * @return
	 */
	Integer selectMaxMenuOrder();
}
