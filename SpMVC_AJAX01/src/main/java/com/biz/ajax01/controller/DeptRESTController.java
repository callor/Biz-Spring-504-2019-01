package com.biz.ajax01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biz.ajax01.model.DeptVO;
import com.biz.ajax01.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DeptRESTController {
	
	@Autowired
	DeptService dService;
		
	// @ResponseBody
	@RequestMapping(value="hello",
			method=RequestMethod.GET,
			produces="text/plan;charset=utf8")
	public String testREST() {
		return "반갑습니다";
	}
	
	@RequestMapping(value="dept.array",
			method=RequestMethod.POST,
			produces="text/plan;charset=utf8")
	public String dept(@RequestParam List<String> deptList) {
		for(String s : deptList) {
			log.debug(s);
		}
		return "데이터 수신 OK!!";
	}

	
	/*
	 * form에서 값을 보내고 Controller 에서 VO에 받을때
	 * 		@ModelAttribute로 설정
	 * GET방식으로 1개(2개)의 변수를 보내고 Controller에서 
	 * 		개별 변수에 받을때 @RequestParam으로 설정
	 * 
	 * Ajax를 통해서 JSON형식의 배열로 데이터를 보내고
	 * Controller에서 List<VO>받을때
	 * 		@RequestBody로 설정
	 */
	@RequestMapping(value="dept.json.array",
			method=RequestMethod.POST,
			produces="text/plan;charset=utf8")
	public String dept_json(
			@RequestBody List<DeptVO> deptList) {
		for(DeptVO vo : deptList) {
			log.debug(vo.toString());
		}
		return "데이터 수신 OK!!";
	
	}

	
	
	@RequestMapping(value="dept.list",
			method=RequestMethod.POST,
			produces="text/plan;charset=utf8")
	public String dept_list(@RequestParam 
			@ModelAttribute List<DeptVO> deptList) {
		
		for(DeptVO v: deptList) {
			log.debug(v.getD_ceo());
		}
		return "데이터 수신 OK!!";
	}

	@RequestMapping(value="dept_save",
				method=RequestMethod.POST,
				produces="text/plan;charset=utf8")
	public String dept_save(@ModelAttribute DeptVO deptVO) {
	
		int ret = dService.save(deptVO);
		if(ret > 0) return "데이터 저장 OK";
		else return "데이터 저장 실패!!!";
	
	}

	
	
}
