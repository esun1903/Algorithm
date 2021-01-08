package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_SW_1953_탈주범검거 {

	private static int T;
	private static int[][] arr;
	private static int result = 0;
	private static int[] dr = { -1, 1, 0, 0 }; // 상 , 하, 좌, 우
	private static int[] dc = { 0, 0, -1, 1 };
	private static boolean[][] visited;
	private static int L;
	private static int N;
	private static int M;

	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int testCase = 1; testCase <= T; testCase++) {
			// 세로크기 N, 가로 크기 M, 맨홀 뚜껑이 위치한 장소의 세로 위치 R, 가로 위치 c, '그리고 탈출 후 소요된 시간 L이 주어진다
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken()); // 세로크기
			M = Integer.parseInt(st.nextToken()); // 가로크기
			int R = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑이 위치한 장소의 세로 위치
			int C = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑이 위치한 장소의 가로 위치
			L = Integer.parseInt(st.nextToken()); // 탈출 후 소요된 시간

			arr = new int[N][M];
			visited = new boolean[N][M];
			result = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 맨홀 뚜껑이 위치한 장소에서 부터 BFS를 하면 될 것 같다.
			go(R, C, 1);
			System.out.println("#" + testCase + " " + result);
			
//			for (int i = 0; i < N; i++) {
//				System.out.println();
//				for (int j = 0; j < M; j++) {
//					if(visited[i][j]==true)
//					System.out.print(1+" ");
//					else
//						System.out.print(0+" ");
//						
//				}
//			}
		} // end of testcase

	} // end of main

	private static void go(int r, int c, int time) { // 위치에서 가는 것

		visited[r][c] = true;
		Queue<Pair> q = new LinkedList<Pair>(); // 초기값 ( 여기는 무조건 가고
		q.offer(new Pair(r, c, time));
		result++;
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			int timeL = p.time;
			if (timeL == L)
				break;

			if (arr[x][y] == 1) { // 상, 하 , 좌 , 우에 있는 터널과 연결된다.

				for (int i = 0; i < 4; i++) {
					int nr = p.x + dr[i];
					int nc = p.y + dc[i];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc] == false && arr[nr][nc] != 0) {
						if (i == 0) { // 상일때는 3,4,7이면 continue;
							if (arr[nr][nc] == 3 || arr[nr][nc] == 4 || arr[nr][nc] == 7)
								continue;
						}
						if (i == 1) { // 하일때 continue; 
							if (arr[nr][nc] == 3 || arr[nr][nc] == 5 || arr[nr][nc] == 6)
								continue;
						}
						if (i == 2) { // 좌일때는 continue;
							if (arr[nr][nc] == 2 || arr[nr][nc] == 6 || arr[nr][nc] == 7)
								continue;
						}
						if (i == 3) { // 우일때는 continue;
							if (arr[nr][nc] == 2 || arr[nr][nc] == 4 || arr[nr][nc] == 5)
								continue;
						}
						result++;
						visited[nr][nc] = true;
						System.out.println(nr+" "+nc);
						q.offer(new Pair(nr, nc, timeL + 1));
					}
				}

			} else if (arr[x][y] == 2) { // 상, 하 에 있는 터널과 연결된다. 3,4,7

				for (int i = 0; i < 2; i++) {
					int nr = p.x + dr[i];
					int nc = p.y + dc[i];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc] == false && arr[nr][nc] != 0) {
						if (i == 0) { // 상일때는 3,4,7이면 continue;
							if (arr[nr][nc] == 3 || arr[nr][nc] == 4 || arr[nr][nc] == 7)
								continue;
						}
						if (i == 1) {
							if (arr[nr][nc] == 3 || arr[nr][nc] == 5 || arr[nr][nc] == 6)
								continue;
						}
						result++;
						visited[nr][nc] = true;
						System.out.println(nr+" "+nc);
						q.offer(new Pair(nr, nc, timeL + 1));
					}
				}

			} else if (arr[x][y] == 3) { // 좌, 우 에 있는 터널과 연결된다. 2,3,4,5

				for (int i = 2; i < 4; i++) {
					int nr = p.x + dr[i];
					int nc = p.y + dc[i];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc] == false && arr[nr][nc] != 0) {
						if (i == 2) { // 좌일때는 continue;
							if (arr[nr][nc] == 2 || arr[nr][nc] == 6 || arr[nr][nc] == 7)
								continue;
						}
						if (i == 3) { // 우일때는 continue;
							if (arr[nr][nc] == 2 || arr[nr][nc] == 4 || arr[nr][nc] == 5)
								continue;
						}
						result++;
						visited[nr][nc] = true;
						System.out.println(nr+" "+nc);
						q.offer(new Pair(nr, nc, timeL + 1));
					}
				}
			} else if (arr[x][y] == 4) { // 상, 우에 있는 터널과 연결된다.

				for (int i = 0; i < 4; ) {
					int nr = p.x + dr[i];
					int nc = p.y + dc[i];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc] == false && arr[nr][nc] != 0) {
						if (i == 0) { // 상일때는 continue;
							if (arr[nr][nc] == 2 || arr[nr][nc] == 6 || arr[nr][nc] == 7)
								continue;
						}
						if (i == 3) { // 우일때는 continue;
							if (arr[nr][nc] == 2 || arr[nr][nc] == 4 || arr[nr][nc] == 5)
								continue;
						}
						result++;
						visited[nr][nc] = true;
						System.out.println(nr+" "+nc);
						q.offer(new Pair(nr, nc, timeL + 1));
					}
					i += 3;
				}

			} else if (arr[x][y] == 5) { // 하, 우에 있는 터널과 연결된다.

				for (int i = 1; i < 4;) {
					int nr = p.x + dr[i];
					int nc = p.y + dc[i];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc] == false && arr[nr][nc] != 0) {
						if (i == 1) { // 하일때 continue; 
							if (arr[nr][nc] == 3 || arr[nr][nc] == 5 || arr[nr][nc] == 6)
								continue;
						}
						if (i == 3) { // 우일때는 continue;
							if (arr[nr][nc] == 2 || arr[nr][nc] == 4 || arr[nr][nc] == 5)
								continue;
						}
						result++;
						visited[nr][nc] = true;
						System.out.println(nr+" "+nc);
						q.offer(new Pair(nr, nc, timeL + 1));
					}
					i += 2;
				}
			} else if (arr[x][y] == 6) { // 하, 좌에 있는 터널과 연결된다.

				for (int i = 1; i < 3; i++) {
					int nr = p.x + dr[i];
					int nc = p.y + dc[i];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc] == false && arr[nr][nc] != 0) {
						if (i == 1) { // 하일때 continue; 
							if (arr[nr][nc] == 3 || arr[nr][nc] == 5 || arr[nr][nc] == 6)
								continue;
						}
						if (i == 2) { // 좌일때는 continue;
							if (arr[nr][nc] == 2 || arr[nr][nc] == 6 || arr[nr][nc] == 7)
								continue;
						}
						
						result++;
						visited[nr][nc] = true;
						System.out.println(nr+" "+nc);
						q.offer(new Pair(nr, nc, timeL + 1));
					}
				}

			} else if (arr[x][y] == 7) { // 상, 좌에 있는 터널과 연결된다.

				for (int i = 0; i < 3;) {
					int nr = p.x + dr[i];
					int nc = p.y + dc[i];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc] == false && arr[nr][nc] != 0) {
						if (i == 0) { // 상일때는 continue;
							if (arr[nr][nc] == 2 || arr[nr][nc] == 6 || arr[nr][nc] == 7)
								continue;
						}
						if (i == 2) { // 좌일때는 continue;
							if (arr[nr][nc] == 2 || arr[nr][nc] == 6 || arr[nr][nc] == 7)
								continue;
						}
						result++;
						visited[nr][nc] = true;
						System.out.println(nr+" "+nc);
						q.offer(new Pair(nr, nc, timeL + 1));
					}
					i += 2;
				}

			}
			// 갈 수 있는 방향 세팅해주기
			// 1 : 상, 하 , 좌, 우 에 씨는 터널과 연결된다.
			// 2: 상, 하에 있는 터널이 연결된다.
			// 3: 좌.우 에 있는 터널이 연결된다.

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
}// end of class

