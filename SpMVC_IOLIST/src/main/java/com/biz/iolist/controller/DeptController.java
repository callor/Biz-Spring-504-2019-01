package com.biz.iolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.iolist.model.DeptVO;
/*
 * 거래처관리 컨트롤러
 */
@Controller
@RequestMapping("/dept")
public class DeptController {

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		
		model.addAttribute("BODY", "D_LIST");
		return "home";
		
	}
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String write(@ModelAttribute DeptVO deptVO, 
							Model model) {

		model.addAttribute("deptVO", deptVO);
		model.addAttribute("BODY", "D_WRITE");
		return "home";
		
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String write(@ModelAttribute DeptVO deptVO, 
							Model model,SessionStatus session) {
		
		model.addAttribute("MSG","데이터 추가 성공!!!");
		return "home";
	}


		

}
