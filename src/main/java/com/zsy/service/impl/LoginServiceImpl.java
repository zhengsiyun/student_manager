package com.zsy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsy.domain.User;
import com.zsy.mapper.UserMapper;
import com.zsy.service.LoginService;
import com.zsy.vo.UserVo;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(UserVo userVo) {
		return userMapper.login(userVo);
	}

}
