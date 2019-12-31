package com.zsy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsy.domain.Clazz;
import com.zsy.service.ClazzService;
import com.zsy.service.GradeService;
import com.zsy.utils.DataGridView;
import com.zsy.utils.ResultObj;
import com.zsy.vo.ClazzVo;

@RestController()
@RequestMapping("clazz")
public class ClazzController {
	
	@Autowired
	private ClazzService clazzService;
	
	/**
	 * 查询全部班级
	 * @param clazzVo
	 * @return
	 */
	@RequestMapping("queryAllClazz")
	public DataGridView queryAllClazz(ClazzVo clazzVo) {
		return clazzService.queryAllClazz(clazzVo);
	}
	
	//查询全部班级不分页
	@RequestMapping("queryAllClazzNotPage")
	public List<Clazz> queryAllClazzNotPage(Integer gradeid){
		return clazzService.queryAllClazzNotPage(gradeid);
	}
	
	//添加班级信息
	@RequestMapping("addClazz")
	public String addClazz(ClazzVo clazzVo) {
		try {
			clazzService.addClazz(clazzVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}
	
	@RequestMapping("deleteClazz")
	public String deleteClazz(Integer clazzid) {
		try {
			clazzService.deleteClazz(clazzid);
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
	
}
