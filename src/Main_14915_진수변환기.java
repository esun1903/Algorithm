package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_14915_진수변환기 {

	private static String str = "";
	private static int cal;

	/*
	 * 정수 m, n을 입력 받아, 10진수 m을 n진수로 바꾸어 출력하는 프로그램을 작성하시오.
	 */

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken()); // 변환할 정수
		int n = Integer.parseInt(st.nextToken()); // 진법

		if (m == 0) { // 0때문에 계속 품 ,, ㅎ
			System.out.println(0);
			System.exit(0); // 여기서 StringBuilder 쓰기 
		} 
			while (m > 0) { // 변환할 정수가 0이 될때까지
				cal = m % n; // 나머지 (넣어두고 )
				if (cal >= 10)	str += (char) (cal - 10 + (int) 'A'); // 10이상이면 계산하기
				else  str += (char) (cal + (int) '0'); // 아님 걍 str에 !

				m /= n; // 나누고
			}
			// print하기 
			for (int i = str.length() - 1; i >= 0; i--) { // 출력하기
				System.out.print(str.charAt(i));
			}
		

	}

}// end of class

