package com.zsy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsy.domain.CourseItem;

public interface CourseItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseItem record);

    int insertSelective(CourseItem record);

    CourseItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseItem record);

    int updateByPrimaryKey(CourseItem record);
    
    //根据教师id查询所有信息
	List<CourseItem> queryAllByTeacherId(@Param("id")Integer id);

	void deleteByTeacherId(Integer id);

	void deleteByGradeId(Integer id);
}