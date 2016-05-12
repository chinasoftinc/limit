package com.athena.common.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;

import com.athena.common.base.entity.PageModel;

/**
 * 分页dto
 * @author niebinxiao
 * @param <bean>
 */
public class PageResult<bean> {

	private static final Integer DEFAULT_PAGE_SIZE = 10;

	// 数据总数
	private Integer total = 0;

	// 数据
	private List<bean> rows;

	// 分页查询对象
	private transient Pagination pagination;

	// 分页排序参数
	private transient List<String> orderBy;

	// 分页查询条件模型
	private transient PageModel<bean> filter;

	/**
	 * 通过分页查询条件模型构建分页查询参数
	 * @param filter
	 */
	public PageResult(PageModel<bean> filter) {
		this.filter = filter;
		this.initPagination(filter, null);
	}

	/**
	 * 通过分页查询条件模型构建分页查询参数
	 * @param filter
	 */
	public PageResult(PageModel<bean> filter, Map<String, String> orderFieldConver) {
		this.filter = filter;
		this.initPagination(filter, orderFieldConver);
	}

	/**
	 * 说明: 初始化分页参数方法
	 * @param filter 分页查询条件参数模型
	 * @return
	 */
	private void initPagination(PageModel<?> filter, Map<String, String> orderFieldConver) {

		// 检测分页查询条件参数是否有误
		if (filter == null || filter.getPage() == null || filter.getRows() == null) {

			// 参数有误, 默认跳转第一页
			this.pagination = new Pagination(1, DEFAULT_PAGE_SIZE);
			return;
		}

		// 初始化分页查询对象
		this.pagination = new Pagination(filter.getPage(), filter.getRows());
		// 处理查询条件参数 [排序]
		if (filter.getSort() != null && filter.getOrder() != null) {

			// 排序参数数组
			String[] sortArr = filter.getSort().split(",");

			// 处理字段的抓换
			converField(sortArr, orderFieldConver);

			// 排序参数对应的排序方向数组
			String[] orderArr = filter.getOrder().split(",");
			List<String> list = new ArrayList<String>();

			// 构建排序sql
			for (int i = 0; i < orderArr.length; i++) {
				list.add(sortArr[i] + " " + orderArr[i]);
			}

			// 将排序sql设置到分页查询参数模型中
			if (list.size() != 0) {
				this.orderBy = list;
			}
		}
	}

	// 转换排序字段为SQL字段
	private void converField(String[] sortArr, Map<String, String> orderFieldConver) {
		if (MapUtils.isNotEmpty(orderFieldConver)) {
			for (Map.Entry<String, String> entry : orderFieldConver.entrySet()) {
				for (int i = 0; i < sortArr.length; i++) {
					if (sortArr[i].equals(entry.getKey())) {
						sortArr[i] = entry.getValue();
					}
				}
			}
		}
	}

	public PageModel<bean> getFilter() {
		return filter;
	}

	public void setFilter(PageModel<bean> filter) {
		this.filter = filter;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public List<String> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(List<String> orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<bean> getRows() {
		return rows;
	}

	public void setRows(List<bean> rows) {
		this.rows = rows;
	}

}
