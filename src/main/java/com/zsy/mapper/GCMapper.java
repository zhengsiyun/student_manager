package com.zsy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsy.domain.GC;

public interface GCMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GC record);

    int insertSelective(GC record);

    GC selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GC record);

    int updateByPrimaryKey(GC record);
    
    //通过年级id查询当前年级下的课程
	List<GC> queryCourseIdByGradeId(@Param("id")Integer id);
	
	//通过年级id删除gc表
	void deleteByGradeId(Integer id);
}