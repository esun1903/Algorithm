package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503 {

	public static int N; // 세로 크기
	public static int M; // 가로 크기
	private static int[][] arr;
	private static boolean[][] visit;
	private static int r;
	private static int c;
	private static int d;
	private static int result = 0;
	
	public static int [] dr = {-1,1,0,0};
	public static int [] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
        visit = new boolean[N][M];
        
        
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		// d = 0인 경우에는 북쪽, 1인 경우엔 동쪽, 2인 경우엔 남쪽을 , 3인 경우에는 서쪽

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(result);

	}

	private static void dfs(int cnt) {
		
		if(cnt==0) {
			visit[r][c] = true;
			cnt++; 
		}
		// 현재방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다. 
		//북-> 서 -> 남 -> 동
		// 0 -> 3 -> 2 -> 1 
		if(d==0)
			d = 3; 
		
		
	}

}
