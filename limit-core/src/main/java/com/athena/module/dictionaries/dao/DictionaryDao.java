package com.athena.module.dictionaries.dao;

import java.math.BigDecimal;

import com.athena.common.base.dao.Dao;
import com.athena.module.dictionaries.model.Dictionary;
import com.athena.module.dictionaries.model.DictionaryExample;

public interface DictionaryDao extends Dao<Dictionary, DictionaryExample>{

	public void removeSubs(BigDecimal id);

}
