package apple.module.user.dao;

import org.springframework.stereotype.Repository;

import apple.common.base.dao.AbstractDao;
import apple.module.user.model.Role;
import apple.module.user.model.RoleExam;

@Repository
public class RoleDaoImp extends AbstractDao<Role, RoleExam> implements RoleDao {

}
