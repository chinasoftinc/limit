package com.athena.module.chelxx.dao;

import java.util.List;

import com.athena.common.base.dao.Dao;
import com.athena.module.chelxx.model.Chelxx;
import com.athena.module.chelxx.model.ChelxxExample;

public interface ChelxxDao extends Dao<Chelxx, ChelxxExample> {

	/**
	 * 查询车牌的所有颜色
	 * @return
	 */
	List<String> selectDistinctChepys();

	/**
	 * 查询所有发证机构
	 * @return
	 */
	List<String> selectDistinctFazjg();

}
