import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17140_이차원배열과연산 {

	public static int R = 3;
	public static int C = 3;
	public static int map[][] = new int[101][101];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 행 또는 열의 크기가 100을 넘어가는 경우에는 처음 100개를 제외한 나머지는 버린다.
		for (int i = 0; i < 100; i++) {
			if (i == 0 && map[r][c] == k) {
				System.out.println(0);
				return;
			}

			// R연산인지, C연산인지 checking
			if (R < C) Ccalculator();
			  else 	Rcalculator();
			
			if (map[r][c] == k) {
				System.out.println(i + 1);
				return;
			}
			
		}
		System.out.println(-1);
	}

	// 배열 A의 모든 행에 대해서 정렬을 수행한다.
	private static void Rcalculator() {
		for (int i = 0; i < R; i++) {
			int[] n = new int[10];
			for (int j = 0; j < C; j++) {
				int k = map[i][j];
				n[k]++;
			}
			// 수의 등장횟수가 커지는 순으로
			// 그게 여러가지라면
			// 이 배열에서 수의 등장횟수가 가장

		} // end of for
	}

	// 배열 A의 모든 열에 대해서 정렬을 수행한다.
	private static void Ccalculator() {

	}

} // end of class

/*
 * 
 * 크기가 3 *3 인 배열 A가 있다. 1초가 지날 때마다 배열에 연산이 적용된다.
 * 
 */
