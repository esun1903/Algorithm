package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1085_직사각형에서탈출 {

	public static void main(String[] args) throws IOException {
	  
	 /* 한수는 지금 (x,y)에 있다. 직사각형의 왼쪽 아래 꼭짓점은 
	  * (0,0)에 있고 오른쪽 위 꼭짓점은 (w,h) 에 있다 직사각형의 경곗선까지 가는 거리의
	  * 최솟값을 구하는 프로그램을 작성하시오 
	  * 
	  * 입력) 첫째 줄에 x,y,w,h가 주어진다
	  * 출력) 첫째 줄에 문제의 정답을 출력한다. */
 
		 BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 int x = Integer.parseInt(st.nextToken());
		 int y = Integer.parseInt(st.nextToken());
		 int w = Integer.parseInt(st.nextToken());
		 int h = Integer.parseInt(st.nextToken());
		 
		 int xw =  w-x<x ? w-x : x; 
		 int yh = h-y <y? h-y : y; 
		 int answer = xw < yh ? xw : yh;
		 
		 System.out.println(answer);
	}

}
