package com.zsy.mapper;

import java.util.ArrayList;
import java.util.List;

import com.zsy.domain.Escore;

public interface EscoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Escore record);

    int insertSelective(Escore record);

    Escore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Escore record);

    int updateByPrimaryKey(Escore record);

	void deleteByStudentId(Integer id);

	void deleteByGradeId(Integer id);
}