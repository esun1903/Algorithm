import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15686_치킨배달 {

	public static List<Pair> chicken = new LinkedList<Pair>();
	public static List<Pair> home = new LinkedList<Pair>();
	public static int result = Integer.MAX_VALUE;
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
		
		visited = new boolean[chicken.size()];
		calculator(0, 0, M);
		// M개를 고른 뒤에 치킨 거리를 구하기
		// 이걸 반복하면서 가장 작은 값을 구하기
		System.out.println(result);
	}

	// 만약, m2개를 다 골랐다면
	// 이제 집들을 탐색하며 계산하기
	private static void calculator(int x, int i, int m2) {
		if (i <= m2) {
			List<Pair> arr = new LinkedList<Pair>();
			for(int j = 0; j < chicken.size(); j++) {
				if (visited[j]) {
					System.out.print(j + " ");
					//System.out.print(chicken.get(j).toString() + " ");
					//arr.add(chicken.get(j));
				}
			}// end for if 
			System.out.println();
			//System.out.println("@@@@@@@@@");
			//homecalculator(arr);
		} 
		for (int j = x; j < chicken.size(); j++) {
			if (!visited[j]) {
				visited[j] = true;
				calculator(x + 1, i + 1, m2);
				visited[j] = false;
			}
		}
	}

	// 집의 위치들을 하나씩 꺼낸다.
	// 그 다음 m 개의 치킨 집들을 꺼내면서 가장 적은 치킨거리를 저장.
	// 반복한 뒤, result 치킨 거리와 비교
	// 적으면 result 값으로 변경
	private static void homecalculator(List<Pair> arr) { // 치킨집
		int sum = 0;
		for (Pair pair : home) {
			int r = pair.r;
			int c = pair.c;

			int cal =10000000;
			for (Pair oneChicken : arr) {
				// 치킨거리를 구하고
				int dir = Math.abs(r - oneChicken.r) + Math.abs(c - oneChicken.c);
				cal = Math.min(dir, cal);
			}
			sum += cal;
		}// end of for 
		result = Math.min(sum, result);
	}

	public static class Pair {
		int r;
		int c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pair [r=" + r + ", c=" + c + "]";
		}
		
		
	}

}