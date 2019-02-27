package com.biz.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.biz.member.model.MemberVO;
import com.biz.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	@Autowired
	MemberService mService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@RequestMapping(value="join",method=RequestMethod.GET)
	public String join(Model model) {
		
		model.addAttribute("BODY","JOIN-FORM");
		return "member-home";
	
	}

	@RequestMapping(value="join",
			method=RequestMethod.POST,
			produces="text/plan;charset=utf8")	
	public String join(@ModelAttribute MemberVO memberVO) {

		log.debug(memberVO.toString());
		/*
		 * memberVO의 비밀번호 항목을 암호화 할  것이다.
		 * 
		 */
		// 1. 일반적인 class 사용법대로 암호화 객체 생성
		// 생성자에 4부터 31까지 임의의 정수를 포함할수 있고
		// 생략할 경우 10이 적용된다.
		// 스프링에서는 16의 값을 권장한다.
		// >> 내부에서 해쉬함수를 이용해서 암호화를 하는데
		// 		16번 반복하고 그중에서 임의 값을 선택하라
		// BCryptPasswordEncoder bcrypt 
		// 	= new BCryptPasswordEncoder(16);
		
		String bcPassword = passwordEncoder.encode(memberVO.getM_password());
		memberVO.setM_password(bcPassword);
		
		mService.insert(memberVO);
		return "redirect:/";
		
	}
	
	@ResponseBody
	@RequestMapping(value="id_check",
		method=RequestMethod.POST,
		produces="text/html;charset=utf8")
	public String id_check(@RequestParam String m_userid) {
		String ret = "";
		
		MemberVO vo = mService.findById(m_userid);
		
		if(vo == null) ret = "사용할 수 있는 ID 입니다";
		else ret = "이미 등록된 ID 입니다";
		return ret;
	}
	
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member-home");
		mv.addObject("BODY","LOGIN-FORM");
		return mv ;
	}

	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(Model model, String LOGIN) {
		
		model.addAttribute("BODY","LOGIN-FORM");
		model.addAttribute("LOGIN",LOGIN);
		return "member-home" ;
	}
	
	/*
	 * 로그인, 로그아웃을 처리할 method에는 
	 * HttpSessio 클래스를 매개변수로 설정 해 두어야 한다.
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(HttpSession session, 
				@ModelAttribute MemberVO memberVO,
				Model model) {

		// memberVO에는 로그인 폼에서 
		// 입력한 id와 비밀번호만 담겨 있을 것이다.
		String userid = memberVO.getM_userid();
		String password = memberVO.getM_password();
		
		System.out.println(userid);
		System.out.println();
		
		// userid로 DB 조회를 해서 사용자 정보를 추출
		List<MemberVO> mList = mService.loginCheck(userid);

		// BCryptPasswordEncoder bcrypt 
		// = new BCryptPasswordEncoder(16);
		
		// mList에는 userid에 해당하는 사용자(들)이 포함되 있다.
		boolean login_ok = false;
		if(mList != null) {
			for(MemberVO vo : mList) {
				
				// vo.m_passsword에 담겨있는 비밀번호는 Bcrypt 암호문이다
				// 이 암호문을 로그인 폼에서 입력한 비밀번호와
				// == 이나 equels() 으로는 비교할 수 없다.
				// 그래서 BCrypt... 클래에 있는 암호 비교 method를 통해서 
				// 값을 비교해 해야 한다.
//				if(vo.getM_password() == password) {
				System.out.println("p1:" + vo.getM_password());
				//						   평문	    DB저장된 암호문
				if(passwordEncoder.matches(password,vo.getM_password())) {				
					login_ok = true;
					break;
				}
			}
		}
	
		String ret = "redirect:/";
		// 여기에서 login_ok 값 ?
		if(!login_ok) {
			// login에 실패했다는 가정을하고
			// LOGIN이라는 속성에 FAIL 이라는 문자열을 싣는다.
			model.addAttribute("LOGIN","FAIL");
			ret = "redirect:login";
		}
		return ret ; // 다시 login GET로 보내기
	}
}
