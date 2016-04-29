package com.athena.module.dictionary.dao;

import org.springframework.stereotype.Repository;

import com.athena.common.base.dao.AbstractDao;
import com.athena.module.dictionary.model.OptDic;
import com.athena.module.dictionary.model.OptDicExam;

@Repository
public class OptDicDaoImp extends AbstractDao<OptDic, OptDicExam> implements OptDicDao {

}
