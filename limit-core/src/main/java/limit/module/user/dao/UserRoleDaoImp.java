package limit.module.user.dao;

import org.springframework.stereotype.Repository;

import limit.common.base.dao.AbstractDao;
import limit.module.user.model.UserRole;
import limit.module.user.model.UserRoleExam;

@Repository
public class UserRoleDaoImp extends AbstractDao<UserRole, UserRoleExam> implements UserRoleDao {


}
