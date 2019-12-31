package com.zsy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsy.domain.SystemInfo;
import com.zsy.mapper.SystemInfoMapper;
import com.zsy.service.SystemInfoService;
@Service
public class SystemInfoServiceImpl implements SystemInfoService{
	@Autowired
	private SystemInfoMapper systemInfoMapper;
	
	@Override
	public SystemInfo queryAllSystemInfo() {
		
		return systemInfoMapper.queryAllSystemInfo();
	}
	
	@Override
	public void updateSystemInfo(SystemInfo systemInfo) {
		systemInfoMapper.updateByPrimaryKeySelective(systemInfo);
		
	}
}
