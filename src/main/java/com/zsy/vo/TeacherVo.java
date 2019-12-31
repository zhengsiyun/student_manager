package com.zsy.vo;

import java.util.List;

import com.zsy.domain.CourseItem;
import com.zsy.domain.Teacher;

public class TeacherVo extends Teacher{
	



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
