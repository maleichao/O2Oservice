package com.tykj.util.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


public class BaseController {
	protected static Map<Object,Object> systemConfig = new HashMap<Object,Object>();
	protected ServletContext servletContext;//servlet 上下文

	static{
		String filePath = "systemConfig.properties";
		Properties ps = new Properties();
		try {
			InputStream	in = BaseController.class.getClassLoader().getResourceAsStream(filePath);
			ps.load(in);
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		systemConfig = ps; 
    }
	public  Map<String, Object> getFormMap(HttpServletRequest request) {
		Map<String, Object> hm = new HashMap<String, Object>();
		Enumeration<String> em = request.getParameterNames();
		while (em.hasMoreElements()) {
			String name = em.nextElement();
			Object value =request.getParameter(name);
			hm.put(name, value);
		}
		return hm;
		}
	public void setServletContext(ServletContext arg0) {
		this.servletContext = servletContext;
		servletContext.setAttribute("systemConfig", systemConfig);
	}
}
