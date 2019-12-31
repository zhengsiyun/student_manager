package com.zsy.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 考试类
 * @author zsy
 *
 */

public class Exam {
	
	public static final int  EXAM_GRADE_TYPE=1;  //年级统考
	
	public static final int EXAM_NORMAL_TYPE=2;  //平时考试
	

	private Integer id;

    private String name;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date time;

    private String remark;


    private Grade grade; //考试年级
    
    private Integer gradeid; //年级id
    
    private Clazz clazz; //考试班级
    
    private Integer clazzid; //班级id
    
    private Course course; //考试科目
    
    private Integer courseid; //考试科目id

    private Integer type = EXAM_GRADE_TYPE;

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
		this.name = name;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	

	public Integer getGradeid() {
		return gradeid;
	}

	public Integer getClazzid() {
		return clazzid;
	}

	public Integer getCourseid() {
		return courseid;
	}

	public Integer getType() {
		return type;
	}

	public void setGradeid(int gradeid) {
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

	

	public void setClazzid(int clazzid) {
		Clazz clazz = new Clazz();
		clazz.setId(clazzid);
		this.clazz = clazz;
		this.clazzid = clazzid;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	

	public void setCourseid(int courseid) {
		Course course = new Course();
		course.setId(courseid);
		this.course = course;
		this.courseid = courseid;
	}

	

	public void setType(int type) {
		this.type = type;
	}

	public void setGradeid(Integer gradeid) {
		this.gradeid = gradeid;
	}

	public void setClazzid(Integer clazzid) {
		this.clazzid = clazzid;
	}

	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", name=" + name + ", time=" + time + ", remark=" + remark + ", grade=" + grade
				+ ", gradeid=" + gradeid + ", clazz=" + clazz + ", clazzid=" + clazzid + ", course=" + course
				+ ", courseid=" + courseid + ", type=" + type + "]";
	}
	
 
}