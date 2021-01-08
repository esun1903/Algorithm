package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_16236_아기상어 {
	private static int N;
	private static int[][] m;
	private static int[] cnt;
	private static int r;
	private static int c;
	private static int[][] visited;
	private static int size;
	private static int num;
	private static int time;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 공간의 크기, 2<=N<=20
		m = new int[N+2][N+2]; // 공간을 한라인을 더 크게 잡음, 공간의 상태 0 123456 9
		
		for (int i = 0; i < m.length; i++) { // 외곽을 넘어가지 않도록 사용하지 않는 숫자로 초기화
			m[i][N+1] = Integer.MAX_VALUE;
			m[i][0] = Integer.MAX_VALUE;
			m[N+1][i] = Integer.MAX_VALUE;
			m[0][i] = Integer.MAX_VALUE;
		}
		
		cnt = new int[10]; // 크기별 물고기의 개수
		r = 0; // 아기상어의 위치
		c = 0;
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1, index = 0; j <= N; j++, index += 2) {
				m[i][j] = s.charAt(index) - '0';
				cnt[m[i][j]]++; // 크기별로 물고기 개수 카운팅
				if (m[i][j] == 9) { // 아기상어라면
					r = i;
					c = j;
					m[i][j] = 0; // 아기상어 칸을 맵에는 기록하지 않음(이동할꺼니까)
				}
			}
		}
		visited = new int[N+2][N+2]; // 방문여부 체크
		size = 2; // 아기상어의 초기 크기
		num = 0; // 아기상어가 먹은 물고기 수
		time = 0; // 지나간 시간
		
		while(true) {
			boolean check = false;
			for (int i = 1; i < size; i++) { // 아기상어가 먹을 수 있는 물고기가 존재하는가?
				if (cnt[i] > 0) {
					check = true;
					break;
				}
			}
			if (!check ) { // 먹을수 있는 물고기 없으면 그만
				break;
			}
			if (!bfs()) { // 먹을수 있는 물고기는 있지만, 먹지 못한경우 그만
				break;
			}
		}
		System.out.println(time);
	} // end of main
	// 우선순위 큐 new int[] {r,c};
	public static PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {
		@Override
		public int compare(int[] a, int[] b) { // 오름차순 a - b
			if (visited[a[0]][a[1]] != visited[b[0]][b[1]]) { // 이동거리 가까운순
				return visited[a[0]][a[1]] - visited[b[0]][b[1]];
			}
			if (a[0] != b[0]) { // 행 값이 작은순 (위쪽순)
				return a[0] - b[0];
			}
			return a[1] - b[1]; // 열 값이 작은순 (좌측순)
		}
	});
	/** 아기상어위치에서 나보다 작은 크기의 물고기 먹은경우 true 리턴, 먹지못한경우 false 리턴  */
	public static boolean bfs() {
		for (int i = 1; i <= N; i++) { // 방문여부 저장할 배열 초기화
			for (int j = 1; j <= N; j++) {
				visited[i][j] = 0;
			}
		}
		q.clear(); // [0]:r, [1]:c
		// 시작지점, 아기상어의 위치 r, c
		visited[r][c] = 1; // 방문체크 (0:미방문, 0보다크면 방문, 1->0초, 2->1초)
		q.offer(new int[] {r,c}); // 큐에 넣기, 아기상어의 위치
		while(q.size() > 0) { // 반복문 큐가 빌때까지
			int[] t = q.poll(); // 큐에서 꺼내기
			r = t[0];
			c = t[1];
			
			// 작업
			if (0 < m[r][c] && m[r][c] < size) { // 물고기가 있고, 아기상어보다 작으면 먹기
				cnt[m[r][c]]--; // 크기별 물고기 개수 감소
				num++; // 아기상어 먹은 물고기 개수
				time += visited[r][c] - 1; // 시간 누적
				if (size == num) { // 자신의 크기만큼 먹으면, 아기상어 레벨업
					size++; // 아기상어 크기 증가
					num = 0; // 먹은 물고기 수 초기화
				}
				m[r][c] = 0; // 아기상어가 물고기 먹음, 물고기 삭제
				return true; // 먹음
			}
			for (int i = 0; i < dr.length; i++) { // 인접한칸
				int nr = r + dr[i];
				int nc = c + dc[i];
				// 배열의범위를 벗어나지 않는지 외곽체크, 미방문, 나보다 작거나 같은 물고기만 진입가능
				if (visited[nr][nc] == 0 && m[nr][nc] <= size) {
					visited[nr][nc] = visited[r][c] + 1; // 방문체크 (아기상어의 이동거리를 저장하려고 활용)
					q.offer(new int[] {nr, nc}); // 큐에 넣기
				}
			}
		}
		return false; // 못먹음
	} // end of bfs()
	private static int [] dr = {-1, 0, 0, 1}; // 상좌우하
	private static int [] dc = { 0,-1, 1, 0}; // 상좌우하
} // end of class


