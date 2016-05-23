package com.athena.module.chelxx.dao;

import com.athena.common.base.dao.AbstractDao;
import com.athena.module.chelxx.model.Chelxx;
import com.athena.module.chelxx.model.ChelxxExample;

public class ChelxxDaoImp extends AbstractDao<Chelxx, ChelxxExample> implements ChelxxDao {

	@Override
	public String sequenceName() {
		return "REP_CHELXX_SEQ";
	}

}
