package com.biz.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.file.model.MemberVO;

/*
 * Controller에 RequestMapping을 설정하면
 * 페이지를 호출할 주소를 그룹으로 묶어서 관리할 수 있다.
 * 단, Mapping 주소 앞에 반드시 / 로 시작해야 한다.
 */
@Controller
@RequestMapping("/member")
/*
 * @SessionAttributes는 @ModelAttribute로 선언된 객체를
 * Session 정보 안에 포함시켜서
 * 서로다른 method에서 값을 참조할수 있도록 도와주는 지시어
 */
@SessionAttributes({"memberVO"})
public class MemberController {
	
	/*
	 * 이 컨트롤러 내에 있는 어떤 method에서
	 * @ModelAttribute("memberVO")라는 코드가 있는데
	 * memberVO라는 객체 혹시 생성이 안되어서
	 * null 값이면 해당 객체를 생성(new)해서 사용가능한 상태로
	 * 만들어라 하는 지시어
	 */
	@ModelAttribute("memberVO")
	public MemberVO newMemberVO() {
		// return new MemberVO();
		MemberVO vo = new MemberVO();
		// vo.setM_userid("test");
		return vo;
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(@ModelAttribute("memberVO") MemberVO memberVO) {
		return "body/join_form";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(
			@ModelAttribute("memberVO") MemberVO memberVO,Model model) {
		return "body/join_form";
	}
	
	
	
	
	
	
	@RequestMapping(value="/join1",method=RequestMethod.GET)
	public String join(Model model) {

		// memberVO를 생성해서
		// form:form tag로 이루어진 폼에 비어있는 데이터를
		// 덫씌워서 새로 작성하는 화면으로 구성
		MemberVO vo = new MemberVO();
		model.addAttribute("memberVO",vo);
		return "body/join_form";
	}
	
	@RequestMapping(value="/join2", method=RequestMethod.GET)
	public String join() {
		return "body/join_form";
	}
	
	
	
}
