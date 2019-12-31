package com.zsy.domain;

public class Student {
    private Integer id;

    private String number;

    private String name;

    private String sex;

    private String phone;

    private String qq;

    private Clazz clazz; //学生班级
    
    private Integer clazzid;

    private Grade grade; //学生年级
    
    private Integer gradeid;

    private String photo;
    
    
    
    public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public Integer getClazzid() {
        return clazzid;
    }

    public void setClazzid(Integer clazzid) {
    	Clazz clazz = new Clazz();
    	clazz.setId(clazzid);
    	this.clazz = clazz;
        this.clazzid = clazzid;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
    	Grade grade = new Grade();
    	grade.setId(gradeid);
    	this.grade = grade;
        this.gradeid = gradeid;
    }

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", number=" + number + ", name=" + name + ", sex=" + sex + ", phone=" + phone
				+ ", qq=" + qq + ", clazz=" + clazz + ", clazzid=" + clazzid + ", grade=" + grade + ", gradeid="
				+ gradeid + "]";
	}

   
}