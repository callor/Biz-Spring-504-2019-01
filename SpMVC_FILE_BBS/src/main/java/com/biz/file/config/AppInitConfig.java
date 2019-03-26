package com.biz.file.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * WebConfigInit(web.xml을 대신하는 파일)
 */
public class AppInitConfig 
			extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Filter[] getServletFilters() {
		
		CharacterEncodingFilter filter
		= new CharacterEncodingFilter();
		
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return new Filter[] { filter } ;
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{ 
				AppServletConfig.class,
				MybatisConfig.class 
		};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}

}
