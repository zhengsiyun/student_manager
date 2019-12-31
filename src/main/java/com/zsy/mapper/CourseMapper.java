package com.zsy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsy.domain.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    
    //根据课程id查询课程信息
	Course queryCourseById(@Param("id")Integer id);
	
	//查询全部课程
	List<Course> queryAllCourse();
}