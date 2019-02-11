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
	 * @ModelAttribute Annotation�� form���� ���� ���۵Ǿ��
	 * �����͵��� VO�� �ڵ����� mapping ��Ű�� command Annotation�̴�
	 * 
	 * �� Annotation�� �ݵ�� VO �տ� ��ġ ���Ѿ� �Ѵ�.
	 * 
	 * ���� Model �տ� ������ �ȵȴ�.
	 */
	@RequestMapping(value="member",method=RequestMethod.POST)
	public String member(Model model, 
			@ModelAttribute MemberVO memberVO ) {
		System.out.println(memberVO);
		return "home";
	}
	
}
