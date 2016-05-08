package com.athena.module.areas.mapper;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;

import com.athena.common.base.mapper.Mapper;
import com.athena.module.areas.model.Area;
import com.athena.module.areas.model.AreaExample;

public interface AreaMapper extends Mapper<Area, AreaExample> {

	/**
	 * 删除并级联删除所有子地区
	 * @param id
	 * @return
	 */
	void removeSubs(@Param("id") BigDecimal id);

	/**
	 * 获取指定节点的子节点最大排序
	 * @param id
	 * @return
	 */
	Short selectMaxSortNo(@Param("id") BigDecimal id);

}