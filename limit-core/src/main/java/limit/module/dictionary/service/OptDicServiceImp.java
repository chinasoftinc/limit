package limit.module.dictionary.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import limit.common.base.service.AbstractService;
import limit.common.exception.BusinessException;
import limit.common.exception.ExceptionCode;
import limit.module.dictionary.dao.OptDicDao;
import limit.module.dictionary.model.OptDic;
import limit.module.dictionary.model.OptDicExam;

/**
 * <pre>
 * 选项字典业务层实现类
 * 约定:
 * 		参数管理: opt_name统一为param, opt_key为参数名, opt_val为参数值, parent为null 
 * 		选项字典: opt_name 为选项名, opt_key 选项key opt_val 选项展示值, parnet为父选项的id, 父选项为parent0
 * @author Binxiao
 */
@Service
public class OptDicServiceImp extends AbstractService<OptDic, OptDicExam> implements OptDicService {
	private static final String PARAM_OPT_NAME = "sys_param";

	@Autowired
	private OptDicDao dao;
	
	public String getEntityType() {
		return "数据字典";
	}

	// 根据字典名称获取选项集合 [下拉]
	@Override
	public List<OptDic> selectOption(String optName) {
		OptDicExam exam = new OptDicExam();
		exam.or().andOptNameEqualTo(optName).andParentIdNotEqualTo(0L);
		return selectByExample(exam);
	}

	// 获取字典指定选项的值
	@Override
	public String getOptionValue(String optName, String optKey) {
		OptDicExam exam = new OptDicExam();
		exam.or().andOptNameEqualTo(optName).andParentIdNotEqualTo(0L).andOptKeyEqualTo(optKey);
		List<OptDic> optdics = selectByExample(exam);
		if (CollectionUtils.isNotEmpty(optdics)) {
			return optdics.get(0).getOptVal();
		}
		return null;
	}

	// 获取所有选项字典的父子结构 [easyui treegird]
	@Override
	public List<OptDic> selectOptDicTree() {

		// 查询选项字典父选项组
		OptDicExam exam = new OptDicExam();
		// 查询所有选项字典
		exam.or().andParentIdEqualTo(0L).andOptNameNotEqualTo(PARAM_OPT_NAME);
		// 按名称排序
		exam.setOrderByClause("opt_name");

		List<OptDic> optDicGroups = dao.selectByExample(exam);

		// 设置子选项到父选项的children的list中
		for (OptDic optDicGroup : optDicGroups) {
			exam = new OptDicExam();
			exam.or().andParentIdEqualTo(optDicGroup.getId());
			List<OptDic> childs = dao.selectByExample(exam);
			optDicGroup.setChildren(childs);
		}

		return optDicGroups;
	}

	// 更新选项字典
	@Override
	public void updateOptdic(OptDic optdic) {

		// 如果是父选项, 级联更新子选项的optName
		if (optdic.getParentId() == 0L) {
			OptDicExam exam = new OptDicExam();
			exam.or().andParentIdEqualTo(optdic.getId());
			List<OptDic> childs = dao.selectByExample(exam);

			// 更新子选项
			for (OptDic child : childs) {
				child.setOptName(optdic.getOptName());
				dao.updateByPrimaryKeySelective(child);
			}
		}

		dao.updateByPrimaryKeySelective(optdic);
	}

	// 删除选项字典
	@Override
	public void removeOptdic(Long id) {
		OptDic optdic = dao.selectByPrimaryKey(id);

		// 如果是父选项, 级联删除子选项
		if (optdic.getParentId() == 0L) {
			OptDicExam exam = new OptDicExam();
			exam.or().andParentIdEqualTo(optdic.getId());
			dao.deleteByExample(exam);
		}

		dao.deleteByPrimaryKey(optdic.getId());
	}

	// 根据参数key获取参数值
	@Override
	public String getParamValue(String paramKey) {
		OptDicExam exam = new OptDicExam();
		// 针对参数
		exam.or().andOptNameEqualTo(PARAM_OPT_NAME).andOptKeyEqualTo(paramKey);
		List<OptDic> optdics = dao.selectByExample(exam);

		if (CollectionUtils.isNotEmpty(optdics)) {
			return optdics.get(0).getOptVal();
		} else {
			throw new BusinessException(ExceptionCode.IllegalParamException, "没有找到[key:" + paramKey + "]对应的参数");
		}
	}

	// 获取所有参数 [easyui datagrid]
	@Override
	public List<OptDic> selectParams() {
		OptDicExam exam = new OptDicExam();
		// 按参数名排序
		exam.setOrderByClause("opt_key");
		// 所有参数
		exam.or().andOptNameEqualTo(PARAM_OPT_NAME);

		return dao.selectByExample(exam);
	}

	// 批量更新参数
	@Override
	public void updateMutliParam(List<OptDic> params) {
		for (OptDic param : params) {
			dao.updateByPrimaryKeySelective(param);
		}
	}

}
