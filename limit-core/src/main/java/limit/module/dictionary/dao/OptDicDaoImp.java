package limit.module.dictionary.dao;

import org.springframework.stereotype.Repository;

import limit.common.base.dao.AbstractDao;
import limit.module.dictionary.model.OptDic;
import limit.module.dictionary.model.OptDicExam;

@Repository
public class OptDicDaoImp extends AbstractDao<OptDic, OptDicExam> implements OptDicDao {

}
