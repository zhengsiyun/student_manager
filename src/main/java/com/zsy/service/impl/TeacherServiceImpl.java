package com.zsy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zsy.domain.Clazz;
import com.zsy.domain.Course;
import com.zsy.domain.CourseItem;
import com.zsy.domain.Grade;
import com.zsy.domain.Teacher;
import com.zsy.domain.User;
import com.zsy.mapper.ClazzMapper;
import com.zsy.mapper.CourseItemMapper;
import com.zsy.mapper.CourseMapper;
import com.zsy.mapper.GradeMapper;
import com.zsy.mapper.TeacherMapper;
import com.zsy.mapper.UserMapper;
import com.zsy.service.TeacherService;
import com.zsy.utils.DataGridView;
import com.zsy.vo.TeacherVo;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private GradeMapper gradeMapper;
	@Autowired
	private ClazzMapper clazzMapper;
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private CourseItemMapper courseItemMapper;
	@Autowired
	private UserMapper userMapper;

	@Override
	public DataGridView queryAllTeacher(TeacherVo teacherVo) {
		Page<Object> page = PageHelper.startPage(teacherVo.getPage(), teacherVo.getRows());
		List<Teacher> teachers = teacherMapper.queryAllTeacher();
		for (int i = 0; i < teachers.size(); i++) {
			Teacher teacher = teachers.get(i);
			Integer id = teacher.getId();
			CourseItem courseItem = null;
			List<CourseItem> courseLists = courseItemMapper.queryAllByTeacherId(id);
			if (!courseLists.isEmpty()) {
				for (int j = 0; j < courseLists.size(); j++) {
					courseItem = courseLists.get(j);
					Integer gradeid = courseItem.getGradeid();
					Grade grade = gradeMapper.queryGradeById(gradeid);
					Integer clazzid = courseItem.getClazzid();
					Clazz clazz = clazzMapper.queryClazzById(clazzid);
					Integer courseid = courseItem.getCourseid();
					Course course = courseMapper.queryCourseById(courseid);
					courseItem.setClazz(clazz);
					courseItem.setGrade(grade);
					courseItem.setCourse(course);
					teacher.getCourseList().add(courseItem);
				}
			}
		}
		return new DataGridView(page.getTotal(), teachers);
	}

	@Override
	public void addTeacher(TeacherVo teacherVo) {
		// 添加教师信息
		teacherMapper.insertSelective(teacherVo);
		// 封装课程信息
		CourseItem courseItem = new CourseItem();
		String[] courses = teacherVo.getCourse();
		int gradeid = Integer.parseInt(courses[0]);
		courseItem.setGradeid(gradeid);
		int clazzid = Integer.parseInt(courses[1]);
		courseItem.setClazzid(clazzid);
		int courseid = Integer.parseInt(courses[2]);
		courseItem.setCourseid(courseid);
		Integer id = teacherMapper.queryIdByNumber(teacherVo.getNumber());
		courseItem.setTeacherid(id);
		// 添加课程信息
		courseItemMapper.insertSelective(courseItem);

		// 封装用户信息,添加用户
		User user = new User();
		user.setAccount(teacherVo.getNumber());
		user.setName(teacherVo.getName());
		user.setType(User.USER_TEACHER);
		userMapper.insertSelective(user);
	}

	@Override
	public void updateTeacher(TeacherVo teacherVo) {
		//修改教师的信息
		teacherMapper.updateByPrimaryKeySelective(teacherVo);
		//根据教师id修改教师之前所选的课程
		courseItemMapper.deleteByTeacherId(teacherVo.getId());
		//添加教师选的课程
		CourseItem courseItem = new CourseItem();
		String[] courses = teacherVo.getCourse();
		int gradeid = Integer.parseInt(courses[0]);
		courseItem.setGradeid(gradeid);
		int clazzid = Integer.parseInt(courses[1]);
		courseItem.setClazzid(clazzid);
		int courseid = Integer.parseInt(courses[2]);
		courseItem.setCourseid(courseid);
		courseItem.setTeacherid(teacherVo.getId());
		courseItemMapper.insertSelective(courseItem);
		//修改教师登陆的姓名
		userMapper.updateNameByAccount(teacherVo);
		
		
	}
	
	@Override
	public void deleteTeacher(Integer id, String number) {
		courseItemMapper.deleteByTeacherId(id);
		teacherMapper.deleteByPrimaryKey(id);
		userMapper.deleteByAccount(number);
		
	}

	@Override
	public Teacher queryTeacherByNumber(String account) {
		return teacherMapper.queryTeacherByNumber(account);
	}

	@Override
	public void updateTeacherPerson(TeacherVo teacherVo) {
		teacherMapper.updateByPrimaryKeySelective(teacherVo);
		
	}
}
