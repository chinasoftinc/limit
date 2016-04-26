package limit.module.menu.dao;

import org.springframework.stereotype.Repository;

import limit.common.base.dao.AbstractDao;
import limit.module.menu.model.RoleMenu;
import limit.module.menu.model.RoleMenuExam;

@Repository
public class RoleMenuDaoImp extends AbstractDao<RoleMenu, RoleMenuExam> implements RoleMenuDao {
}
