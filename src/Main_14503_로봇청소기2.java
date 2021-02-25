import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기2 {
	public static int arr[][];
	public static boolean visited[][];
	public static int[] dr = { -1, 0, 1, 0 }; // 북, 동, 남, 서
	public static int[] dc = { 0, 1, 0, -1 };
	public static int result, robot_d = 0;
	public static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로 크기
		M = Integer.parseInt(st.nextToken()); // 가로 크기

		arr = new int[N][M];
		visited = new boolean[N][M];

		// 로봇 청소기의 위치 r,c와 바라보는 방향 d가 주어진다.
		st = new StringTokenizer(br.readLine());
		int robot_r = Integer.parseInt(st.nextToken());
		int robot_c = Integer.parseInt(st.nextToken());
		int robot_d = Integer.parseInt(st.nextToken());

		// 입력하기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cleaning(robot_r, robot_c, robot_d); // 로봇청소기의 위치, 방향을 입력하기
		System.out.println(result); // 로봇청소기가 청소하는 칸의 개수를 출력한다.

	}// end of main

	private static void cleaning(int robot_r, int robot_c, int robot_d) {
		if (arr[robot_r][robot_c] == 1) // 만약, 벽이라면 리턴한다.
			return;

		if (arr[robot_r][robot_c] == 0) {
			result++;
			arr[robot_r][robot_c] = 2; // 현재 위치를 청소한다.
		}
	
		
		for (int i = 0; i < 4; i++) { // 4방향으로 하기
			 int ndir = changeDir(robot_d);
			// 방향 변환
			int nr = robot_r + dr[ndir];
			int nc = robot_c + dc[ndir];

			if (nr < N && nc < M && 0 <= nr && 0 <= nc) { // 만약, 다음조건(조건이 허용)에 허용된다면
				if(arr[nr][nc] == 0) {
				cleaning(nr, nc, ndir);
				return;
			 }
			else {
				robot_d = ndir; 
			}
			}
		} // end of for

		// 후진가자 (바라보는 방향을 유지한 채로 한 칸을 후진하자.)
	

		// 후진한 것을 바탕으로 새로운 방향을 제시
		int nr = robot_r + dr[backDir(robot_d)];
		int nc = robot_c + dc[backDir(robot_d)];
		if (nr < N && nc < M && 0 <= nr && 0 <= nc) {
			cleaning(nr, nc, robot_d);
		} else {
			return;
		}

		return;
	}// end of cleaning
	
    private static int changeDir(int dir) {
        if (dir == 0) {
            dir = 3;
        } else {
            dir--;
        }
        return dir;
    }

    private static int backDir(int dir) {
        if (dir == 0) dir = 2;
        else if(dir == 1) dir = 3;
        else if(dir == 2) dir = 0;
        else dir = 1;
        return dir;
    }

}// end of class
