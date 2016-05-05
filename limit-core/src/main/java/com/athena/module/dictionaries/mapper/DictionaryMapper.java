package com.athena.module.dictionaries.mapper;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;

import com.athena.common.base.mapper.Mapper;
import com.athena.module.dictionaries.model.Dictionary;
import com.athena.module.dictionaries.model.DictionaryExample;

public interface DictionaryMapper extends Mapper<Dictionary, DictionaryExample> {

	/**
	 * 删除其并级联删除所有下级
	 * @param id
	 */
	void removeSubs(@Param("id") BigDecimal id);

	/**
	 * 获取指定节点的子节点最大排序
	 * @param id
	 * @return
	 */
	Short selectMaxSortNo(@Param("id") BigDecimal id);
}