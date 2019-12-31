package com.zsy.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zsy.domain.Student;
import com.zsy.domain.SystemInfo;
import com.zsy.domain.User;
import com.zsy.mapper.StudentMapper;
import com.zsy.mapper.SystemInfoMapper;
import com.zsy.service.StudentService;
import com.zsy.service.SystemInfoService;
import com.zsy.service.impl.SystemInfoServiceImpl;
import com.zsy.utils.WebUtils;

@WebListener
public class AppListener implements ServletContextListener{
	private static SystemInfoService systemInfoService;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//取到ServletContext
		ServletContext context=arg0.getServletContext();
		//获取项目名
		context.setAttribute("ctx", context.getContextPath());
		System.out.println(context.getContextPath());
		
		//获取系统信息用于回显admin的个人信息
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
		systemInfoService = applicationContext.getBean(SystemInfoService.class);
		SystemInfo sys = systemInfoService.queryAllSystemInfo();
		context.setAttribute("systemInfo", sys);
		System.err.println("---------Servlet容器创建成功 ctx被放到ServletContext作用域-------");
		
	}

}
