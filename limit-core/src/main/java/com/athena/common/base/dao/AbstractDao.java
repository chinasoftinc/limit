package com.athena.common.base.dao;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.athena.common.base.entity.Model;
import com.athena.common.base.mapper.Mapper;
import com.athena.module.sequence.mapper.SequenceMapper;

/**
 * @author niebinxiao
 */
public abstract class AbstractDao<MODEL extends Model<MODEL>, EXAM> implements Dao<MODEL, EXAM> {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Mapper<MODEL, EXAM> mapper;

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

	public int countByExample(EXAM example) {
		return mapper.countByExample(example);
	}

	public int deleteByExample(EXAM example) {
		return mapper.deleteByExample(example);
	}

	public int deleteByPrimaryKey(BigDecimal id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public int insert(MODEL record) {
		return mapper.insert(record);
	}

	public int insertSelective(MODEL record) {
		return mapper.insertSelective(record);
	}

	public List<MODEL> selectByExample(EXAM example) {
		return mapper.selectByExample(example);
	}

	public MODEL selectByPrimaryKey(BigDecimal id) {
		return mapper.selectByPrimaryKey(id);
	}

	public int updateByExampleSelective(MODEL record, EXAM example) {
		return mapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(MODEL record, EXAM example) {
		return mapper.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(MODEL record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(MODEL record) {
		return mapper.updateByPrimaryKey(record);
	}

}
