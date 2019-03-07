package com.biz.memo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@RequestMapping(value="jq1",method=RequestMethod.GET)
	public String jq_test1( ) {
		return "jq/j-test1";
	}
	
}
