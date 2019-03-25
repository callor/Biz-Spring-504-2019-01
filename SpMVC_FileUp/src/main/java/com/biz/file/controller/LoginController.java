package com.biz.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.file.model.MemberVO;
import com.biz.file.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes({"login_info"})
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService lService;
	
	/*
	 * @ModelAttribute로 login_info 를 선언하고
	 * login_info 초기화 method
	 */
	@ModelAttribute("login_info")
	public MemberVO login_info() {
		log.debug("NEW memberVO");
		return new MemberVO();
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(@ModelAttribute("login_info") 
							MemberVO memberVO,
							Model model, 
							SessionStatus session,String s) {
		
		log.debug(String.valueOf(session.isComplete()));
		session.setComplete();
		log.debug(String.valueOf(session.isComplete()));
		model.addAttribute("BODY","LOGIN_FORM");
		return "home";
	}
	
	/*
	 * @ModelAttribute만 사용하면 지정된 객체가 실제 이름이 된다.
	 * 컨트롤러에서 form으로 데이터를 받는 용도로만 사용할때는
	 * 아무런 문제가 없다.
	 * 
	 * 하지만, 지금 프로젝에서는 memberVO 객체를 
	 * 컨트롤러와 view(jsp)에서 공유해서 사용하고 있다.
	 * 
	 * 이럴때는 반드시 이름을 강제로 지정해 주는 것이 좋다
	 * @ModelAttribute("login_info") 식으로 작성
	 * 
	 * 이제 login() method에서 제어권이 다른곳으로 이동되는 순간
	 * memberVO는 마치 이름이 login_info로 바뀌는 것과 같다.
	 * 
	 */
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@ModelAttribute("login_info") 
							MemberVO memberVO, 
							Model model,
							SessionStatus session) {
		
		MemberVO vo = lService.getMemberInfo(memberVO);
		if(vo != null) {
			/* 로그인에 성공했을 경우
			 * memberVO를 session에서 
			 * login_info 이름으로 사용중이므로
			 * 
			 * memberVO에 vo를 담지 않고
			 * memberVO의 다른이름인 login_info에 담아야 한다.
			 * 
			 * 그런데 login_info는 변수가 아니므로
			 * model을 사용해서 다시 login_info 에 vo를 세팅한다
			 */
			model.addAttribute("login_info", vo);
			log.debug(memberVO.toString());
			
		} else {
			
			// 로그인 method가 호출되면
			// member의 로그인 관련 정보가 정상이 아니라도
			// session이 이미 시작이 되어버린다.
			
			// 그래서 
			// 로그인에 실패 했으면 세션정보를 반드시 지워줘야
			// 안전하다.
			session.setComplete();
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(
			@ModelAttribute("login_info") MemberVO memberVO,
			SessionStatus seStatus) {
		
		
		log.debug("LOGOUT");
		// session을 제거
		// session완료, 만료되었다라고 표현
		seStatus.setComplete();
		return "redirect:/";
		
	}
	
}
