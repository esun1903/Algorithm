package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_SW_1952_수영장 {

	private static int T;
	private static int[] cost;
	private static int[] month;
	private static int result;
	private static boolean[]visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		for (int testCase = 1; testCase <= T; testCase++) {

			// 1일 이용권의 요금, 1달 이용권의 요금 , 3달 이용권의 요금 , 1년 이용권의 요금
			cost = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
         
			// 1월부터 12월까지의 이용 계획이 주어진다.
			month = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}

			// 이용 계획대로 수영장을 이용하는 경우 중 가장 적게 지출하는비용이다.
			dfs();
           System.out.println("#"+testCase+" "+month[12]);
		} // end of testcase
       
	}// end of main

	private static void dfs() {
		for (int i = 1; i <=12; i++) {
			int one = month[i-1] + month[i] * cost[0];  // 1일 계산 
 			int two = month[i-1] + cost[1]; //1월계산 
            int three = month[i-1] + cost[2] ; // 3월 뒤 	
            int prethree = 0;  // 3월 앞 계산 
            if( i>2) {
            	prethree  =month[i-3] + cost[2];
            }
            else {
            	prethree = cost[2];
            }
			int year = cost[3]; 
		    month[i] = Math.min(one, Math.min(two, Math.min(three, Math.min(prethree, year))));
	}
	}

}// end of class
