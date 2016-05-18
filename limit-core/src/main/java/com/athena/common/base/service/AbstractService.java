package com.athena.common.base.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.athena.common.base.dao.Dao;

/**
 * @author niebinxiao
 * @param <bean>
 * @param <example>
 */
public abstract class AbstractService<bean, example> implements Service<bean, example> {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Dao<bean, example> dao;

	public int countByExample(example example) {
		return dao.countByExample(example);
	}

	public int deleteByExample(example example) {
		return dao.deleteByExample(example);
	}

	public int deleteByPrimaryKey(BigDecimal id) {
		return dao.deleteByPrimaryKey(id);
	}

	public int insertDictionary(bean record) {
		return dao.insert(record);
	}

	public int insertSelective(bean record) {
		return dao.insertSelective(record);
	}

	public List<bean> selectByExample(example example) {
		return dao.selectByExample(example);
	}

	public bean selectByPrimaryKey(BigDecimal id) {
		return dao.selectByPrimaryKey(id);
	}

	public int updateByExampleSelective(bean record, example example) {
		return dao.updateByExampleSelective(record, example);
	}

	public int updateByExample(bean record, example example) {
		return dao.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(bean record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(bean record) {
		return dao.updateByPrimaryKey(record);
	}

}
