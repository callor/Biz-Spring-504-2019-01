package com.biz.memo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

/*
 * ContextTestController를 상속받아서
 * 실행환경과 동일하게 test를 진행할수 있게 되었다.
 * 
 * 다만, 여기서는 HomeController 부분과
 * 		MemoController 부분을 모두 테스트 할수 있는 case를 만들었지만
 * 
 * 실제상황에서는 각 Controller를 테스트 할 수 있도록
 * 클래스를 분리하는 것이 좋다.
 */
public class ContextTestControllerEx 
			extends ContextTestController{

	@Test
	public void testHome() throws Exception{
		
		mvc.perform(get("/"))
			.andExpect(status().isOk())
			.andDo(print());
		
	}

	@Test
	public void testMemo() throws Exception {
		mvc.perform(get("/memo/update"))
			.andExpect(status().isOk())
			.andDo(print());
	}

}
