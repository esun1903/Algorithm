package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1249_보급로 {

	private static int N, INF = Integer.MAX_VALUE;
	static int map[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		for (int t = 1; t < TC; t++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				char ch[] = in.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = ch[j] - '0';

				}
			} // end for
			System.out.println("#" + t + " " + dijkstra(0, 0, N - 1, N - 1));
		}

	}

	private static int dijkstra(int startX, int startY, int endX, int endY) {
		boolean[][] visited = new boolean[N][N];
		int[][] minTime = new int[N][N];

		// 모든 최소비용 최대값으로 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minTime[i][j] = INF;
			}
		}

		minTime[startX][startY] = 0;
		int r = 0, c = 0, cost = 0, nr, nc;
		while (true) {
			// 1. 미방문 정점 중에 최소비용의 정점 찾기
			cost = INF;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] && cost > minTime[i][j]) {
						cost = minTime[i][j];
						r = i;
						c = j;
					}
				}
			}
			visited[r][c] = true;
			//선택된 정점이 도착정점이면 끝냄 
			if (r == endX && c == endY)
				return cost;
			
			//2. 선택된 정점을 경유지로 하여 미방문 정점들의 최소비용 갱신 
			//선택된 정점의 인접정점은 4방에 있는 정점이므로 4방탐색 수행 
			for (int d = 0; d < 4; d++) {
				nr = r + dr[d];
				nc = c + dc[d];
				if(nr>= 0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && minTime[nr][nc] > cost+map[nr][nc]) {
					 minTime[nr][nc] = cost+map[nr][nc];
				}
			}
		}

	}

}
