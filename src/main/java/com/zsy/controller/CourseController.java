package com.zsy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsy.domain.Course;
import com.zsy.service.CourseService;
import com.zsy.utils.DataGridView;
import com.zsy.utils.ResultObj;
import com.zsy.vo.CourseVo;

@RestController
@RequestMapping("course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("queryAllCourse")
	public DataGridView queryAllCourse(CourseVo courseVo) {
		return courseService.queryAllCourse(courseVo);
	}

	@RequestMapping("queryAllCourseNotPage")
	public List<Course> queryAllCourseNotPage(Integer gradeid) {
		return courseService.queryAllCourseNotPage(gradeid);
	}

	@RequestMapping("queryAllCourses")
	public List<Course> queryAllCourses() {
		return courseService.queryAllCourses();
	}

	// 添加课程
	@RequestMapping("addCourse")
	public String addCourse(CourseVo courseVo) {
		try {
			courseService.addCourse(courseVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}

	// 删除课程
	@RequestMapping("deleteCourse")
	public String deleteCourse(Integer courseid) {
		try {
			courseService.deleteCourse(courseid);
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}

}
