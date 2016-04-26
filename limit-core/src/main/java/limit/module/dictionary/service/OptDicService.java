package limit.module.dictionary.service;

import java.util.List;

import limit.common.base.service.Service;
import limit.module.dictionary.model.OptDic;
import limit.module.dictionary.model.OptDicExam;

/**
 * 选项字典业务层
 * @author Binxiao
 */
public interface OptDicService extends Service<OptDic, OptDicExam> {

	/**
	 * 根据字典名称获取选项集合 [下拉]
	 * @param optName
	 * @return
	 */
	List<OptDic> selectOption(String optName);

	/**
	 * 获取字典指定选项的值
	 * @param optName
	 * @param optKey
	 * @return
	 */
	String getOptionValue(String optName, String optKey);

	/**
	 * 获取所有选项字典的父子结构 [easyui treegird]
	 * @return
	 */
	List<OptDic> selectOptDicTree();

	/**
	 * 更新选项字典
	 * @param optdic
	 */
	void updateOptdic(OptDic optdic);

	/**
	 * 删除选项字典
	 * @param id
	 */
	void removeOptdic(Long id);

	/**
	 * 根据参数key获取参数值
	 * @param paramKey
	 * @return
	 */
	String getParamValue(String paramKey);

	/**
	 * 获取所有参数 [easyui datagrid]
	 * @return
	 */
	List<OptDic> selectParams();

	/**
	 * 批量更新参数
	 * @param saveOptdics
	 */
	void updateMutliParam(List<OptDic> params);

}
