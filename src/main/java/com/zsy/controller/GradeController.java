package com.zsy.controller;

import java.util.List;

import org.apache.commons.math3.special.Gamma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsy.domain.GC;
import com.zsy.domain.Grade;
import com.zsy.service.GradeService;
import com.zsy.utils.DataGridView;
import com.zsy.utils.ResultObj;
import com.zsy.vo.CourseVo;
import com.zsy.vo.GradeVo;
import com.zsy.vo.StudentVo;

@RestController()
@RequestMapping("grade")
public class GradeController {
	
	@Autowired
	private GradeService gradeService;
	
	@RequestMapping("queryAllGrade")
	public DataGridView queryAllGrade(GradeVo gradeVo) {
		return gradeService.queryAllGrade(gradeVo);
	}
	
	@RequestMapping("queryAllGradeNotPage")
	public List<Grade> queryAllGradeNotPage(){
		return gradeService.queryAllGradeNotPage();
	}
	
	@RequestMapping("queryGradeById")
	public Grade queryGradeById(Integer id) {
		return gradeService.queryGradeById(id);
	}
	
	@RequestMapping("addGrade")
	public String addGrade(GradeVo gradeVo,GC gc) {
		try {
			gradeService.addGrade(gradeVo,gc);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}
	

	@RequestMapping("deleteGrade")
	public String deleteGrade(Integer id) {
		try {
			gradeService.deleteGrade(id);
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
}
