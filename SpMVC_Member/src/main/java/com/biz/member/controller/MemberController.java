package com.biz.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

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
		/*
		 * memberVO의 비밀번호 항목을 암호화 할  것이다.
		 * 
		 */
		// 1. 일반적인 class 사용법대로 암호화 객체 생성
		// 생성자에 4부터 31까지 임의의 정수를 포함할수 있고
		// 생략할 경우 10이 적용된다.
		// 스프링에서는 16의 값을 권장한다.
		// >> 내부에서 해쉬함수를 이용해서 암호화를 하는데
		// 		16번 반복하고 그중에서 임의 값을 선택하라
		// BCryptPasswordEncoder bcrypt 
		// 	= new BCryptPasswordEncoder(16);
		
		String bcPassword = passwordEncoder.encode(memberVO.getM_password());
		memberVO.setM_password(bcPassword);
		
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
	
	@RequestMapping(value="test",
			produces= {"text/plan;charset=utf8"},
			consumes="application/json")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member-home");
		mv.addObject("BODY","LOGIN-FORM");
		return mv ;
	}

}
