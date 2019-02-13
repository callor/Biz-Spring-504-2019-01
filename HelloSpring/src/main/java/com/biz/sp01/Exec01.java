package com.biz.sp01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Exec01 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		문항VO[] 문항 = new 문항VO[4];
		for(int i = 0 ; i < 4 ; i++) {
			문항[i] = new 문항VO();
		}

		문항[0].문항 = "대한민국";
		문항[0].정답 = 1;
		
		문항[1].문항 = "미국";
		문항[1].정답 = -1;

		문항[2].문항 = "소련";
		문항[2].정답 = -1;

		문항[3].문항 = "영국";
		문항[3].정답 = -1;
		
		Collections.shuffle(Arrays.asList(문항));
		
		System.out.println("다음중 서울이 수도인 나라는");
		for(int i = 0 ; i < 4 ; i++) {
			System.out.println((i+1) + 문항[i].문항);
		}
		Scanner scan = new Scanner(System.in);
		System.out.print("선택 >>");
		String strN = scan.nextLine();
		
		int intN = Integer.valueOf(strN);
		
		if(문항[intN - 1].정답 == 1) {
			System.out.println("참 잘했어요");
		} else {
			System.out.println("그것도 모르니");
		}
		
		

		
		
		
	}

}
