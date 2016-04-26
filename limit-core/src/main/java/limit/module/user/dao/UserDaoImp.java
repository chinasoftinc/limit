package limit.module.user.dao;

import org.springframework.stereotype.Repository;

import limit.common.base.dao.AbstractDao;
import limit.module.user.model.User;
import limit.module.user.model.UserExam;

@Repository
public class UserDaoImp extends AbstractDao<User, UserExam> implements UserDao {

}
