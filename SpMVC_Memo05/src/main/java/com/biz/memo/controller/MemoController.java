package com.biz.memo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.memo.mapper.MemoVO;

@Controller
@RequestMapping("/memo")
@SessionAttributes("memoVO")
public class MemoController {
	
	@ModelAttribute("memoVO")
	public MemoVO newMemoVO(){
		return new MemoVO();
	}
	
	
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String write(
			@ModelAttribute("memoVO") MemoVO memoVO,
			Model model) {
		
		model.addAttribute("BODY","MEMO_WRITE");
		model.addAttribute("memoVO", memoVO);
		return "memo_write";
	
		
	}
	
}
