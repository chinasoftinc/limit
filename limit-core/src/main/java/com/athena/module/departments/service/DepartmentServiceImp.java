package com.athena.module.departments.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athena.common.base.service.AbstractService;
import com.athena.common.context.Constants.DepartmentModel;
import com.athena.common.context.Constants.DepartmentModel.Type;
import com.athena.common.context.Constants.Direction;
import com.athena.common.context.Constants.IS_DEL;
import com.athena.common.dto.Pagination;
import com.athena.common.exception.BusinessException;
import com.athena.common.exception.ExceptionCode;
import com.athena.common.utils.AssertUtils;
import com.athena.common.utils.PinyinUtils;
import com.athena.module.departments.dao.DepartmentDao;
import com.athena.module.departments.model.Department;
import com.athena.module.departments.model.DepartmentExample;
import com.athena.module.departments.model.DepartmentExample.Criteria;
import com.athena.module.users.dao.UserDao;
import com.athena.module.users.model.User;
import com.athena.module.users.model.UserExample;

@Service
public class DepartmentServiceImp extends AbstractService<Department, DepartmentExample> implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private UserDao userDao;

	@Override
	public List<Department> selectDepartmentsTree() {
		// 查询一级路径选项字典
		DepartmentExample example = new DepartmentExample();
		example.or().andDeptDeepEqualTo(DepartmentModel.TOP_DEEP).andDeptTypeEqualTo(DepartmentModel.Type.ORG.code).andIsDelEqualTo(IS_DEL.NOT.code);
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
		example.or().andDeptParentIdEqualTo(parent.getId()).andIsDelEqualTo(IS_DEL.NOT.code);
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
	public int insertDept(Department dept, User creator) {

		// 主键
		dept.setId(departmentDao.nextSEQ());

		// 排序自增
		Short no = departmentDao.selectMaxSortNo(dept.getDeptParentId() == null ? BigDecimal.ZERO : dept.getDeptParentId());
		dept.setDeptSortNo((short) (no + 1));

		// 部门代码生成
		String code = PinyinUtils.getFirstPinyin(dept.getDeptName());
		DepartmentExample example = new DepartmentExample();
		example.or().andIsDelEqualTo(IS_DEL.NOT.code).andDeptCodeEqualTo(code);
		int count = this.countByExample(example);
		if (this.countByExample(example) != 0) {
			code += count;
		}
		dept.setDeptCode(code);

		// 版本
		dept.setVersionNo(dept.getVersionNo().add(new BigDecimal(1)));

		// 操作时间
		dept.setCreateTime(new Date());
		dept.setUpdateTime(new Date());

		// 记录操作用户
		if (creator != null) {
			dept.setCreateUserid(creator.getId());
			dept.setUpdateUserid(creator.getId());
		}

		// 更新上级部门数量
		Department parent = this.selectByPrimaryKey(dept.getDeptParentId());
		if (parent != null) {
			parent.setDeptSubCount((short) (parent.getDeptSubCount() + 1));
			this.updateByPrimaryKeySelective(parent);
		}

		return super.insertSelective(dept);
	}

	@Override
	public int updateDept(Department dept, User creator) {

		// 版本
		dept.setVersionNo(dept.getVersionNo().add(new BigDecimal(1)));

		// 操作时间
		dept.setUpdateTime(new Date());

		// 记录操作用户
		if (creator != null) {
			dept.setUpdateUserid(creator.getId());
		}

		return this.updateByPrimaryKeySelective(dept);
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
		if (direction == Direction.UP) {
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

		// 检测是否含有子部门
		DepartmentExample example = new DepartmentExample();
		example.or().andDeptParentIdEqualTo(id).andIsDelEqualTo(IS_DEL.NOT.code);
		AssertUtils.isTrue(this.countByExample(example) == 0, ExceptionCode.BusinessException, "含有子机构或部门, 无法删除!");

		Department dept = this.selectByPrimaryKey(id);
		if (dept != null) {

			// 检测是否含有用户
			UserExample userexample = new UserExample();
			userexample.or().andDepartmentIdEqualTo(dept.getId()).andIsDelEqualTo(IS_DEL.NOT.code);
			userexample.or().andOrgIdEqualTo(dept.getId()).andIsDelEqualTo(IS_DEL.NOT.code);
			AssertUtils.isTrue(userDao.countByExample(userexample) == 0, ExceptionCode.BusinessException, "部门含有人员, 无法删除该部门!");

			dept.setIsDel(IS_DEL.DELED.code);
			this.updateByPrimaryKeySelective(dept);
		}

		// 更新上级部门数量
		Department parent = this.selectByPrimaryKey(dept.getDeptParentId());
		if (parent != null) {
			parent.setDeptSubCount((short) (parent.getDeptSubCount() - 1));
			this.updateByPrimaryKeySelective(parent);
		}
	}

	@Override
	public List<Department> listDeptForOrg(BigDecimal orgId) {
		DepartmentExample example = new DepartmentExample();
		example.or().andDeptParentIdEqualTo(orgId).andIsDelEqualTo(IS_DEL.NOT.code);

		List<Department> depts = this.selectByExample(example);
		List<Department> temp = new ArrayList<Department>();
		ListIterator<Department> it = depts.listIterator();
		while (it.hasNext()) {
			Department dept = it.next();
			if (dept.getDeptType().equals(Type.ORG.code)) {
				it.remove();
			}
			temp.addAll(this.listDeptForOrg(dept.getId()));
		}
		depts.addAll(temp);
		return depts;
	}

}
