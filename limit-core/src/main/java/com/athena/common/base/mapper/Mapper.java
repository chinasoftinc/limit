package com.athena.common.base.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author niebinxiao
 * @param <bean>
 * @param <example>
 */
public interface Mapper<bean, example> {

	int countByExample(example example);

	int deleteByExample(example example);

	int deleteByPrimaryKey(BigDecimal id);

	int insert(bean record);

	int insertSelective(bean record);

	List<bean> selectByExample(example example);

	bean selectByPrimaryKey(BigDecimal id);

	int updateByExampleSelective(@Param("record") bean record, @Param("example") example example);

	int updateByExample(@Param("record") bean record, @Param("example") example example);

	int updateByPrimaryKeySelective(bean record);

	int updateByPrimaryKey(bean record);

}
