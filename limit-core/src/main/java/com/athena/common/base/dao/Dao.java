package com.athena.common.base.dao;

import java.util.List;

public interface Dao<MODEL, EXAM> {

	int countByExample(EXAM example);

	int deleteByExample(EXAM example);

	int deleteByPrimaryKey(Long id);

	int insert(MODEL record);

	int insertSelective(MODEL record);

	List<MODEL> selectByExample(EXAM example);

	MODEL selectByPrimaryKey(Long id);

	int updateByExampleSelective(MODEL record, EXAM example);

	int updateByExample(MODEL record, EXAM example);

	int updateByPrimaryKeySelective(MODEL record);

	int updateByPrimaryKey(MODEL record);
}
