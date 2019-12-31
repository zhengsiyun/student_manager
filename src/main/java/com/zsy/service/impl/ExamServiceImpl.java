package com.zsy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zsy.domain.Clazz;
import com.zsy.domain.Course;
import com.zsy.domain.Exam;
import com.zsy.domain.Grade;
import com.zsy.mapper.ClazzMapper;
import com.zsy.mapper.CourseMapper;
import com.zsy.mapper.ExamMapper;
import com.zsy.mapper.GradeMapper;
import com.zsy.service.ExamService;
import com.zsy.utils.DataGridView;
import com.zsy.vo.ExamVo;

@Service
public class ExamServiceImpl implements ExamService{
	
	@Autowired
	private ExamMapper examMapper;
	@Autowired
	private GradeMapper gradeMapper;
	@Autowired
	private ClazzMapper clazzMapper;
	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public DataGridView loadAllExam(ExamVo examVo) {
		Page<Object> page = PageHelper.startPage(examVo.getPage(),examVo.getRows());
		System.out.println(page);
		List<Exam> exams1 = examMapper.queryAllExam(examVo);
		System.out.println(exams1);
		Exam exam = null;
		ArrayList<Exam> exams = new ArrayList<>();
		for (int i = 0; i < exams1.size(); i++) {
			exam = exams1.get(i);
			System.out.println(exam);
			Grade grade = gradeMapper.queryGradeById(exam.getGradeid());
			Clazz clazz = clazzMapper.queryClazzById(exam.getClazzid());
			Course course = courseMapper.queryCourseById(exam.getCourseid());
			exam.setGrade(grade);
			exam.setClazz(clazz);
			exam.setCourse(course);
			exams.add(exam);
		}
		return new DataGridView(page.getTotal(), exams);
	}

	@Override
	public void addExam(ExamVo examVo) {
		examMapper.insertSelective(examVo);
		
	}

	@Override
	public void deleteExam(Integer id) {
		examMapper.deleteByPrimaryKey(id);
		
	}

}
