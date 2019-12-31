package com.zsy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zsy.domain.Clazz;
import com.zsy.domain.Grade;
import com.zsy.domain.Student;
import com.zsy.domain.User;
import com.zsy.mapper.ClazzMapper;
import com.zsy.mapper.EscoreMapper;
import com.zsy.mapper.GradeMapper;
import com.zsy.mapper.StudentMapper;
import com.zsy.mapper.UserMapper;
import com.zsy.service.StudentService;
import com.zsy.utils.DataGridView;
import com.zsy.vo.StudentVo;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private ClazzMapper clazzMapper;
	@Autowired
	private GradeMapper gradeMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private EscoreMapper escoreMapper;
	
	@Override
	public DataGridView queryAllStudent(StudentVo studentVo) {
		Page<Object> page = PageHelper.startPage(studentVo.getPage(), studentVo.getRows());
		List<Student> students1 = studentMapper.queryAllStudent(studentVo);
		ArrayList<Student> students = new ArrayList<>();
		for (int i = 0; i < students1.size(); i++) {
			Student student = students1.get(i);
			System.out.println(student);
			Clazz clazz = clazzMapper.queryClazzById(student.getClazzid());
			Grade grade = gradeMapper.queryGradeById(student.getGradeid());
			student.setClazz(clazz);
			student.setGrade(grade);
			students.add(student);
		}
		
		return new DataGridView(page.getTotal(), students);
	}
	
	@Override
	public void addStudent(StudentVo studentVo) {
		studentMapper.insertSelective(studentVo);
		User user = new User();
		user.setAccount(studentVo.getNumber());
		user.setName(studentVo.getName());
		user.setType(User.USER_STUDENT);
		userMapper.insertSelective(user);
		
	}

	@Override
	public void updateStudent(StudentVo studentVo) {
		studentMapper.updateByPrimaryKeySelective(studentVo);
		
	}

	@Override
	public void deleteStudent(Integer  id, String   number) {
		// TODO Auto-generated method stub
		escoreMapper.deleteByStudentId(id);
		studentMapper.deleteByPrimaryKey(id);
		userMapper.deleteByAccount(number);

	}
	
	//用于回显学生信息
	@Override
	public Student queryStudentByNumber(String account) {
		
		return studentMapper.queryStudentByNumber(account);
	}

	@Override
	public void updateStudentPerson(StudentVo studentVo) {
		studentMapper.updateByPrimaryKeySelective(studentVo);
		
	}

	

}
