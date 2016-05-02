package com.athena.module.areas.dao;

import java.math.BigDecimal;

import com.athena.common.base.dao.Dao;
import com.athena.module.areas.model.Area;
import com.athena.module.areas.model.AreaExample;

public interface AreaDao extends Dao<Area, AreaExample> {

	/**
	 * 删除并级联所有子地区
	 * @param id
	 */
	void removeSubs(BigDecimal id);

}
