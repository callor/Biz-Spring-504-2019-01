package com.biz.memo.controller;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= 
	{"/WEB-INF/spring/testServlet/*-context.xml"})
public class HomeControllerTest {

	@Autowired
	private HomeController hController;
	
	private MockMvc mockMvc;
	
	/*
	 * TestCase에서 생성자 역할을 하는 method
	 */
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders
					.standaloneSetup(hController)
					.build();
	}

	@Test
	public void testHome() throws Exception {
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andDo(print());
	
	}

}
