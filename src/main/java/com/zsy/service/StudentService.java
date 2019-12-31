package com.zsy.service;

import java.util.ArrayList;
import java.util.List;

import com.zsy.domain.Student;
import com.zsy.utils.DataGridView;
import com.zsy.vo.StudentVo;

public interface StudentService {

	DataGridView queryAllStudent(StudentVo studentVo);

	void addStudent(StudentVo studentVo);

	void updateStudent(StudentVo studentVo);

	void deleteStudent(Integer id, String number);

	Student queryStudentByNumber(String account);

	void updateStudentPerson(StudentVo studentVo);

}
