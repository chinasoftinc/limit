package com.athena.common.base.service;

import java.math.BigDecimal;
import java.util.List;

public interface Service<MODEL, EXAM> {

	int countByExample(EXAM example);

	int deleteByExample(EXAM example);

	int deleteByPrimaryKey(BigDecimal id);

	int insert(MODEL model);

	int insertSelective(MODEL model);

	List<MODEL> selectByExample(EXAM example);

	MODEL selectByPrimaryKey(BigDecimal id);

	int updateByExampleSelective(MODEL model, EXAM example);

	int updateByExample(MODEL model, EXAM example);

	int updateByPrimaryKeySelective(MODEL model);

	int updateByPrimaryKey(MODEL model);

}
