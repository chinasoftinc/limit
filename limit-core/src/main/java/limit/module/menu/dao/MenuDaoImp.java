package limit.module.menu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import limit.common.base.dao.AbstractDao;
import limit.module.menu.mapper.MenuMapper;
import limit.module.menu.model.Menu;
import limit.module.menu.model.MenuExam;

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
