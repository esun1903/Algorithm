package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2309 {

	public static int[] nanjang = new int[9];
	public static StringBuilder sb;

	public static boolean [] visit = new boolean  [9]; 
	public static int [] result = new int [7];
	public static void combination(int n, int m, int sum) {

	   // 내가 원하던 조합의 수가 나왔을 때에 대한 것을 if문으로 작성한다.
		if( m  == 7) {
			if(sum == 100) {
			
				for(int i  = 0 ,index = 0; i< 9; i++) {
					if(visit[i] == true) {
						result[index] = nanjang[i];
						index ++; 
					}
				}
				return; 
			}
			return; 
		}
		if(n>=9 )return ; 
		//만약, 7이 넘지 않았다면 
        visit[n] = true; 
        combination(n+1, m+1, sum+nanjang[n]);
        visit[n] = false;
        
        combination(n+1, m, sum);
     
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			nanjang[i] = Integer.parseInt(br.readLine());
		}
         
		Arrays.sort(nanjang);
		combination(0, 0, 0);
		Arrays.sort(result);
       for (int i = 0; i < result.length; i++) {
		 System.out.println(result[i]);
		 
	}
		
	}

}
