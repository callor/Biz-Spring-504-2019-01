package com.biz.file.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.file.model.BoardVO;
import com.biz.file.model.MemberVO;
import com.biz.file.service.BBSService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SessionAttributes({"login_info"})
@Controller
@RequestMapping("/bbs")
public class BBSController {

	@Autowired
	BBSService bService;

	@ModelAttribute("login_info")
	public MemberVO newMember() {
		return new MemberVO();
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String bbs_list(Model model) {
		
		List<BoardVO> bbsList = bService.selectAll();
		
		model.addAttribute("BBS_LIST",bbsList);
		model.addAttribute("BODY", "BBS_LIST");
		return "home";
	}
	
	/*
	 * login_info 라는 ModelAttribute는
	 * sessionAttributes로 설정이 되어 있어서
	 * write 메서드가 호출될때 
	 * 자동으로 memberVO를 세팅한채로 작동이 된다.
	 * 
	 * memberVO에서 m_userid를 추출하여 
	 * boardVO의 b_userid를 세팅하여 자동으로 회원id값을
	 * 세팅된 상태로 게시판 폼을 열어서 글쓰기를 할 수 있다. 
	 */
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String bbs_write(
			@ModelAttribute("login_info") MemberVO memberVO,
				@ModelAttribute("boardVO") 
				BoardVO boardVO,Model model) {
		
		
		// login이 되지 않은상태에서
		// 게시판 글쓰기를 시도하면
		// login 화면으로 redirect
		log.debug(memberVO.toString());
		if(memberVO.getM_userid() == null) {
			return "redirect:/login/login";
		}
		
		// 1.7 이하일 경우
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");
		Date d = new Date();
		
		String today = sd.format(d);
		String nt = st.format(d);
		boardVO.setB_date(today);
		boardVO.setB_time(nt);
		
		// 1.8 이상일 경우
		LocalDateTime ld = LocalDateTime.now();
		DateTimeFormatter fd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter ft = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		String today1 = ld.format(fd);
		String nt1 = ld.format(ft);
		
		boardVO.setB_date(today1);
		boardVO.setB_time(nt1);
		boardVO.setB_userid(memberVO.getM_userid());
		
		model.addAttribute("BODY","BBS_WRITE");
		return "home";
		
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String bbs_write(@ModelAttribute("boardVO") 
						@Valid
						BoardVO boardVO,
						BindingResult result,
						Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("BODY","BBS_WRITE");
			return "home";
		} else {
			int ret = bService.insert(boardVO);
			
			/*
			 * Model 에 addAttribute 된 변수는
			 * redirect 할때 ?변수=값 형태로 따라간다.
			 * 
			 * ModelAndView 는 redirec 하면
			 * 값을 버리고 간다.
			 * 
			 */
			model.addAttribute("BODY", "BBS_LIST");
			return "redirect:/bbs/";
		
		
		}
	}
}
