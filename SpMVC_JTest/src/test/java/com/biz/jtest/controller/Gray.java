package com.biz.jtest.controller;

public class Gray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int X[] = new int[] {0,1,1,0,0 } ;
		int Y[] = new int[4];
		
		Y[0] = X[1];
		if(X[0] == 0) {
			for(int i = 1 ; i < 4 ; i++) {
				Y[i] = 1;
				if(X[i] == X[i+1]) {
					Y[i] = 0;
				}
			}
		} else {
			for(int i = 1 ; i < 4 ; i++) {
				Y[i] = 1;
				if(Y[i-1] == X[i+1]) {
					Y[i] = 0;
				}
			}
		}
		
		for(int i = 0;i < 4 ; i++) {
			System.out.print(Y[i]);
		}
		
		

	}

}
