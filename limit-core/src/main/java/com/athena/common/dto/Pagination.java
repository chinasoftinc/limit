package com.athena.common.dto;

/**
 * @author niebinxiao
 */
public final class Pagination {

	// 查询的当前页
	private int currentPage = 1;

	// 查询的结果总数
	private int totalRecord;

	// 分页起始角标 [limit 第一个参数, 根据当前页*分页单位计算]
	private int limitIndex;

	// 记录开始角标
	private int beginIndex;

	// 记录结束角标
	private int endIndex;

	// 分页单位 [每页显示记录数]
	private int pageSize = 10;

	// 总共页数 [根据总记录数/分页单位]
	private int totalPage;

	public Pagination(int currentPage, int pageSize) {
		this.currentPage = currentPage - 1;
		this.pageSize = pageSize;
		beginIndex = (currentPage - 1) * pageSize;
		endIndex = beginIndex + pageSize;
	}

	/**
	 * 获取查询记录的开始角标
	 * @return
	 */
	public int getBeginIndex() {
		return beginIndex;
	}

	/**
	 * 获取查询记录的结束角标
	 * @return
	 */
	public int getEndIndex() {
		return endIndex;
	}

	/**
	 * 说明: 获取当前页
	 * @return
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * 说明: 获取总记录数
	 * @return
	 */
	public int getTotalRecord() {
		return totalRecord;
	}

	/**
	 * 说明: 获取limit角标
	 * @return
	 */
	public int getLimitIndex() {
		this.limitIndex = this.pageSize * this.currentPage;
		return this.limitIndex;
	}

	/**
	 * 说明: 获取分页单位
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 说明: 获取总页数
	 * @return
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * 说明: 设置总记录数, 计算总页数
	 * @param totalPage
	 */
	public void setTotalRcord(int totalRecord) {
		this.totalRecord = totalRecord;
		this.totalPage = this.totalRecord < this.pageSize ? 1 : (this.totalRecord % this.pageSize == 0 ? this.totalRecord / this.pageSize : this.totalRecord / this.pageSize + 1);
	}

}
