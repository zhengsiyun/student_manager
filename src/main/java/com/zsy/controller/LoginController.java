package com.zsy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zsy.domain.Clazz;
import com.zsy.domain.Course;
import com.zsy.domain.CourseItem;
import com.zsy.domain.Grade;
import com.zsy.domain.Student;
import com.zsy.domain.Teacher;
import com.zsy.domain.User;
import com.zsy.mapper.ClazzMapper;
import com.zsy.mapper.CourseItemMapper;
import com.zsy.mapper.CourseMapper;
import com.zsy.mapper.GradeMapper;
import com.zsy.mapper.StudentMapper;
import com.zsy.service.LoginService;
import com.zsy.service.StudentService;
import com.zsy.service.TeacherService;
import com.zsy.utils.WebUtils;
import com.zsy.vo.UserVo;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private GradeMapper gradeMapper;
	@Autowired
	private ClazzMapper clazzMapper;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private CourseItemMapper courseItemMapper;
	@Autowired
	private CourseMapper courseMapper;
	
	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping("login")
	@ResponseBody
	public String login(UserVo userVo) {
		//返回前端的信息
		String msg = "";
		User user = loginService.login(userVo);
		if (null == user) {
			msg = "loginError";
			return msg;
		}else if(user.getType()!=userVo.getType()) {
			msg = "typeError";
			return msg;
		}else if (user.getType()==1) {
			msg = "admin";
			WebUtils.getHttpSession().setAttribute("user", user);
		}else if(user.getType()==2){
			msg = "student";
			WebUtils.getHttpSession().setAttribute("user", user);
		}else if(user.getType()==3){
			msg = "teacher";
			WebUtils.getHttpSession().setAttribute("user", user);
		}
		
		//如果是学生登陆 把学生的信息封装到session中
		if (user.getType()==user.USER_STUDENT) {
			Student student = studentService.queryStudentByNumber(user.getAccount());
			Clazz clazz = clazzMapper.queryClazzById(student.getClazzid());
			Grade grade = gradeMapper.queryGradeById(student.getGradeid());
			student.setClazz(clazz);
			student.setGrade(grade);
			WebUtils.getHttpSession().setAttribute("student", student);
		}else if(user.getType()==user.USER_TEACHER) {
			//如果是教师登陆,把教师的信息封装到教师表中
			Teacher teacher = teacherService.queryTeacherByNumber(user.getAccount());
			CourseItem courseItem = null;
			List<CourseItem> courseLists = courseItemMapper.queryAllByTeacherId(teacher.getId());
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
			WebUtils.getHttpSession().setAttribute("teacher", teacher);
		}
		
		return msg;
	}
	
	
}
