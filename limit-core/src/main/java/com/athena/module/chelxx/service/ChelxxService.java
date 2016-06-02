package com.athena.module.chelxx.service;

import java.util.List;

import com.athena.common.base.service.Service;
import com.athena.module.chelxx.model.Chelxx;
import com.athena.module.chelxx.model.ChelxxExample;

public interface ChelxxService extends Service<Chelxx, ChelxxExample> {

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
