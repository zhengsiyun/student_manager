package com.zsy.mapper;

import com.zsy.domain.Teacher;
import com.zsy.domain.User;
import com.zsy.vo.TeacherVo;
import com.zsy.vo.UserVo;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //登陆
	User login(User userVo);

	void deleteByAccount(String number);

	void updateNameByAccount(Teacher teacher);
	
}