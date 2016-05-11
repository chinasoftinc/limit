package com.athena.common.base.dao;

import java.math.BigDecimal;
import java.util.List;

public interface Dao<bean, example> {
	
	BigDecimal nextSEQ();

	int countByExample(example example);

	int deleteByExample(example example);

	int deleteByPrimaryKey(BigDecimal id);

	int insert(bean record);

	int insertSelective(bean record);

	List<bean> selectByExample(example example);

	bean selectByPrimaryKey(BigDecimal id);

	int updateByExampleSelective(bean record, example example);

	int updateByExample(bean record, example example);

	int updateByPrimaryKeySelective(bean record);

	int updateByPrimaryKey(bean record);
}
