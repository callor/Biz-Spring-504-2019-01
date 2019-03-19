package com.biz.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * Controller에 RequestMapping을 설정하면
 * 페이지를 호출할 주소를 그룹으로 묶어서 관리할 수 있다.
 * 단, Mapping 주소 앞에 반드시 / 로 시작해야 한다.
 */
@Controller
@RequestMapping("/member")
public class MemberController {
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		return "body/join_form";
	}
	
	
	
}
