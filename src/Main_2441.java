package com.algorithm.a;

import java.util.Scanner;

public class Main_2441 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
 
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();//5
	    
	   	int i=0;
	   	int index = 0;
	   	for(i=N; i>0;i--) { //N만큼 별찍어야함 
	   		for(int k=0;k<index;k++) { 
	   			System.out.print(" ");
	   		}
	   		for(int j =0;j<i;j++) {
	   			System.out.print("*");
	   		}
	   		
	   		System.out.println();
	   		index++;
	   	}
	}

}