/*
 * 교도소로 이송 중이던 흉악범이 탈출하는 사건이 발생하여 수색에 나섰다. 탈주범은 탈출한 지 한 시간 뒤, 맨홀뚜껑을 통해 지하터널의 어느
 * 한 지점으로 들어갔으며, 지하 터널 어딘가에서 은신 중인 것으로 추정된다. 터널끼리 연결이 되어 있는 경우 이동이 가능 하므로 탈주범이
 * 있을 수 있는 위치의 개수를 계산하여야 한다. 탈주범은 시간당 1의 거리를 움직일 수 있다. 지하 터널은 총 7종류의 터널 구조물로
 * 구성되어 있으며 각 구조물 별 설명은 표 1 과 같다.
 * 
 * 그림 1은 지하 터널 지도의 한 예를 나타낸다. 이 경우 지도의 세로 크기는 5, 가로 크기는 6이다 맨홀 뚜껑의 위치가 (2,1)로
 * 주어질 경우, 이는 세로 위치 2, 가로위치 1을 의미하며 붉은 색으로 표기된 구역이다., 탈주범이 탈출 한 시간 뒤 도달할 수 있는
 * 지점은 한 곳이다. 탈주범이 2시간 후 도달할 수 있는 지점은 그림과 같이 맨홀 뚜껑이 위치한 붉은 색으로 표시된 지하도와 파란색으로
 * 표기된 지하도까지 총 3개의 장소에 있을 수 있다 3시간 후에는 그림과 같이 총 5개의 지점에 있을 수 있다. 그림과 같이 맨홀뚜껑이
 * 위치한 지점이 (2,2)이고 경과한 시간이 6으로 주어질 경우, 그림에서 맨홀뚜껑이 위치한 지점은 붉은 색, 탈주범이 있을 수 있는 장소가
 * 푸른색으로 표기되어 있따. 탈주범이 있을 수 있는 장소는 맨홀뚜껑이 위치한 지점을 포함하여 총 15개 이다. 지하 터널 지도와 맨홀 뚜껑의
 * 위치, 경과된 시간이 주어질때 탈주범이 위치할 수 있는 장소의개수를 계싼하는 프로그램을 작성하라
 * 
 * 제약사항 : 시간 제한 : 최대 50개의 테스트케이스를 모두 통과하는 데 1초 지하터널 지도의 세로크기, 가로그키 M은 각각 5이상 50
 * 이하이다, 맨홀 뚜껑의 세로 위치 R은 0이상 N -1 이하이고 가로위치 C는 0이상 M-1 이하이다. 탈출 후 소요된 시간 L은 1이상
 * 20이하이다. 지하터널 지도에는 반드시 1개 이상의 터널이 있음이 보장된다. 맨홀 뚜껑은 항상 터널이 있는 위치에 존재한다.
 * 
 * 입력: 첫 줄에 총 테케 T가 주어진다. 두 번째 부터 T개의 테스트케이스가 차례대로 주어진다. 각 테스트케이스의 첫 줄에는 지하터널지도의
 * 세로크기 N, 가로 크기 M, 맨홀 뚜껑이 위치한 장소의 세로 위치 R, 가로 위치 c, '그리고 탈출 후 소요된 시간 L이 주어진다
 * 
 * 그 다음 N줄에는 지하터널 지도정보가 주어지는데 , 각 줄마다 M개의 숫자가 주어진다 숫자 1 - 7은 해당 위치의 터널 구조물 타입을
 * 의미하며 숫자 0은 터널이 없는 장소를 의미한다.
 * 
 * 출력 : 탈주범이 위치할 수 있는 장소의 개수이다.
 */
