package com.algorithm.a;

import java.util.Scanner;

public class Main_2442 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int count;
		int index = N-1; //
		//1 = 1, 2 = 3, 3 = 5, 4 = 7 ~ 
		for (int i = 0; i < N; i++) { //0부터 5까지 <공백의수 4:1 > <공백의 수 3:3>~ 
			count = 2 * (i+1) - 1;  // 
			
			for(int k=0;k<index;k++) {  //공백의 수 N-1에서 점점 줄여나가기
	   			System.out.print(" ");
	   		}
	   		for(int j =0;j<count;j++) { //
	   			System.out.print("*");
	   		}
	   	      index--;
	   		System.out.println();
		}
	}

}
