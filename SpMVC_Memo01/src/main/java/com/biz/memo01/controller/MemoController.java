package com.biz.memo01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo01.model.MemoVO;

@Controller
public class MemoController {

	@RequestMapping("memo")
	public String memo() {
		return "memoHome" ;
	}
	
	@RequestMapping(value="memo_write", method = RequestMethod.GET)
	public String memo_write() {
		return "memo_write";
	}

	@RequestMapping(value="memo_write", method = RequestMethod.POST)
	public String memo_write(@ModelAttribute MemoVO vo) {
		System.out.println(vo);
		return "memoHome";
	}

	
	
}
