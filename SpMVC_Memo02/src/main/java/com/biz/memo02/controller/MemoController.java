package com.biz.memo02.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo02.service.MemoService;
import com.biz.memo02.vo.MemberVO;
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
	
	@RequestMapping("memo_home")
	public String memo_list(Model model) {
		
		List<MemoVO> memoList = memoService.selectAll();
		
		model.addAttribute("MEMOS",memoList);
		model.addAttribute("BODY","LIST");
		model.addAttribute("memberVO",new MemberVO());
		return "home";
	}
	
	@RequestMapping("memo_view")
	public String memo_view(@Param("id") long id,
				String MSG, 
				Model model) {
		
		// 매개변수로 전달받은 id를 사용해서
		// 데이터를 읽어 오고
		// memo_view와 렌더링 처리
//		System.out.print(id);
		MemoVO vo = memoService.getMemo(id);
		
		model.addAttribute("MSG",MSG);
		model.addAttribute("MEMO", vo);
		model.addAttribute("BODY","VIEW");
		
		return "home" ;
	
	}
	
	
	// 폼을 열때 사용할 reqPath
	// 메뉴에서 메모작성을 클릭하면 호출될 reqPath
	@RequestMapping(value="memo",method=RequestMethod.GET)
	public String memo(Model model) {
		
		model.addAttribute("BODY","WRITE");
		return "home";
	}

	// 폼으로 부터 데이터를 전달 받을때 사용할 reqPath
	@RequestMapping(value="memo",method=RequestMethod.POST)
	public String memo(@ModelAttribute MemoVO vo, Model model) {
		
		// form으로 부터 받은 데이터를
		// Service에게 전달하여 어떤 가공(연산)을 수행한 후
		// DB에 저장하도록 실행
		
		String retMsg = "" ;
		String resPath = "" ;
		// int ret = memoService.insertDB(vo);
		int ret = memoService.writeDB(vo);
		
		if(ret > 0) { // 정상적으로 insert 완료
			resPath = "redirect:memo_home";
		} else {
			retMsg = "데이터 추가 오류";
			resPath = "home";
		}
		
		model.addAttribute("BODY", "WRITE");
		model.addAttribute("MESSAGE", retMsg);
		return resPath;
	
	}

	@RequestMapping(value="memo_update", method=RequestMethod.GET)
	public String memo_update(@Param("id") long id, Model model) {
		
		MemoVO vo = memoService.getMemo(id);
		model.addAttribute("MEMO",vo);
		model.addAttribute("BODY", "WRITE");
		return "home";
	
	}
	
	
	@RequestMapping("memo_delete")
	public String memo_delete(@Param("id") long id, Model model) {
		
		int ret = memoService.delete(id);
		String resPath = "";
		String resMsg = "";
		
		if(ret > 0) {
			resPath = "redirect:memo_home";
		} else {
			resPath = "redirect:memo_view";
			resMsg = "DEL-ERR";
		}
		model.addAttribute("id",id);
		model.addAttribute("MSG", resMsg);
		return resPath ;
		
	}
	
	
}
