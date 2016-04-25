package apple.module.dictionary.dao;

import org.springframework.stereotype.Repository;

import apple.common.base.dao.AbstractDao;
import apple.module.dictionary.model.OptDic;
import apple.module.dictionary.model.OptDicExam;

@Repository
public class OptDicDaoImp extends AbstractDao<OptDic, OptDicExam> implements OptDicDao {

}
