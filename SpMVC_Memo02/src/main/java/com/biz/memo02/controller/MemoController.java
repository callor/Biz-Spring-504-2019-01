package com.biz.memo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo02.service.MemoService;
import com.biz.memo02.vo.MemoVO;

@Controller
public class MemoController {
	
	// 지금부터 memoService를 사용할수 있도록
	// 초기화 작업을 수행해 두어라
	@Autowired
	// Service 클래스를 사용하기 위해서 선언
	MemoService memoService;
		
	/*
	public MemoController() {
		// TODO Auto-generated constructor stub
		memoService = new MemoService();
	}
	*/
	
	
	// 폼을 열때 사용할 reqPath
	// 메뉴에서 메모작성을 클릭하면 호출될 reqPath
	@RequestMapping(value="memo",method=RequestMethod.GET)
	public String memo() {
		return "memo_write";
	}

	// 폼으로 부터 데이터를 전달 받을때 사용할 reqPath
	@RequestMapping(value="memo",method=RequestMethod.POST)
	public String memo(@ModelAttribute MemoVO vo, Model model) {
		
		// form으로 부터 받은 데이터를
		// Service에게 전달하여 어떤 가공(연산)을 수행한 후
		// DB에 저장하도록 실행
		
		String retMsg = "" ;
		String resPath = "" ;
		int ret = memoService.insertDB(vo);
		
		if(ret > 0) { // 정상적으로 insert 완료
			resPath = "redirect:/";
		} else {
			retMsg = "데이터 추가 오류";
			resPath = "memo_write";
		}
		
		model.addAttribute("MESSAGE", retMsg);
		return resPath;
	
	}

	
	
}
