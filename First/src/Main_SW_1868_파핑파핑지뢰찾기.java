package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_SW_1868_파핑파핑지뢰찾기 {

	private static int N;
	private static char[][] arr;
	private static int[][] map;

	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 }; // 좌상부터 시계방향
	static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };

	// 8방탐색
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		String str;
		boolean first = true;
		for (int testcase = 1; testcase <= T; testcase++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j);
					if (arr[i][j] == '*')
						first = false;
				}
			} // end of 입력받기
			if (first == true) {
				System.out.println("#" + testcase + " " + 1);
				continue;
			}
			// * 이면 지뢰가 있다는 뜻이고 , . 이면 지뢰가 없다는 뜻이다.
			// 지뢰가 없는 칸이라면 변이 맞닿아 있거나 꼭지점이 맞닿아 있는
			// 최대 8칸에 대해 몇 개의 지뢰가 있는지가 0에서 8사이의 숫자로 클릭한 칸에 표시된다.
			// 만약 숫자가 0이라면 근처의 8방향에 지뢰가 없다는 것이 확정
			// 지뢰가 있는 칸을 제외한 다른 모든 칸의 숫자들이 표시되려면 최소 몇 번의 클릭을 해야하는지 구하는 프로그램을 작성하라

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] != '*')
						bfs(i,j);
				}
			}

			System.out.println("#" + testcase + " ");
		}
	}

	private static void bfs(int x, int y) {

		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0, 0)); // 큐에 넣기
     
		while(!q.isEmpty()) {
			Pair p = q.poll(); 
			
			for (int i = 0; i < 8; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if(0<=nx && 0<=ny &&nx<N && ny<N) {
					
					
				
				}//end of if
				
			}// end of for
		}// end of while
		
	}// end of bfs 

	public static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}

/*
 * 파핑파핑 지뢰 찾기 라는 유명한 게임이 있다. 이 게임은 R * C 크기의 표를 이용하는 게임인데 표의 각 칸에는 지뢰가 있을 수도 있고
 * 없을 수도 있다. 표의 각 칸을 클릭했을때, 그 칸이 지뢰가 있는 칸이라면 파핑파핑 이라는 소리와 함께 게임은 끝난다. 지뢰가 없는
 * 칸이라면 변이 맞닿아 있거나 꼭지점이 맞닿아 있는 최대 8칸데 대해 몇 개의 지회가 있는지가 9에서 8사이의 숫자로 클릭한 칸에 표시된다.
 * 실제 게임에서는 어떤 위치에 지회가 있는지 알 수 없지만 이 문제에서는 특별히 알 수 있다고 하자. 지뢰를 '*'로 지뢰가 없는 칸을
 * '.'로, 클릭한 지뢰가 없는 칸을 'c'로 나타냈을때 표가 어떻게 변화되는지 나타낸다.
 * 
 * 입력 ) 첫 번째 줄에 t가 주어진다. 각 테케의 첫 번쨰 줄에 하나의 정수 n이 주어진다. 이는 지뢰찾기를 하는 표의 크기가 N *
 * N임을 나타낸다, 다름 N개의 ㅜㄹ의 i번쨰 줄에는 길이가 N인 문자열이 주어진다. 이 중 j번째 문자는 표에서 i번쨰 줄에는 길이가 N인
 * 문자열이 주어진다.
 * 
 * ‘*’이면 지뢰가 있다는 뜻이고, ‘.’이면 지뢰가 없다는 뜻이다. ‘*’와 ‘.’외의 다른 문자는 입력으로 주어지지 않는다. 각 테스트
 * 케이스마다 #x를 출력하괴 최소 몇 번의 클릭을 해야 지뢰가 없는 모든 칸에 숫자가 표시될 ㄱ거
 */
