import java.util.Scanner;

public class Main_10026_적록색약 {

	public static char map[][];
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	public static int NonResult; // 적록색이 아닐때 result 값
	public static int Result;
	public static boolean visited[][];
	public static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		visited = new boolean[N][N];
		String str;
		for (int i = 0; i < N; i++) {
			str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		// 적록색약이 아닌 사람이 봤을 때의 구역의 개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false)
					NonResult++;
				NonRedGreen(i, j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'R')
					map[i][j] = 'G';
			   visited[i][j] = false; 
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false)
					  Result++;
			   RedGreen(i, j);
			}
		}
 
	
		
		System.out.print(NonResult + " "  + Result);

	}

	private static void RedGreen(int r, int c) {
		if (visited[r][c] == true) {
			return;
		}
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (0 <= nr && nr < N && 0 <= nc && nc < N) {
				if (map[r][c] == map[nr][nc] && visited[nr][nc] == false) {
					NonRedGreen(nr, nc);
				}
			}
		}
		// 만약, 4방향 다 돌았는데도 DFS 돌 곳이 없다면?
//
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			System.out.println();
//			for (int j = 0; j < N; j++) {
//				if (visited[i][j] == false) {
//					System.out.print(0 + " ");
//				} else
//					System.out.print(1 + " ");
//			}
//		}
		
	}

	private static void NonRedGreen(int r, int c) { // DFS를 사용할 것

		if (visited[r][c] == true) {
			return;
		}
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (0 <= nr && nr < N && 0 <= nc && nc < N) {
				if (map[r][c] == map[nr][nc] && visited[nr][nc] == false) {
					NonRedGreen(nr, nc);
				}
			}
		}
		// 만약, 4방향 다 돌았는데도 DFS 돌 곳이 없다면?
//
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			System.out.println();
//			for (int j = 0; j < N; j++) {
//				if (visited[i][j] == false) {
//					System.out.print(0 + " ");
//				} else
//					System.out.print(1 + " ");
//			}
//		}

	}

}// end of class

/*
 * 적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못하낟. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수
 * 있다, 크기가 N *N 그리드의 각 칸에 R,G,B 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은
 * 색으로 이루어져 있다.
 * 
 * 적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다.
 * 
 * 적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수
 * 있다. (빨강-초록 2, 파랑 1)
 * 
 * 그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오. RRRBB
 * GGBBB BBBRR BBRRR RRRRR
 * 
 * 
 * 
 * for (int i = 0; i < N; i++) { System.out.println(); for (int j = 0; j < N;
 * j++) { System.out.print(map[i][j]+" "); } }// end of for
 */
