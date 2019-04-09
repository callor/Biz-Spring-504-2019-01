package com.biz.jtest.controller;

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

// spring 프레임워크와 Junit을 연결해줄 클래스
@RunWith(SpringJUnit4ClassRunner.class)

// ...test-context.xml에 bean으로 등록된 클래스 정보를
// 가져와
@ContextConfiguration(
		locations= {"/WEB-INF/spring/testServlet/home-test-context.xml"})
public class HomeControllerTest {

	// @ContextConfiguration을 설정하였기때문에
	// HomeController를 Autowired로 가져올수 있다.
	@Autowired
	HomeController hController;
	
	// mockito를 사용하겠다.
	private MockMvc mockMVC;
	
	// mockito(MockMvc 사용할수 있도록 초기화 설정을 한다.
	@Before
	public void setUp() throws Exception {
		mockMVC = MockMvcBuilders.standaloneSetup(hController).build();
	}

	/*
	 * throws Exception
	 * 1. try catch 구문을 대신하는 것
	 * 2. 주 목적은 해당 method내부에서 exception이 발생을 하면
	 * 	직접 처리하지 말고,
	 * 	해당 method를 호출한 곳으로 Exception 정보를 return
	 */
	@Test
	public void testHome() throws Exception {
		mockMVC.perform(get("/"))  // HomeController에게
								   // http://localhost:8080/context/ 요청하라
			.andExpect(status().isOk()) // 200 코드를 받으면
			.andDo(print());
	}

	/*
	 * HomeController의 write 메서드는
	 * 웹브라우저에 입력 form을 띄워주고
	 * 값을 입력한 후 서버로 전송했을때
	 * 정상적으로 모든 처리를 하도록 설계를 했다.
	 * 
	 * method : POST로 하고
	 * str parameter를 설정했을때 test가 pass됨을 확인한다.
	 */
	@Test
	public void testWritePostParam() throws Exception {
		mockMVC.perform(post("/write")
							.param("str","대한민국만세"))
			.andExpect(status().isOk())
			.andDo(print());
	}

	/*
	 * write 메서드를 POST로 호출하면서
	 * str 매개변수를 전달하지 않으면
	 * 400 응답코드가 발생하고
	 * Exception이 발생하여 문제가 생길 수 있음을
	 * 테스트를 통해서 확인한다.
	 */
	@Test
	public void testWriteGet() throws Exception {
		mockMVC.perform(get("/write"))
			.andExpect(status().isOk())
			.andDo(print());
	}
	
	/*
	 * write 메서드들 GET로 호출하면
	 * write는 주소는 있지만 GET method가 없기 때문에
	 * 405 응답코드가 발생하고
	 * Exception이 발생하여 문제가 생길 수 있음을
	 * 테스트를 통해서 확인 한다.
	 */
	@Test
	public void testWritePost() throws Exception {
		mockMVC.perform(post("/write"))
			.andExpect(status().isOk())
			.andDo(print());
	}
	
	/*
	 * JUnit test는 정상적인 pass도 테스트 하지만
	 * 비정상적인 fail도 테스트 케이스에 포함하여
	 * 오류가 발생하는 경우를 알수 있도록 한다.
	 */

}




