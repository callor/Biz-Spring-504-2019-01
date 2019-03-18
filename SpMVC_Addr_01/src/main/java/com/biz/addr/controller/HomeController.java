package com.biz.addr.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.addr.model.AddrVO;
import com.biz.addr.service.SelectService;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 * 
 */
@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	SelectService sService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		AddrVO addrVO = new AddrVO();
		addrVO.setA_name("이몽룡");
		addrVO.setA_tel("999-8888");
		addrVO.setA_city("JEJU");
		
		model.addAttribute("addrVO",addrVO);
		
		model.addAttribute("CITIES",sService.getCities());
		// model.addAttribute("CITIES",sService.getCities2());
		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="addr",produces="text/html;charset=utf8", method = RequestMethod.POST)
	public String addr(@ModelAttribute AddrVO addrVO) {

		log.debug(addrVO.toString());
		return "주소록 리턴";
		
	}
	
}
