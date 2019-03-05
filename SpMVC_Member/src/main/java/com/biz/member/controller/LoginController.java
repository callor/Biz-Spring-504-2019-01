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

import com.biz.member.model.MemberVO;
import com.biz.member.service.MemberService;

@Controller
public class LoginController {
	
	@Autowired
	MemberService mService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(Model model, String LOGIN_MSG) {
		
		model.addAttribute("BODY","LOGIN-FORM");
		model.addAttribute("LOGIN_MSG",LOGIN_MSG);
		return "member-home" ;
		
	}

	@RequestMapping(value="login_pop",method=RequestMethod.GET)
	public String login_pop(Model model, String LOGIN_MSG) {
		
		model.addAttribute("BODY","LOGIN-FORM");
		model.addAttribute("LOGIN_MSG",LOGIN_MSG);
		return "bodys/login-form" ;
		
	}

	

	
	@RequestMapping(value="login_ok",method=RequestMethod.POST)
	public String login_ok(@ModelAttribute MemberVO memberVO,
				Model model,
				// login과 관련된 req에는 반드시 설정해야 하는 매개변수)
				HttpSession session) {

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
		boolean login_ok = true;
		
		memberVO.setM_role("ADMIN");
		memberVO.setM_role("USER");

		session.setAttribute("LOGIN", memberVO);
	
		return "redirect:login_ok";
	}
	
	@RequestMapping(value="login_ok",method=RequestMethod.GET)
	public String login_ok() {
		
		return "bodys/login-ok";
		
	}
	
	/*
	 * 로그인, 로그아웃을 처리할 method에는 
	 * HttpSessio 클래스를 매개변수로 설정 해 두어야 한다.
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@ModelAttribute MemberVO memberVO,
				Model model,
				// login과 관련된 req에는 반드시 설정해야 하는 매개변수)
				HttpSession session) {

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
					/*
					 * login 폼에서 req된 memberVO에는
					 * m_userid와 m_password만 담긴 상태이다
					 * 그래서 DB로 부터 조회된 vo데이터를
					 * 다시 memberVO에 세팅하여
					 * 이름, 전화번호, 기타 정보를 
					 * 	조회할수 있도록 한다.
					 */
					memberVO = vo;
					memberVO.setM_role("ADMIN");
					memberVO.setM_role("USER");
					break;
				}
			}
		}
	
//		String ret = "redirect:/";
		String ret = "redirect:login_ok";

		// 여기에서 login_ok 값 ?
		// 정상적으로 login 정보가 확인되면 login_ok 값이 true일 것이다
		if(login_ok) {
			
			// 이 프로젝트가 서버에서 실행되고 있는 동안에
			// 같은 웹브라우저 페이지에서
			// req, res 중일때 어디에서나
			// LOGIN 이라는 변수를 통해서 memberVO내용을 조회
			//		할수 있게 된다.
			session.setAttribute("LOGIN_INFO", memberVO);
		
		} else {
			// login에 실패했다는 가정을하고
			// LOGIN이라는 속성에 FAIL 이라는 문자열을 싣는다.
			model.addAttribute("LOGIN_MSG","FAIL");
			ret = "redirect:login";
		}
		return ret ; // 다시 login GET로 보내기
	}

	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
		// 혹시모를 시스템에서 사용하는 세션 정보가 있을 경우에
		// login 정보만 삭제를 한다.
		session.setAttribute("LOGIN_INFO", null); // 값을 null 해서 삭제 된것처럼
		session.removeAttribute("LOGIN_INFO"); // 값을 아예 삭제
		
		// 모든 session 정보를 삭제
		session.invalidate();
		
		return "redirect:/" ;
	}
	
}
