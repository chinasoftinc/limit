package com.athena.module.dictionaries.service;

import java.math.BigDecimal;
import java.util.List;

import com.athena.common.base.service.Service;
import com.athena.common.context.Constants.Direction;
import com.athena.module.dictionaries.model.Dictionary;
import com.athena.module.dictionaries.model.DictionaryExample;

public interface DictionaryService extends Service<Dictionary, DictionaryExample> {

	/**
	 * 根据字典名称获取子选项集合
	 * @param optName
	 * @return
	 */
	List<Dictionary> selectDictionaries(String name);

	/**
	 * 根据字典名称, 散列键, 获取对应字典值
	 * @param optName
	 * @param optKey
	 * @return
	 */
	String getDictionaryValue(String name, String key);

	/**
	 * 获取所有选项字典的上下级结构
	 * @return
	 */
	List<Dictionary> selectDictionariesTree();

	/**
	 * 添加字典
	 * @param record
	 * @return
	 */
	int insertDictionary(Dictionary record);

	/**
	 * 更新选项字典或参数
	 * @param optdic
	 */
	void updateDictionary(Dictionary model);

	/**
	 * 删除选项字典或参数
	 * @param id
	 */
	void removeDictionary(BigDecimal id);

	/**
	 * 根据参数键获取参数值
	 * @param paramKey
	 * @return
	 */
	String getParameterValue(String key);

	/**
	 * 获取所有参数的上下级结构
	 * @return
	 */
	List<Dictionary> selectParametersTree();

	/**
	 * 移动位置
	 * @param id
	 * @param direction
	 */
	void updatePos(BigDecimal id, Direction direction);

	/**
	 * 检测选项组名称是否可用
	 * @param group
	 * @return
	 */
	boolean isNotExistDictionaryGroup(Dictionary group);

	/**
	 * 检测选项键是否可用
	 * @param option
	 * @return
	 */
	boolean isNotExistDictionaryKey(Dictionary option);

	/**
	 * 检测参数名称是否可用
	 * @param form
	 * @return
	 */
	boolean isNotExistParameterName(Dictionary form);

}
