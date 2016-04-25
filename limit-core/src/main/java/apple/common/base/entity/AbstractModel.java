package apple.common.base.entity;

import java.util.List;

/**
 * model超类
 * @author niebinxiao
 * @param <T>
 */
public abstract class AbstractModel<T> extends Entity<T> {
	private static final long serialVersionUID = 1L;

	// 当前页 easyui
	transient Integer page;

	// 分页单位 easyui
	transient Integer rows;

	// 总记录数
	transient Integer totalRecord = 0;

	// 排序字段 easyui
	transient String sort;

	// 排序模式 easyui
	transient String order;

	// 排序SQL条件数组 [手动组装 (id asc..)]
	transient List<String> orderBy;

	// 操作类型 edit/add [页面路由判断]
	transient String operation;

	// 父窗口引用Id [页面当前操作窗口的父窗口引用]
	transient String parentWinId;

	// 当前窗口Id [页面当前操作窗口]
	transient String winId;

	/**
	 * 获取统一的id
	 * @return
	 */
	public abstract Object getId();

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getParentWinId() {
		return parentWinId;
	}

	public void setParentWinId(String parentWinId) {
		this.parentWinId = parentWinId;
	}

	public String getWinId() {
		return winId;
	}

	public void setWinId(String winId) {
		this.winId = winId;
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public List<String> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(List<String> orderBy) {
		this.orderBy = orderBy;
	}

}
