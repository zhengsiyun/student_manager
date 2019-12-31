package com.zsy.service;

import com.zsy.utils.DataGridView;
import com.zsy.vo.ExamVo;

public interface ExamService {

	DataGridView loadAllExam(ExamVo examVo);

	void addExam(ExamVo examVo);

	void deleteExam(Integer id);

}
