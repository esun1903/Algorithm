package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_11650_좌표정렬하기 {

	public static void main(String[] args) throws IOException {
		 
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int N = Integer.parseInt(st.nextToken());
		String arr[][] = new String [N][2];
		for (int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] =st.nextToken();	
		} // end of for
		

		Arrays.sort(arr,new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				if(o1[0].equals(o2[0])) { // x좌표가 같다면 
					return  Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
				}
				else {
					return  Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
				}
			}
		});
		
		 for (int i = 0; i < N; i++) {
			System.out.println(arr[i][0]+" "+arr[i][1]);
		}
	
	}// end of main

}// end of class
/* 2차원 평명 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로
 * x좌표가 같으면 y좌표가 증가하는 순으로 정렬한 다음 출력하는 프로그램을 작성하시오
 * 
 *  입력) 첫쨰 줄에 점의 개숙 ㅏ주어진다 둘째 줄부터 N개의 줄에는 i번점의 위치
 *  xi와 yi가 주어진다 . */
