package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589_보물섬 {

	private static int N;
	private static int M;
	private static char[][] arr;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static boolean[][] visit;
	public static int count = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로의 크기
		M = Integer.parseInt(st.nextToken()); // 가로의 크기
		arr = new char[N][M]; // 2차원 배열 생성
		visit = new boolean[N][M];
		// char형으로 입력받기
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 'L' && !visit[i][j]) { // 만약, 땅이라면
					bfs(i, j);

				}
			
			
				for (int l = 0; l < N; l++) {
					for (int k = 0; k < M; k++) {
						visit[l][k] = false;
					}
				}
			}
		}

		System.out.println(count);
	}

	private static void bfs(int i, int j) {
	
		
			Queue q = new LinkedList<Pair>();
			q.offer(new Pair(i, j, 0));
			visit[i][j] = true;
			
			while (!q.isEmpty()) {
				Pair p = (Pair) q.poll();
				int row = p.x; 
				int col = p.y;
				int time = p.time;
				if (time > count) {
					count = time;
				}
				for (int t = 0; t < 4; t++) {
					int nx = row + dx[t];
					int ny = col + dy[t];
				 
				//만약,  result할 값이 더 크다면 
					

					if (0 <= nx && nx < N && 0 <= ny && ny < M && !visit[nx][ny] && arr[nx][ny] == 'L') {
						visit[nx][ny] = true;
						q.offer(new Pair(nx, ny, time + 1));
					}

				}


		}
	}

	public static class Pair {
		int x;
		int y;
		int time;

		public Pair(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

	}
}