package com.zsy.utils;

public class ResultObj {
	
	private String msg;

	//添加成功
	public static final String ADD_SUCCESS = "success";
	
	//添加失败
	public static final String ADD_ERROR = "error";
	
	//修改成功
	public static final String UPDATE_SUCCESS = "success";
	
	//修改失败
	public static final String UPDATE_ERROR = "error";
	
	//删除成功
	public static final String DELETE_SUCCESS = "success";
	
	//删除失败
	public static final String DELETE_ERROR = "error";
	
	//重置成功
	public static final String RESET_SUCCESS = "success";
	
	//重置失败
	public static final String RESER_ERROR = "error";
	public ResultObj(String msg) {
		super();
		this.msg = msg;
	}

	public ResultObj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	
	
}
