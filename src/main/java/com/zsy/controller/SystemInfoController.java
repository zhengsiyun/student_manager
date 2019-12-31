package com.zsy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsy.domain.SystemInfo;
import com.zsy.service.SystemInfoService;
import com.zsy.utils.ResultObj;

@RestController
@RequestMapping("systeminfo")
public class SystemInfoController {
	
	@Autowired
	private SystemInfoService systemInfoService;
	
	@RequestMapping("updateSystemInfo")
	public String updateSystemInfo(String name,String value,SystemInfo systemInfo) {
		try {
			if (name.equals("schoolName")) {
				systemInfo.setSchoolName(value);
			}else if (name.equals("forbidTeacher")) {
				systemInfo.setForbidTeacher(Integer.parseInt(value));
			}else if (name.equals("forbidStudent")) {
				systemInfo.setForbidStudent(Integer.parseInt(value));
			}else if (name.equals("noticeTeacher")) {
				systemInfo.setNoticeTeacher(value);
			}else if (name.equals("noticeStudent")) {
				systemInfo.setNoticeStudent(value);
			}
			systemInfoService.updateSystemInfo(systemInfo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}
}
