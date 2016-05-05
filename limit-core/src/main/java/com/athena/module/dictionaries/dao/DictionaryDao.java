package com.athena.module.dictionaries.dao;

import java.math.BigDecimal;

import com.athena.common.base.dao.Dao;
import com.athena.module.dictionaries.model.Dictionary;
import com.athena.module.dictionaries.model.DictionaryExample;

public interface DictionaryDao extends Dao<Dictionary, DictionaryExample> {

	/**
	 * 删除节点及所有子节点
	 * @param id
	 */
	public void removeSubs(BigDecimal id);

	/**
	 * 获取指定节点的子节点最大排序
	 * @param id
	 * @return
	 */
	public Short selectMaxSortNo(BigDecimal id);

}
