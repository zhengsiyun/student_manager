package com.zsy.domain;

/**
 * 系统用户类
 * @author zsy
 *
 */
public class User {
	
	/**
	 * 管理员类型用户
	 */
	public static final int USER_ADMIN = 1;
	/**
	 * 学生类型用户
	 */
	public static final int USER_STUDENT = 2;
	/**
	 * 老师类型用户
	 */
	public static final int USER_TEACHER = 3;
	
    private Integer id;//id

    private String account;//用户名

    private String password="111111";//密码

    private String name;//用户姓名

    private int type=USER_STUDENT;//用户类型

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

    
}