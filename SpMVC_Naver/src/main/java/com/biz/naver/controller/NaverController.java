package com.biz.naver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.naver.service.NaverService;

@Controller 
public class NaverController {

	@Autowired
	NaverService nService;
	
	@RequestMapping(value="naver",method=RequestMethod.POST)
	public String naver() {
		
		nService.getBookInfo();
		return "home";
	
	}
	
}
