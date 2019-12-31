package com.zsy.domain;

public class Clazz {
    private Integer id;

    private String name;

    private Integer gradeid;
    
    private Grade grade;
    
    
    public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
}