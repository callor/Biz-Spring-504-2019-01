package com.biz.file.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.biz.file.model.BoardVO;
import com.biz.file.model.MemberVO;
import com.biz.file.service.BBSService;
import com.biz.file.service.FileUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SessionAttributes({"bbsVO"})
@Controller
@RequestMapping("/bbs")
public class BBSController {

	@Autowired
	BBSService bService;
	
	@Autowired
	FileUpService fService;

	@ModelAttribute("bbsVO")
	public BoardVO newMember() {
		return new BoardVO();
	}
	
	/**
	 * 게시판 list 보기
	 * @param model
	 * @return
	 * @since 2019-03-01
	 */
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
				@ModelAttribute("bbsVO") 
				BoardVO boardVO,
				HttpSession session, // login 정보를 추출하기 위한 
				Model model) {
		
		// login이 되지 않은상태에서
		// 게시판 글쓰기를 시도하면
		// login 화면으로 redirect
		// MemberVO memberVO = session.getAttribute("login_info");
		
		// Object obj = session.getAttribute("login_info");
		// MemberVO memberVO = (MemberVO)obj;
		MemberVO memberVO = (MemberVO)session.getAttribute("login_info");
		
		// session의 Attribute에 담긴 값은 Type 이 Object 형이다
		// Object Type은 모든 클래스의 조상이다.
		// 그래서 session의 Attribute에는 어떤 클래스, 객체든지
		// 담아 놓을 수 있다.
		// 단, 사용을 위해서 get을 실행한 후에는 반드시 
		// cascading 해주어야 한다. 
		
		// log.debug(memberVO.toString());
		// if(memberVO.getM_userid() == null) {
		//	return "redirect:/login/login";
		// }
		
		// HttpSession은 session 정보가 없으면 Object 자체가 null 이된다.
		if(memberVO == null) {
			model.addAttribute("LOGIN_MSG","LOGIN_REQ");
			return "redirect:/login/login";
			
			// memberVO = new MemberVO();
			// memberVO.setM_userid("callor@callor.com");
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
	public String bbs_write(@ModelAttribute("bbsVO") 
						@Valid
						BoardVO boardVO,
						BindingResult result,
						Model model,
						SessionStatus sStatus) {
		
		if(result.hasErrors()) {
			model.addAttribute("BODY","BBS_WRITE");
			return "home";
		} else {
			
			log.debug(boardVO.toString());
			int ret = 0 ;
			if(boardVO.getId() > 0) {
				ret = bService.update(boardVO);
			} else {
				ret = bService.insert(boardVO);	
			}
			
			/*
			 * Model 에 addAttribute 된 변수는
			 * redirect 할때 ?변수=값 형태로 따라간다.
			 * 
			 * ModelAndView 는 redirec 하면
			 * 값을 버리고 간다.
			 * 
			 */
			sStatus.setComplete();
			model.addAttribute("BODY", "BBS_LIST");
			return "redirect:/bbs/";
		
		}
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String bbs_view(
			@ModelAttribute("bbsVO") BoardVO boardVO, 
			Model model,
			HttpSession session) {
		
		MemberVO memberVO 
		= (MemberVO)session.getAttribute("login_info");
		
		// 게시판보기에서 로그인 정보가 없으면
		if(memberVO == null) {
			model.addAttribute("LOGIN_MSG","LOGIN_REQ");
			return "redirect:/login/login";
		} else {
			
			long id = boardVO.getId();
			log.debug("BOARD ID : " + id);
			
			// 게시물 가져오기와 조회수 올리기
			boardVO 
			= bService.UpdateHit(id,memberVO.getM_userid());
			
			log.debug(boardVO.toString());
			
			model.addAttribute("bbsVO",boardVO);
			model.addAttribute("BODY","BBS_VIEW");
			return "home";
			
			/*
			if(bVO.getB_userid().equalsIgnoreCase(memberVO.getM_userid()){
				// 게시물 보이기
			} else {
				// 본인이 작성한
			}
			*/
			
		}
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String bbs_delete(@RequestParam long id) {
		bService.delete(id);
		return "redirect:/bbs/" ;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String bbs_update(
			@ModelAttribute("bbsVO") BoardVO boardVO,
			Model model) {
		
		long id = boardVO.getId();
		log.debug("BOARD ID: " + id);
		boardVO = bService.findById(id);
		
		model.addAttribute("bbsVO",boardVO);
		model.addAttribute("BODY","BBS_WRITE");
		return "home";
		
	}
	
	
	@ResponseBody
	// /bbs/file
	@RequestMapping(value="/file",method=RequestMethod.POST)
	public String file(@RequestParam MultipartFile file) {
		
		String fileName = fService.upload(file);
		return fileName;
	}
}
