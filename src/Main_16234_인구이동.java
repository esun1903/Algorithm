import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234_인구이동 {

	public static int N, L, R;
	public static int map[][];
	public static boolean check[][]; // 방문체크
	public static int result = 0;
	public static int peCheck = 1;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // N*N의 땅이 있는 것
		L = Integer.parseInt(st.nextToken()); // L명 이상
		R = Integer.parseInt(st.nextToken()); // R명 이하
       
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력받기

           	 for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						     BFS(i,j);
					}
				}
           

		System.out.println(result);

	}

	private static void BFS(int x, int y) {
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.offer(new Pair(0, 0));
		peCheck = 1;
		int sum = map[x][y];
		while (!queue.isEmpty()) {
			Pair p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (0 <= nr && nr < N && 0 <= nc && nc < N && !check[nr][nc]) { // 만약 범위 안에 존재하고 방문하지 않았다면 들어가기
					int sub = Math.abs(map[nr][nc] - map[p.r][p.c]); // 만약 내가 갈 곳의 위치 - 지금 위치 뺀게
					if (L <= sub && R >= sub) { // L보단 크거나 같고 R보단 작거나 같다면
						queue.add(new Pair(nr, nc)); // 큐에 넣는다.
						sum += map[nr][nc];
						peCheck++;
						check[nr][nc] = true;
						if (peCheck == N * N && result == 0) {
							System.out.println(result + 1);
							System.exit(0);
						}
					}
				}
			}
		} // end of while

		if (peCheck > 1) {
			int cal = sum / peCheck;
			result++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (check[i][j] == true) { // 만약에 true이면
						map[i][j] = cal; // 변경
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println();
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
		} // 입력받기
       System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.println();
			for (int j = 0; j < N; j++) {
				if(check[i][j] == true)
					System.out.print(1+" ");
				else
					System.out.print(0+" ");
			}
		} // 입력받기
       System.out.println();

	}

	public static class Pair {
		int r;
		int c;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}

/*
 * N * N 크기의 땅이 있고, 땅은 1*1개의 칸으로 이루어져 있다. 각각의 땅에는 나라가 하나씩 존재하며, r행 c열에 있는 나라에는
 * A[r][c] 명이 살고 있다. 인접한 나라 사이에는 국경선이 존재한다. 모든 나라는 1*1크기이기 때문에 모든 국경선에는 정사각형
 * 형태이다 오늘부터 인구 이동이 시작되는 날이다 인구이동은 다음과 같이 진행되고, 더 이상 아래 방법에 의해 인구 이동이 없을 때까지
 * 지속된다. - 국경선을 공유하는 두 나라의 인구차이가 L명 이상, R명 이하라면 두 나라가 공유하는 국경선을 오늘 하루동안 연다 - 위의
 * 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다. - 국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그
 * 나라를 오늘 하루동안은 연합이라고 한다. - 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가
 * 된다. 편의상 소수점은 버린다. - 연합을 해체하고, 모든 국경선을 닫는다.
 * 
 * 각 나라의 인구수가 주어졌을 때, 인구 이동이 몇 번 발생하는지 구하는 프로그램을 작성하시오
 * 
 * 입력 : 첫째 줄에 N,L,R이 주어진다 ( 1<=N<=50 , 1<=L<=R<=100) 둘째 줄부터 N개의 줄에 각 나라의 인구수가
 * 주어진다. r행 c열에 주어지는 정수는 A[r][c]의 값이다 인구 이동이 발생하는 횟수가 2,000번 보다 작거나 같은 입력만 주어진다
 * 
 * 출력 : 인구 이동이 몇 번 발생하는지 첫째 줄에 출력한다.
 * 
 * 
 * for (int r = 0; r < N; r++) { System.out.println(); for (int c = 0; c < N;
 * c++) { System.out.print(check[r][c] + " "); } } // 입력받기
 */
