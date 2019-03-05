package com.biz.memo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@RequestMapping(value="join",method=RequestMethod.GET)
	public String join() {
		return "bodys/join_form";
	}

	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login() {
		return "bodys/login_form";
	}

	
}
