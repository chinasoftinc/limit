package com.athena.module.area.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athena.common.base.service.AbstractService;
import com.athena.common.dto.TreeNode;
import com.athena.module.area.dao.AreaDao;
import com.athena.module.area.model.Area;
import com.athena.module.area.model.AreaExam;
import com.athena.module.area.model.AreaExam.Criteria;

/**
 * 地区业务层实现类
 * @author Binxiao
 */
@Service
public class AreaServiceImp extends AbstractService<Area, AreaExam> implements AreaService {

	@Autowired
	private AreaDao dao;

	public String getEntityType() {
		return "地区管理";
	}

	// 获取地区树结构 [eaysuiTreeNode]
	@Override
	public List<TreeNode> selectAreaTree(Long parentAreaId) {
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();

		// 根据parentAreaId查询指定子地区数据
		AreaExam exam = new AreaExam();
		// 排序
		exam.setOrderByClause("AreaId");
		exam.or().andParentareaidEqualTo(parentAreaId);
		List<Area> areas = dao.selectByExample(exam);

		// 转化为easyuiTreeNode结构
		TreeNode node;
		for (Area area : areas) {
			node = new TreeNode();
			node.setId(area.getAreaid().toString());
			node.setText(area.getAreaname());
			treeNodes.add(node);
		}
		return treeNodes;
	}

	// 删除多个地区, 级联删除子地区
	@Override
	public void deleteMultiArea(List<Long> areaidList) {
		if (CollectionUtils.isNotEmpty(areaidList)) {
			for (Long areaid : areaidList) {
				// 处理子地区的删除
				AreaExam exam = new AreaExam();
				exam.or().andParentareaidEqualTo(areaid);
				List<Area> childs = dao.selectByExample(exam);
				if (CollectionUtils.isNotEmpty(childs)) {
					List<Long> childAreaIdList = new ArrayList<Long>();
					for (Area area : childs) {
						childAreaIdList.add(area.getAreaid());
					}
					deleteMultiArea(childAreaIdList);
				}
				dao.deleteByPrimaryKey(areaid);
			}
		}
	}

	// 根据parentareaid获取子地区树结构 [eaysuiTreeNode]
	@Override
	public List<TreeNode> selectAreaChildTree(Long parentAreaId, String areaname) {
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();

		// 根据parentAreaId查询指定子地区数据
		AreaExam exam = new AreaExam();
		// 排序
		exam.setOrderByClause("AreaId");
		Criteria criteria = exam.or();
		if (StringUtils.isNotEmpty(areaname)) {
			criteria.andAreanameLikeInsensitive(areaname + "%");
		}
		criteria.andParentareaidEqualTo(parentAreaId);
		List<Area> areas = dao.selectByExample(exam);

		// 转化为easyuiTreeNode结构, combox下拉数据格式和easyuiTreeNode一致
		TreeNode node;
		for (Area area : areas) {
			node = new TreeNode();
			node.setId(area.getAreaid().toString());
			node.setText(area.getAreaname());
			treeNodes.add(node);
		}
		return treeNodes;
	}

}
