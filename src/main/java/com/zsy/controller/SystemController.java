package com.zsy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sys")
public class SystemController {

	// 跳转到管理员界面
	@RequestMapping("/toAdminView")
	public String toAdminView() {
		return "admin/admin";
	}

	// 跳转到学生界面
	@RequestMapping("/toStudentView")
	public String toStudentView() {
		return "student/student";
	}

	// 跳转到老师界面
	@RequestMapping("toTeacherView")
	public String toTeacherView() {
		return "teacher/teacher";
	}

	// 跳转到考试列表
	@RequestMapping("toExamListView")
	public String toExamListView() {
		return "other/examList";
	}

	// 跳转到学生列表
	@RequestMapping("toStudentListView")
	public String toStudentListView() {
		return "student/studentList";
	}

	// 跳转到教师列表
	@RequestMapping("toTeacherListView")
	public String toTeacherListView() {
		return "teacher/teacherList";
	}

	// 跳转到年级列表
	@RequestMapping("toGradeListView")
	public String toGradeListView() {
		return "other/gradeList";
	}

	// 跳转到班级列表
	@RequestMapping("toClazzListView")
	public String toClazzListView() {
		return "other/clazzList";
	}

	// 跳转到课程列表
	@RequestMapping("toCourseListView")
	public String toCourseListView() {
		return "other/courseList";
	}

	// 跳转到课程列表
	@RequestMapping("toAdminPersonalView")
	public String toAdminPersonalView() {
		return "admin/adminPersonal";
	}

	// 跳转到登陆列表
	@RequestMapping("logOut")
	public String logOut() {
		return "login";
	}

	// 跳转到学生成绩列表
	@RequestMapping("toStudentExamList")
	public String toStudentExamList() {
		return "student/examStudentList";
	}

	// 跳转到学生班级信息列表
	@RequestMapping("toStudentNoteListView")
	public String toStudentNoteListView() {
		return "student/studentNoteList";
	}

	// 跳转到学生个人信息列表
	@RequestMapping("toStudentPersonalView")
	public String toStudentPersonalView() {
		return "student/studentPersonal";
	}

	// 跳转到学生班级信息列表
	@RequestMapping("toExamTeacherView")
	public String toExamTeacherView() {
		return "teacher/examTeacherList";
	}

	// 跳转到学生成绩列表
	@RequestMapping("toTeacherNoteListView")
	public String toTeacherNoteListView() {
		return "teacher/teacherNoteList";
	}

	// 跳转到学生成绩列表
	@RequestMapping("toTeacherPersonalView")
	public String toTeacherPersonalView() {
		return "teacher/teacherPersonal";
	}
}
