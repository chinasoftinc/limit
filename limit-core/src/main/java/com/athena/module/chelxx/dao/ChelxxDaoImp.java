package com.athena.module.chelxx.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.athena.common.base.dao.AbstractDao;
import com.athena.module.chelxx.mapper.ChelxxMapper;
import com.athena.module.chelxx.model.Chelxx;
import com.athena.module.chelxx.model.ChelxxExample;

@Repository
public class ChelxxDaoImp extends AbstractDao<Chelxx, ChelxxExample> implements ChelxxDao {

	@Autowired
	private ChelxxMapper chelxxMapper;
	
	@Override
	public String sequenceName() {
		return "REP_CHELXX_SEQ";
	}

	@Override
	public List<String> selectDistinctChepys() {
		return chelxxMapper.selectDistinctChepys();
	}

	@Override
	public List<String> selectDistinctFazjg() {
		return chelxxMapper.selectDistinctFazjg();
	}

}
