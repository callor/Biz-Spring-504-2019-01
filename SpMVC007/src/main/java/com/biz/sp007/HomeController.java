package com.biz.sp007;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	// RequestMapping에 단순히 문자열만 setting하면
	// req(요청)하는 방식이 GET이거나 POST 이거나
	// 상관없이 작동되어라 하는 설졍
	@RequestMapping("home")
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	// method=...GET 이라고 setting을 하면
	// req하는 방식이 GET 일경우에만
	// 작동되어라 하는 설정
	// req가 GET 인경우 : 
	//		브라우저의 주소창에 직접입력을 하고
	//		Enter를 눌렀을 경우가 해당
	//
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String calc() {
		return "calc_form";
	}
	
}
