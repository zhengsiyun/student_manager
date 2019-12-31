package com.zsy.utils;

public class DataGridView {
	
	private Long total;
	private Object rows;
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Object getRows() {
		return rows;
	}
	public void setRows(Object rows) {
		this.rows = rows;
	}
	public DataGridView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DataGridView(Long total, Object rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	
}
