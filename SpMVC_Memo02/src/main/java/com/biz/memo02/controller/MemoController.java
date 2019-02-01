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
	
	
	// ���� ���� ����� reqPath
	// �޴����� �޸��ۼ��� Ŭ���ϸ� ȣ��� reqPath
	@RequestMapping(value="memo",method=RequestMethod.GET)
	public String memo() {
		return "memo_write";
	}

	// ������ ���� �����͸� ���� ������ ����� reqPath
	@RequestMapping(value="memo",method=RequestMethod.POST)
	public String memo(@ModelAttribute MemoVO vo, Model model) {
		
		// form���� ���� ���� �����͸�
		// Service���� �����Ͽ� � ����(����)�� ������ ��
		// DB�� �����ϵ��� ����
		
		String retMsg = "" ;
		String resPath = "" ;
		int ret = memoService.insertDB(vo);
		
		if(ret > 0) { // ���������� insert �Ϸ�
			resPath = "redirect:/";
		} else {
			retMsg = "������ �߰� ����";
			resPath = "memo_write";
		}
		
		model.addAttribute("MESSAGE", retMsg);
		return resPath;
	
	}

	
	
}
