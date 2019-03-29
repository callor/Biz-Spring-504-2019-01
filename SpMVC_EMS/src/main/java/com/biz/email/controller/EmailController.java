package com.biz.email.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
		model.addAttribute("MAILS",mList);
		return "home";
	}
	
	@RequestMapping(value="mail",method=RequestMethod.GET)
	public String mail(@ModelAttribute("mailVO")
					MailVO mailVO,
					Model model) {
		
		LocalDateTime lt = LocalDateTime.now();
		DateTimeFormatter dd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		mailVO.setS_date(dd.format(lt));
		mailVO.setS_time(dt.format(lt));
		
		model.addAttribute("mailVO",mailVO);
		return "mail_form";

	}
	
	@RequestMapping(value="mail",method=RequestMethod.POST)
	public String mail(@ModelAttribute("mailVO")
						MailVO mailVO,
						BindingResult result,
						Model model,
						SessionStatus session) {
		
		int ret = mService.insert(mailVO);
		session.setComplete();
		return "redirect:/";
		
	}
	
	
	@RequestMapping(value="view",method=RequestMethod.GET)
	public String view(@RequestParam long id,Model model) {
		
		MailVO mailVO = mService.findById(id);
		model.addAttribute("mail", mailVO);
		
		return "mail_view";
		
	}
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String update(@ModelAttribute MailVO mailVO,Model model) {
		
		long id = mailVO.getId();
		mailVO = mService.findById(id);
		model.addAttribute("mailVO",mailVO);
		return "mail_form";
		
	}
	
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(@ModelAttribute MailVO mailVO, Model model,SessionStatus session) {
		
		int ret = mService.update(mailVO);
		session.setComplete();
		return "redirect:/";
	}
	
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String delete(long id) {
		
		mService.delete(id);
		return "redirect:/";
		
	}
}
