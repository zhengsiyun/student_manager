package com.zsy.vo;

import com.zsy.domain.Clazz;
import com.zsy.domain.Exam;

public class ClazzVo extends Clazz{
	private Integer page;
	private Integer rows;
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
}
