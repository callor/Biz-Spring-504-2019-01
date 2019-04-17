package com.biz.memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.memo.mapper.MemoVO;
import com.biz.memo.service.MemoService;

@Controller
@RequestMapping("/memo")
@SessionAttributes("memoVO")
public class MemoController {
	
	@ModelAttribute("memoVO")
	public MemoVO newMemoVO(){
		return new MemoVO();
	}
	
	@Autowired
	MemoService mService;
	
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String write(
			@ModelAttribute("memoVO") MemoVO memoVO,
			Model model) {
		
		model.addAttribute("BODY","MEMO_WRITE");
		model.addAttribute("memoVO", memoVO);
		return "memo_write";
	
		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add() {
		
		int sum = 0;
		for(int i = 0 ; i < 5 ; i++) {
			sum += mService.add();
		}
		return "" + sum ;
	}
	
	
	@ResponseBody
	@RequestMapping(value="get_name",method=RequestMethod.GET)
	public String getName() {
		return mService.getName();
	}
	
	
	
}
