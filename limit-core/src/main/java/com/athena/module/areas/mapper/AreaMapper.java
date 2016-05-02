package com.athena.module.areas.mapper;

import java.math.BigDecimal;

import com.athena.common.base.mapper.Mapper;
import com.athena.module.areas.model.Area;
import com.athena.module.areas.model.AreaExample;

public interface AreaMapper extends Mapper<Area, AreaExample> {

	/**
	 * 删除并级联删除所有子地区
	 * @param id
	 * @return
	 */
	void removeSubs(BigDecimal id);

}