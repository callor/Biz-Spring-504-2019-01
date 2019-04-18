package com.biz.rent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.rent.mapper.UserDao;
import com.biz.rent.model.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UserDao uDao;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home() {
		return "admin_home";
	}

	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String user(Model model) {
		
		List<UserVO> userList = uDao.selectAll();
		model.addAttribute("LIST", userList);
		model.addAttribute("BODY","USER_LIST");
		return "admin_home";
	}

	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String user(@ModelAttribute("userVO") UserVO userVO, 
						Model model) {
		
		log.debug("UserVO : " + userVO.toString());
		
		uDao.insert(userVO);
		
		return "redirect:/admin/user";
	}
	
	@RequestMapping(value="/user/delete",method=RequestMethod.GET)
	public String user_delete(@RequestParam long id) {
		
		uDao.delete(id);
		return "redirect:/admin/user";
		
	}
	
	
	@RequestMapping(value="/book",method=RequestMethod.GET)
	public String book(Model model) {
		model.addAttribute("BODY","BOOK_LIST");
		return "admin_home";
	}
	
	
	
}
