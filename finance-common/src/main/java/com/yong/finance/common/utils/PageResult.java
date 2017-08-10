package com.yong.finance.common.utils;

import java.util.List;

public class PageResult {
	//总页数
	private Integer total;
	//实际数据
	private List<?> rows;
	//记录数
	private Long records;
	//当前页
	private Integer page;
	

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Long getRecords() {
		return records;
	}

	public void setRecords(Long records) {
		this.records = records;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	
}
