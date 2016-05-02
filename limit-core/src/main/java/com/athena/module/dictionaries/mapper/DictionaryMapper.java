package com.athena.module.dictionaries.mapper;

import java.math.BigDecimal;

import com.athena.common.base.mapper.Mapper;
import com.athena.module.dictionaries.model.Dictionary;
import com.athena.module.dictionaries.model.DictionaryExample;

public interface DictionaryMapper extends Mapper<Dictionary, DictionaryExample> {

	/**
	 * 删除其并级联删除所有下级
	 * @param id
	 */
	void removeSubs(BigDecimal id);
}