package com.athena.common.base.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.athena.common.base.dao.Dao;

/**
 * @author NieBinxiao
 */
public abstract class AbstractService<MODEL, EXAM> implements Service<MODEL, EXAM> {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Dao<MODEL, EXAM> dao;

	public int countByExample(EXAM example) {
		return dao.countByExample(example);
	}

	public int deleteByExample(EXAM example) {
		return dao.deleteByExample(example);
	}

	public int deleteByPrimaryKey(BigDecimal id) {
		return dao.deleteByPrimaryKey(id);
	}

	public int insert(MODEL record) {
		return dao.insert(record);
	}

	public int insertSelective(MODEL record) {
		return dao.insertSelective(record);
	}

	public List<MODEL> selectByExample(EXAM example) {
		return dao.selectByExample(example);
	}

	public MODEL selectByPrimaryKey(BigDecimal id) {
		return dao.selectByPrimaryKey(id);
	}

	public int updateByExampleSelective(MODEL record, EXAM example) {
		return dao.updateByExampleSelective(record, example);
	}

	public int updateByExample(MODEL record, EXAM example) {
		return dao.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(MODEL record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(MODEL record) {
		return dao.updateByPrimaryKey(record);
	}

}
