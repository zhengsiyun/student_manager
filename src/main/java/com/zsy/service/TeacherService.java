package com.zsy.service;

import com.zsy.domain.Teacher;
import com.zsy.utils.DataGridView;
import com.zsy.vo.TeacherVo;

public interface TeacherService {

	DataGridView queryAllTeacher(TeacherVo teacherVo);

	void addTeacher(TeacherVo teacherVo);

	void updateTeacher(TeacherVo teacherVo);

	void deleteTeacher(Integer id, String number);

	Teacher queryTeacherByNumber(String account);

	void updateTeacherPerson(TeacherVo teacherVo);

}
