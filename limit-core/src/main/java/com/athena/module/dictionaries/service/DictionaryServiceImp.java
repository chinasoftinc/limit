package com.athena.module.dictionaries.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athena.common.base.service.AbstractService;
import com.athena.common.context.Constants.DictionaryModel;
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
		example.or().andOptNameEqualTo(name).andOptTypeEqualTo(DictionaryModel.Type.DICTIONARY.code).andOptIsDirEqualTo(DictionaryModel.IsDir.NO.code);

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
		example.setOrderByClause("OPT_SORT_NO");

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
		example.or().andOptDeepEqualTo(DictionaryModel.TOP_DEEP).andOptTypeEqualTo(DictionaryModel.Type.DICTIONARY.code);
		example.setOrderByClause("OPT_SORT_NO");

		List<Dictionary> dics = this.selectByExample(example);

		if (CollectionUtils.isNotEmpty(dics)) {
			for (Dictionary dic : dics) {
				dic.setChildren(selectAllSubDictionary(dic)); // 递归查询
			}
		}

		return dics;
	}

	@Override
	public int insertDictionary(Dictionary record) {
		record.setId(dictionaryDao.nextSEQ());
		Short no = dictionaryDao.selectMaxSortNo(record.getOptParentId() == null ? BigDecimal.ZERO : record.getOptParentId());
		record.setOptSortNo((short) (no + 1)); // 排序自增
		return super.insertSelective(record);
	}

	@Override
	public void updateDictionary(Dictionary dic) {

		// 更新选项组名称级联更新子选项名称
		if (dic.getOptType().equals(DictionaryModel.Type.DICTIONARY_GROUP.code)) {
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
	public void removeDictionary(BigDecimal id) {
		dictionaryDao.removeSubs(id);
	}

	@Override
	public String getParameterValue(String key) {

		DictionaryExample example = new DictionaryExample();
		example.or().andOptTypeEqualTo(DictionaryModel.Type.PARAMETER.code).andOptKeyEqualTo(key);

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
		example.or().andOptDeepEqualTo(DictionaryModel.TOP_DEEP).andOptTypeEqualTo(DictionaryModel.Type.PARAMETER.code);
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
		if (direction == Direction.UP) {
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

			// 交换排序
			short targetSortNo = target.getOptSortNo();
			target.setOptSortNo(current.getOptSortNo());
			current.setOptSortNo(targetSortNo);
			this.updateByPrimaryKeySelective(target);
			this.updateByPrimaryKeySelective(current);
		}

	}

	@Override
	public boolean isNotExistDictionaryGroup(Dictionary group) {
		DictionaryExample example = new DictionaryExample();
		Criteria or = example.or();
		if (group.getId() != null) {
			or.andIdNotEqualTo(group.getId()); // 针对修改排除自身
		}
		or.andOptNameEqualTo(group.getOptName()).andOptTypeEqualTo(DictionaryModel.Type.DICTIONARY_GROUP.code);

		return this.countByExample(example) == 0;
	}

	@Override
	public boolean isNotExistDictionaryKey(Dictionary option) {
		DictionaryExample example = new DictionaryExample();
		Criteria or = example.or();
		if (option.getId() != null) {
			or.andIdNotEqualTo(option.getId()); // 针对修改排除自身
		}
		or.andOptKeyEqualTo(option.getOptKey()).andOptParentIdEqualTo(option.getOptParentId());

		return this.countByExample(example) == 0;
	}

	@Override
	public boolean isNotExistParameterName(Dictionary parameter) {
		DictionaryExample example = new DictionaryExample();
		Criteria or = example.or();
		if (parameter.getId() != null) {
			or.andIdNotEqualTo(parameter.getId()); // 针对修改排除自身
		}
		or.andOptNameEqualTo(parameter.getOptName()).andOptTypeEqualTo(DictionaryModel.Type.PARAMETER.code);

		return this.countByExample(example) == 0;
	}

}
