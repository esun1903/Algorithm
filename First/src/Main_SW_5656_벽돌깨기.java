package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_SW_5656_벽돌깨기 {

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	private static int N, W, H, min;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			for (int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			go(0,map);
			System.out.println("#" + t + " " + min);
		} // end of testcase
	} // end of main

	// i번쨰 구슬을 떨어뜨리기
	private static void go(int count, int[][] map) { // 던져진 구슬의 개수, 이전 구슬까지의 2차원 배열

		if (count == N) {
			int result = getRemain(map); //남아있는 벽돌의 개수를 구하여 최소값 갱신 
			if (min > result)
				min = result;
			return;
		}
		int newMap[][] = new int[H][W];
		// 모든 열에 떨어뜨리는 시도
		for (int c = 0; c < W; c++) {
			int r = 0;
			while (r < H && map[r][c] == 0)
				++r;

			if (r == H) { // 벽돌이 없음 .
				go(count + 1, map);
			} else {
				// 이전 구슬 상태로 배열 복사하여 초기화
				copy(map, newMap);
				// 터뜨리기
				boom(newMap, r, c);
				// 벽돌내리기
				down(newMap);
				// 다음 구슬 처리
				go(count + 1, newMap);

			}
		}

	}

	private static void boom(int[][] map, int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(r, c, map[r][c]));
		map[r][c] = 0; // 벽돌 제거 처리 (방문처리)

		while (!queue.isEmpty()) {
			Point p = queue.poll(); // 벽돌꺼내기
			if (p.cnt == 1)
				continue;

			for (int d = 0; d < 4; d++) {
				int nr = p.r, nc = p.c;
				for (int k = 1; k < p.cnt; k++) {
					nr += dr[d];
					nc += dc[d];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
						queue.offer(new Point(nr, nc, map[nr][nc]));
						map[nr][nc] = 0;
					}
				}
			}

		}
	}

	private static void down(int[][] map) {
		for (int c = 0; c < W; c++) { // 열고정
			int r = H - 1;
			while (r > 0) {
				if (map[r][c] == 0) {
					int nr = r - 1; // 직전행
					while (nr > 0 && map[nr][c] == 0) // 처음 만나는 벽돌 찾기
						--nr;
					map[r][c] = map[nr][c];
					map[nr][c] = 0;
				}
				--r;
			}

		}

	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}

	}

	private static int getRemain(int[][] map) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] > 0)
					++count;
			}
		}
		return count;
	}

}
/*
 * 구슬을 쏘아 벽돌을 깨뜨리는 게임을 하려고 한다. 구슬은 n번만 쏠수 있고 벽돌의 정보는 아래와 같이 w * h 배열로 주어진다. (0은
 * 빈 공간을 의미하며, 그 외의 숫자는 벽돌을 의미한다. 게임의 규칙은 다음과 같다. 1) 구슬은 좌, 우로만 움직일 수 있어서 항상 맨
 * 위에 있는 벽돌만 깨뜨릴 수 있다. 2) 벽돌은 숫자 1 - 9 로만 표현되며, 구슬이 명중한 벽돌은 상하좌우 (벽돌에 적힌 숫자 -1 )
 * 칸 만큼 같이 제거된다. 아래는 벽돌에 적힌 숫자와, 구슬이 명중했을 시 제거되는 범위의 예이다. 3) 제거되는 범위 내에 있는 벽돌은
 * 동시에 제거된다. 예를 들어 아래와 같이 4번 벽돌에 구슬이 명중할 경우, 9번 벽돌은 4번 벽돌에 반응하여 동시에 제거된다. 4) 빈
 * 공간이 있을 경우 벽돌은 밑으로 떨어지게 된다. Nㅇ개의 벽돌을 떨어뜨려 최대한 많은 벽돌을 제거하려고 한다. N,W,H 그리고 벽돌들의
 * 정보가 주어질 때, 남은 벽돌의 개수를 구하라! 최대한 많은 벽돌을 제거하려고 한다 -> N개만큼 다해봐야되는 것 같다..
 * 
 * 
 * 시뮬레이션이 잘 안되서 ,,이렇게 냅니다,,,ㅠㅠ
 */
