package apple.module.user.dao;

import org.springframework.stereotype.Repository;

import apple.common.base.dao.AbstractDao;
import apple.module.user.model.UserRole;
import apple.module.user.model.UserRoleExam;

@Repository
public class UserRoleDaoImp extends AbstractDao<UserRole, UserRoleExam> implements UserRoleDao {


}
