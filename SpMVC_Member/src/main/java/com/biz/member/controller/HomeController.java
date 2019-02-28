package com.biz.member.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.member.model.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "member-home";
	}
	
	@RequestMapping(value="admin/member",
			method=RequestMethod.GET,
			produces="text/html;charset=utf8")
	public String admin_member(HttpSession session) {
		
		MemberVO memberVO = (MemberVO)session.getAttribute("LOGIN_INFO");
		if(memberVO == null) {
			return "redirect:/login?LOGIN_MSG=ADMIN-FAIL" ;
		}
		return "redirect:/";
		
	}
	
}
