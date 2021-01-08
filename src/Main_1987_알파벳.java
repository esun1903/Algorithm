package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {

	public static int R;
	public static int C;
	public static char[][] arr;
	public static boolean[] visit = new boolean[26];
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
    static int max = Integer.MIN_VALUE;
   
	public static void main(String[] args) throws IOException {


		// toCharArray쓰기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());  // 2
		C = Integer.parseInt(st.nextToken());  // 4
		arr = new char[R][]; // 세로만 주기
		for (int i = 0; i < R; i++) { //  2
			arr[i] = br.readLine().toCharArray();
		}
 
		dfs(0,0,1);
		System.out.println(max);
	}

	public static void dfs(int y, int x ,int cnt) { // dfs
		
			visit[arr[y][x]-'A'] = true;  //C-'A': 3 visit[3] = true; 
			max = Math.max(max, cnt);
			
			for(int i= 0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				//경계체크 
				if(0<=nx && nx<C && 0<=ny && ny<R && visit[arr[ny][nx]-'A'] == false) {   //경계체크
					dfs(ny,nx,cnt+1); //dfs(nx,ny,cnt+1) ; 
				}
			}
			visit[arr[y][x]-'A'] =false;
		
	}//end of dfs

	
}// end of class 
