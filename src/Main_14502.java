package com.algorithm.a;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502 {

	public static int N;
	public static int M;
	public static int arr[][];
	public static List<Pair> list = new ArrayList<>();
	public static int[] dx = { 1, -1, 0, 0 };
	public static int[] dy = { 0, 0, 1, -1 };
	public static int result = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2)
					list.add(new Pair(i, j)); // 저 list에는 바이러스의 위치만 들어가있음
			}
		}

		combination(0);

		System.out.println(result);
	}

	// 조합하기 -> 그다음 bfs로 찾기
	// 0 : 빈칸 , 1: 벽 , 2: 바이러스
	public static void combination(int count) { // n * m 의 C 3를 하기
		if (count == 3) {
			// 3개가 되었을시
			BFS();
			//System.exit(0);

		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 0) {
						arr[i][j] = 1;
						combination(count + 1);
						arr[i][j] = 0;

					}
				}
			}
		}
	}

	public static void BFS() {
		// 시작 위치
		Queue<Pair> queue = new LinkedList<Pair>();
		boolean[][] visited = new boolean[N][M];
		for (Pair p : list) {
			visited[p.x][p.y] = true;
			queue.offer(p);
		}
		int temp[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		while (!queue.isEmpty()) {
			Pair p = queue.poll();
		//	System.out.println(p.toString());
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i]; 
				//System.out.println("nx : " + nx + "ny : " + ny +"temp nx : "  );
				// 경계값안에 들어가면
				if (0 <= nx && 0 <= ny && nx < N && ny < M) {
					if (temp[nx][ny] == 0 && !visited[nx][ny]) {
						queue.offer(new Pair(nx, ny));
						visited[p.x][p.y] = true;
						temp[nx][ny] = 2;
					}
				}
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 0)
					count++;
			//	System.out.print(temp[i][j] + "   ");
			}
		//	System.out.println();
		}
		result = Math.max(result, count);

	}

	public static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}

	}
}
