package limit.module.userOpt.dao;

import org.springframework.stereotype.Repository;

import limit.common.base.dao.AbstractDao;
import limit.module.userOpt.model.UserOpt;
import limit.module.userOpt.model.UserOptExam;

@Repository
public class UserOptDaoImp extends AbstractDao<UserOpt, UserOptExam> implements UserOptDao {


}
