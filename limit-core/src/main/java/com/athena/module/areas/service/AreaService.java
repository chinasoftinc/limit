package com.athena.module.areas.service;

import java.math.BigDecimal;
import java.util.List;

import com.athena.common.base.service.Service;
import com.athena.common.context.Constants.Direction;
import com.athena.common.dto.TreeNode;
import com.athena.module.areas.model.Area;
import com.athena.module.areas.model.AreaExample;

public interface AreaService extends Service<Area, AreaExample> {

	/**
	 * 获取指定节点的上下级树模型
	 * @param id
	 * @return
	 */
	List<TreeNode> selectAreasTree(BigDecimal id);

	/**
	 * 删除地区及所有子地区
	 * @param ids
	 */
	void remove(BigDecimal id);

	/**
	 * 添加地区
	 * @return
	 */
	int insertArea(Area record);

	/**
	 * 更新地区
	 * @param form
	 */
	int update(Area form);

	/**
	 * 根据id和名称模糊查询获取下级数模型
	 * @param id
	 * @param name [areasName或areasHeadLetter]
	 * @return
	 */
	List<TreeNode> selectAreaChildTree(BigDecimal id, String name);

	/**
	 * 移动位置
	 * @param id
	 * @param direction
	 */
	void updatePos(BigDecimal id, Direction direction);

}
