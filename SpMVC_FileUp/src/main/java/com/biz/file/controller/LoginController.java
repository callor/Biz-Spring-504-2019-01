package com.biz.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.file.model.MemberVO;
import com.biz.file.service.LoginService;

@Controller
@SessionAttributes({"login_info"})
@RequestMapping("/login")
public class LoginController {

	
	@Autowired
	LoginService lService;
	
	/*
	 * @ModelAttribute로 login_info 를 선언하고
	 * login_info 초기화 method
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
							MemberVO memberVO, 
							Model model,
							SessionStatus session) {
		
		MemberVO vo = lService.getMemberInfo(memberVO);
		if(vo != null) {
			memberVO = vo;
		} else {
			
			// 로그인 method가 호출되면
			// member의 로그인 관련 정보가 정상이 아니라도
			// session이 이미 시작이 되어버린다.
			
			// 그래서 
			// 로그인에 실패 했으면 세션정보를 반드시 지워줘야
			// 안전하다.
			session.setComplete();
		}
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
