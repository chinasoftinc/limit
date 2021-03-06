package com.athena.module.dictionaries.dao;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.athena.common.base.dao.AbstractDao;
import com.athena.module.dictionaries.mapper.DictionaryMapper;
import com.athena.module.dictionaries.model.Dictionary;
import com.athena.module.dictionaries.model.DictionaryExample;

@Repository
public class DictionaryDaoImp extends AbstractDao<Dictionary, DictionaryExample> implements DictionaryDao {

	@Autowired
	private DictionaryMapper dictionaryMapper;

	public void removeSubs(BigDecimal id) {
		dictionaryMapper.removeSubs(id);
	}

	@Override
	public String sequenceName() {
		return "T_DICTIONARIES_SEQ";
	}

	@Override
	public Short selectMaxSortNo(BigDecimal id) {
		Short no = dictionaryMapper.selectMaxSortNo(id);
		return no == null ? 0 : no;
	}
}
