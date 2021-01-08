package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2475_검증수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0; 
		for (int i = 0; i <5; i++) {
			int n = Integer.parseInt(st.nextToken());
			sum += n*n;
		}
		
		int result = sum%10; 
		System.out.println(result);
	}

}

/*
 * 컴퓨터를 제조하는 회사인 KOI 전자에서는 제조하는 컴퓨터마다 
 * 6자리의 고유번호를 매긴다. 고유번호의 처음 5자리에는 0000부터 
 * 999999까지의 수 중 하나가 주어지며 6번쨰 자리에는 검증수가 들어간다
 * 검증수는 고유번호의 처음 5자리에 들어가는 5개의 숫자를 각각 제곱한 수의 합을
 * 10으로 나눈 나머지이다. 
 * 예를 들어 고유번호의 처음 5자리의 숫자들이 빈칸을 사이에 두고 하나씩 주어진다. 
 * 
 *  출력) 첫째 줄에 검증수를 출력한다. 
 *  
 *  */
 