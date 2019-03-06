package com.biz.memo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemoController {
	
	@RequestMapping(value="memo",method=RequestMethod.GET)
	public String memo(HttpSession session,Model model) {
		
		if(session.getAttribute("LOGIN_INFO") == null) {
			model.addAttribute("LOGIN_FAIL", "REQ");
			return "bodys/login_form";
		}
		return "bodys/memo_form";
	}

}
