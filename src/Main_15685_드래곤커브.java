package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15685_드래곤커브 {

	private static int N;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		map= new int [100][100];
		N = Integer.parseInt(br.readLine());
		int x = 0;
		int y = 0;
		int d = 0;
		int z = 0;

		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
		    z = Integer.parseInt(st.nextToken());
		    
		    
		    paint(x,y,d,z);
		   
			
		}
		
		
		

	} // end of main
	
	
	// 그리기 
	
	private static void paint(int x, int y, int d, int z) {
   
		
		
	}
	
	
	public static class Point {
		int x1; 
		int y1; 
		
		
		public Point(int x1, int y1) {
			super();
			this.x1 = x1;
			this.y1 = y1;
		}
		
	} // end of point 

}

/*
 * 드래곤 커브는 다음과 같은 세 가지 속성으로 이루어져 있으며, 이차원 좌표 평면위에서 정의된다. 좌표 평면의 x축은 -> 방향, y 축은
 * 방향이다. 1. 시작 점 2. 시작 방향 3. 세대
 * 
 * 0세대 드래곤 커브는 아래 그림과 같은 길이가 1인 선분이다. 아래 그림은 0,0 에서 시작하고 , 시작방향은 오른쪽인 0세대 드래곤
 * 커브이다. 1세대 드래곤 커브는 0세대 그래곤 커브를 끝 점을 기준으로 시계 방향으로 90도 회전시킨 다음 0세대 드래곤 커브의 끝 점에
 * 붙인 것이다. 끝점이란 점에서 선분을 타고 이동했을 때, 가장 먼 거리에 있는 점을 의미하낟.
 * 
 * 2세대 드래곤 커브도 1세대 만든 방법을 이용해서 만들 수 있다. (파란색 선분은 새로 추가된 선분을 나타낸다, )
 * 
 * 3세대 드래곤 커브도 2세대 드래곤 커브를 이용해 만들 수 있다. 아래 그림은 3세대 드래곤 커브이다. 즉, K(K > 1)세대 드래곤
 * 커브는 K-1세대 드래곤 커브를 끝 점을 기준으로 90도 시계 방향 회전 시킨 다음, 그것을 끝 점에 붙인 것이다.
 * 
 * 크기가 100 * 100인 격자위에 드래곤 커브가 n개 있다. 이때, 크기가 1x1인 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인
 * 정사각형의 개수를 구하는 프로그램을 작성하시오
 * 
 * 첫째 줄에 드래곤 커브의 개수 N(1 ≤ N ≤ 20)이 주어진다. 둘째 줄부터 N개의 줄에는 드래곤 커브의 정보가 주어진다. 드래곤
 * 커브의 정보는 네 정수 x, y, d, g로 이루어져 있다. x와 y는 드래곤 커브의 시작 점, d는 시작 방향, g는 세대이다. (0 ≤
 * x, y ≤ 100, 0 ≤ d ≤ 3, 0 ≤ g ≤ 10)
 * 
 * 입력으로 주어지는 드래곤 커브는 격자 밖으로 벗어나지 않는다. 드래곤 커브는 서로 겹칠 수 있다.
 * 
 * 방향은 0, 1, 2, 3 중 하나이고, 다음을 의미한다.
 * 
 * 0: x좌표가 증가하는 방향 (→) 1: y좌표가 감소하는 방향 (↑) 2: x좌표가 감소하는 방향 (←) 3: y좌표가 증가하는 방향
 * (↓)
 * 
 * 
 * 첫째 줄에 크기가 1×1인 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인 것의 개수를 출력한다.
 */
