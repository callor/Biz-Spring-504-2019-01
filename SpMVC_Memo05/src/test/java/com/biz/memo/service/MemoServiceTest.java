package com.biz.memo.service;

import static org.junit.Assert.fail;

import javax.servlet.ServletContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= 
	{"/WEB-INF/spring/testServlet/*-context.xml"})
public class MemoServiceTest {

	@Autowired
	MemoService mService;
	
	@Autowired
	private WebApplicationContext wx;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setUp() {
		
		mockMvc = MockMvcBuilders
				.standaloneSetup(mService)
				.build();
	}
	
	@Test
	public void test() {

		ServletContext context = wx.getServletContext();
		
		
	}

}
