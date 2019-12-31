package com.zsy.controller;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zsy.domain.Teacher;
import com.zsy.service.TeacherService;
import com.zsy.utils.BeanMapUtils;
import com.zsy.utils.DataGridView;
import com.zsy.utils.JsonUtil;
import com.zsy.utils.ResultObj;
import com.zsy.vo.TeacherVo;

@RestController
@RequestMapping("teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	/**
	 * 查询全部教师
	 * 
	 * @param teacherVo
	 * @return
	 */
	@RequestMapping("queryAllTeacher")
	public DataGridView queryAllTeacher(TeacherVo teacherVo) {
		return teacherService.queryAllTeacher(teacherVo);
	}

	@RequestMapping("addTeacher")
	public String addTeacher(@RequestParam Map<String, Object> map) {/* @RequestParam Map<String, Object> map */
		try {
			/*
			 * JsonUtil<TeacherVo> jsonUtil = new JsonUtil<>(); List<TeacherVo> mapToList =
			 * jsonUtil.mapToList(map, TeacherVo.class, "course");
			 */
			TeacherVo teacherVo = BeanMapUtils.mapToBean(map, TeacherVo.class);
			Entry<String, Object> tail = this.getTail(map);
			String value = (String) tail.getValue();
			String[] course = value.split(",");
			teacherVo.setCourse(course);
			teacherService.addTeacher(teacherVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}

	@RequestMapping("updateTeacher")
	public String updateTeacher(@RequestParam Map<String, Object> map) {
		try {
			//由于map集合工具类转实体类只能转string类型
			//所以先遍历map集合,把第一个元素添加到teacherVo里面,并删除第一个元素
			TeacherVo teacherVo2 = new TeacherVo();
			// 删除元素
			Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, Object> entry = it.next();
				String key = entry.getKey();
				System.out.println(key);
				String value = (String) entry.getValue();
				System.out.println(value);
				if (key.equals("id")) {
					int k = Integer.parseInt(value);
					//封装教师的id并删除map的第一个元素
					teacherVo2.setId(k);
					it.remove();
				}
			}
			TeacherVo teacherVo = BeanMapUtils.mapToBean(map, TeacherVo.class);
			//将teachervo2的id封装到teacherVo里面  传给service
			teacherVo.setId(teacherVo2.getId());
			Entry<String, Object> tail = this.getTail(map);
			String value = (String) tail.getValue().toString();
			String[] course = value.split("_");
			teacherVo.setCourse(course);
			teacherService.updateTeacher(teacherVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}

	@RequestMapping("deleteTeacher")
	public String deleteTeacher(Integer id,String number) {
		try {
			teacherService.deleteTeacher(id,number);
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
	
	@RequestMapping("updateTeacherPerson")
	public String updateTeacherPerson(TeacherVo teacherVo) {
		try {
			teacherService.updateTeacherPerson(teacherVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}
	
	
	
	public <K, V> Entry<String, Object> getTail(Map<String, Object> map) {
		Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
		Entry<String, Object> tail = null;
		while (iterator.hasNext()) {
			tail = iterator.next();
		}
		return tail;
	}

}
