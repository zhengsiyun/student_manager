package com.zsy.domain;

import java.util.ArrayList;
import java.util.List;

public class Grade {
    private Integer id;

    private String name;

    //private List<Clazz> clazzList = new ArrayList<Clazz>(); //年级下的班级列表
    
    private List<Course> courseList = new ArrayList<>(); //年级下的课程列表
    
    private List<GC> gc = new ArrayList<>(); //年级下的课程列表
    
    //private List<Student> studentList = new ArrayList<>(); //年级下的学生列表
    
    
    public List<Course> getCourseList() {
		return courseList;
	}

	
	public List<GC> getGc() {
		return gc;
	}


	public void setGc(List<GC> gc) {
		this.gc = gc;
	}


	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	/*public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<Clazz> getClazzList() {
		return clazzList;
	}

	public void setClazzList(List<Clazz> clazzList) {
		this.clazzList = clazzList;
	}*/

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

	@Override
	public String toString() {
		return "Grade [id=" + id + ", name=" + name + ", courseList=" + courseList + "]";
	}
    
}