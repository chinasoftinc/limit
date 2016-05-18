package com.athena.module.loggers.dao;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.athena.common.base.dao.AbstractDao;
import com.athena.common.context.Constants.loggerModel.EntityName;
import com.athena.common.context.Constants.loggerModel.OptorType;
import com.athena.module.loggers.model.Logger;
import com.athena.module.loggers.model.LoggerExample;
import com.athena.module.users.model.User;

@Repository
public class LoggerDaoImp extends AbstractDao<Logger, LoggerExample> implements LoggerDao {

	@Override
	public String sequenceName() {
		return "T_LOGGERS_SEQ";
	}

	@Override
	public void insertLogger(User optorUser, OptorType optorType, EntityName name, String modelTitle, BigDecimal modelId, String optorDetail) {
		Logger logger = new Logger();

		logger.setEntityName(name.getCode());
		logger.setId(this.nextSEQ());
		logger.setModelId(modelId);
		logger.setModelTitle(modelTitle);
		logger.setOptorDetail(optorDetail);
		logger.setOptorTime(new Date());
		logger.setOptorType(optorType.code);
		logger.setUserId(optorUser.getId());
		logger.setUserNickname(optorUser.getNickName());

		this.insertSelective(logger);
	}

}
