package com.biz.rent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.rent.model.UserVO;
import com.biz.rent.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService uService;
	
	@RequestMapping(value="/s_list/{string}",method=RequestMethod.GET)
	public String search_list(
			@PathVariable("string") String s_string,
			Model model) {
		
		List<UserVO> userList = uService.getSearchList(s_string);
		
		model.addAttribute("USERS",userList);
		return "rent_body/user/user_s_list" ;
	
	}
}
