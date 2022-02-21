package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2563 {

	private static int[][] arr;
	public static int result = 0;

	public static void main(String[] args) throws IOException {

		/*
		 * 가로, 세로의크기가 각각 100인 정사각형 모양의 흰색 도화지가 있따. 이 도화지 위에 가로 , 세로의 크기가 각각 10인 정사각형 모양의
		 * 검은색 색종이는 색종이의 변과 도화지의 변이 평행하도록 붙인다. 이러한 방식으로 색종이를 한 장 또는 여러 장 붙인후 검은 영역의 넓이를
		 * 구하는 프로그램을 작성하시오
		 * 
		 * 
		 * 입력) 첫째 줄에 색종이의 수가 주어진다. 이어 둘째 줄부터 한 줄에 하나씩 색종이를 붙인 위치가 주어진다. 색종이를 붙인 위치는 두 개의
		 * 자연수 로 주어진는데 첫 번쨰 자연수는 색종이의왼쪽 변과 도화지희 왼쪽 변 사이의 거리이고 두 번쨰 자연수는 색종이의 아래쪽 변과 도화지의
		 * 아래쪽 변 사이의 거리이다.
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		arr = new int[N][2];
		
		int[][] map;
		boolean[][] nesting;
		int min = 0;
		int max = 0;
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			if (min > arr[i][0])
				min = arr[i][0];
			else if (min > arr[i][1])
				min = arr[i][1];
			if (max < arr[i][0])
				max = arr[i][0];
			else if (max < arr[i][1])
				max = arr[i][1];
		}

	
		map = new int[max + 100][max + 100];
		nesting = new boolean[max + 100][max + 100];
		for (int i = 0; i < N; i++) {
			int x = arr[i][0]; // 3
			int y = arr[i][1]; // 7

			for (int f = y; f < y + 10; f++) { // 7 -> 17
				for (int d = x; d < x + 10; d++) { // 5 -> 15
					map[f][d] = 1; 
				}
			}

		}

	
		
for (int i = 0; i < max + 100; i++) {
	for(int j = 0; j<max + 100; j++) {
		 if(map[i][j]==1) {
			 result++;
		 }
	}
	
}

System.out.println(result);
	} //end of main
}
