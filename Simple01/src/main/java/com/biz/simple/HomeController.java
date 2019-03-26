package com.biz.simple;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @Controller는 Web browser의 요청(Request)을 수신할 bean임을 선언
 * 클래스의 이름은 중요하지 않다.
 * 단, 중복만되지 않으면 된다.
 */
@Controller
public class HomeController {
	
	/*
	 * @RequestMapping은
	 * 컨트롤러로 부터 세부 할일들을 부여받은 method 들
	 * @RequestMapping이 없는 method는 그냥 평범한 method일 뿐이다.
	 */
	@RequestMapping("home")
	public String home(Model model) {
		System.out.println("홈 method 실행");
		return "home";
	}

	@RequestMapping("yes")
	public String yes() {
		System.out.println("YES method 실행");
		return "home" ;
	}
	
	@RequestMapping("no")
	public String no() {
		System.out.println("NO method 실행");
		return "home";
	}

	@ResponseBody @RequestMapping("home1") public String home1() {
		return "Welcome My Home";
	}
	
	@ResponseBody @RequestMapping("yes1") public String yes1() {
		return "Yes OK!!!";
	}
	
	@ResponseBody @RequestMapping("no1") public String no1() {
		add("10","20");
		return "No thank you";
	}
	
	@ResponseBody
	@RequestMapping("add")
	public String add(String num1, String num2) {
		System.out.println(num1 + num2);
		int intNum1 = Integer.valueOf(num1);
		int intNum2 = Integer.valueOf(num2);
		// return num1 + num2 ;
		return "" + (intNum1 + intNum2) ;
	
	}
	
}
