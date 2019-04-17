package com.biz.memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo.model.MemoVO;
import com.biz.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/memo")
public class MemoController {

	@Autowired
	MemoService memoService;
	
	
	@RequestMapping(value="/update",
			method=RequestMethod.GET)
	public String update(
			@ModelAttribute MemoVO memoVO,
			Model model) {
		
		MemoVO vo = memoService.findById(1);
		// log.debug("MEMOVO : " + vo.toString()); 
		
		// model.addAttribute("MEMO",vo);
		model.addAttribute("BODY","MEMO_WRITE");
		
		return "home";
		
	}
	
	
	
}
