package com.biz.ajax01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptRESTController {
	
	
	// @ResponseBody
	@RequestMapping(value="hello",
			method=RequestMethod.GET,
			produces="text/plan;charset=utf8")
	public String testREST() {
		return "반갑습니다";
	}

}
