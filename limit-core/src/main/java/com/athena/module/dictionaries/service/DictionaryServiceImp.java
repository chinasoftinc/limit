package com.athena.module.dictionaries.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athena.common.base.service.AbstractService;
import com.athena.common.context.Constants;
import com.athena.common.context.Constants.Direction;
import com.athena.common.dto.Pagination;
import com.athena.common.exception.BusinessException;
import com.athena.common.exception.ExceptionCode;
import com.athena.module.dictionaries.dao.DictionaryDao;
import com.athena.module.dictionaries.model.Dictionary;
import com.athena.module.dictionaries.model.DictionaryExample;
import com.athena.module.dictionaries.model.DictionaryExample.Criteria;

@Service
public class DictionaryServiceImp extends AbstractService<Dictionary, DictionaryExample> implements DictionaryService {

	@Autowired
	private DictionaryDao dictionaryDao;

	@Override
	public List<Dictionary> selectDictionaries(String name) {

		DictionaryExample example = new DictionaryExample();
		example.or().andOptNameEqualTo(name).andOptTypeEqualTo(Constants.Dictionary.Type.DICTIONARY.code).andOptIsDirEqualTo(Constants.Dictionary.IsDir.NO.code);

		return this.selectByExample(example);

	}

	@Override
	public String getDictionaryValue(String name, String key) {

		String value = null;

		DictionaryExample example = new DictionaryExample();
		example.or().andOptNameEqualTo(name).andOptKeyEqualTo(key);

		List<Dictionary> dics = this.selectByExample(example);
		if (CollectionUtils.isNotEmpty(dics)) {
			value = dics.get(0).getOptValue();
		}

		return value;
	}

	private List<Dictionary> selectAllSubDictionary(Dictionary parent) {

		DictionaryExample example = new DictionaryExample();
		example.or().andOptParentIdEqualTo(parent.getId());

		List<Dictionary> dics = this.selectByExample(example);

		if (CollectionUtils.isNotEmpty(dics)) {
			for (Dictionary dic : dics) {
				dic.setChildren(selectAllSubDictionary(dic));
			}
		}

		return dics;
	}

	@Override
	public List<Dictionary> selectDictionariesTree() {

		// 查询一级路径选项字典
		DictionaryExample example = new DictionaryExample();
		example.or().andOptDeepEqualTo(Constants.Dictionary.TOP_DEEP).andOptTypeEqualTo(Constants.Dictionary.Type.DICTIONARY.code);
		example.setOrderByClause("OPT_SORT_NO");

		List<Dictionary> dics = this.selectByExample(example);

		if (CollectionUtils.isNotEmpty(dics)) {
			for (Dictionary dic : dics) {

				// 递归查询
				dic.setChildren(selectAllSubDictionary(dic));
			}
		}

		return dics;
	}

	@Override
	public void update(Dictionary dic) {

		// 选项字典级联更新子选项名称
		if (dic.getOptIsDir().equals(Constants.Dictionary.IsDir.NO.code) && dic.getOptType().equals(Constants.Dictionary.Type.DICTIONARY.code)) {
			Dictionary source = selectByPrimaryKey(dic.getId());

			if (!source.getOptName().equals(dic.getOptName())) {
				DictionaryExample example = new DictionaryExample();
				example.or().andOptParentIdEqualTo(dic.getId());

				List<Dictionary> subs = this.selectByExample(example);

				for (Dictionary sub : subs) {
					sub.setOptName(dic.getOptName());
					this.updateByPrimaryKeySelective(sub);
				}
			}
		}

		this.updateByPrimaryKeySelective(dic);
	}

	@Override
	public void remove(BigDecimal id) {
		Dictionary source = this.selectByPrimaryKey(id);

		// 目录删除一切
		if (source.getOptIsDir().equals(Constants.Dictionary.IsDir.YES.code)) {
			dictionaryDao.removeSubs(id);
		}

		// 选项字典删除子选项
		else if (source.getOptType().equals(Constants.Dictionary.Type.DICTIONARY.code)) {

			DictionaryExample example = new DictionaryExample();
			example.or().andOptParentIdEqualTo(id);

			List<Dictionary> subs = this.selectByExample(example);

			for (Dictionary sub : subs) {
				this.deleteByPrimaryKey(sub.getId());
			}
		}

		this.deleteByPrimaryKey(id);
	}

	@Override
	public String getParameterValue(String key) {

		DictionaryExample example = new DictionaryExample();
		example.or().andOptTypeEqualTo(Constants.Dictionary.Type.PARAMETER.code).andOptKeyEqualTo(key);

		List<Dictionary> params = this.selectByExample(example);

		if (CollectionUtils.isNotEmpty(params)) {
			return params.get(0).getOptValue();
		} else {
			throw new BusinessException(ExceptionCode.IllegalParamException, "没有找到[key:" + key + "]对应的参数");
		}
	}

	@Override
	public List<Dictionary> selectParametersTree() {

		// 查询一级路径参数
		DictionaryExample example = new DictionaryExample();
		example.or().andOptDeepEqualTo(Constants.Dictionary.TOP_DEEP).andOptTypeEqualTo(Constants.Dictionary.Type.PARAMETER.code);
		example.setOrderByClause("OPT_SORT_NO");

		List<Dictionary> dics = this.selectByExample(example);

		if (CollectionUtils.isNotEmpty(dics)) {
			for (Dictionary dic : dics) {

				// 递归查询
				dic.setChildren(selectAllSubDictionary(dic));
			}
		}

		return dics;
	}

	@Override
	public void updatePos(BigDecimal id, Direction direction) {

		// 当前记录
		Dictionary current = this.selectByPrimaryKey(id);

		// 条件为, 父级菜单相同, 深度相同, 排序相邻的
		DictionaryExample example = new DictionaryExample();
		Criteria crt = example.or().andOptParentIdEqualTo(current.getOptParentId()).andOptDeepEqualTo(current.getOptDeep());
		example.setPagination(new Pagination(1, 1));

		// 判断方向
		if (direction == Constants.Direction.UP) {
			// 查询小于当前sort, 并且是最大的
			crt.andOptSortNoLessThan(current.getOptSortNo());
			example.setOrderByClause("OPT_SORT_NO DESC");
		} else {
			// 查询大于当前sort, 并且是最小的
			crt.andOptSortNoGreaterThan(current.getOptSortNo());
			example.setOrderByClause("OPT_SORT_NO ASC");
		}

		List<Dictionary> dics = this.selectByExample(example);

		if (CollectionUtils.isNotEmpty(dics)) {
			Dictionary target = dics.get(0);

			// 交互排序
			short targetSortNo = target.getOptSortNo();
			target.setOptSortNo(current.getOptSortNo());
			current.setOptSortNo(targetSortNo);
			this.updateByPrimaryKeySelective(target);
			this.updateByPrimaryKeySelective(current);
		}

	}

}
