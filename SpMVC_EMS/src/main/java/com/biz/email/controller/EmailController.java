package com.biz.email.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.email.model.MailVO;
import com.biz.email.service.MailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes("mailVO")
public class EmailController {

	
	@Autowired
	MailService mService;
	
	@ModelAttribute("mailVO")
	public MailVO newMailVO() {
		return new MailVO();
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(Model model) {
		
		List<MailVO> mList = mService.selectAll();
		return "home";
	}
	
	@RequestMapping(value="mail",method=RequestMethod.GET)
	public String mail(@ModelAttribute("mailVO")
					MailVO mailVO,
					Model model) {
		
		model.addAttribute("mailVO",mailVO);
		return "mail_form";

	}
	
	public String mail(@ModelAttribute("mailVO")
						MailVO mailVO,
						BindingResult result,
						Model model) {
		
		int ret = mService.insert(mailVO);
		return "redirect:/";
		
	}
	
}
