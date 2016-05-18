package com.athena.module.loggers.dao;

import org.springframework.stereotype.Repository;

import com.athena.common.base.dao.AbstractDao;
import com.athena.module.loggers.model.Logger;
import com.athena.module.loggers.model.LoggerExample;

@Repository
public class LoggerDaoImp extends AbstractDao<Logger, LoggerExample> implements LoggerDao {

	@Override
	public String sequenceName() {
		return "T_LOGGERS_SEQ";
	}

}
