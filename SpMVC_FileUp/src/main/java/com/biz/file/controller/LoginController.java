package com.biz.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.file.model.MemberVO;

@Controller
@SessionAttributes({"login_info"})
@RequestMapping("/login")
public class LoginController {

	/*
	 * @ModelAttribute로 login_info 를 선언하고
	 */
	@ModelAttribute("login_info")
	public MemberVO login_info() {
		return new MemberVO();
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(@ModelAttribute("login_info") 
							MemberVO memberVO,
							Model model, String strId) {
		
		model.addAttribute("BODY","LOGIN_FORM");
		return "home";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@ModelAttribute("login_info") 
							MemberVO memberVO, Model model) {
		
		memberVO.setM_name("임꺽정");
		memberVO.setM_tel("001-001");
		return "body/login_ok";

	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(
			@ModelAttribute("login_info") MemberVO memberVO,
			SessionStatus seStatus) {
		
		// session을 제거
		// session완료, 만료되었다라고 표현
		seStatus.setComplete();
		return "redirect:login";
		
	}
	
}
