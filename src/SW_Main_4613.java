package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_Main_4613 {

	public static void main(String[] args) throws IOException {
		/*삼성전자가 러시아 현지법인을 설립한지 20주년이 된 해이다. 
		 * 이를 기념해서 당신은  러시아 국기를 만들기로 했다 
		 * 먼저 창고에서 오래된 깃발을 꺼내왔다. 이 깃발은 N행 M열로 나뉘어 있고 , 
		 * 각 칸은 흰색, 파란색, 빨간색 중 하나로 칠해져 있다 
		 * 
		 * 당신은 몇개의 칸에 있는 색을 다시 칠해서 
		 * 이 깃발을 러시아 국기처럼 만들려고 한다. 
		 * 다음의 조건을 만족해야 한다. 
		 * 
		 * 
		 * 위에서 몇 줄 (한 줄 이상)은 모두 흰색이 칠해져 있어야한다. 
		 * 다음 몇 줄은 모두 파란색으로 칠해져 있어야 한다. 
		 * 나머지는 모두 빨간색으로 칠해져 있어야한다. 
		 * 
		 * 이렇게 러시아 국기 같은 깃발을 만들기 위해서 새로 칠해야하는 칸의 개수의
		 * 최솟값을 구하여라 
		 * 
		 * 첫 번째 예제이다. 왼쪽에 있는 그림이 입력이다. 중간에 있는 그림에 X가 적힌
		 * 칸들을 새롭게 색칠해서 오른쪽에 있는 그림과 같은 깃발을 만들면 최적이다. 
		 * 
		 * 
		 * 입력) 첫번째 줄에 테스트케이스의 수 T가 주어진다. 
		 * 각 테스트 케이스의 첫 번쨰 줄에는 두 정수 N,M이 공백으로 구분되어 주어진다. 
		 * 다음 N개의 줄에는 M개의 문자로 이루어진 문자열이 주어진다.  
		 * i번쨰 줄의 j번째 문자는 깃발에서 i번쨰 행 j번쨰 열인 칸의 색을 의미한다. 
		 * 'W'은 흰색, 'B'은 파란색, 'R'은 빨간색을 의미한다. 
		 * 
		 * 출력) 각 줄마다 #T를 출력한 뒤, 러시아 국기 같은 깃발을 만들기 위해서 새로 칠해야하는 
		 * 칸의 개수의 최솟값을 구하여 T줄에 걸쳐 출력한다. 
		 * 
		 * */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for (int tc = 0; tc < testCase; tc++) { //테스트 케이스만큼 반복 
			
			//테스트 케이스만큼 for문 돌기 
		    st = new StringTokenizer(br.readLine());
			
			 
		}
		
	}

}
