package com.zsy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsy.domain.Clazz;
import com.zsy.vo.ClazzVo;

public interface ClazzMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Clazz record);

    int insertSelective(Clazz record);

    Clazz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clazz record);

    int updateByPrimaryKey(Clazz record);
    
    //根据id获取班级信息
	Clazz queryClazzById(@Param("id")Integer id);
	
	//查询全部班级
	List<Clazz> queryAllClazz(ClazzVo clazzVo);
	
	//根据年级id查询年级下的班级
	List<Clazz> queryAllClazzById(Integer gradeid);
	
	//查询年级下的班级
	List<Clazz> queryAllClazzList();
	
	//通过年级id删除班级信息
	void deleteByGradeId(Integer id);
}