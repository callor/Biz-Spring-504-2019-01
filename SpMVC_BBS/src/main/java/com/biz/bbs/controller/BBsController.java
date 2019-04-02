package com.biz.bbs.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.bbs.model.BBsVO;
import com.biz.bbs.service.BBsService;

@SessionAttributes("bbsVO")
@Controller
public class BBsController {
	
	@Autowired
	BBsService bService;
	
	@ModelAttribute("bbsVO")
	public BBsVO newBbsVO() {
		
		BBsVO bbsVO = new BBsVO();
		
		bbsVO.setB_userid("callor@callor.com");
		
		LocalDateTime lt = LocalDateTime.now();
		DateTimeFormatter fdate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter ftime = DateTimeFormatter.ofPattern("HH:mm:ss");

		bbsVO.setB_date(fdate.format(lt));
		bbsVO.setB_time(ftime.format(lt));
		
		return bbsVO;

	}
	
	@RequestMapping(value="write",method=RequestMethod.GET)
	public String bbs_write(@ModelAttribute("bbsVO") BBsVO bbsVO,
			Model model) {
		
		model.addAttribute("BODY","BBS_WRITE");
		model.addAttribute("bbsVO",bbsVO);
		return "home";
		
	}
	
	@RequestMapping(value="write",method=RequestMethod.POST)
	public String bbs_write(@ModelAttribute("bbsVO") BBsVO bbsVO,
						SessionStatus session) {
		
		int ret = bService.insert(bbsVO);
		/*
		 * 다음에 새로운 글을 작성할때
		 * 기존에 작성했던 내용이 form 에 나타나게 된다.
		 * 그러한 현상을 막는 방법
		 */
		session.setComplete();
		return "redirect:/" ;
	}
	
	@RequestMapping(value="view",method=RequestMethod.GET)
	public String bbs_view(@ModelAttribute("bbsVO") BBsVO bbsVO,
							Model model) {
		
		long id = bbsVO.getId();
		// id를 기준으로 1개의 게시판 정보 조회
		bbsVO = bService.findById(id);
		model.addAttribute("bbsVO",bbsVO);
		model.addAttribute("BODY","BBS_VIEW");
		return "home";
		
	}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String bbs_delete(@RequestParam long id) {
		int ret = bService.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String bbs_update(@ModelAttribute("bbsVO") BBsVO bbsVO,
							Model model) {
		
		long id = bbsVO.getId();
		bbsVO = bService.findById(id);
		model.addAttribute("bbsVO",bbsVO);
		model.addAttribute("BODY", "BBS_WRITE");
		return "home";
		
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String bbs_update(@ModelAttribute("bbsVO") BBsVO bbsVO,
					SessionStatus session) {
		
		int ret = bService.update(bbsVO);
		session.setComplete();
		
		return "redirect:/";
		
	}
}
