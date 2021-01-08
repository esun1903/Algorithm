package com.algorithm.a;


import java.util.Scanner;


public class Main_10872 {
	public static void main(String[] args) {
		//재귀로 풀기 
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();//10
        
		System.out.println(Factorial(N));
	}

	  public static int Factorial(int n ) {
		if(n==1 || n ==0 ) {
			return 1;
		}
		
		
		return n * Factorial(n-1);
	}
}
