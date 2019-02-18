package com.biz.simple.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalcController {
	
	@ResponseBody
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String add() {
		int intNum1 = 30;
		int intNum2 = 40;
		int intSum = intNum1 + intNum2;
		return "" + intSum ;
	}
	
	@ResponseBody
	@RequestMapping(value="add1",method=RequestMethod.GET,
			produces="application/json;charset=utf8")
	public String add(
			@RequestParam("intNum1") String strNum1, 
			@RequestParam("intNum2" ) String strNum2) {
		
		int intNum1;
		int intNum2;
		
		try {
			intNum1 = Integer.valueOf(strNum1);			
		} catch (Exception e){
			return "intNum1 을 숫자로 변환 할 수 없습니다" ;
		}
		
		try {
			intNum2 = Integer.valueOf(strNum2);	
		} catch (Exception e) {
			return "intNum2 를 숫자로 변환 할 수 없습니다";
		}
		
		int intSum = intNum1 + intNum2;
		return "intNum1 =  " + intNum1 
				+ "intNum2 = "+ intNum2
				+ " 두수의 합 = " + intSum ;
	
	}

	@ResponseBody
	@RequestMapping(value="add2",method=RequestMethod.GET,
			produces="application/json;charset=utf8")
	public String add2(
			@RequestParam("intNum1") String strNum1, 
			@RequestParam("intNum2" ) String strNum2) {
		
		int intNum1;
		int intNum2;
		
		try {
			intNum1 = Integer.valueOf(strNum1);			
		} catch (Exception e){
			return "intNum1 을 숫자로 변환 할 수 없습니다" ;
		}
		
		try {
			intNum2 = Integer.valueOf(strNum2);	
		} catch (Exception e) {
			return "intNum2 를 숫자로 변환 할 수 없습니다";
		}
		
		int intSum = intNum1 + intNum2;
		
		String strRet = "{intNum1:" + intNum1 + ","
						+ " intNum2:" + intNum2 + ","
						+ "intSUm:" + intSum + "}" ;
		
		return strRet;
	}

	@ResponseBody
	@RequestMapping(value="add3",method=RequestMethod.GET,
					produces="text/html; charset=utf8"
			)
	public String add3(
			@RequestParam("intNum1") String strNum1, 
			@RequestParam("intNum2" ) String strNum2) {
		
		int intNum1 = 0;
		int intNum2 = 0;
		
		try {
			intNum1 = Integer.valueOf(strNum1);			
		} catch (Exception e){
			return "intNum1 을 숫자로 변환 할 수 없습니다" ;
		}
		
		try {
			intNum2 = Integer.valueOf(strNum2);	
		} catch (Exception e) {
			return "intNum2 를 숫자로 변환 할 수 없습니다";
		}
		
		int intSum = intNum1 + intNum2;
		
		String strRet = "<html>";
		strRet += "<body>";
		strRet += "<p><font color=blue>숫자1 : " + intNum1 + "</font></p>";
		strRet += "<p><font color=red>숫자2 : " + intNum2 + "</font></p>";
		strRet += "<p><font color=green>합계 : " + intSum + "</font></p>";
		strRet += "</body>" ;
		strRet += "</html>" ;
		
		return strRet;
	}


}





