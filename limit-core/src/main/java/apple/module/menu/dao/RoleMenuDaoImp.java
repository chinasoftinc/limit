package apple.module.menu.dao;

import org.springframework.stereotype.Repository;

import apple.common.base.dao.AbstractDao;
import apple.module.menu.model.RoleMenu;
import apple.module.menu.model.RoleMenuExam;

@Repository
public class RoleMenuDaoImp extends AbstractDao<RoleMenu, RoleMenuExam> implements RoleMenuDao {
}
