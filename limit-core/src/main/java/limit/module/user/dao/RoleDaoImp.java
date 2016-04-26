package limit.module.user.dao;

import org.springframework.stereotype.Repository;

import limit.common.base.dao.AbstractDao;
import limit.module.user.model.Role;
import limit.module.user.model.RoleExam;

@Repository
public class RoleDaoImp extends AbstractDao<Role, RoleExam> implements RoleDao {

}
