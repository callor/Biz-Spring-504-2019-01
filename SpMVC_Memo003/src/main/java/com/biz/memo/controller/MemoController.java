package com.biz.memo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemoController {
	
	@RequestMapping(value="memo",method=RequestMethod.GET)
	public String memo() {
		return "bodys/memo_form";
	}

}
