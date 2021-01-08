package com.algorithm.a;

import java.util.Scanner;

public class Main_1110 {

	public static int N;
	public static int result = 0;

	public static void main(String[] args) {
		/*
		 * 0보다 크거나 같고, 99보다 작거나 같은 정수가 주어질때 다음과 같은 연산을 할 수 있다. 먼저 주어진 수가 10보다 작다면 앞에 9을
		 * 붙여 두 자리 수로 만들고 , 각 자리의 숫자를 더한다. 그 다음, 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리
		 * 수를 이어붙이면 새로운 수를 만들 수 있다 .
		 * 
		 * 예를보자 26부터 시작한다. 2+6= 8이다. 새로운 수는 68이다 6+8은 14이다. 새로운 수는 84이다 8+4=12이다 새로운 수는
		 * 42이다 4+2는 6이다 새로운수는 26이다. 위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다 N이
		 * 주어졌을 떄, N의 사이클의 길이르 구하는 프로그램을 작성하시오
		 * 
		 */

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int newsu = -1;
		
		while (newsu != N) {
            if(newsu == -1)   
			    newsu = N; 
            
            if(newsu<10) {
            	newsu = newsu*10 + newsu; 
            }
            else {
            	int sib = newsu/10; 
            	int ill = newsu%10; 
            	int dab = sib+ ill;
            	if(dab>=10) {
            		dab = dab%10; 
            	}
            	
            	newsu = ill*10 + dab; 
            	
            }
            result++; 
            
		}

		System.out.println(result);

	}

}
