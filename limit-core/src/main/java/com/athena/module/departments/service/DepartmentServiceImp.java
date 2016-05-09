package com.athena.module.departments.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.athena.common.base.service.AbstractService;
import com.athena.common.context.Constants;
import com.athena.module.departments.model.Department;
import com.athena.module.departments.model.DepartmentExample;

@Service
public class DepartmentServiceImp extends AbstractService<Department, DepartmentExample> implements DepartmentService {

	@Override
	public List<Department> selectDepartmentsTree() {
		// 查询一级路径选项字典
		DepartmentExample example = new DepartmentExample();
		example.or().andDeptDeepEqualTo(Constants.DepartmentModel.TOP_DEEP).andDeptTypeEqualTo(Constants.DepartmentModel.Type.ORG.code);
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
		example.or().andDeptParentIdEqualTo(parent.getId());
		example.setOrderByClause("DEPT_SORT_NO");

		List<Department> depts = this.selectByExample(example);

		if (CollectionUtils.isNotEmpty(depts)) {
			for (Department dept : depts) {
				dept.setChildren(selectAllSubDepartment(dept));
			}
		}
		
		return depts;
	}

}
