package com.zsy.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teacher {
	private Integer id;

	private String number;

	private String name;

	private String sex;

	private String phone;

	private String photo;

	private String qq;

	private List<CourseItem> courseList = new ArrayList<CourseItem>();

	private String[] course = new String[] {};

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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public List<CourseItem> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<CourseItem> courseList) {
		this.courseList = courseList;
	}

	public String[] getCourse() {
		return course;
	}

	public void setCourse(String[] course) {
		this.course = course;
	}

	
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", number=" + number + ", name=" + name + ", sex=" + sex + ", phone=" + phone
				+ ", photo=" + photo + ", qq=" + qq + ", courseList=" + courseList + ", course="
				+ Arrays.toString(course) + "]";
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}



	


	
}