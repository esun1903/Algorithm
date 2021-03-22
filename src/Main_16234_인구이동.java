import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234_인구이동 {
	public static int result = 0; // 인구이동이 일어나는 횟수(결과값)
	public static int dr[] = { -1, 1, 0, 0 };
	public static int dc[] = { 0, 0, 1, -1 };
	public static int N, L, R;
	public static int visited[][];
	public static int arr[][];
	public static boolean check = false;
	public static int count = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		visited = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = 0;
			}
		}

		while (true) {
			visited = new int[N][N];

			int now = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == 0) { // 아직 안되어있는 것들만
						now += BFS(i, j);

//						System.out.println("#####################");
//						for (int r = 0; r < N; r++) {
//							for (int c = 0; c < N; c++) {
//								System.out.print(arr[r][c] + " ");
//							}
//							System.out.println();
//						}
//						System.out.println("#####################");
					}
				}
			}

//			System.out.println("#####################");
//			for (int r = 0; r < N; r++) {
//				for (int c = 0; c < N; c++) {
//					System.out.print(arr[r][c] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("#####################");

			// 인구 이동이 없을 때까지 지속된다.
			if (now > 0) { // 만약, 인구 이동이 있다면 ++;
				result++;
			} else { // 만약, 인구 이동이 없다면 false
				break;
			}
		}

		System.out.println(result);
	}

	private static int BFS(int i, int j) {
		count++;
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(i, j));
		int 인구수 = 1;
		int sum = arr[i][j];
		visited[i][j] = count;
		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				// L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루동안 연다. , 방문을 안했거나
				if (0 <= nr && 0 <= nc && nr < N && nc < N && visited[nr][nc] == 0) {
					int sub = Math.abs(arr[p.r][p.c] - arr[nr][nc]);
					if (L <= sub && R >= sub) {
						queue.offer(new Pair(nr, nc));
						visited[nr][nc] = count;
						if (인구수 == 1) {
//							result++;
						}
						인구수++;
						sum += arr[nr][nc];
					}
				}
			}
		}

//		System.out.println("=============");
//		for (int k = 0; k < N; k++) {
//			for (int k2 = 0; k2 < N; k2++) {
//				System.out.print(visited[k][k2] + " ");
//			}
//			System.out.println();
//		}

//		System.out.println(인구수);
		if (인구수 > 1) { // 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
			int m = (sum) / (인구수);
			check = true;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (visited[r][c] == count) {
						arr[r][c] = m;
					}
				}
			}
		} else {
			check = false;
		}

		if (인구수 == 1)
			인구수--;

		return 인구수;

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
 */
