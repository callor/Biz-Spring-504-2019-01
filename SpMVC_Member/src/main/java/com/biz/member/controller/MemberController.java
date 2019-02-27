package com.biz.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.biz.member.model.MemberVO;
import com.biz.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	@Autowired
	MemberService mService;

	@RequestMapping(value="join",method=RequestMethod.GET)
	public String join(Model model) {
		
		model.addAttribute("BODY","JOIN-FORM");
		return "member-home";
	
	}

	@RequestMapping(value="join",
			method=RequestMethod.POST,
			produces="text/plan;charset=utf8")	
	public String join(@ModelAttribute MemberVO memberVO) {

		log.debug(memberVO.toString());
		mService.insert(memberVO);
		return "redirect:/";
		
	}
	
	@ResponseBody
	@RequestMapping(value="id_check",
		method=RequestMethod.POST,
		produces="text/html;charset=utf8")
	public String id_check(@RequestParam String m_userid) {
		String ret = "";
		
		MemberVO vo = mService.findById(m_userid);
		
		if(vo == null) ret = "사용할 수 있는 ID 입니다";
		else ret = "이미 등록된 ID 입니다";
		return ret;
	}
	
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member-home");
		mv.addObject("BODY","LOGIN-FORM");
		return mv ;
	}

	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(Model model, String LOGIN) {
		
		model.addAttribute("BODY","LOGIN-FORM");
		model.addAttribute("LOGIN",LOGIN);
		return "member-home" ;
	}
	
	/*
	 * 로그인, 로그아웃을 처리할 method에는 
	 * HttpSessio 클래스를 매개변수로 설정 해 두어야 한다.
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(HttpSession session, 
				@ModelAttribute MemberVO memberVO,
				Model model) {

		// memberVO에는 로그인 폼에서 
		// 입력한 id와 비밀번호만 담겨 있을 것이다.
		
		// login에 실패했다는 가정을하고
		// LOGIN이라는 속성에 FAIL 이라는 문자열을 싣는다.
		model.addAttribute("LOGIN","FAIL");
		return "redirect:login"; // 다시 login GET로 보내기
		// return "redirect:/" ;
	}
}
