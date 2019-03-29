package com.biz.file.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/*
 * java Mail 보내기 NoXML 버전
 */
@Configuration
public class JavaMailConfig {

	@Bean
	public static JavaMailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		String host = "smtp.naver.com";
		final String username = "NAVER ID";
		final String password = "NAVER PASS";
		int port = 465;
		
		mailSender.setHost(host);
		mailSender.setUsername(username);
		mailSender.setPassword(password);
		mailSender.setPort(465);
		mailSender.setDefaultEncoding("UTF-8");
		mailSender.setProtocol("smtp");
		
		// Key 정보 설정
		Properties props = System.getProperties(); 

		// SMTP 서버 정보 설정
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);
		
		mailSender.setJavaMailProperties(props);
		
		return mailSender;
	}

}
