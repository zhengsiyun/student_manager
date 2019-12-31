package com.zsy.mapper;

import java.util.List;

import com.zsy.domain.Exam;
import com.zsy.vo.ExamVo;

public interface ExamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Exam record);

    int insertSelective(Exam record);

    Exam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);
    
    //查询全部考试
	List<Exam> queryAllExam(Exam exam);

	void deleteByGradeId(Integer id);

}