package com.athena.business.dto;

import java.util.ArrayList;
import java.util.List;

public class PageModel {

	private List data = new ArrayList();

	private int pageNumber;

	private int pageSize;

	private int totalNumber;

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

}
