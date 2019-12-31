package com.zsy.service;

import com.zsy.domain.SystemInfo;

public interface SystemInfoService {

	void updateSystemInfo(SystemInfo systemInfo);

	SystemInfo queryAllSystemInfo();

}
