package com.athena.module.users.model;

import com.athena.common.base.entity.PageModel;
import com.athena.common.dto.Pagination;

/**
 * 自定义用户查询条件
 * @author niebinxiao
 */
public class UserExampleDefined {

	// 分页查询dto
	private Pagination pagination;

	// 查询过滤条件
	private PageModel<User> filter;

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public PageModel<User> getFilter() {
		return filter;
	}

	public void setFilter(PageModel<User> filter) {
		this.filter = filter;
	}

}
