package day0830;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	static int R;
	static int C;
	static char[][] arr;
	static int cnt;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken()); // C-1 (col)
		arr = new char[R][];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray(); // 읽어오기
		}
		makeBread(0);
		System.out.println(cnt);
	}
	private static void makeBread(int rowNo) {// 모든 행에서 시작하기
		cnt = 0;
		for (int i = 0; i < R; i++) {
			visited[i][0] = true;
			go(i, 0);
		}
	}

	static int dr[] = { -1, 0, 1 };

	private static boolean go(int r, int c) {
		if (c == C - 1) { // 만약에 도착했다면
			cnt++;
			return true;
		}

		int nr, nc = c + 1;
		// 현 위치에서 오른쪽대각선위(-1,1), 오른쪽(0,1), 오른쪽대각선아래 (1,1) 순서적으로 파이프 연결 시도
		for (int i = 0; i < 3; i++) {
			nr = r + dr[i]; // 위치 갱신
			if (0 > nr || nr >= R || visited[nr][nc] || arr[nr][nc] == 'x')
				continue;
			// 방문하지 않았고 ,

			visited[nr][nc] = true;
	        if (go(nr, nc))	return true;

		}
		return false;
	}
}
