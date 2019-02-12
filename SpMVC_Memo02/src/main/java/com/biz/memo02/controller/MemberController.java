package com.biz.memo02.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo02.service.MemberService;
import com.biz.memo02.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService mService;

	@RequestMapping(value="member",method=RequestMethod.GET)
	public String member(Model model) {

		model.addAttribute("CITIES",mService.getCities());
		model.addAttribute("HOBBIES", mService.getHobbies());
		
		model.addAttribute("BODY","MEMBER_JOIN");
		
		
		MemberVO vo = new MemberVO();
		
		// ȸ������ �����Ҷ�
		// DB���� ���� ���� form�� setting�ϴ� ������ ����� ����
		vo.setM_city("JEJU");
		vo.setM_hobby(new String[]{"MOUNT","MOVIE"});
		
		model.addAttribute("memberVO",vo);
		
		return "home" ;
	
	}
	
	/*
	 * @ModelAttribute Annotation�� form���� ���� ���۵Ǿ��
	 * �����͵��� VO�� �ڵ����� mapping ��Ű�� command Annotation�̴�
	 * 
	 * �� Annotation�� �ݵ�� VO �տ� ��ġ ���Ѿ� �Ѵ�.
	 * 
	 * ���� Model �տ� ������ �ȵȴ�.
	 */
	@RequestMapping(value="member",method=RequestMethod.POST)
	public String member(Model model, 
			@ModelAttribute MemberVO memberVO ) {

		mService.insert(memberVO);
		
		model.addAttribute("BODY","MEMBER-VIEW");
		model.addAttribute("MEMBER", memberVO);
		return "home";
	
	}

	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("BODY","LOGIN");
		model.addAttribute("memberVO", new MemberVO());
		return "home";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@ModelAttribute MemberVO memberVO, 
			Model model, HttpSession session) {
		
		/*
		 * ������ userCheck���� vo�� �����ϰ�
		 * Dao�� userChek�� ����ؼ� id�� password�� ��ȸ�ϰ�
		 * ����� return �޾Ƽ� vo�� ��Ҵ�.
		 * 
		 * ���� id�� password�� ��ġ�ϸ�
		 * vo�� member �����͸� ���� ���� ���̰�
		 * �׷��� ������ null���� ���� �ȴ�.
		 * 
		 *  ��,vo�� null�̸� login ����
		 *  �Ƹ� �α��� ������ �ȴ�.
		 * 
		 */
		String ret = "";
		MemberVO vo = mService.userCheck(memberVO);
		if(vo == null) {
			ret = "�α��� ����";
		} else {
			ret = "�α��� ����";
			session.setAttribute("LOGIN", vo);
		}
		
		System.out.println(ret);
		return "redirect:memo_home";
	
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("LOGIN");
		return "redirect:memo_home";
	}
}
