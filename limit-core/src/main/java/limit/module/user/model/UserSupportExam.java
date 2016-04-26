package limit.module.user.model;

import limit.common.base.entity.PageModel;
import limit.common.base.entity.Entity;
import limit.common.dto.Pagination;

/**
 * 用户查询条件扩展
 * @author niebinxiao
 */
public class UserSupportExam extends Entity<UserSupportExam> {
	private static final long serialVersionUID = -6280237863080151278L;
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
