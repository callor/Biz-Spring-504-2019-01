package com.biz.file.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.biz.file.interceptor.LoginInterceptor;

import lombok.extern.slf4j.Slf4j;

/*
 * serlvet-context.xml의 하는일을 대신
 * WebConfig
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
		"com.biz.file.controller",
		"com.biz.file.service"
		})
@Slf4j
public class AppServletConfig implements WebMvcConfigurer{
	
	@Bean
	LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		// WebMvcConfigurer.super.addInterceptors(registry);
		log.debug("ADD INTERCEPTER");
		registry.addInterceptor(loginInterceptor())
				.addPathPatterns("/bbs/**");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addResourceHandler("/resources/**")
			.addResourceLocations("/resources/");

		registry.addResourceHandler("/files/**")
			.addResourceLocations("/files/");

		registry.addResourceHandler("/css/**")
			.addResourceLocations("/css/");
		
		WebMvcConfigurer.super.addResourceHandlers(registry);

	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean 
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver mr
		= new CommonsMultipartResolver();
		mr.setMaxUploadSize(1000000000); // 100MB
		mr.setMaxUploadSizePerFile(10000000); // 10MB 
		return mr;
	}
	
	/*
	 * @Bean Annotation
	 * 스프링의 내장된 클래스를 사용할 준비를 하라 하는 지시어
	 */
	@Bean
	public InternalResourceViewResolver resolver() {
		
		InternalResourceViewResolver resolver
		= new InternalResourceViewResolver();
		
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
		
	}
	
}





