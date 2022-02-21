package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2578 {

	public static int count = 0;
	public static int bingo = 0; // 빙고 수 (3이되면 count 출력하고 끝나기 )
	public static boolean[][] visit = new boolean[5][5];
	private static int[][] map;
	private static int[][] test;
    public static boolean flag_r = false;
    public static boolean flag_l = false;
    public static boolean [] flag_u = new boolean [5];
    public static boolean []flag_d = new boolean[5];
    
	public static void main(String[] args) throws IOException {
		/*
		 * 빙고 게임은 다음과 같은 방식으로 이루어진다. 먼저 아래와같이 25개의 칸으로 이루어진 빙고판에 1부터 25까지 자연수를 한 칸에 하나씩
		 * 쓴다.
		 *
		 * 다음은 사회자가 부르는 수를 차례로 지워나간다. 예를들어. 5,10,7이 불렀다면 이 세 수를 지운 뒤 빙코판의 모습은 다음과 같다.
		 * 차례로 수를 지워가다가 같은 가로줄, 세로줄 또는 대각선 위에 있는 5개의 모든 수가 지워지는 경우 그 줄에 선을 긋는다. 이러한 선이 세
		 * 개 이상 그어지는 순간
		 */
		map = new int[5][5];
		test = new int[5][5];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// =============입력받기
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				test[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// test[][]에서 하나씩 꺼내면서 for하고 비교하기
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {

				for (int x = 0; x < 5; x++) {
					for (int y = 0; y < 5; y++) {
						if (map[x][y] == test[i][j]) { 
							//System.out.println("map: "+ x+"."+ y +" "+test[i][j]);
							map[x][y] = 0;
							count++;
							check(x, y);

							if (bingo >= 3) {
								System.out.println(count);
								return;
							}
						}
					}
				} // 비교하는 부분

			}
		} // test for문
		return;

	}

	private static void check(int x, int y) {

		// 가로
		
		int index = 0;
		for (int j = 0; j < 5 ; j++) {
			if (map[x][j] == 0)
				index++;
		}
		if (index == 5) {
			bingo++;
			
		}

		// 세로
		index = 0;
		for (int j = 0; j < 5; j++) {
			if (map[j][y] == 0)
				index++;
		}
		if (index == 5) {
			bingo++;
		
		}

		// 왼쪽 대각선

		index = 0;
	
		for (int i = 0, j = 4; i < 5 && j >= 0 && flag_r==false; i++, j--) {
			if (map[i][j] == 0)
				index++;
		}
		if (index == 5) {
			bingo++; 
			flag_r = true;
		}

		// 오른쪽
		index = 0;
		for (int i = 0, j = 0; i < 5 && j < 5 && flag_l == false; i++, j++) {

			if (map[i][j] == 0)
				index++;
		}
		if (index == 5) {
			bingo++;
			flag_l = true;
		}

	}

}
