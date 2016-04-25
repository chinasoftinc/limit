package apple.module.userOpt.dao;

import org.springframework.stereotype.Repository;

import apple.common.base.dao.AbstractDao;
import apple.module.userOpt.model.UserOpt;
import apple.module.userOpt.model.UserOptExam;

@Repository
public class UserOptDaoImp extends AbstractDao<UserOpt, UserOptExam> implements UserOptDao {


}
