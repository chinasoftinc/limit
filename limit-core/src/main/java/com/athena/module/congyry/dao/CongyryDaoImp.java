package com.athena.module.congyry.dao;

import org.springframework.stereotype.Repository;

import com.athena.common.base.dao.AbstractDao;
import com.athena.module.congyry.model.Congyry;
import com.athena.module.congyry.model.CongyryExample;

@Repository
public class CongyryDaoImp extends AbstractDao<Congyry, CongyryExample> implements CongyryDao {

	@Override
	public String sequenceName() {
		return "CONGYRY_SEQ";
	}

}
