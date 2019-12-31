package com.zsy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsy.service.StudentService;
import com.zsy.utils.DataGridView;
import com.zsy.utils.ResultObj;
import com.zsy.vo.StudentVo;

@RestController()
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	/**
	 * 查询全部学生
	 * @param studentVo
	 * @return
	 */
	@RequestMapping("queryAllStudent")
	public DataGridView queryAllStudent(StudentVo studentVo) {
		return studentService.queryAllStudent(studentVo);
	}
	
	/**
	 * 添加学生
	 * @param studentVo
	 * @return
	 */
	@RequestMapping("addStudent")
	public String addStudent(StudentVo studentVo) {
		try {
			studentService.addStudent(studentVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
				
	}
	
	/**
	 * 修改学生
	 * @param studentVo
	 * @return
	 */
	@RequestMapping("updateStudent")
	public String updateStudent(StudentVo studentVo) {
		try {
			studentService.updateStudent(studentVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
				
	}
	
	/**
	 * 修改个人学生信息
	 * @param studentVo
	 * @return
	 */
	@RequestMapping("updateStudentPerson")
	public String updateStudentPerson(StudentVo studentVo) {
		try {
			studentService.updateStudentPerson(studentVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
				
	}
	
	/**
	 * 删除学生
	 * @param studentVo
	 * @return
	 */
	@RequestMapping("deleteStudent")
	public String deleteStudent(Integer id,String number) {
		try {
			
			studentService.deleteStudent(id,number);
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
				
	}
}
