package com.biz.memo01.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo01.model.MemoVO;
import com.biz.memo01.service.MemoService;

@Controller
public class MemoController {

	@Autowired
	MemoService memoService;
	
	@RequestMapping("memo")
	public String memo(Model model) {
		// return "memoHome" ;
		List<MemoVO> memoList = memoService.selectAll();
		model.addAttribute("memoList", memoList);
		return "memo_list";
	}
	
	@RequestMapping("memo_view")
	public String memo_view(String id,Model model) {
		
		MemoVO vo = memoService.findById(Long.valueOf(id));
		model.addAttribute("MEMO", vo);
		return "memo_view";
	
	}
	
	@RequestMapping(value="memo_write", method = RequestMethod.GET)
	public String memo_write(Model model) {
		
		// 1.7 ���Ϲ���
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String today = sf.format(date);
		
		// 1.8 �̻󿡼�
		LocalDate localDate = LocalDate.now();
		today = localDate.toString();
	
		MemoVO vo = new MemoVO();
		vo.setM_date(today);
		
		model.addAttribute("MEMO",vo);
		return "memo_write_form";
	
	}

	@RequestMapping(value="memo_write", method = RequestMethod.POST)
	public String memo_write(@ModelAttribute MemoVO vo) {
		
		memoService.memo_write(vo);
		// memoService.insert(vo);
		// System.out.println(vo);
		// Mapper Method���� ���ڿ��� return �ϸ�
		// /WEB-INF/views ������ �ִ� jsp ������ �о 
		// �������� �ϵ��� �⺻������ ���� �Ǿ� �ִ�.
		//
		// ���ڿ��� ������ redirect: ���� �ϸ�
		// spring�� views�� response�ϴ� ��ſ�
		// ������ req �ּҸ� �����Ѵ�.
		return "redirect:memo";
		// returm "memo" ;
	}
	
	
	@RequestMapping("memo_update")
	public String memo_update(String id,Model model) {
		MemoVO vo = memoService.findById(Long.valueOf(id));
		
		model.addAttribute("MEMO", vo);
		return "memo_write_form" ;
		
	}
	
	@RequestMapping("memo_delete")
	public String memo_delete(String id) {
		
		int ret = memoService.delete(Long.valueOf(id));
		return "redirect:memo" ;
		
	}

	
	
}
