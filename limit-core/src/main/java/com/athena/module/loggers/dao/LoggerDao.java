package com.athena.module.loggers.dao;

import java.math.BigDecimal;

import com.athena.common.base.dao.Dao;
import com.athena.common.context.Constants.loggerModel.EntityName;
import com.athena.common.context.Constants.loggerModel.OptorType;
import com.athena.module.loggers.model.Logger;
import com.athena.module.loggers.model.LoggerExample;
import com.athena.module.users.model.User;

public interface LoggerDao extends Dao<Logger, LoggerExample> {

	/**
	 * 插入日志
	 * @param optorUser
	 * @param optType
	 * @param name
	 * @param modelTitle
	 * @param modelId
	 * @param optDetail
	 */
	void insertLogger(User optorUser, OptorType optorType, EntityName name, String modelTitle, BigDecimal modelId, String optDetail);
}
