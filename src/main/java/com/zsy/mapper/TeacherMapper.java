package com.zsy.mapper;

import java.util.List;

import com.zsy.domain.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKeyWithBLOBs(Teacher record);

    int updateByPrimaryKey(Teacher record);
    
    //查询全部教师
	List<Teacher> queryAllTeacher();

	Integer queryIdByNumber(String number);

	Teacher queryTeacherByNumber(String account);
}