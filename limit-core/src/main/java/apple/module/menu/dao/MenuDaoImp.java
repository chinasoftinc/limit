package apple.module.menu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import apple.common.base.dao.AbstractDao;
import apple.module.menu.mapper.MenuMapper;
import apple.module.menu.model.Menu;
import apple.module.menu.model.MenuExam;

@Repository
public class MenuDaoImp extends AbstractDao<Menu, MenuExam> implements MenuDao {

	@Autowired
	private MenuMapper mapper;

	@Override
	public Integer selectMaxPrivilegePos() {
		return mapper.selectMaxPrivilegePos();
	}

	@Override
	public Long selectMaxPrivilegeCode(Integer privilegePos) {
		return mapper.selectMaxPrivilegeCode(privilegePos);
	}

	@Override
	public Integer selectMaxMenuOrder() {
		return mapper.selectMaxMenuOrder();
	}

}
