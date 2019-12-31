package com.zsy.mapper;

import com.zsy.domain.SystemInfo;

public interface SystemInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemInfo record);

    int insertSelective(SystemInfo record);

    SystemInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemInfo record);

    int updateByPrimaryKey(SystemInfo record);

	SystemInfo queryAllSystemInfo();
}