package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.iolist.model.DeptVO;
import com.biz.iolist.service.DeptService;
/*
 * 거래처관리 컨트롤러
 */
@SessionAttributes("deptVO")
@Controller
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
	DeptService deptService;

	// deptVO SessionAttribute를 생성할 초기화 method 를 만든다
	// Session deptVO 아예 없거나, 내용이 제거되었을경우 실행되어서
	// depVO를 새로 만들어주는 method
	@ModelAttribute("deptVO")
	public DeptVO newDeptVO() {
		DeptVO deptVO = new DeptVO();
		deptVO.setD_code(deptService.getDCode());
		return deptVO;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		
		List<DeptVO> deptList = deptService.selectAll();
		model.addAttribute("LIST", deptList);
		model.addAttribute("BODY", "D_LIST");
		return "home";
		
	}
	
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String write(
			@ModelAttribute("deptVO") DeptVO deptVO, 
					Model model) {

		model.addAttribute("deptVO", deptVO);
		model.addAttribute("BODY", "D_WRITE");
		return "home";
		
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String write(
			@ModelAttribute("deptVO") DeptVO deptVO, 
				Model model,SessionStatus session) {
	
		// TODO insert 테스트 케이스
		// deptService 클래스의 insert method를 수행하는데
		// 조건 : deptVO 객체를 매개변수로 전달하고
		// 결과 : tbl_dept 테이블에 해당 데이터가 저장되도록 한다.
		int ret = deptService.insert(deptVO);

		if(ret > 0) { // 정상적으로 insert가 수행되었다
			session.setComplete();
			return "redirect:/dept/list";
		} else {
			// insert가 정상적으로 수행되지 않으면
			// 다시 입력 폼으로 되돌아 간다.
			model.addAttribute("deptVO", deptVO);
			model.addAttribute("BODY", "D_WRITE");
			return "home";
		}
		
		// model.addAttribute("MSG","데이터 추가 성공!!!");
		// return "home";
	
	}
	
	@ResponseBody
	@RequestMapping(value="get_new_code",method=RequestMethod.GET)
	public String getNewCode() {
		return deptService.getDCode();
	}

	@ResponseBody
	@RequestMapping(value="get_d_name",method=RequestMethod.GET,
					produces="text/plan;charset=utf8")
	public String getDName(@RequestParam("d_code") String d_code) {
		return deptService.getDName(d_code);
	}


}
