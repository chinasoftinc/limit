package limit.common.dto;

import java.util.ArrayList;
import java.util.List;

import limit.common.base.entity.AbstractModel;

/**
 * 分页DTO
 * @author niebinxiao
 * @param <T>
 */
public class PageResult<T> {

	private static final Integer DEFAULT_PAGE_SIZE = 10;

	// 数据总数
	private Integer total = 0;

	// 数据
	private List<T> rows;

	// 分页查询对象
	private transient Pagination page;

	// 分页排序参数
	private transient List<String> orderBy;

	// 分页查询条件pojo
	private transient AbstractModel<T> filter;

	/**
	 * 通过分页查询条件pojo构建分页查询参数
	 * @param filter
	 */
	public PageResult(AbstractModel<T> filter) {
		this.filter = filter;
		this.initPagination(filter);
	}

	/**
	 * 说明:　初始化分页参数方法
	 * @param filter 分页查询条件参数pojo
	 * @return
	 */
	private void initPagination(AbstractModel<?> filter) {
		// 检测分页查询条件参数是否有误
		if (filter == null || filter.getPage() == null || filter.getRows() == null) {
			// 参数有误, 默认跳转第一页
			this.page = new Pagination(1, DEFAULT_PAGE_SIZE);
			return;
		}

		// 初始化分页查询对象
		this.page = new Pagination(filter.getPage(), filter.getRows());
		// 处理查询条件参数 [排序]
		if (filter.getSort() != null && filter.getOrder() != null) {
			// 排序参数数组
			String[] sortArr = filter.getSort().split(",");
			// 排序参数对应的排序方向数组
			String[] orderArr = filter.getOrder().split(",");
			List<String> list = new ArrayList<String>();
			// 构建排序sql
			for (int i = 0; i < orderArr.length; i++) {
				list.add(sortArr[i] + " " + orderArr[i]);
			}

			// 将排序sql设置到分页查询参数pojo中
			if (list.size() != 0) {
				this.orderBy = list;
			}
		}
	}

	public AbstractModel<T> getFilter() {
		return filter;
	}

	public void setFilter(AbstractModel<T> filter) {
		this.filter = filter;
	}

	public Pagination getPage() {
		return page;
	}

	public void setPage(Pagination page) {
		this.page = page;
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

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
