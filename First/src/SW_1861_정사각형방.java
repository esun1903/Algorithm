package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


//DFS에 대한 개념부족 (재귀) , 그리고 Buffered의 입출력에 대한 개념이 부족한 것 같다.

public class SW_1861_정사각형방 {

	// 상하좌우
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] arr;
	static int max;
	static int N;
	static int roomNo;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		// 테스트케이스
		int T = sc.nextInt();

	

		for (int test_case = 1; test_case <= T; test_case++) {
			
			max = 1;
			roomNo = Integer.MAX_VALUE;
			// 정수
			N = sc.nextInt(); 

			arr = new int[N][N];

			// 입력받기
			for (int i = 0; i < N; i++) {
				// 개행해주기
			
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					DFS(i, j, arr[i][j], 1);
				}

			}
			System.out.print("#" + test_case + " " + roomNo + " " + max);

		}

	}

	public static void DFS(int n, int m, int origin, int count) { // 현재의 위치 n,m그리고 arr[n][m] = origin , count = 얼마나
																	// 가고있나를 나타내는 변수
		int nx;
		int ny;

		if (count > max) { // count가 max보다 클때에는
			max = count;
			roomNo = origin;
		} else if (count == max) { // 만약 count == max와 같을 때에는 origin 의 값이 arr[n][m]값보다 클때엔 바꿔주기
			if (roomNo > arr[n][m])
				roomNo = origin;
		}

		for (int i = 0; i < 4; i++) { // 상하좌우로 돌면서
			nx = n + dx[i];
			ny = m + dy[i];
			// 경계체크하기 ,처음으로 출발해야하는 좌표를 저장하기 만약 크다면 작은 값을 저장하기
			if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == arr[n][m] + 1) {
				DFS(nx, ny, origin, count + 1);
			}

		}

	}

}
