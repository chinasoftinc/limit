package com.athena.module.loggers.service;

import org.springframework.stereotype.Service;

import com.athena.common.base.service.AbstractService;
import com.athena.module.loggers.model.Logger;
import com.athena.module.loggers.model.LoggerExample;

@Service
public class LoggerServiceImp extends AbstractService<Logger, LoggerExample> implements LoggerService {

}
