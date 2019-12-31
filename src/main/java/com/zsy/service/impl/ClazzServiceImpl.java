package com.zsy.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zsy.domain.Clazz;
import com.zsy.domain.Grade;
import com.zsy.mapper.ClazzMapper;
import com.zsy.mapper.GradeMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsy.service.ClazzService;
import com.zsy.utils.DataGridView;
import com.zsy.vo.ClazzVo;

@Service
public class ClazzServiceImpl implements ClazzService{
	
	@Autowired
	private ClazzMapper clazzMapper;
	@Autowired
	private GradeMapper gradeMapper;

	@Override
	public DataGridView queryAllClazz(ClazzVo clazzVo) {
		Page<Object> page = PageHelper.startPage(clazzVo.getPage(),clazzVo.getRows());
		List<Clazz> clazzs = clazzMapper.queryAllClazz(clazzVo);
		for (int i = 0; i < clazzs.size(); i++) {
			Clazz clazz = clazzs.get(i);
			Integer gradeid = clazz.getGradeid();
			Grade grade = gradeMapper.queryGradeById(gradeid);
			clazz.setGrade(grade);
		}
		return new DataGridView(page.getTotal(), clazzs);
	}

	@Override
	public List<Clazz> queryAllClazzNotPage(Integer id) {
		List<Clazz> clazzs = clazzMapper.queryAllClazzById(id);
		return clazzs;
	}

	@Override
	public void addClazz(ClazzVo clazzVo) {
		clazzMapper.insertSelective(clazzVo);
		
	}

	@Override
	public void deleteClazz(Integer clazzid) {
		clazzMapper.deleteByPrimaryKey(clazzid);
		
	}

	
	
	
}
