package com.biz.memo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutController {

	@RequestMapping(value="ad-1",method=RequestMethod.GET)
	public String about_1(Model model) {
		return "bodys/about";
		
	}

	@RequestMapping(value="ad-2",method=RequestMethod.GET)
	public String about_2(Model model) {
		return "bodys/about";
	}
	
	@RequestMapping(value="ad-3",method=RequestMethod.GET)
	public String about_3(Model model) {
		return "bodys/about";
	}
	
	@RequestMapping(value="ad-4",method=RequestMethod.GET)
	public String about_4(Model model) {
		return "bodys/about";
	}
	
	@RequestMapping(value="ad-5",method=RequestMethod.GET)
	public String about_5(Model model) {
		return "bodys/about";
	}
	

	
}
