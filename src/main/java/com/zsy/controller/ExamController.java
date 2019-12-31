package com.zsy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsy.service.ExamService;
import com.zsy.utils.DataGridView;
import com.zsy.utils.ResultObj;
import com.zsy.vo.ExamVo;

@RestController()
@RequestMapping("exam")
public class ExamController {

	@Autowired
	private ExamService examService;
	
	/**
	 * 查询全部考试信息
	 * @param examVo
	 * @return
	 */
	@RequestMapping("loadAllExam")
	public DataGridView loadAllExam(ExamVo examVo) {
		return examService.loadAllExam(examVo);
	}
	
	/**
	 *  添加考试
	 * @param examVo
	 * @return
	 */
	@RequestMapping("addExam")
	public String addExam(ExamVo examVo) {
		try {
			examService.addExam(examVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
				
	}
	
	/**
	 *  修改考试
	 * @param examVo
	 * @return
	 */
	@RequestMapping("deleteExam")
	public String deleteExam(Integer id) {
		try {
			examService.deleteExam(id);
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
				
	}

	

}
