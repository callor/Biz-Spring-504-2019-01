package com.biz.memo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/*
 * spring 3.2 이상에서만 작동되는 코드
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations="/WEB-INF/spring/appServlet/*-context.xml")
@WebAppConfiguration
public class ContextTestController {

	@Autowired
	protected WebApplicationContext context;

	// 변수에 protected 선언을 하면
	// 다른 외부에서는 직접 접근을 할수 없으나
	// 이 클래스를 상속(extends)받은 클래스에서는
	// 해당 변수에 접근해서 어떤 일을 수행할수 있다.
	protected MockMvc mvc;
	
	@Before
	public void setUp() throws Exception{
		mvc = MockMvcBuilders
				.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void test() throws Exception {
		mvc.perform(get("/"));
	}
	
}
