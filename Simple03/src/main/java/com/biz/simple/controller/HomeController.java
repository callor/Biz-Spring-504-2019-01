package com.biz.simple.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.simple.service.HomeService;

@Controller
public class HomeController {
	
	@Autowired
	HomeService hService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value="calc",method=RequestMethod.POST)
	public String calc(@RequestParam String num1, 
						String op, 
						@RequestParam String num2,
						Model model) {

		int result = hService.calc(num1,op, num2);
		
		model.addAttribute("result", result);
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		
		return "home";

	}
}
