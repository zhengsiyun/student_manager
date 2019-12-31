package com.zsy.domain;

public class GC {
    private Integer id;

    private Integer gradeid;

    private Integer courseid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

	@Override
	public String toString() {
		return "GC [id=" + id + ", gradeid=" + gradeid + ", courseid=" + courseid + "]";
	}
    
}