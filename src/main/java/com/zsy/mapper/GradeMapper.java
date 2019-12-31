package com.zsy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsy.domain.Grade;
import com.zsy.vo.GradeVo;

public interface GradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
    
    //根据id获取年级信息
	Grade queryGradeById(@Param("id")Integer id);
	
	//查询全部年级
	List<Grade> queryAllGrade();

	Grade queryGradeByName(String name);


}