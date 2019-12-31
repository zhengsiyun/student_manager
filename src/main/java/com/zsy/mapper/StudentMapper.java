package com.zsy.mapper;

import java.util.List;

import com.zsy.domain.Student;
import com.zsy.vo.StudentVo;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student student);

    int updateByPrimaryKeyWithBLOBs(Student record);

    int updateByPrimaryKey(Student record);
    
    //查询全部学生
	List<Student> queryAllStudent(Student student);

	void deleteByGradeId(Integer id);

	List<String> selectByGradeId(Integer id);
	
	//用于回显学生信息
	Student queryStudentByNumber(String number);
}