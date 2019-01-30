package com.biz.sp007;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Ŭ���� �̸��� @Controller Annotation�� �����ϸ�
// ������Ʈ�� �ٽ� ���� �� �ָ�
// tomcat�� �ش� Ŭ������ Controller�� �ν��� �ϰ�
// req�� ó���� �غ� �Ǿ� �ִٰ� �Ǵ����Ѵ�.

@Controller
public class MyController {

	@RequestMapping(value="calc",method=RequestMethod.GET)
	public String calc() {
		return "calc_form";
	}
	
	/*
	 *  jsp������ form�� input box���� �����ϰ�
	 *  �� input box�鿡 name �Ӽ��� �������ְ�
	 *  ���������� box�� ���ڿ��� �Է��� �� ������ �ϸ�
	 *  
	 *  �� ������ ������ ��� ���� ������ �ǰ�
	 *  Controller�� method�� �Ű��������� ���� �̸����� �������ָ�
	 *  
	 *   form�� ������ �����͸� ���� �� �ִ�
	 */
	@RequestMapping(value="calc",method=RequestMethod.POST)
	public String calc1(Model model,
			String txt_num3, 
			String txt_num1, 
			String txt_num2) {
		
		int intNum1 = Integer.valueOf(txt_num1);
		int intNum2 = Integer.valueOf(txt_num2);
		int intSum = intNum1 + intNum2;
		
		model.addAttribute("SUM",intSum);
		model.addAttribute("NUM1",intNum1);
		model.addAttribute("NUM2",intNum2);
		LocalDate ld = LocalDate.now();
		model.addAttribute("TODAY", ld.toString());
		
		System.out.printf("%d + %d = %d\n", intNum1, intNum2, intSum);
		
		System.out.println("txt_num1 : " + txt_num1);
		System.out.println("txt_num2 : " + txt_num2);
		System.out.println("txt_num3 : " + txt_num3);
		
		return "calc_result";
	
	}
	
}
