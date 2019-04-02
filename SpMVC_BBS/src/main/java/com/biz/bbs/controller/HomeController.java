package com.biz.bbs.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.bbs.model.BBsVO;
import com.biz.bbs.service.BBsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	BBsService bService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
//		List<BBsVO> bbsList = bService.selecAll();
		List<BBsVO> bbsList = bService.pageList(1);
		model.addAttribute("BBS_LIST", bbsList);
		model.addAttribute("BODY", "BBS_LIST");
		return "home";

	}
}
