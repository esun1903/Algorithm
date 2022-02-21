package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_SW_4008_숫자만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		 BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		 int T = Integer.parseInt(br.readLine());
		 int N; 
		 int result; 
		 for (int testCase = 1; testCase <= T; testCase++) {
			result = 0; 
		     N = Integer.parseInt(br.readLine());
			 System.out.println("#"+testCase+" "+result);
		}
	}

}


/* 선표는 게임을 통해 사칙 연산을 공부하고 있다. 
 * N개의 숫자가 적혀 있는 게임 판이 있고 +,-,x,/ 의 연산자 카드를 숫자 사이에 끼어 넣어 다양한 결과 값을 구해보기로 했다. 
 * 수식을 계산할 때 연산자의 우선 순위는 고려하지 않고 왼쪽에서 오른쪽으로 차례대로 계산한다
 * 예를 들어 1,2,3이 적힌 게임 판에 + 와 X를 넣어 만들면 1 + 2 를 먼저 계산하고 그 뒤에 *를 계산한다
 * 즉 1+2*3의 결과는 9이다. 
 * 
 * 주어진 연산자 카드를 사용하여 수식을 계산했을 때 그 결과가 최대가 되는 수식과 최소가 되는 수식을 찾고 , 두 값의 차이를
 * 출력하시오
 * 
 * 예) 3,5,3,7,9,가 적힌 숫자판과 +2 개, - 1개, / 1개의 연산자 카드가 주어진 경우를 생각해보자 
 * 
 *  이 경우 최댓값은 3 - 5 / 3 + 7 + 9 = 16 , 최솟값은 3 + 5 + 3 /7 - 9 = -8 이다
 *  즉 결과는 최댓값과 최솟값의 차이는 16 - (-8) 로 24가 된다.
 *  */
 