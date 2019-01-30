package com.biz.sp007;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	// RequestMapping�� �ܼ��� ���ڿ��� setting�ϸ�
	// req(��û)�ϴ� ����� GET�̰ų� POST �̰ų�
	// ������� �۵��Ǿ�� �ϴ� ����
	@RequestMapping("home")
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	// method=...GET �̶�� setting�� �ϸ�
	// req�ϴ� ����� GET �ϰ�쿡��
	// �۵��Ǿ�� �ϴ� ����
	// req�� GET �ΰ�� : 
	//		�������� �ּ�â�� �����Է��� �ϰ�
	//		Enter�� ������ ��찡 �ش�
	//
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String calc() {
		return "calc_form";
	}
	
}
