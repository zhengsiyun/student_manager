package com.zsy.service;

import java.util.List;

import com.zsy.domain.GC;
import com.zsy.domain.Grade;
import com.zsy.utils.DataGridView;
import com.zsy.vo.ClazzVo;
import com.zsy.vo.CourseVo;
import com.zsy.vo.GradeVo;

public interface GradeService {

	DataGridView queryAllGrade(GradeVo gradeVo);

	List<Grade> queryAllGradeNotPage();

	Grade queryGradeById(Integer id);

	void addGrade(GradeVo gradeVo, GC gc);

	void deleteGrade(Integer id);




}
