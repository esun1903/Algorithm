
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕2 {
	public static int map[][];
	public static int map2[][];
	public static int R;
	public static int C;
	public static int T;

	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static int x1, y1 = Integer.MIN_VALUE;
	public static int x2, y2 = Integer.MIN_VALUE;

	public static void main(String... args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		map2 = new int[R][C];

//        입력받기
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 공기청정기라면 체크
				if (map[i][j] == -1 && y1 == Integer.MIN_VALUE) {
					x1 = i;
					y1 = j;
				} else if (map[i][j] == -1 && x1 >= 0) {
					x2 = i;
					y2 = j;
				}
			}
		}

//      1) 미세먼지 확산
//		 2) 
		for (int t = 0; t < T; t++) {
			map2 = new int [R][C];
			map2[x1][0] = -1; 
			map2[x2][0] = -1; 
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] > 0) expand(i, j);
                }
            }
            map = map2;
			clean1();
			clean2();
		} // end of 초 
		
		int result =0; 
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
			 if(map[i][j]>0)
				 result+=map[i][j];
			}
		}
		System.out.println(result);
		

	}

	// 반시계 방향으로 순환. x1, y1
	private static void clean1() {
		for (int i = x1 - 1; i >= 0; i--) {
			if (map[i][0] > 0) {
				if (i + 1 != x1) {
					map[i + 1][0] = map[i][0];
				}
				map[i][0] = 0;
			}
		}
		for (int j = 1; j < C; j++) {
			if (map[0][j] > 0) {
				map[0][j - 1] = map[0][j];
				map[0][j] = 0;
			}
		}
		for (int i = 1; i <= x1; i++) {
			if (map[i][C - 1] > 0) {
				map[i - 1][C - 1] = map[i][C - 1];
				map[i][C - 1] = 0;
			}
		}
		for (int j = C - 2; j >= 1; j--) {
			if (map[x1][j] > 0) {
				map[x1][j + 1] = map[x1][j];
				map[x1][j] = 0;
			}
		}
	}

	private static void clean2() {
		for (int i = x2 + 1; i < R; i++) {
			if (map[i][0] > 0) {
				if (i - 1 != x2) {
					map[i - 1][0] = map[i][0];
				}
				map[i][0] = 0;
			}
		}
		for (int j = 1; j < C; j++) {
			if (map[R - 1][j] > 0) {
				map[R - 1][j - 1] = map[R - 1][j];
				map[R - 1][j] = 0;
			}
		}
		for (int i = R - 2; i >= x2; i--) {
			if (map[i][C - 1] > 0) {
				map[i + 1][C - 1] = map[i][C - 1];
				map[i][C - 1] = 0;
			}
		}
		for (int j = C - 2; j >= 1; j--) {
			if (map[x2][j] > 0) {
				map[x2][j + 1] = map[x2][j];
				map[x2][j] = 0;
			}
		}

	}

	// 미세먼지가 확산된다.
	private static void expand(int i, int j) {
		int count = 0;
		for (int r = 0; r < 4; r++) {
			int nr = i + dr[r];
			int nc = j + dc[r];

			if (nr < R && nc < C && nr >= 0 && nc >= 0) {
				if (map[nr][nc] != -1) {
					count++;
					map2[nr][nc] += (map[i][j] / 5);
				}
			}
		}
		map2[i][j] += map[i][j] - ((map[i][j] / 5) * count);
	}

}