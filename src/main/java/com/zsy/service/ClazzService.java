package com.zsy.service;

import java.util.List;

import com.zsy.domain.Clazz;
import com.zsy.utils.DataGridView;
import com.zsy.vo.ClazzVo;

public interface ClazzService {

	DataGridView queryAllClazz(ClazzVo clazzVo);

	List<Clazz> queryAllClazzNotPage(Integer id);

	void addClazz(ClazzVo clazzVo);

	void deleteClazz(Integer clazzid);


}
