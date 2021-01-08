package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.rmi.ConnectIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2605 {

	/*
	 * 점심시간이 되면 반 학생 모두가 한 줄로 서서급식을 탄다. 그런데 매일 같이 앞자리에 앉은 학생들이 앞에 줄을 서 먼저 점심을 먹고,
	 * 뒷자리에 앉은 학생들은 뒤에 줄을 늦게 점심을 먹게된다. 선생님이 이를 위해 한 가지 방법을 내놓았다. 그 방법은 다음과 같다. 학생들이
	 * 한 줄로 줄을 선 후, 첫 번쨰 하갯ㅇ부터 차례로 번호를 뽑는다. 1) 첫 번째로 줄을 선 학생은 무조건 0번을 받아 제일 압줄에 선다.
	 * 2) 두 번쨰로 줄을 선 학생은 0번 또는 1번 둘 중 하나의 번호를 뽑는다. -> 0번을 뽑ㅇ으면 그 자리에 그대로 있고, 1번을 뽑으면
	 * 바로 앞의 학생 앞으로 가서 줄을 선다. 3) 세번 쨰로 줄을 선 학생은 0,1 또는 2 중 하나의 번호를 뽑는다. 그리고 뽑은 번호 만큼
	 * 앞자리로 가서 줄을 선다. ... 마지막에 줄을 선 학생까지 이와 같은 방식으로 뽑은 번호만큼 앞으로 가서 줄을 서게 된다. 각자 뽑은
	 * 번호는 자신이 처음에 선 순서보다는 작은 수이다.
	 * 
	 * 예를들어 5명의 학생이 줄을 서고 ,첫 번쨰로 줄을 선 학생부터 다섯 번째로 줄을 선 학생까지 차례로 0,1,1,3,2번의 번호을 뽑았다고
	 * 하자. 첫 번째 학생부터 다섯 번째 학생까지 1 부터 5로 표시하면 학생ㅇ들이 줄을 선 순서는 다음과 같다. 첫 번쨰ㅇ 학생이 번호를 뽑은
	 * 후 : 1 두 : 2 1 세 : 2 3 1 네 : 4 2 3 1
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		int[] result = new int[N + 1];

		// 입력받기
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		    result[i] =i; 
		}

		// 구현하기 -> N-1까지 가는데 인덱스 i가 0일 경우 ! -> 0이라면 인덱가
		for (int i = 1; i <= N; i++) {


			if (arr[i] == 0) {
	            continue;
			} else {
				//반복문 
				for (int j = arr[i]+1; j > 1; j--) { //arr[i] + 1 : 2이고 j가 1보다 클떄까지 한번만 반복 
				   
					int x = i-1; 
				   arr[i-1] = i;
				   arr[i] = x;
				   
				   
				   result[i-1]= i; 
				   result[i] = x; 

					
				}
			}
		}
		for (int i = 1; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}// end of main

}
