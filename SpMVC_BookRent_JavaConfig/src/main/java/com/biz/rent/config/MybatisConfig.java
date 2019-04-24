package com.biz.rent.config;


import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement // <tx:annotation-driven/>
@MapperScan("com.biz.rent.mapper") // <mybatis-spring:scan base-package="com.biz.rent.mapper"/>
public class MybatisConfig {

	/*
	 * dataSource
	 * SqlSessionFactory
	 * transaction
	 * SessionTemplet
	 * 
	 */
	
	/*
	 * 1 DataSource 생성
	 */
	@Bean
	public DataSource ds() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("iolist");
		ds.setPassword("1234");
		return ds;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() {
		SqlSessionFactoryBean sf 
		= new SqlSessionFactoryBean();
		
		sf.setDataSource(ds());
		
		// model의 경로를 지정
		sf.setTypeAliasesPackage("com.biz.rent.model");
		return sf;
	}
	
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager
		ts = new DataSourceTransactionManager(ds());
		return ts;
	}
}
