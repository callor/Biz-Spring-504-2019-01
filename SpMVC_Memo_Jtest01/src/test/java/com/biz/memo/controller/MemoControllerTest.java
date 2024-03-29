package com.biz.memo.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.biz.memo.mapper.MemoVO;
import com.biz.memo.service.MemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/WEB-INF/spring/testServlet/*-context.xml"})
public class MemoControllerTest {

	@InjectMocks
	MemoController mController;
	
	@Mock
	MemoService mService;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception{
		
		// @InjectMocks와 @Mock 연동된
		// Controller와 Service 가져와서 테스트 하겠다.
		MockitoAnnotations.initMocks(this);
		
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


	@Test
	public void testAdd() throws Exception{
		
		// Controller를 test 하기
		mockMvc.perform(get("/memo/add"))
			.andExpect(status().isOk())
			.andDo(print());
		
		// Controller의 memo/add가 호출되었을때
		// Service의 add method가 잘 실행되었는지 보기
		
		verify(mService,times(5)).add();
	}
	
	@Test
	public void testGetName() throws Exception {
		
		
		MemoVO vo = new MemoVO();
		
		// vo의 getSubject() 메서드가 호출되면
		//		메모쓰기 라는 문자열을 리턴하라
		when(vo.getSubject()).thenReturn("메모쓰기");
				
		// vo의 getMemo() 메서드가 호출되면
		//		오늘의 메모 라는 문자열을 리턴하라
		when(vo.getMemo()).thenReturn("오늘의 메모");
		
		// 값을 검증하라
		assertTrue("메모쓰기".equals(vo.getSubject()));
		assertTrue("오늘의 메모".equals(vo.getMemo()));

		// 값을 저장하는(setter) 메서드가 1번씩만 실행 되었나?
		verify(vo,times(1)).setSubject("메모쓰기");
		verify(vo,times(1)).setMemo("오늘의 메모");
		
		// 메모쓰기가 1번 이상 setting 되었나
		// verify(vo,atLeastOnce()).setSubject("메모쓰기");
		
		// 임의의 문자열이 1번이상 setting 되었나
		// verify(vo,atLeastOnce())
		// 		.setSubject(any(String.class));
		
		
	}
	
}
