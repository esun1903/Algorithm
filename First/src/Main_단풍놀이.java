package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_단풍놀이 {

	private static int N;
	private static char[][] arr;
	private static boolean [][]  visited;	
	private static int result = Integer.MIN_VALUE;
	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };
	

	public static void main(String[] args) throws IOException {
		/*
		 * 나뭇잎을 줍는 취미가 있는 어떤 사람에게 다음과 같은 문제를 제시했습니다.
		 * 
		 * NxN 2차원 배열에 단풍이 물든 나뭇잎을 놓습니다. 나뭇잎의 색은 모두 같이 않을 수도 있습니다. 나뭇잎의 색이 다른 인접한 두 칸을
		 * 고른 뒤에, 두 칸에 있는 나뭇잎을 교환합니다. 그런 다음, 가로 또는 세로로 모두 연속적으로 같은 색인 나뭇잎을 가져올 수 있습니다.
		 * 나뭇잎의 배열이 주어졌을 때, 최대로 가져올 수 있는 나뭇입은 몇개일까요?
		 * 
		 * 힌트) 1. 배열을 순회하면서 인접한 두 칸의 나뭇잎 색이 다른 경우에 한해, 나뭇잎을 서로 변경해 보고 그로부터 연속적인 같은 색의
		 * 갯수를 센다. 2. 현재 최대값과 비교하여 선택한다. 3. 변경된 나뭇잎은 다시 원래도 되돌리고 다시 탑색을 반복한다.
		 * 
		 * 입력 첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50) 다음 N개 줄에는 나뭇잎의 색상이 주어진다. 빨간색은 C, 파란색은
		 * P, 초록색은 Z, 노란색은 Y로 주어진다. 나뭇잎의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.
		 * 
		 * => 5 YCPZY CYZZP CCPPP YCYZC CPPZZ
		 * 
		 * 
		 * 출력 첫째 줄에 나뭇잎의 최대 개수를 출력한다. => 4
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new char[N][N];
		visited = new boolean[N][N]; 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}

		} 

		// 나뭇잎의 색이 다른 인접한 두 칸을 고른 뒤 
        //  두 칸에 있는 나뭇잎을 교환합니다. 그런 다음, 가로 또는 세로로 모두 연속적으로 같은 색인 나뭇잎을 가져올 수 있습니다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 총 4 곳의 자리를 변경해야함 
				// 나뭇잎의 색이 다른 인접한 두 칸을 고른 뒤 
				
				//왼쪽과 변경 
				if(j!=0&& arr[i][j]!= arr[i][j-1]) {
					char left = arr[i][j];
					arr[i][j] = arr[i][j-1];
					arr[i][j-1] = left; 
					int garo_left = garo_find(i,j);
					int sero_left = sero_find(i,j);
					if(garo_left <sero_left && result<sero_left) 
						 result = sero_left; 
					else if(garo_left > sero_left && result<garo_left)
						 result = garo_left; 
					 left = arr[i][j];
					arr[i][j] = arr[i][j-1];
					arr[i][j-1] = left; 
				} //오른쪽과 변경
				if(j!=N-1 && arr[i][j]!= arr[i][j+1]) {
					char right = arr[i][j];
					arr[i][j] = arr[i][j+1];
					arr[i][j+1] = right; 
					int garo_right = garo_find(i,j);
					int sero_right = sero_find(i,j);
					if(garo_right <sero_right && result<sero_right) 
						 result = sero_right; 
					else if(garo_right > sero_right && result<garo_right)
						 result = garo_right; 
					right = arr[i][j];
					arr[i][j] = arr[i][j+1];
					arr[i][j+1] = right; 
				} //위와 변경 
				if(i!=0 && arr[i][j]!= arr[i-1][j]) {
					char up = arr[i][j];
					arr[i][j] = arr[i-1][j];
					arr[i-1][j] = up; 
					int garo_up = garo_find(i,j);
					int sero_up = sero_find(i,j);
					if(garo_up <sero_up && result<sero_up) 
						 result = sero_up; 
					else if(garo_up > sero_up && result<garo_up)
						 result = garo_up; 
					up = arr[i][j];
					arr[i][j] = arr[i-1][j];
					arr[i-1][j] = up; 
				} //아래와 변경 
				if(i!=N-1&& arr[i][j]!= arr[i+1][j]) {
					char right = arr[i][j];
					arr[i][j] = arr[i+1][j];
					arr[i+1][j] = right;  
					int garo_right = garo_find(i,j);
					int sero_right = sero_find(i,j);
					if(garo_right <sero_right && result<sero_right) 
						 result = sero_right; 
					else if(garo_right > sero_right && result<garo_right)
						 result = garo_right; 
					right = arr[i][j];
					arr[i][j] = arr[i+1][j];
					arr[i+1][j] = right; 
				}
				
				
			}
		} 

		System.out.println(result);

	}

//	그로부터 연속적인 같은 색의
//	 * 갯수를 센다. 2. 현재 최대값과 비교하여 선택한다. 3. 변경된 나뭇잎은 다시 원래도 되돌리고 다시 탑색을 반복한다.
	private static int garo_find(int x, int y) {
		int i = x; 
		int j = y; 
		int cnt = 1; 
	   //x,y의 왼쪽까지 계속 counting
		while(j>0) {
			if(arr[x][y] == arr[i][j-1]) {
				cnt ++;
				j--; 
			}
			else 
				break; 
		}
		 i = x; 
		 j = y; 
	  //x,y의 오른쪽까지 계속 counting
		while(j<N-1) {
			if(arr[x][y] == arr[i][j+1]) {
				cnt ++; 
                j ++; 				
			}
			else 
				break; 
			
		}
		
		return cnt; 
	}
	
//	그로부터 연속적인 같은 색의
//	 * 갯수를 센다. 2. 현재 최대값과 비교하여 선택한다. 3. 변경된 나뭇잎은 다시 원래도 되돌리고 다시 탑색을 반복한다.
	private static int sero_find(int x, int y) {
		int i = x; 
		int j = y; 
		int cnt = 1; 
	   //x,y의 위쪽까지 계속 counting
		while(i>0) {
			if(arr[x][y] == arr[i-1][j]) {
				cnt ++; 
				i--;
			}
			else 
				break; 
		} 
		 i = x; 
		 j = y; 
	  //x,y의 아래쪽까지 
		while(i<N-1) {
			if(arr[x][y] == arr[i+1][j]) {
				cnt ++; 
			    i++; 
			}
			else 
				break; 
			
		}
		
		return cnt; 
		
		
	}
	


}
