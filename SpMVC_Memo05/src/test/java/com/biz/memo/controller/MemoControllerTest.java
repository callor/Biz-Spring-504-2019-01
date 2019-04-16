package com.biz.memo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.biz.memo.mapper.MemoVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/WEB-INF/spring/testServlet/*-context.xml"})
public class MemoControllerTest {

	@Autowired
	MemoController mController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders
					.standaloneSetup(mController)
					.build();
	}
	
	@Test
	public void testWriteGet() throws Exception{
		mockMvc.perform(get("/memo/write"))
			.andExpect(status().isOk())
			.andDo(print());
	}

	
	/*
	 * memo/write를 request하면서
	 * id 값에 1이라는 문자열을 포함해서보내면
	 * param("id","1")
	 * memo/write의 ModelAttribute로 설정된 VO에
	 * 해당 이름(id)과 같은 맴버변수가 있으면
	 * 해당 속성값만 Controller가 수신해서
	 * 사용할 수 있다. 
	 *
	 */
	@Test
	public void testWriteParam() throws Exception{
		mockMvc.perform(get("/memo/write").param("id","1"))
			.andExpect(status().isOk())
			.andDo(print());
	}
	
	@Test
	public void testWriteView() throws Exception{
		
		MemoVO vo = new MemoVO();
		
		mockMvc.perform(get("/memo/write")
			.flashAttr("memoVO",vo)) // 객체파라미터 주입 
			.andExpect(status().isOk())
			
			// memo/write를 request 했을때
			// view로 memo_write를 return 하고 있느냐
			// 설계 spec을 검사
			.andExpect(view().name("memo_write"))

			// model에 memoVO라는 Attribute가 담겨있냐
			// 설계 spec을 검사
			.andExpect(model().attributeExists("memoVO"))
			
			// memoVO에 담겨있는 값이 MemoVO.class이냐
			// 설계 spec을 검사
			.andExpect(model().attribute("memoVO",vo)) 
			
			.andExpect(model().attributeExists("BODY"))
			.andExpect(model().attribute("BODY", "MEMO_WRITE"))
			.andDo(print());
	}


	
	
}
