package com.biz.rent.config;

import javax.lang.model.util.AbstractAnnotationValueVisitor6;
import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * Web.xml의 할일을 대신할 클래스
 * Web.xml에 세팅할 부분을 설정하고 서버가 시작될때
 * 자동으로 실행하도록 지정한다.
 */
public class AppInitConfig 
		extends AbstractAnnotationConfigDispatcherServletInitializer {

	/*
	 * 한글 encoding 처리
	 */
	@Override
	protected Filter[] getServletFilters() {

		CharacterEncodingFilter encKor
		= new CharacterEncodingFilter();

		encKor.setEncoding("UTF-8");
		encKor.setForceEncoding(true);
		
		return new Filter[] { encKor } ;
		
	}

	/*
	 * root-context.xml을 대신할 method
	 * 실질적으로 context-param tag 설정을 대신할 method
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { RootConfig.class };
	}

	/*
	 * servlet 설정을 대신할 부분
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { 
				AppServletConfig.class,
				MybatisConfig.class
				};
	}

	
	/*
	 * web.xml의 appServlet의  servlet-mapping을 대신
	 */
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
