/**
 * DFS : 200 * 200 시간이 터진다
 * BFS : 진행과정에서 가지치기가 많이 되니까 시간을 많이 절약할 수 있어 
 * 
 */
package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {
	public static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1, -1, 1, 0, 0 }; // 말처럼이동 (0~7), 상하좌우(8,11)
	public static int[] dc = { -2, -1, 1, 2, 2, 1, -1, -2, 0, 0, -1, 1 }; // 말처럼이동 (0~7), 상하좌우(8,11)

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine()); // 말처럼 이동할 수 있는 횟수 0<= k <= 30

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken()); // 가로 1 <= W <= 200
		int H = Integer.parseInt(st.nextToken());
		int[][] m = new int[H][W];

		for (int i = 0; i < H; i++) {
			String s = br.readLine();
			for (int j = 0, index = 0; j < W; j++, index += 2) {
				m[i][j] = s.charAt(index); // '0' 평지 , '1' 장애물
			}
		}
		int minMoveCnt = -1; // 이동회수의 최소값
// BFS 
		boolean[][][] visited = new boolean[H][W][K+1]; // [행][열][말처럼 이동할수 있는 남은 회수]
		visited[0][0][K] = true;
		Queue<int[]> q = new LinkedList<>(); // {r,c,K(말처럼이동할 수 있는 남은회수), moveCnt(지금까지의 이동회수)
		q.add(new int[] { 0, 0, K, 0 });

		while (!q.isEmpty()) { // 반복 (큐가 빌때까지)
			int[] arr = q.poll(); // 정점 = 큐에서 하나 꺼내기
			int r = arr[0];
			int c = arr[1];
			int kk = arr[2];
			int moveCnt = arr[3];

//		       도착지점이면 그만하기  (우측하단)
			if (r == H - 1 && c == W - 1) {
				minMoveCnt = moveCnt;
				break; 
			}
			for (int i = 8; i < dr.length; i++) { // 상하좌우 이동 ( 8 ~ 11 )
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (0 <= nr && nr < H && 0 <= nc && nc < W && !visited[nr][nc][kk] && m[nr][nc] == '0') {
					// 정점에 인접한, 방문하지않은 정점, 평지일경우만
					visited[nr][nc][kk] = true;
					q.offer(new int[] { nr, nc, kk, moveCnt + 1 }); // 큐에 넣기
				}
			}
			if (kk == 0) // 말처럼 이동할 수 있는 회수가 남아있으면 진행하도록
				continue;
			for (int i = 0; i < 8; i++) { // 말처럼 이동하기 ( 0 - 7 )
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (0 <= nr && nr < H && 0 <= nc && nc < W && !visited[nr][nc][kk - 1] && m[nr][nc] == '0') {
					// 정점에 인접한, 방문하지않은 정점, 평지일경우만
					visited[nr][nc][kk - 1] = true; // 방문체크
					q.offer(new int[] { nr, nc, kk - 1, moveCnt + 1 }); // 큐에 넣기
				}
			}
		}

		System.out.println(minMoveCnt);

//		 큐 생성 
//		 큐에 시작점 넣기 
//		 반복 (큐가 빌때까지)
//                 정점 = 큐에서 하나 꺼내기 
//		       도착지점이면 그만하기 
//                 정점에 인접한, 방문하지않은  정점을 (3차원 정점으로 알아내기)  , 평지일경우만 가야한다. 
//                          방문체크
//                          큐에 넣기 

	} // end of main
} // end of class
