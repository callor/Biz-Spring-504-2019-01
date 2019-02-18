package com.biz.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.simple.service.InoutService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IolistController {

	@Autowired
	InoutService ios;
	
	@RequestMapping(value="iolist",method=RequestMethod.GET)
	public String iolist(Model model) {

		model.addAttribute("IOLIST", ios.getIolist());
		return "iolist";
		
	}
}



