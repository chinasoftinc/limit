package com.athena.common.base.service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author niebinxiao
 * @param <bean>
 * @param <example>
 */
public interface Service<bean, example> {

	int countByExample(example example);

	int deleteByExample(example example);

	int deleteByPrimaryKey(BigDecimal id);

	int insertDictionary(bean model);

	int insertSelective(bean model);

	List<bean> selectByExample(example example);

	bean selectByPrimaryKey(BigDecimal id);

	int updateByExampleSelective(bean model, example example);

	int updateByExample(bean model, example example);

	int updateByPrimaryKeySelective(bean model);

	int updateByPrimaryKey(bean model);

}
