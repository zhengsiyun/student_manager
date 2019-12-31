package com.zsy.service;

import java.util.List;

import com.zsy.domain.Course;
import com.zsy.utils.DataGridView;
import com.zsy.vo.CourseVo;

public interface CourseService {

	DataGridView queryAllCourse(CourseVo courseVo);

	List<Course> queryAllCourseNotPage(Integer gradeid);

	List<Course> queryAllCourses();

	void addCourse(CourseVo courseVo);

	void deleteCourse(Integer id);

}
