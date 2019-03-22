package com.biz.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.file.model.BoardVO;

// @SessionAttributes({"login_info"})
@Controller
@RequestMapping("/bbs")
public class BoardController {

	
	
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String bbs_write(@ModelAttribute("boardVO") 
							BoardVO boardVO,Model model) {
		
		model.addAttribute("BODY","BBS_WRITE");
		return "home";
		
	}
	
	
}
