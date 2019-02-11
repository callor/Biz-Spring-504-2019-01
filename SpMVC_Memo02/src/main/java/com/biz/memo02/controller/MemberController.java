package com.biz.memo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo02.service.MemberService;
import com.biz.memo02.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService mService;

	@RequestMapping(value="member",method=RequestMethod.GET)
	public String member(Model model) {

		model.addAttribute("CITIES",mService.getCities());
		model.addAttribute("HOBBIES", mService.getHobbies());
		
		model.addAttribute("BODY","MEMBER_JOIN");
		
		return "home" ;
	
	}
	
	/*
	 * @ModelAttribute Annotation은 form으로 부터 전송되어온
	 * 데이터들을 VO에 자동으로 mapping 시키는 command Annotation이다
	 * 
	 * 이 Annotation은 반드시 VO 앞에 위치 시켜야 한다.
	 * 
	 * 절대 Model 앞에 놓으면 안된다.
	 */
	@RequestMapping(value="member",method=RequestMethod.POST)
	public String member(Model model, 
			@ModelAttribute MemberVO memberVO ) {
		System.out.println(memberVO);
		return "home";
	}
	
}
