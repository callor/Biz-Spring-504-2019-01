package com.biz.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.simple.service.MyService;
import com.biz.simple.vo.CalcVO;

@Controller	
public class MyController {
	
	/*
	 * @Service Annotation이 설정된 클래스를 가져다가
	 * ms 객체를 생성(초기화)하여 사용할 준비를 하라 는 지시어
	 */
	@Autowired
	MyService ms ;
	
	@ResponseBody
	@RequestMapping(value="addList",method=RequestMethod.GET,
			produces="text/html;charset=utf8")
	public String addList(int intNum1, int intNum2) {

		String retStr = "<html>";
		retStr += "<body>";

		int intSum = 0;
		for(int i = intNum1 ; i <= intNum2 ; i++) {
			intSum += i ;
			retStr += "<p>" + intSum + "</p>";
		}
		
		retStr += "<hr/>";
		retStr += "<p>합계 : " + intSum + "</p>" ;
		
		return retStr;
		
	}

	@RequestMapping(value="addList",method=RequestMethod.POST,
			produces="text/html;charset=utf8")
	public String addList1(int intNum1, int intNum2,Model model) {

		int intSum = 0;
		for(int i = intNum1 ; i <= intNum2 ; i++) {
			intSum += i ;
		}
		
		
		model.addAttribute("intNum1", intNum1);
		model.addAttribute("intNum2", intNum2);
		model.addAttribute("SUM", intSum);
		
		return "home";
		
	}

	
	@RequestMapping(value="addList1",method=RequestMethod.POST,
			produces="text/html;charset=utf8")
	public String addList2(int intNum1, int intNum2,Model model) {

		int intOdd = 0;
		int intEven = 0 ;
		for(int i = intNum1 ; i <= intNum2 ; i++) {
			if(i % 2  == 0) intEven += i;
			else intOdd += i;
		}
		model.addAttribute("intNum1", intNum1);
		model.addAttribute("intNum2", intNum2);
		model.addAttribute("SUM", "짝수: " + intEven + "/ 홀수:" + intOdd );
		return "home";
		
	}
	
	@RequestMapping(value="calc",method=RequestMethod.GET)
	public String calc() {
		return "calc";
	}
	
	@RequestMapping(value="calc",method=RequestMethod.POST)
	public String calc(int intNum1, int intNum2,Model model) {
//		MyService myService = new MyService();
		
		int intAdd = ms.add(intNum1, intNum2);
		int intMinus = ms.minus(intNum1, intNum2);
		int intMulti = ms.multi(intNum1, intNum2);
		int intDevide = ms.devide(intNum1, intNum2);
		
		model.addAttribute("ADD", intAdd);
		model.addAttribute("MINUS", intMinus);
		model.addAttribute("MULTI", intMulti);
		model.addAttribute("DEVIDE", intDevide);
				
		return "calc";
		
	}

	@RequestMapping(value="calc-vo",method=RequestMethod.POST)
	public String calc(@ModelAttribute CalcVO vo,Model model) {
//		MyService myService = new MyService();
		
		int intAdd = ms.add(vo.getIntNum1(), vo.getIntNum2());
		int intMinus = ms.minus(vo.getIntNum1(), vo.getIntNum2());
		int intMulti = ms.multi(vo.getIntNum1(), vo.getIntNum2());
		int intDevide = ms.devide(vo.getIntNum1(), vo.getIntNum2());
		
		vo.setIntAdd(intAdd);
		vo.setIntMinus(intMinus);
		vo.setIntMulti(intMulti);
		vo.setIntDevide(intDevide);
		
		model.addAttribute("CALC", vo);
		return "calc";
		
	}
	
	
	
	
	
	
}
