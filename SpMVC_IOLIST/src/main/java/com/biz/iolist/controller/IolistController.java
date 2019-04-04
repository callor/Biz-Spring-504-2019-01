package com.biz.iolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.iolist.model.DeptVO;
import com.biz.iolist.model.IolistVO;

@Controller
@RequestMapping("/iolist")
public class IolistController {


	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("BODY","IO_LIST");
		return "home";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String write(@ModelAttribute IolistVO iolistVO,
					Model model) {
		
		model.addAttribute("iolistVO", iolistVO);
		model.addAttribute("BODY","IO_WRITE");
		return "home";
	
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String write(@ModelAttribute DeptVO deptVO, 
							Model model,SessionStatus session) {
		
		model.addAttribute("MSG","데이터 추가 성공!!!");
		return "home";
	}


	
}
