package com.biz.rent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc 
@ComponentScan(basePackages = {"com.biz.rent.controller"})
public class AppServletConfig implements WebMvcConfigurer {

	
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**") // resources mapping
			.addResourceLocations("/resources/"); // resources location

		registry.addResourceHandler("/css/**") // resources mapping
		.addResourceLocations("/css/"); // resources location

		
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

	@Bean
	public InternalResourceViewResolver resolver() {
		
		InternalResourceViewResolver resolver 
		= new InternalResourceViewResolver();
		
		// jsp 파일에서 jstl, el 문법을 사용할수 있도록 세팅
		resolver.setViewClass(JstlView.class);
		
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	
}
