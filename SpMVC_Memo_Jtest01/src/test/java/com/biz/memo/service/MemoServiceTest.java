package com.biz.memo.service;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= 
	{"/WEB-INF/spring/testServlet/*-context.xml"})
public class MemoServiceTest {

	@Mock
	MemoService mService;
	
	// @Autowired
	// private WebApplicationContext wx;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setUp() {
		
		mockMvc = MockMvcBuilders
				.standaloneSetup(mService)
				.build();
	}
	
	@Test
	public void test() {

		// ServletContext context = wx.getServletContext();
		
		mService.add();
		mService.getName();
		
		// 여러 메서드들이 Chainning 형식으로
		// 연속되어서 호출되는 경우
		// 잘 호출되서 실행되는지 검증하는 절차
		verify(mService).add();
		verify(mService).getName();
		
	}

}
