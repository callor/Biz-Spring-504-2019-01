package com.biz.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.file.model.PageVO;
import com.biz.file.service.PageService;

@Controller
public class PageController {
	
	@Autowired
	PageService pService;
	
	@RequestMapping(value="get_page",method=RequestMethod.GET)
	public String getPage(@RequestParam("page_no")
					long page_no,	
					Model model ) {
		
		PageVO pageVO = pService.page_select(page_no);
		model.addAttribute("BODY","BBS_LIST");
		model.addAttribute("BBS_LIST",pService.pagiList(pageVO));
		model.addAttribute("PAGE",pageVO);
		return "home";
	}
	

}
