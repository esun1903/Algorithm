import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15686_치킨배달 {

	public static List<Pair> chicken = new LinkedList<Pair>();
	public static List<Pair> home = new LinkedList<Pair>();
	public static int result = 0;
	public static int map[][];
	public static int N, M;
	public static boolean visited[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					home.add(new Pair(i, j));
				} else if (map[i][j] == 2) {
					chicken.add(new Pair(i, j));
				}
			}
		}

		// 치킨집의 개수 중 최대 M개를 고르고
		List<Pair> arr = new LinkedList<Pair>();
		visited = new boolean[chicken.size()];
		calculator(1, M, arr);
		// M개를 고른 뒤에 치킨 거리를 구하기
		// 이걸 반복하면서 가장 작은 값을 구하기
		System.out.println(result);
	}

	private static void calculator(int i, int m2, List<Pair> arr) {
		if (i == m2) {
			// 만약, m2개를 다 골랐다면
			// 이제 집들을 탐색하며 계산하기
			for (int j = 0; j < arr.size(); j++) {
				Pair p = arr.get(j);
				System.out.print(p.r+" "+p.c+" ");
			}
			System.out.println();
			homecalculator(arr);
			return; 
		} else {
			for (int j = 0; j < chicken.size(); j++) {
				if (!visited[j]) {
					visited[j] = true;
					Pair p =chicken.get(j);
					arr.add(new Pair(p.r,p.c));
					calculator(i + 1, m2, arr);
					visited[j] = false;
				}
			}
		}
	}

	// 집의 위치들을 하나씩 꺼낸다.
	// 그 다음 m 개의 치킨 집들을 꺼내면서 가장 적은 치킨거리를 저장.
	// 반복한 뒤, result 치킨 거리와 비교
	// 적으면 result 값으로 변경
	private static void homecalculator(List<Pair> arr) { // 치킨집
//		int cal = Integer.MAX_VALUE;
//		for (Pair pair : home) {
//			int r = pair.r;
//			int c = pair.c;
//
//			for (Pair oneChicken : arr) {
//				int dir = Math.abs(r - oneChicken.r) + Math.abs(c - oneChicken.c);
//				cal = Math.min(dir, cal);
//			}
//			result = Math.min(cal, result);
//		}
	}

	public static class Pair {
		int r;
		int c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static void checking() {
//		for (int i = 0; i < N; i++) {
//			System.out.println();
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//		}
	}

}