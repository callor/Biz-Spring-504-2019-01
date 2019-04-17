package com.biz.memo.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

/**
 * 단위테스트
 * 자바(스프링)에서 단위테스트는 클래스에 포함된
 * 각 메서드들을 테스트하는 단위이다
 * 
 * 보통은 1개의 클래스에서 단위테스트를 수행하며
 * 각 test*() 메서드들을 testCase라고 부른다. 
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = 
	{"/WEB-INF/spring/testServlet/*-context.xml"})
public class HomeControllerTest {
	
	@Autowired
	HomeController hController;

	// web브라우저를 대신해서 Controller를 테스트해줄
	// mock(모조품)객체
	private MockMvc mockMvc;

	// test Controller의 일종의 생성자 역할을 하는 곳
	// mockMVC에게 HomeController를 테스트 맡기기 위해
	// 초기 Building을 실행
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

	@Test
	public void testWrite() throws Exception{
		mockMvc.perform(get("/write"))
			.andExpect(status().isOk())
			.andDo(print());
	}
	
	@Test
	public void testThisGet() throws Exception {
		mockMvc.perform(get("/this"))
			.andExpect(status().isOk())
			.andDo(print());
	}

	@Test
	public void testThisPost() throws Exception {
		mockMvc.perform(post("/this"))
			.andExpect(status().isOk())
			.andDo(print());
	}


}
