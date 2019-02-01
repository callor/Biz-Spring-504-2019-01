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
import com.biz.memo02.vo.MemoVO;

@Controller
public class MemoController {
	
	// ���ݺ��� memoService�� ����Ҽ� �ֵ���
	// �ʱ�ȭ �۾��� ������ �ξ��
	@Autowired
	// Service Ŭ������ ����ϱ� ���ؼ� ����
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
		return "home";
	}
	
	@RequestMapping("memo_view")
	public String memo_view(@Param("id") long id,
				String MSG, 
				Model model) {
		
		// �Ű������� ���޹��� id�� ����ؼ�
		// �����͸� �о� ����
		// memo_view�� ������ ó��
//		System.out.print(id);
		MemoVO vo = memoService.getMemo(id);
		
		model.addAttribute("MSG",MSG);
		model.addAttribute("MEMO", vo);
		model.addAttribute("BODY","VIEW");
		
		return "home" ;
	
	}
	
	
	// ���� ���� ����� reqPath
	// �޴����� �޸��ۼ��� Ŭ���ϸ� ȣ��� reqPath
	@RequestMapping(value="memo",method=RequestMethod.GET)
	public String memo(Model model) {
		
		model.addAttribute("BODY","WRITE");
		return "home";
	}

	// ������ ���� �����͸� ���� ������ ����� reqPath
	@RequestMapping(value="memo",method=RequestMethod.POST)
	public String memo(@ModelAttribute MemoVO vo, Model model) {
		
		// form���� ���� ���� �����͸�
		// Service���� �����Ͽ� � ����(����)�� ������ ��
		// DB�� �����ϵ��� ����
		
		String retMsg = "" ;
		String resPath = "" ;
		// int ret = memoService.insertDB(vo);
		int ret = memoService.writeDB(vo);
		
		if(ret > 0) { // ���������� insert �Ϸ�
			resPath = "redirect:memo_home";
		} else {
			retMsg = "������ �߰� ����";
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