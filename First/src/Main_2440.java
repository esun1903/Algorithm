package com.algorithm.a;

import java.util.Scanner;

public class Main_2440 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=N; i>0; i--) {
			
			for(int j=0;j<i;j++)
				System.out.print("*");
		 
			System.out.println();
		}
	}

}
