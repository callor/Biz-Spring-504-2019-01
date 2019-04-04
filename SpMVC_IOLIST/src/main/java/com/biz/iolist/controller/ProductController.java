package com.biz.iolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.iolist.model.DeptVO;
import com.biz.iolist.model.ProductVO;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		
		model.addAttribute("BODY","P_LIST");
		return "home";
	}

	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String write(@ModelAttribute ProductVO productVO,
						Model model) {
		
		model.addAttribute("productVO",productVO);
		model.addAttribute("BODY","P_WRITE");
		return "home";

	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String write(@ModelAttribute DeptVO deptVO, 
							Model model,SessionStatus session) {
		
		model.addAttribute("MSG","데이터 추가 성공!!!");
		return "home";
	}

	
}
