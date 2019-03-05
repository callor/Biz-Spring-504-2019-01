package com.biz.memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo.model.MemberVO;
import com.biz.memo.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService mService;
	
	@RequestMapping(value="join",method=RequestMethod.GET)
	public String join() {
		return "bodys/join_form";
	}

	@RequestMapping(value="join",method=RequestMethod.POST)
	public String join(@ModelAttribute MemberVO memberVO) {
		mService.insert(memberVO);
		return "bodys/join_form";
	}

	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login() {
		return "bodys/login_form";
	}

	
}
