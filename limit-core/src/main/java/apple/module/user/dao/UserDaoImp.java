package apple.module.user.dao;

import org.springframework.stereotype.Repository;

import apple.common.base.dao.AbstractDao;
import apple.module.user.model.User;
import apple.module.user.model.UserExam;

@Repository
public class UserDaoImp extends AbstractDao<User, UserExam> implements UserDao {

}
