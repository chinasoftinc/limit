package com.athena.module.departments.service;

import java.math.BigDecimal;
import java.util.Date;
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
import com.athena.common.utils.AssertUtils;
import com.athena.common.utils.PinyinUtils;
import com.athena.module.departments.dao.DepartmentDao;
import com.athena.module.departments.model.Department;
import com.athena.module.departments.model.DepartmentExample;
import com.athena.module.departments.model.DepartmentExample.Criteria;

@Service
public class DepartmentServiceImp extends AbstractService<Department, DepartmentExample> implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public List<Department> selectDepartmentsTree() {
		// 查询一级路径选项字典
		DepartmentExample example = new DepartmentExample();
		example.or().andDeptDeepEqualTo(Constants.DepartmentModel.TOP_DEEP).andDeptTypeEqualTo(Constants.DepartmentModel.Type.ORG.code).andIsDelEqualTo(Constants.IS_DEL.NOT.code);
		example.setOrderByClause("DEPT_SORT_NO");

		List<Department> depts = this.selectByExample(example);

		if (CollectionUtils.isNotEmpty(depts)) {
			for (Department dept : depts) {
				dept.setChildren(selectAllSubDepartment(dept)); // 递归查询
			}
		}

		return depts;
	}

	private List<Department> selectAllSubDepartment(Department parent) {
		DepartmentExample example = new DepartmentExample();
		example.or().andDeptParentIdEqualTo(parent.getId()).andIsDelEqualTo(Constants.IS_DEL.NOT.code);
		example.setOrderByClause("DEPT_SORT_NO");

		List<Department> depts = this.selectByExample(example);

		if (CollectionUtils.isNotEmpty(depts)) {
			for (Department dept : depts) {
				dept.setChildren(selectAllSubDepartment(dept));
			}
		}

		return depts;
	}

	@Override
	public int insert(Department record) {

		// 主键
		record.setId(departmentDao.nextSEQ());

		// 排序自增
		Short no = departmentDao.selectMaxSortNo(record.getDeptParentId() == null ? BigDecimal.ZERO : record.getDeptParentId());
		record.setDeptSortNo((short) (no + 1));

		// 部门代码生成
		String code = PinyinUtils.getFirstPinyin(record.getDeptName());
		DepartmentExample example = new DepartmentExample();
		example.or().andIsDelEqualTo(Constants.IS_DEL.NOT.code).andDeptCodeEqualTo(code);
		int count = this.countByExample(example);
		if (this.countByExample(example) != 0) {
			code += count;
		}
		record.setDeptCode(code);

		// 版本
		record.setVersionNo(record.getVersionNo().add(new BigDecimal(1)));

		// 操作时间
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());

		// FIXME 记录操作用户

		// 更新上级部门数量
		Department parent = this.selectByPrimaryKey(record.getDeptParentId());
		if (parent != null) {
			parent.setDeptSubCount((short) (parent.getDeptSubCount() + 1));
			this.updateByPrimaryKeySelective(parent);
		}

		return super.insertSelective(record);
	}

	@Override
	public void update(Department record) {

		// 版本
		record.setVersionNo(record.getVersionNo().add(new BigDecimal(1)));

		// 操作时间
		record.setUpdateTime(new Date());

		// FIXME 记录操作用户

		this.updateByPrimaryKeySelective(record);
	}

	@Override
	public void updatePos(BigDecimal id, Direction direction) {
		// 当前记录
		Department current = this.selectByPrimaryKey(id);

		// 条件为, 父级菜单相同, 深度相同, 排序相邻的
		DepartmentExample example = new DepartmentExample();
		Criteria or = example.or().andDeptParentIdEqualTo(current.getDeptParentId()).andDeptDeepEqualTo(current.getDeptDeep());
		example.setPagination(new Pagination(1, 1));

		// 判断方向
		if (direction == Constants.Direction.UP) {
			// 查询小于当前sort, 并且是最大的
			or.andDeptSortNoLessThan(current.getDeptSortNo());
			example.setOrderByClause("DEPT_SORT_NO DESC");
		} else {
			// 查询大于当前sort, 并且是最小的
			or.andDeptSortNoGreaterThan(current.getDeptSortNo());
			example.setOrderByClause("DEPT_SORT_NO ASC");
		}

		List<Department> depts = this.selectByExample(example);

		if (CollectionUtils.isNotEmpty(depts)) {
			Department target = depts.get(0);

			// 交换排序
			short targetSortNo = target.getDeptSortNo();
			target.setDeptSortNo(current.getDeptSortNo());
			current.setDeptSortNo(targetSortNo);
			this.updateByPrimaryKeySelective(target);
			this.updateByPrimaryKeySelective(current);
		}
	}

	@Override
	public void remove(BigDecimal id) throws BusinessException {

		DepartmentExample example = new DepartmentExample();
		example.or().andDeptParentIdEqualTo(id).andIsDelEqualTo(Constants.IS_DEL.NOT.code);

		AssertUtils.isTrue(this.countByExample(example) == 0, ExceptionCode.BusinessException, "含有子机构或部门, 无法删除!");

		Department dept = this.selectByPrimaryKey(id);
		if (dept != null) {

			// FIXME 检测是否含有用户
			AssertUtils.isTrue(false, ExceptionCode.BusinessException, "部门含有人员, 无法删除该部门!");

			dept.setIsDel(Constants.IS_DEL.DELED.code);
			this.updateByPrimaryKeySelective(dept);

		}
	}

}
