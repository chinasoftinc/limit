package com.athena.common.base.dao;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.athena.common.base.entity.Bean;
import com.athena.common.base.mapper.Mapper;
import com.athena.module.sequence.mapper.SequenceMapper;

/**
 * @author niebinxiao
 * @param <bean>
 * @param <example>
 */
public abstract class AbstractDao<bean extends Bean<bean>, example> implements Dao<bean, example> {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Mapper<bean, example> mapper;

	@Autowired
	private SequenceMapper sequenceMapper;

	/**
	 * 获取序列名
	 * @return
	 */
	public abstract String sequenceName();

	public BigDecimal nextSEQ() {
		return sequenceMapper.next(sequenceName());
	}

	public int countByExample(example example) {
		return mapper.countByExample(example);
	}

	public int deleteByExample(example example) {
		return mapper.deleteByExample(example);
	}

	public int deleteByPrimaryKey(BigDecimal id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public int insert(bean record) {
		return mapper.insert(record);
	}

	public int insertSelective(bean record) {
		return mapper.insertSelective(record);
	}

	public List<bean> selectByExample(example example) {
		return mapper.selectByExample(example);
	}

	public bean selectByPrimaryKey(BigDecimal id) {
		return mapper.selectByPrimaryKey(id);
	}

	public int updateByExampleSelective(bean record, example example) {
		return mapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(bean record, example example) {
		return mapper.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(bean record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(bean record) {
		return mapper.updateByPrimaryKey(record);
	}

}
