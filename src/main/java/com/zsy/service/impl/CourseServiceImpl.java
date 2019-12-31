package com.zsy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zsy.domain.Course;
import com.zsy.domain.GC;
import com.zsy.mapper.CourseMapper;
import com.zsy.mapper.GCMapper;
import com.zsy.service.CourseService;
import com.zsy.utils.DataGridView;
import com.zsy.vo.CourseVo;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseMapper courseMapper;
	
	@Autowired
	private GCMapper gcMapper;

	@Override
	public DataGridView queryAllCourse(CourseVo courseVo) {
		Page<Object> page = PageHelper.startPage(courseVo.getPage(),courseVo.getRows());
		List<Course> courses = courseMapper.queryAllCourse();
		return new DataGridView(page.getTotal(), courses);
	}

	@Override
	public List<Course> queryAllCourseNotPage(Integer gradeid) {
		List<GC> gcs = gcMapper.queryCourseIdByGradeId(gradeid);
		List<Course> courses = new ArrayList<Course>();
		for (int i = 0; i < gcs.size(); i++) {
			GC gc = gcs.get(i);
			Course course = courseMapper.selectByPrimaryKey(gc.getCourseid());
			courses.add(course);
		}
		return courses;
	}

	@Override
	public List<Course> queryAllCourses() {
		
		return courseMapper.queryAllCourse();
	}

	@Override
	public void addCourse(CourseVo courseVo) {
		courseMapper.insertSelective(courseVo);
		
	}

	@Override
	public void deleteCourse(Integer id) {
		courseMapper.deleteByPrimaryKey(id);
		
	}

	
}
