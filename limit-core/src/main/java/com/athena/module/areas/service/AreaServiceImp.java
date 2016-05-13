package com.athena.module.areas.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athena.common.base.service.AbstractService;
import com.athena.common.context.Constants.AreaModel;
import com.athena.common.context.Constants.Direction;
import com.athena.common.dto.Pagination;
import com.athena.common.dto.TreeNode;
import com.athena.common.utils.PinyinUtils;
import com.athena.module.areas.dao.AreaDao;
import com.athena.module.areas.model.Area;
import com.athena.module.areas.model.AreaExample;
import com.athena.module.areas.model.AreaExample.Criteria;

@Service
public class AreaServiceImp extends AbstractService<Area, AreaExample> implements AreaService {

	@Autowired
	private AreaDao areaDao;

	@Override
	public List<TreeNode> selectAreasTree(BigDecimal id) {

		List<TreeNode> tree = new ArrayList<TreeNode>();

		// 根据节点ID查询指定子地区数据
		AreaExample example = new AreaExample();
		example.setOrderByClause("AREAS_SORT_NO");
		example.or().andAreasParentIdEqualTo(id);

		List<Area> areas = this.selectByExample(example);

		// 转化为easyuiTreeNode结构
		TreeNode node;
		for (Area area : areas) {
			node = new TreeNode();
			node.setId(String.valueOf(area.getId()));
			node.setText(area.getAreasName());
			tree.add(node);
		}
		return tree;

	}

	@Override
	public void remove(BigDecimal id) {
		areaDao.removeSubs(id);
	}

	@Override
	public List<TreeNode> selectAreaChildTree(BigDecimal id, String name) {

		List<TreeNode> tree = new ArrayList<TreeNode>();

		// 查询指定子地区数据
		AreaExample example = new AreaExample();
		example.setOrderByClause("AREAS_SORT_NO");

		// 是否模糊查询
		if (StringUtils.isNotEmpty(name)) {
			example.or().andAreasParentIdEqualTo(id).andAreasNameLikeInsensitive(name + "%");
			example.or().andAreasParentIdEqualTo(id).andAreasHeadLetterLikeInsensitive(name + "%");
		} else {
			example.or().andAreasParentIdEqualTo(id);
		}
		List<Area> subs = this.selectByExample(example);

		// 转化为树模型
		TreeNode node;
		for (Area sub : subs) {
			node = new TreeNode();
			node.setId(String.valueOf(sub.getId()));
			node.setText(sub.getAreasName());
			tree.add(node);
		}

		return tree;
	}

	@Override
	public void updatePos(BigDecimal id, Direction direction) {
		// 当前记录
		Area current = this.selectByPrimaryKey(id);

		// 条件为, 上级ID相同, 深度相同, 排序相邻的
		AreaExample example = new AreaExample();
		Criteria crt = example.or().andAreasParentIdEqualTo(current.getAreasParentId()).andAreasDeepEqualTo(current.getAreasDeep());
		example.setPagination(new Pagination(1, 1));

		// 判断方向
		if (direction == Direction.UP) {
			// 查询小于当前sort, 并且是最大的
			crt.andAreasSortNoLessThan(current.getAreasSortNo());
			example.setOrderByClause("AREAS_SORT_NO DESC");
		} else {
			// 查询大于当前sort, 并且是最小的
			crt.andAreasSortNoGreaterThan(current.getAreasSortNo());
			example.setOrderByClause("AREAS_SORT_NO ASC");
		}

		List<Area> areas = this.selectByExample(example);

		if (CollectionUtils.isNotEmpty(areas)) {
			Area target = areas.get(0);

			// 交换排序
			short targetSortNo = target.getAreasSortNo();
			target.setAreasSortNo(current.getAreasSortNo());
			current.setAreasSortNo(targetSortNo);
			this.updateByPrimaryKeySelective(target);
			this.updateByPrimaryKeySelective(current);
		}
	}

	@Override
	public int insert(Area record) {
		record.setId(areaDao.nextSEQ());

		// 生成首字母
		String word = PinyinUtils.getFirstPinyin(record.getAreasName().substring(0, 1));
		record.setAreasHeadLetter(word);

		// 获取排序
		Short no = areaDao.selectMaxSortNo(record.getAreasParentId() == null ? BigDecimal.ZERO : record.getAreasParentId());
		record.setAreasSortNo((short) (no + 1)); // 排序自增

		// 顶级地区
		if (new BigDecimal(0).compareTo(record.getAreasParentId()) == 0) {
			record.setAreasDeep(AreaModel.TOP_DEEP);
		}
		// 非顶级区域
		else {
			Area parentArea = this.selectByPrimaryKey(record.getAreasParentId());
			record.setAreasDeep((short) (parentArea.getAreasDeep() + 1));
		}
		return super.insertSelective(record);
	}

	@Override
	public int update(Area record) {
		// 生成首字母
		String word = PinyinUtils.getFirstPinyin(record.getAreasName().substring(0, 1));
		record.setAreasHeadLetter(word);

		return super.updateByPrimaryKeySelective(record);
	}

}
