package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {

	private static int R;
	private static int C;
	private static int[][] arr;

	public static int result = Integer.MIN_VALUE;
	public static int index = 0;

	public static void main(String[] args) throws IOException {
		/*
		 * 폴리오미노란 크기가 1 x 1 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야한다. - 정사각형은 서로 겹치면 안
		 * 된다. - 도형은 모두 연결되어 있어야 한다. - 정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
		 * 정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고하며, 다음과 같은 5가지가 있다.
		 * 
		 * 아름이는 크기가 N * M인 종이 위에 테트로미노 하나를 놓으려고한다. 종이는 1x1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가
		 * 하나 쓰여있다.
		 * 
		 * 테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여있는 수들의 합을 최대로 하는 프로그램을 작성하시오. 테트로미노는 반드시 한
		 * 정사각형이 정확히 하나의 칸을 포함하도록 놓아야하며 , 회전이나 대칭을 시켜도 된다.
		 * 
		 * 입력) 첫쨰 줄에 종이의 세로 크기N과 가로크기M이 주어진다. 둘쨰 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. i번쨰 줄의
		 * j번쨰 수는 위에서부터 i번째 칸, 왼쪽에서부터j번째 칸에 쓰여 있는 수이다. 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.
		 * 
		 * 출력) 첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 세로 크기
		C = Integer.parseInt(st.nextToken()); // 가로 크기
		arr = new int[R][C];

		// 1) 입력받기
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of for

		// 2) 첫번째 ㅡ
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (c + 1 < C && c + 2 < C && c + 3 < C) {
					index = arr[r][c] + arr[r][c + 1] + arr[r][c + 2] + arr[r][c + 3];
					result = Math.max(result, index);
				}
				if (r + 1 < R && r + 2 < R && r + 3 < R) {
					index = arr[r][c] + arr[r + 1][c] + arr[r + 2][c] + arr[r + 3][c];
					result = Math.max(result, index);
				}if (c + 1 < C && r + 1 < R) {
					index = arr[r][c] + arr[r][c + 1] + arr[r + 1][c] + arr[r + 1][c + 1];
					result = Math.max(result, index);
				}
				if (r + 1 < R && r + 2 < R && c + 1 < C) {
					index = arr[r][c] + arr[r + 1][c] + arr[r + 2][c] + arr[r + 2][c + 1];
					result = Math.max(result, index);
				} 
				if (r + 1 < R && r + 2 < R && 0 <= c - 1) {
					index = arr[r][c] + arr[r + 1][c] + arr[r + 2][c] + arr[r + 2][c - 1];
					result = Math.max(result, index);
				} 
				if (c + 1 < C && c + 2 < C && r + 1 < R) {
					index = arr[r][c] + arr[r][c + 1] + arr[r][c + 2] + arr[r + 1][c + 2];
					result = Math.max(result, index);
				}
				 if(c + 1 < C && c + 2 < C && r + 1 < R) {
					index = arr[r][c] + arr[r + 1][c] + arr[r][c + 1] + arr[r][c + 2];
					result = Math.max(result, index);
				} 
				if (r + 1 < R && c + 1 < C && c + 2 < C) {
					index = arr[r][c] + arr[r + 1][c] + arr[r + 1][c + 1] + arr[r + 1][c + 2];
					result = Math.max(result, index);
				}
				if(r+1<R && 0<=c-1 && 0<= c-2) {
					index = arr[r][c] + arr[r + 1][c] + arr[r + 1][c - 1] + arr[r + 1][c - 2];
					result = Math.max(result, index);
				}
				if (r + 1 < R && r + 2 < R && c + 2 < C) {
					index = arr[r][c] + arr[r + 1][c] + arr[r + 1][c + 1] + arr[r + 2][c + 1];
					result = Math.max(result, index);
				} 
				if (r + 1 < R && r + 2 < R && 0 <= c - 1) {
					index = arr[r][c] + arr[r + 1][c] + arr[r + 1][c - 1] + arr[r + 2][c - 1];
					result = Math.max(result, index);
				} 
				if (r + 1 < R && c + 1 < C && 0 <= c - 1) {
					index = arr[r][c] + arr[r + 1][c] + arr[r + 1][c - 1] + arr[r][c + 1];
					result = Math.max(result, index);
				} 
				if (r + 1 < R && c + 1 < C && c + 2 < C) {
					index = arr[r][c] + arr[r][c + 1] + arr[r + 1][c + 1] + arr[r + 1][c + 2];
					result = Math.max(result, index);
				}
				if (r + 1 < R && 0 <= c - 1 && c + 1 < C) {
					index = arr[r][c] + arr[r + 1][c] + arr[r + 1][c - 1] + arr[r + 1][c + 1];
					result = Math.max(result, index);
				}
				if (r + 1 < R && 0 <= c - 1 && c + 1 < C) {
					index = arr[r][c] + arr[r][c - 1] + arr[r][c + 1] + arr[r + 1][c];
					result = Math.max(result, index);
				} 
				if (r + 1 < R && r + 2 < R && c + 1 < C) {
					index = arr[r][c] + arr[r + 1][c] + arr[r + 2][c] + arr[r + 1][c + 1];
					result = Math.max(result, index);
				} 
				if (r + 1 < R && r + 2 < R && 0 <= c - 1) {
					index = arr[r][c] + arr[r + 1][c] + arr[r + 2][c] + arr[r + 1][c - 1];
					result = Math.max(result, index);
				}
			}
		} // end of for

	

		System.out.println(result);
	}// end of main

}// end of class
