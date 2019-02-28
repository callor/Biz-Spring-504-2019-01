package com.biz.member.controller;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcRestController {
	
	@ResponseBody
	@RequestMapping(value="add1",
		method=RequestMethod.GET,
			produces="text/html;charset=utf8")
	public String getParam(
			// required 는 기본값이 true이며
			// localhost/add1?num1=20&num2=30 과 같은 형식으로 req 하지 않으면
			// 400 오류가 발생한다.
			
			// required=false 설정하면
			// 일단 method 호출은 정상적으로 통과가 된다.
			// 	그러면 method 내부에서 매개변수에 대한 설정을
			// 	해주면 사용자에게 불필요한 오류 메시지를
			// 	덜 보여주게 할수 있다.
			// @RequestParam("num1")
			@RequestParam(value="num1",
					required=false) String num1, 
			@RequestParam(value="num2",
					required=false) String num2) {

		int intNum1 ;
		int intNum2 ;
		int sum = 0 ;
		try {
			intNum1 = Integer.valueOf(num1);
			intNum2 = Integer.valueOf(num2);
			sum = intNum1 + intNum2;
		} catch (Exception e) {
			return "숫자 매개변수가 잘못되어 계산을 수행할수 없음";
		}
		return "" + sum;
		
	}

	// localhost/add/num1/num2
	@RequestMapping(value="add",produces="text/html;charset=utf8")
	public String getPath() {
		return "덧셈을 하려면 숫자를 보내야 합니다";
	}
	
	// localhost/add/num1/num2
	@RequestMapping(value="add/{num1}",produces="text/html;charset=utf8")
	public String getPath(
				@PathVariable int num1 
				) {
		return "덧셈을 하려면 숫자를 2개 보내야 합니다";
	}

	// localhost/add/num1/num2
	@RequestMapping(value="add/{num1}/{num2}",produces="text/html;charset=utf8")
	public String getPath(
				@PathVariable int num1, 
				@PathVariable int num2) {
		return "숫자 2개의 덧셈결과 : " + (num1 + num2) ;
	}

	@RequestMapping(value="add2/{num1}/{num2}",
				produces="text/html;charset=utf8")
	public Integer getPath(
				@PathVariable("num1") String strNum1, 
				@PathVariable("num2") String strNum2) {
		
		int num1 = Integer.valueOf(strNum1);
		int num2 = Integer.valueOf(strNum1);
		return (num1 + num2) ;
	}

	
	
}



