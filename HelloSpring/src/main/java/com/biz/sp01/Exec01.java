package com.biz.sp01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Exec01 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		����VO[] ���� = new ����VO[4];
		for(int i = 0 ; i < 4 ; i++) {
			����[i] = new ����VO();
		}

		����[0].���� = "���ѹα�";
		����[0].���� = 1;
		
		����[1].���� = "�̱�";
		����[1].���� = -1;

		����[2].���� = "�ҷ�";
		����[2].���� = -1;

		����[3].���� = "����";
		����[3].���� = -1;
		
		Collections.shuffle(Arrays.asList(����));
		
		System.out.println("������ ������ ������ �����");
		for(int i = 0 ; i < 4 ; i++) {
			System.out.println((i+1) + ����[i].����);
		}
		Scanner scan = new Scanner(System.in);
		System.out.print("���� >>");
		String strN = scan.nextLine();
		
		int intN = Integer.valueOf(strN);
		
		if(����[intN - 1].���� == 1) {
			System.out.println("�� ���߾��");
		} else {
			System.out.println("�װ͵� �𸣴�");
		}
		
		

		
		
		
	}

}
