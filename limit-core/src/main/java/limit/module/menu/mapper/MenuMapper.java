package limit.module.menu.mapper;

import org.apache.ibatis.annotations.Param;

import limit.common.base.mapper.Mapper;
import limit.module.menu.model.Menu;
import limit.module.menu.model.MenuExam;

public interface MenuMapper extends Mapper<Menu, MenuExam> {

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
