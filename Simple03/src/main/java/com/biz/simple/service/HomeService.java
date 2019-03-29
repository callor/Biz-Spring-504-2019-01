package com.biz.simple.service;

import org.springframework.stereotype.Service;

// bean등록
@Service
public class HomeService {

	public int calc(String num1, String op, String num2) {
		// TODO Auto-generated method stub
		
		int intSum = 0;
		
		// 브라우져에서 보내온 num1과 num2를 숫자로 변환하려고 했더니
		// 문자열이 있다.
		// 문자열이 포함되어 있으면 무시해 버려라
		try {
			
			int intNum1 = Integer.valueOf(num1);
			int intNum2 = Integer.valueOf(num2);

			if(op.equals("P")){
				intSum = intNum1 + intNum2;
			}
			if(op.equals("T")) {
				intSum = intNum1 * intNum2;
			}
			if(op.equals("M")) {
				intSum = intNum1 - intNum2;
			}
			
			
		} catch (Exception e) {
			
		}
		
		System.out.println(num1);
		System.out.println(op);
		System.out.println(num2);
		
		return intSum;
	
	}

}
