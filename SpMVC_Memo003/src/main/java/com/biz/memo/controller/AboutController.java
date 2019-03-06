package com.biz.memo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutController {

	@RequestMapping(value="ad-1",method=RequestMethod.GET)
	public String about_1(HttpSession session,
						Model model) {
		
		if(session.getAttribute("LOGIN_INFO") == null) {
			model.addAttribute("LOGIN_FAIL", "REQ");
			return "bodys/login_form";
		}
		return "bodys/about";
	}

	@RequestMapping(value="ad-2",method=RequestMethod.GET)
	public String about_2(HttpSession session,
						Model model) {
		
		if(session.getAttribute("LOGIN_INFO") == null) {
			model.addAttribute("LOGIN_FAIL", "REQ");
			return "bodys/login_form";
		}
		return "bodys/about";
	}
	
	@RequestMapping(value="ad-3",method=RequestMethod.GET)
	public String about_3(HttpSession session,
						Model model) {
		
		if(session.getAttribute("LOGIN_INFO") == null) {
			model.addAttribute("LOGIN_FAIL", "REQ");
			return "bodys/login_form";
		}
		return "bodys/about";
	}
	
	
	
	
}
