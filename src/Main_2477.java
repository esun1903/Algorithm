package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2477 {
	public static int map[][];
	public static int N;
	public static int max;

	public static void main(String[] args) throws IOException {

		/*
		 * 시골에 있는 태양이의 삼촌 댁에는 커다란 참외받이 있다. 문득 태양이는 이 밭에서 자라는 참외가 도대체 몇 개나 되는지 궁금해졌다 어떻게
		 * 알아낼 수 있는지 골똘이 생각하다가 드디어 좋은 아이디어가 떠올랐다. 유리카! 1m^2의 넓이에 자라는 참외 개수를 헤아린 다음, 참외밭의
		 * 넓이를 구하며 비례식을 이용하여 참외의 총개수를 구할 수 있다. 1m^2의 넓이에 자라는 참외의 개수는 헤아렸고, 이제 참외밭의 넓이만
		 * 구하면 된다. 참외밭은 ㄱ-자 모양이거나 ㄱ-자를 90도, 180도 , 270도 회전한 모양의 육각형이다 다행히도 밭의 경계는 모두
		 * 동서방향이거나 남북방향이었다. 밭의 한 모퉁이에서 출발하밭의 둘레를 돌면서 밭경계 길이를 모두 측정하였다.
		 * 
		 * 입력) 첫 번째 줄에 참외의 개수를 나타내는 양의 정수가 주어진다. 참외밭을 나타내는 육각형의 임의의 한 꼭짓점에서 출발하여 반시계방향으로
		 * 둘레를 돌면서 지나는 변의 방향과 길이가 둘째 줄부터 일곱번째 줄까지 한 줄에 하나씩 순서대로 주어진다. 변의 방향에서 동쪽은 1, 서쪽은
		 * 2, 남쪽은 3, 북쪽은 4로 나타낸다. 2-> 3-> 1-> 4
		 * 
		 * 출력) 첫째 줄에 입력으로 주어진 밭에서 자라는 참외의 수를 출력한다.
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[6][2];
		max = Integer.MIN_VALUE;

		int w = 0;
		int h = 0;
		// 입력받기
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			}
		 // end of for

		
		for (int i = 0; i < 6; i++) {
			// 방향에 따라 높이냐, 너비인게 있다는 것
			if (i%2==0) { // 가로
				if(w<map[i][1]) {
					w= map[i][1];
				}
			}
			else{
				if(h<map[i][1]) {
					h= map[i][1];
				}
			}

		} // end of for

		int ww= 0; 
		int hh= 0; 
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) { // 가로일때 
                  if(h == map[(i+5)%6][1] + map[(i+1) % 6][1]) {
                      ww = map[i][1];    
                	  
                  }
     
                	 
			}
			else {
			    if(w == map[(i+5)%6][1] + map[(i+1) % 6][1]) {
                    hh = map[i][1];    
              	  
                }
			}
		}

		System.out.println((w * h - ww * hh) * N);

	}// end of main



}// end of class
