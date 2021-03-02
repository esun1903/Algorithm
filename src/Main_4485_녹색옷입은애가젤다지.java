import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {

	public static int map[][];
	public static int distance[][]; // 최단 거리를 저장할 변수
	public static boolean check[][]; // 해당 노드를 방문했는지 체크할 변수
	public static int dr[] = { 1, -1, 0, 0 };
	public static int dc[] = { 0, 0, -1, 1 };
	public static Queue<Pair> queue;
	public static int N, result;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		result = 0;
		int num = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			// 만약, N이 0이라면 return 한다.
			if (N == 0) {
				break;
			}
			result++;
			map = new int[N][N];
			distance = new int[N][N]; // distance 는 처음에 나올 수 있는 가장 큰 값으로 초기화해줍니다 .
			check = new boolean[N][N];
			queue = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dijkstra(0, 0, map[0][0]);

			// 우선순위 큐에서 나오는 점들은 기회 비용이 최소인 값으로 갱신된 점들이므로
			// 상하좌우 4방향의 점들도 새로 갱신하고 기회 비용이 줄어든 값이 있다면 우선순위 큐에 넣는다.

			System.out.println("Problem " + num + ": " + result);
			num++;
		}
	}

	private static void dijkstra(int i, int j, int cost) {
		PriorityQueue<Pair> queue = new PriorityQueue<>();
		queue.offer(new Pair(i, j, cost)); // 우선순위큐에 넣기
		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			if (p.x == N - 1 && p.y == N - 1) { // 도착했을 경우 (마지막) 
				result = p.cost;
				break;
			}
			check[p.x][p.y] = true; // true 하기 
			for (int d = 0; d < 4; d++) {
				int nx = dr[d] + p.x;
				int ny = dc[d] + p.y;
				if (0 <= nx && nx < N && 0 <= ny && ny < N && !check[nx][ny]) {
					int nw = p.cost + map[nx][ny];
					queue.add(new Pair(nx, ny, nw));
				}
			}
		}
	}

	public static class Pair implements Comparable<Pair>{
		int x;
		int y;
		int cost;

		public Pair(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Pair o) { // 내림차순 :) 
			return this.cost < o.cost ? -1 :1 ;
		}

	}

}

// 다익스트라 알고리즘 이해하기 좋았던 블로그 : https://bumbums.tistory.com/4

/*
 * 0,0 에서 시작해서 n*n까지 가고싶은데 각 칸마다 도둑루피가 있어서 이 칸을 지나면 해당 도둑루피의 크기만큼 소지품을 잃게 된다. 잃는
 * 금액을 최소로하여 N *N까지 이동하는 방법
 * 
 * 다익스트라를 활용해서 잃는 금액을 최소로하는 방법을 찾기
 */
