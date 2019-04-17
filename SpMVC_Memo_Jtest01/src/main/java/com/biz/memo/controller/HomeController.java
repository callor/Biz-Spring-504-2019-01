package com.biz.memo.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="write",method=RequestMethod.GET)
	public String write() {
		
		int sum = 0 ;
		for(int i = 1 ; i <= 100 ; i++) {
			sum += i;
		}
		return "*" + sum ;
		
	}
	
	@RequestMapping(value="this",method=RequestMethod.GET)
	public String thisM() {
		return "this_page";
	}

	@RequestMapping(value="this",
				method=RequestMethod.POST,
				produces = "text/html;charset=utf8")
	public String thisM(Model model) {
		
		model.addAttribute("MYNAME", "홍길동");
		return "this_page";
	}

	
	
	
}
