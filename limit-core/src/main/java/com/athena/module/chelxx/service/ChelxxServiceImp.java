package com.athena.module.chelxx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athena.common.base.service.AbstractService;
import com.athena.module.chelxx.dao.ChelxxDao;
import com.athena.module.chelxx.model.Chelxx;
import com.athena.module.chelxx.model.ChelxxExample;

@Service
public class ChelxxServiceImp extends AbstractService<Chelxx, ChelxxExample> implements ChelxxService {

	@Autowired
	private ChelxxDao chelxxDao;

	@Override
	public List<String> selectDistinctChepys() {
		return chelxxDao.selectDistinctChepys();
	}

	@Override
	public List<String> selectDistinctFazjg() {
		return chelxxDao.selectDistinctFazjg();
	}

}
