package com.zsy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zsy.domain.Course;
import com.zsy.domain.CourseItem;
import com.zsy.domain.Escore;
import com.zsy.domain.GC;
import com.zsy.domain.Grade;
import com.zsy.domain.Student;
import com.zsy.mapper.ClazzMapper;
import com.zsy.mapper.CourseItemMapper;
import com.zsy.mapper.CourseMapper;
import com.zsy.mapper.EscoreMapper;
import com.zsy.mapper.ExamMapper;
import com.zsy.mapper.GCMapper;
import com.zsy.mapper.GradeMapper;
import com.zsy.mapper.StudentMapper;
import com.zsy.mapper.UserMapper;
import com.zsy.service.GradeService;
import com.zsy.utils.DataGridView;
import com.zsy.vo.CourseVo;
import com.zsy.vo.GradeVo;

@Service
public class GradeServiceImpl  implements GradeService{
	
	@Autowired
	private GradeMapper gradeMapper;
	@Autowired
	private GCMapper gcMapper;
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private ClazzMapper clazzMapper;
	@Autowired
	private CourseItemMapper courseItemMapper;
	@Autowired
	private EscoreMapper escoreMapper;
	@Autowired
	private ExamMapper examMapper;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public DataGridView queryAllGrade(GradeVo gradeVo) {
		Page<Object> page = PageHelper.startPage(gradeVo.getPage(),gradeVo.getRows());
		List<Grade> grades = gradeMapper.queryAllGrade();
		for (int i = 0; i < grades.size(); i++) {
			Grade grade = grades.get(i);
			System.out.println(grade);
			List<GC> courseids = gcMapper.queryCourseIdByGradeId(grade.getId());
			for (int j = 0; j < courseids.size(); j++) {
				Course course = courseMapper.queryCourseById(courseids.get(j).getCourseid());
				System.out.println(course);
				grade.getCourseList().add(course);
				
			}
			
		}
		return new DataGridView(page.getTotal(), grades);
	}

	

	@Override
	public Grade queryGradeById(Integer id) {
		
		return gradeMapper.queryGradeById(id);
	}

	@Override
	public List<Grade> queryAllGradeNotPage() {
		List<Grade> grades = gradeMapper.queryAllGrade();
		
		return grades;
	}



	@Override
	public void addGrade(GradeVo gradeVo, GC gc) {
		gradeMapper.insertSelective(gradeVo);
		Grade grade = gradeMapper.queryGradeByName(gradeVo.getName());
		Integer id = grade.getId();
		gc.setGradeid(id);
		gc.setCourseid(gc.getCourseid());
		gcMapper.insertSelective(gc);
	}



	@Override
	public void deleteGrade(Integer id) {
		escoreMapper.deleteByGradeId(id);
		examMapper.deleteByGradeId(id);
		courseItemMapper.deleteByGradeId(id);
		List<String> list = studentMapper.selectByGradeId(id);
		for (int i = 0; i < list.size(); i++) {
			String number = list.get(i);
			userMapper.deleteByAccount(number);
		}
		studentMapper.deleteByGradeId(id);
		clazzMapper.deleteByGradeId(id);
		
		gradeMapper.deleteByPrimaryKey(id);
		
	}

	

}
