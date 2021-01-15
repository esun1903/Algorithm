import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3085_사탕게임 {

	public static int count_R = 0;
	public static int count_C = 0;
	public static int N = 0;
	public static char arr[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 보드의 크기
		arr = new char[N][N];

		for (int i = 0; i < N; i++) { // 보드에 채워져 있는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z,
			String str = br.readLine(); // 노란색은 Y로 주어진다. , 사탕의 색이
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		} // end of for

		// 이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다. 조합이다.
		// 두 개를 고르고 그 다음에 가장 긴 연속 부분을 고른 다음 그 사탕을의 개수를 센다.
		// 여기서 두 개를 고르기
		int r = 0, c = 0;

		// 1) 행의 두 가지를 고르고 count를 세기
		for (int i = 0; i < N -1; i++) { 
			for (int j = 0; j < N ; j++) {
			   //두 가지를 바꾸기 
				char num = arr[i][j] ; 
			    arr[i][j] = arr[i+1][j]; 
			    arr[i+1][j] = num;
			    
			    func_R(); 
			     // 다시 되돌려놓기 
			     char num2 = arr[i+1][j];
			     arr[i+1][j] = arr[i][j];
			     arr[i][j]= num2; 
			}
		}
		
		//2) 열의 두 가지를 고르고 count를 세기 
//		for (int i = 0; i < N - 1; i++) {
//			for (int j = 0; j < N - 1; j++) {
//			   //두 가지를 바꾸기 
//				char num = arr[i][j] ; 
//			    arr[i][j] = arr[i][j+1]; 
//			    arr[i][j+1] = num; 
//			   func_C();
//			}
//		}
		
		count_C = Math.max(count_C, count_R);
		System.out.println(count_C);

	}

	// 만약 같은 색이라면 count 하기
	private static void func_R() {
		int num = 0;
		char c = arr[0][0];
		for (int i = 1; i < N - 1; i++) {
			for (int j = 0; j < N; j++) {
				if (c == arr[i][j]) {// 만약 c와 같으면 num++ 아니면 i,
					num++;
				} else { // 만약 같지 않으면
					c = arr[i][j];
					count_R= Math.max(count_R, num);
					num = 0;
				}
			}
		}

		return ;
	}

	// 만약 같은 색이라면 count 하기
	private static void func_C() {
		int num = 0;
		char c = arr[0][0];
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N - 1; j++) {
				if (c == arr[i][j]) {// 만약 c와 같으면 count++ 아니면 i,
					num++;
				} else { // 만약 같지 않으면
					c = arr[i][j];
					count_C = Math.max(count_C, num);
					num = 0;
				}

			}
		}

		return ;
	}

} // end of class

/*
 * 완탐 상근이는 어렸을 적에 "봄보니" 게임을 즐겨했다. 가장 처음에 N* N 크기의 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도
 * 있다. 상근이의 사탕의 색이 다른 인접한 두 칸을 고른다. 그 다음 고른 칸에 들어있는사탕을 서로 교환한다. 이제, 모두 같은 색으로
 * 이루어져 있는 가장 긴 연속 부분을 고른 다음 그 사탕을 모두 먹는다,, 사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의
 * 최대 개수를 구하는 프로그램을 작성하시오
 * 
 * 입력 : 첫째 줄에 보드의 크기 N이 주어진다. 다음 N개의 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은
 * P, 초록색은 Z, 노란색은 Y로 주어진다. 사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.
 * 
 * 출력 : 첫째 줄에 상근이가 먹을 수 있는 사탕의 최대 개수를 출력한다.
 * 
 */
