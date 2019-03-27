package com.biz.simple;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/*
	 * value="/" : rootPath
	 * 프로젝트에서 아무런 URI 없이 호출되는 주소(path)
	 * localhost:8080/simple/
	 * 
	 * 프로젝트가 최초 시작되었을때 views/home.jsp를 열어서
	 * web browser로 보내라
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping("list")
	public String list() {
		return "list";
	}
	
	@RequestMapping(value="write",method=RequestMethod.GET)
	public String write() {
		return "write";
	}
	
	@RequestMapping(value="write",method=RequestMethod.POST)
	public String write1(InputVO inputVO, Model model) {
		
		System.out.println(inputVO.getNum1());
		System.out.println(inputVO.getOp());
		System.out.println(inputVO.getNum2());
		
		int intNum1 = Integer.valueOf(inputVO.getNum1());
		int intNum2 = Integer.valueOf(inputVO.getNum2());
		
		String op = inputVO.getOp();

		int result = 0;
		if(op.equals("+")) {
			result = intNum1 + intNum2;
		}
		if(op.equals("-")) {
			result = intNum1 - intNum2;
		}
		if(op.equals("*")) {
			result = intNum1 * intNum2;
		}
		
		model.addAttribute("result","결과:" + result);
		return "view";
	
	}
}
