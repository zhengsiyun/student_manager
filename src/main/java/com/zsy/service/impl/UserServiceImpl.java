package com.zsy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsy.domain.User;
import com.zsy.mapper.UserMapper;
import com.zsy.service.UserService;
import com.zsy.vo.UserVo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	@Override
	public void updatePassword(UserVo userVo) {
		User user = userMapper.selectByPrimaryKey(userVo.getId());
		Integer type = user.getType();
		userVo.setType(type);
		userMapper.updateByPrimaryKeySelective(userVo);
		
	}

}
