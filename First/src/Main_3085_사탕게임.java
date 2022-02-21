import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class Main_3085_사탕게임 {

	public static int result_행 = 0;
	public static int result_열 = 0;
	public static int N = 0;
	public static char arr[][];
	public static int result = 0;
	/*
	 * 완탐 상근이는 어렸을 적에 "봄보니" 게임을 즐겨했다. 가장 처음에 N* N 크기의 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도
	 * 있다. 상근이의 사탕의 색이 다른 인접한 두 칸을 고른다. 그 다음 고른 칸에 들어있는사탕을 서로 교환한다. 이제, 모두 같은 색으로
	 * 이루어져 있는 가장 긴 연속 부분을 고른 다음 그 사탕을 모두 먹는다,, 사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의
	 * 최대 개수를 구하는 프로그램을 작성하시오 <p> 입력 : 첫째 줄에 보드의 크기 N이 주어진다. 다음 N개의 줄에는 보드에 채워져 있는
	 * 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다. 사탕의 색이 다른 인접한 두 칸이 존재하는
	 * 입력만 주어진다. <p> 출력 : 첫째 줄에 상근이가 먹을 수 있는 사탕의 최대 개수를 출력한다.
	 * 
	 * 여기서 시간복잡도를 줄이는 방법은 바뀐 위치의 행, 열에 대해서만 가장 긴 연속하는 색의 갯수를 구하는 거다. 그럴경우, 가장 긴 연속하는
	 * 색의 갯수를 구하는 시간복잡도가 N제곱에서 3N으로 줄어든다
	 */

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 보드의 크기
		arr = new char[N][N]; // 보드의 크기 지정해주기

		// 입력받기
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		// 행에서 두 가지 경우 찾기 
		for (int r = 0; r < N - 1; r++) {
			for (int c = 0; c < N; c++) {
				char swap = arr[r][c];
				arr[r][c] = arr[r + 1][c];
				arr[r + 1][c] = swap;
				result_행 = Math.max(calculator(r, c) , result_행) ;
				swap = arr[r][c];
				arr[r][c] = arr[r + 1][c];
				arr[r + 1][c] = swap;
			}
		}

		// 열에서 두 가지 경우 찾기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N - 1; c++) {
				char swap = arr[r][c];
				arr[r][c] = arr[r][c + 1];
				arr[r][c + 1] = swap;
				result_열 = Math.max(calculator_열(r, c) , result_열);
				swap = arr[r][c];
				arr[r][c] = arr[r][c + 1];
				arr[r][c + 1] = swap;
			}
		}
		 int result = Math.max(result_열 , result_행);
		 System.out.println(result);
	}

	private static int calculator(int r, int c) { // 행을 볼때 왼쪽, 오른쪽 하나씩 그리고 아래 체크하기

		char comparison = arr[r][0];
		int count = 0;
		int max = 0;
		for (int R = 0; R < N - 1; R++) { // (0일때는 왼쪽 체크하면 안되고, n-1 일때는 오른 체크하면 안되고 )
			if (r == 0) {
				if (comparison == arr[R][r + 1]) // 오른쪽 과 비교
					count++;
				if (comparison == arr[R][r]) { // 자기자신과 비교
					count++;
				}
				if (comparison != arr[R + 1][r]) { // 밑과 비교
					comparison = arr[R + 1][c];
					max = Math.max(max, count);
					count = 0;
				}
			} else if (r != 0 && r < N - 1) {
				if (comparison == arr[R][r + 1]) // 오른쪽과비교
					count++;
				if (comparison == arr[R][r - 1]) // 왼쪽과 비교
					count++;

				if (comparison == arr[R][r]) { // 자신과 비교
					count++;
				}
				if (comparison != arr[R + 1][r]) {
					comparison = arr[R + 1][c];
					max = Math.max(max, count);
					count = 0;
				}
			} else if (r == N - 1) {
				if (comparison == arr[R][r - 1]) // 왼쪽과 비교
					count++;
				if (comparison == arr[R][r - 1]) { // 자신과 비교
					count++;
				}
				if (comparison != arr[R + 1][c]) {
					comparison = arr[R + 1][c];
					count = 0;
					max = Math.max(max, count);
				}
			}
		}
		return max; 
	}
 
	//  ===========================
	
	
	private static int calculator_열(int r, int c) { // 열을 볼때 위, 아래 하나씩 그리고 옆
		char comparison = arr[0][c];
		int count = 0;
		int max = 0;
		for (int C = 0; C < N - 1; C++) { // (0일때는 왼쪽 체크하면 안되고, n-1 일때는 오른 체크하면 안되고 )
			if (r == 0) {
				if (comparison == arr[r+1][C]) // 아래랑 비교 
					count++;
				
				if (comparison == arr[r][C]) { // 자기자신과 비교
					count++;
				}
				if(comparison == arr[r][C+1]) { // 만약 오른쪽과 비교해서 같으면 count++ 하기 
					count++; 
				}
			   if (comparison != arr[r][C+1]) { // 오른쪽과 비교 
					comparison = arr[r][C+1];
					max = Math.max(max, count);
					
					count = 0;
				}   
			} else if (r != 0 && r < N - 1) {
				if (comparison == arr[r+1][C]) //아래랑 비교 
					count++;
				if (comparison == arr[r-1][C]) //위랑 비교  
					count++;
				
			
				if (comparison != arr[r][C+1]) { // 오른쪽비교 
					comparison = arr[r][C+1];
					max = Math.max(max, count);
					count = 0;
				}else {
					count++; 
				}
			}
		 else if (r == N - 1) {  // 가장 밑인 경우에는
				if (comparison == arr[r-1][C]) // 위와비교
					count++;
				if (comparison != arr[r][C+1]) { //오른쪽과 비교
					comparison = arr[r ][C+1];
					count = 1;
					max = Math.max(max, count);
				}
				else {
					count++; 
			}
		}
		}
		max = Math.max(max, count);
		return max; 
	}

}
