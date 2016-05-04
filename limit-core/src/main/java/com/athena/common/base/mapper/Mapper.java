package com.athena.common.base.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author NieBinxiao
 */
public interface Mapper<MODEL, EXAM> {

	int countByExample(EXAM example);

	int deleteByExample(EXAM example);

	int deleteByPrimaryKey(BigDecimal id);

	int insert(MODEL record);

	int insertSelective(MODEL record);

	List<MODEL> selectByExample(EXAM example);

	MODEL selectByPrimaryKey(BigDecimal id);

	int updateByExampleSelective(@Param("record") MODEL record, @Param("example") EXAM example);

	int updateByExample(@Param("record") MODEL record, @Param("example") EXAM example);

	int updateByPrimaryKeySelective(MODEL record);

	int updateByPrimaryKey(MODEL record);

}