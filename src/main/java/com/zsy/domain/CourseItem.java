package com.zsy.domain;

public class CourseItem {
	
	private Integer id;
	
	private Clazz clazz;
	
    private Integer clazzid;

    private Grade grade;
    
    private Integer gradeid;

    private Course course;
    
    private Integer courseid;

    private Teacher teacher;
    
    private Integer teacherid;

   
    
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Integer getClazzid() {
        return clazzid;
    }

    public void setClazzid(Integer clazzid) {
        this.clazzid = clazzid;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

	@Override
	public String toString() {
		return "CourseItem [clazz=" + clazz + ", clazzid=" + clazzid + ", grade=" + grade + ", gradeid=" + gradeid
				+ ", course=" + course + ", courseid=" + courseid + ", teacher=" + teacher + ", teacherid=" + teacherid
				+ "]";
	}
    
}