package com.athena.module.areas.dao;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.athena.common.base.dao.AbstractDao;
import com.athena.module.areas.mapper.AreaMapper;
import com.athena.module.areas.model.Area;
import com.athena.module.areas.model.AreaExample;

@Repository
public class AreaDaoImp extends AbstractDao<Area, AreaExample> implements AreaDao {

	@Autowired
	private AreaMapper areaMapper;
	
	@Override
	public void removeSubs(BigDecimal id) {
		areaMapper.removeSubs(id);
	}

	@Override
	public String sequenceName() {
		return "T_AREAS_SQL";
	}

}
