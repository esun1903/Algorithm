package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW_9229_한빈이와SpotMart {

	public static void main(String args[]) throws Exception {
	
		Scanner sc = new Scanner(System.in);
	
		int T = sc.nextInt();
		int N; int M;int N_arr[];int result = 0 ;
		int max;  
		for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();
          
            max = -1;
            N_arr = new int [N];
            
            //입력받기 
            for(int i = 0; i<N; i++) {
            	N_arr[i] = sc.nextInt();
            }
            
            //정확히 두개야되고 , m을 넘어서는 안된다.
            //조합 (N*(N-1))/2 
          
            for(int i = 0; i<N_arr.length;i++ ) {
            	for(int j = i+1; j<N_arr.length; j++) {
            		int result1 = N_arr[i]+ N_arr[j];
            
            		if(result1<=M && result1 > max)  //
            			max = result1;
            
            }

		}
          
		System.out.println("#"+test_case+" "+max);
	}
}
}
